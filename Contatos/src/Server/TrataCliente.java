package Server;

import java.io.IOException;
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
			entrada = new Scanner(cliente.getInputStream());
			
			while (entrada.hasNextLine()) {
				//Imprimir  a entrada do cliente
				System.out.println(entrada.nextLine());
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
