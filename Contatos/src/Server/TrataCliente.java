package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable{

	private Socket cliente = null;
	private ServerSocket servidor = null;
	
	/**
	 * Recebe o socket do cliente
	 * @param cliente Numero de socket do cliente
	 */
	public TrataCliente(Socket cliente, ServerSocket servidor) {
		// TODO Auto-generated constructor stub
		this.cliente = cliente;
		this.servidor = servidor;
	}
	
	/**
	 * Inicia Thread para o cliente acessar o servidor
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner entrada = null;
		
		try {
			//DataOutputStream paraCliente = new DataOutputStream(cliente.getOutputStream());
			//PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new Scanner(cliente.getInputStream());
			while (entrada.hasNextLine()) {
				
				switch (entrada.nextLine()) {
				case "1":
					System.out.println("recebi 1");
					//System.out.println(paraCliente.);
					oos.writeObject("Teste: resposta ao comando 1");
					//inserir código para listar os registros
					break;
				case "2":
					System.out.println("recebi 2");
					oos.writeObject("Teste: resposta ao comando 2");
					//inserir código para armazenar registro
					break;
				case "3":
					System.out.println("recebi 3");
					oos.writeObject("Teste: resposta ao comando 3");
					//inserir código para remover registro
					break;
				case "4":
					System.out.println("recebi 4");
					oos.writeObject("Teste: resposta ao comando 4");
					//inserir código para recuperar registro 
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
