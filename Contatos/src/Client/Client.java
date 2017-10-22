package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import DB.ContatoDao;
import Model.Contato;

public class Client {
	
	//IP do Local Host
    private static String ipServidor;
    private ContatoDao contatoDao;
    
    ObjectInputStream ois = null;
    
    //Porta a ser utilizada
    private static int port = 4321;
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
		
    	 try {
             //IP do servidor, caso ele esteja na mesma máquina do cliente: 
    		 ipServidor = InetAddress.getLocalHost().getHostAddress();
            
    		 //IP do servidor, caso seja uma máquina diferente:
    		 //ipServidor = 192.168.1.50 
             
    		 //Executa a ação de cliente
             new Client().executa();

             
        } catch (UnknownHostException e) {}
		
	}

	private void executa() throws ClassNotFoundException {
		try {
            //Cria Socket
            Socket cliente = new Socket(ipServidor, port);
            contatoDao = new ContatoDao();
            
            //Sinalizacao de conexao
            System.out.println("Conectado ao servidor de IP " + ipServidor + ", via porta " + port + ".\n");
            PrintStream saida = new PrintStream(cliente.getOutputStream());
                        
            try {
            	menu();
                String message;
                String telefone;
                String nome;
            	BufferedReader entrada;
            	ObjectInputStream ois = null;
            	Scanner leitor = new Scanner(System.in);
            	ContatoDao cdao;
            	Contato contato;
            	//Leitura da opção escolhida
                entrada = new BufferedReader(new InputStreamReader(System.in));                
            	char opcao = entrada.readLine().charAt(0);
            	//InputStream para enviar mensagem ao servidor via socket.
                ois = new ObjectInputStream(cliente.getInputStream());
            	while (opcao != '5') {
                	switch (opcao) {
                	case '1':
                		saida.println("1"); //Envio do comando ao servidor
                        message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println("Mensagem recebida: " + message);
                        ArrayList<Contato> contatos = contatoDao.getAll();
                		for(Contato c : contatos){
                			System.out.print("Telefone: " + c.getTelefone());
                			System.out.println("\tNome: " + c.getNome());
                		}
                		break;
                	case '2':
                		saida.println("2"); //Envio do comando ao servidor
                		message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println("Mensagem recebida: " + message);
                        System.out.println("Informe o nome:");
                        nome = leitor.next();
                        System.out.println("Informe o telefone:");
                        telefone = leitor.next();
                        contato = new Contato();
                        contato.setNome(nome);
                        contato.setTelefone(telefone);
                        cdao = new ContatoDao();
                        cdao.adiciona(contato);
                		break;
                	case '3':
                		saida.println("3"); //Envio do comando ao servidor
                		message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println("Mensagem recebida: " + message);
                        System.out.println("Informe o telefone que deseja remover:");
                        telefone = leitor.next();
                        cdao = new ContatoDao();
                        contato = new Contato();
                        contato.setTelefone(telefone);
                        cdao.remover(contato);
                		break;
                	case '4':
                		saida.println("4"); //Envio do comando ao servidor
                		message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println("Mensagem recebida: " + message);
                        System.out.println("Informe o telefone que deseja recuperar:");
                        telefone = leitor.next();
                        cdao = new ContatoDao();
                        System.out.println(cdao.getByTelefone(telefone));
                        break;
            		default: 
            			System.out.println("Opção inválida.");
                	}
            		System.out.println();
                    menu();
                    opcao = entrada.readLine().charAt(0);
            	}
            	//Envia comando diferente do esperado, para o servidor fechar a conexão:
            	saida.println("desconectar"); 
            	System.out.println("===APLICAÇÃO ENCERRADA===");
            	//Liberando recursos
            	ois.close(); 
            	cliente.close();
            } catch (IOException e) {
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
	}	

	private void menu() {
		System.out.println("===AGENDA TELEFÔNICA===");
		System.out.println("1 - Lista registros");
		System.out.println("2 - Armazena/Atualiza um registro");
		System.out.println("3 - Remove um registro");
		System.out.println("4 - Recupera um registro");
		System.out.println("5 - Finaliza a Aplicação");
		System.out.print("Selecione a opção: ");
	}
	
}

