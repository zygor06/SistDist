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
    private static String ipLocal;
    
    //Porta a ser utilizada
    private static int port = 4321;
    
    public static void main(String[] args) {
		
    	 try {
             //IP da m�quina utilizada como servidor
             ipLocal = InetAddress.getLocalHost().getHostAddress();
            
             //Executa a a��o de cliente
             new Client().executa();

             
        } catch (UnknownHostException e) {
           }
          catch (IOException e) {
        }
		
	}

	private void executa() {
		// TODO Auto-generated method stub
		try {
            //Cria Socket seja localhost ou endere�o ena rede
            //Socket cliente = new Socket(localHost, port);
            Socket cliente = new Socket(ipLocal, port);
            
            boolean saidaCli = true;
            
            //Sinaliza��o de conex�o
            System.out.println("O cliente se conectou ao servidor!");
                        
            try {
                /*
                Fazendo a leitura do teclado
                e apresentanado a sa�da
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
