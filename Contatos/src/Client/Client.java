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
    
    ObjectInputStream ois = null;
    
    //Porta a ser utilizada
    private static int port = 4321;
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
		
    	 //IP do servidor, caso ele esteja na mesma máquina do cliente: 
		 //ipServidor = "10.62.148.135";
    	ipServidor = "10.61.17.16";
		
		 //IP do servidor, caso seja uma máquina diferente:
		 //ipServidor = 192.168.1.50 
		 
		 //Executa a ação de cliente
		 new Client().executa();
		
	}

	private void executa() throws ClassNotFoundException {
		try {
            //Cria Socket
            Socket cliente = new Socket(ipServidor, port);
            
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
                        System.out.println(message);
                        
                		break;
                	case '2':
                        System.out.println("Informe o nome:");
                        nome = leitor.next();
                        System.out.println("Informe o telefone:");
                        telefone = leitor.next();
                        
                        saida.println("2"); //Envio do comando ao servidor
                        saida.println(nome);
                        saida.println(telefone);
                        message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println(message);
                		break;
                	case '3':
                        System.out.println("Informe o telefone que deseja remover:");
                        telefone = leitor.next();
                        saida.println("3"); //Envio do comando ao servidor
                        saida.println(telefone);
                        message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println(message);
                		break;
                	case '4':
                        System.out.println("Informe o telefone que deseja recuperar:");
                        telefone = leitor.next();

                        
                        saida.println("4"); //Envio do comando ao servidor
                        saida.println(telefone);
                        message = (String) ois.readObject(); //Mensagem recebida do servidor
                        System.out.println(message);
                        
                        
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

