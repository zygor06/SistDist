package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import DB.ContatoDao;
import Model.Contato;

public class TrataCliente implements Runnable{
	private Socket cliente = null;
	
	/**
	 * Recebe o socket do cliente
	 * @param cliente Numero de socket do cliente
	 */
	public TrataCliente(Socket cliente, ServerSocket servidor) {
		this.cliente = cliente;
	}
	
	/**
	 * Inicia Thread para o cliente acessar o servidor
	 */
	@Override
	public void run() {
		Scanner entrada = null;
		ContatoDao cdao;
    	Contato contato;
    	String nome;
    	String telefone;
		try {
			//Informa o IP dos clientes que se conectarem, conforme aconteca a conexao.
			System.out.println("Recebida conexão de cliente com endereço IP " + cliente.getInetAddress());
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new Scanner(cliente.getInputStream());
			while (entrada.hasNextLine()) {
				switch (entrada.nextLine()) {
				case "1":
					cdao = new ContatoDao();
					ArrayList<Contato> contatos = cdao.getAll();
					StringBuilder sb = new StringBuilder();
            		for(Contato c : contatos){
            			sb.append("Nome: " + c.getNome());
            			sb.append("\nTelefone: " + c.getTelefone());
            			sb.append("\n\n");
            		}
            		oos.writeObject(sb.toString());
					//oos.writeObject("Teste: resposta ao comando 1");
					//TO DO: inserir código para listar os registros
					break;
				case "2":
					nome = entrada.nextLine();
					telefone = entrada.nextLine();
					
					contato = new Contato();
                    contato.setNome(nome);
                    contato.setTelefone(telefone);
                    cdao = new ContatoDao();
                    cdao.adiciona(contato);
                    
					oos.writeObject("Nome e telefone adicionados ao banco.");
					break;
				case "3":
					telefone = entrada.nextLine();
					
					cdao = new ContatoDao();
                    contato = new Contato();
                    contato.setTelefone(telefone);
                    cdao.remover(contato);
                    
					oos.writeObject("Telefone: " + telefone + " removido da base.");
					break;
				case "4":
					telefone = entrada.nextLine();
					cdao = new ContatoDao();
					oos.writeObject(cdao.getByTelefone(telefone).toString());
					break;
				default: 
					cliente.close();
					if (cliente.isClosed()) {
						System.out.println("Cliente do endereço IP " + cliente.getInetAddress() + " desconectado.");
					} else {
						System.out.println("Conexão mantida!");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}