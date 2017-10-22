package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import Server.Server;

public class Client {
	
	//IP do Local Host
    private static String localHost = "127.0.0.1";
    private static String ipServidor;
    
    //Porta a ser utilizada
    private static int port = 4321;
    
    public static void main(String[] args) {
		
    	 try {
             //IP do servidor, caso ele esteja na mesma máquina do cliente: 
    		 ipServidor = InetAddress.getLocalHost().getHostAddress();
            
    		 //IP do servidor, caso seja uma máquina diferente:
    		 //ipServidor = 192.168.1.50 
             
    		 //Executa a ação de cliente
             new Client().executa();

             
        } catch (UnknownHostException e) {
           }
          catch (IOException e) {
        }
		
	}

	private void executa() {
		// TODO Auto-generated method stub
		try {
            //Cria Socket seja localhost ou endereço ena rede
            //Socket cliente = new Socket(localHost, port);
            Socket cliente = new Socket(ipServidor, port);
            
            boolean saidaCli = true;
            
            //Sinalizacao de conexao
            //System.out.println("O cliente se conectou ao servidor, via porta " + port + ".");
            PrintStream saida = new PrintStream(cliente.getOutputStream());
                        
            try {
            	/*
                Fazendo a leitura do teclado
                e apresentanado a saida
                */
                //Scanner teclado = new Scanner(System.in); 
                BufferedReader entrada;
                entrada = new BufferedReader(new InputStreamReader(System.in));                
            	menu();
            	char opcao = entrada.readLine().charAt(0);
            	while (opcao != '5') {
                	switch (opcao) {
                	case '1':
                		//System.out.println("mandei 1");
                		saida.println("1");
                		break;
                	case '2':
                		//System.out.println("mandei 2");
                		saida.println("2");
                		break;
                	case '3':
                		//System.out.println("mandei 3");
                		saida.println("3");
                		break;
                	case '4':
                		//System.out.println("mandei 4");
                		saida.println("4");
                		break;
            		default: 
            			System.out.println("Opção inválida.");
                	}
            		System.out.println();
                    menu();
                    opcao = entrada.readLine().charAt(0);
            	}
            	saida.println("desconectar");
            	System.out.println("===APLICAÇÃO ENCERRADA===");
            } catch (IOException e) {
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
	}	

	private static void menu() {
		System.out.println("===AGENDA TELEFÔNICA===");
		System.out.println("1 - Lista registros");
		System.out.println("2 - Armazena/Atualiza um registro");
		System.out.println("3 - Remove um registro");
		System.out.println("4 - Recupera um registro");
		System.out.println("5 - Finaliza a Aplicação");
		System.out.print("Selecione a opção: ");
	}
	
}

