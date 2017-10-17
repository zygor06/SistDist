package Client;

import java.io.IOException;
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
            System.out.println("O cliente se conectou ao servidor, via porta " + port + ".");
                        
            try {
                /*
                Fazendo a leitura do teclado
                e apresentanado a saida
                */
                Scanner teclado = new Scanner(System.in); 
                PrintStream saida = new PrintStream(cliente.getOutputStream());
                
                while (teclado.hasNextLine()) {
                   saida.println(teclado.nextLine());
               }
                
            } catch (IOException e) {
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
