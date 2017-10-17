package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable{

	private Socket cliente = null;
	
	/**
	 * Recebe o socket do cliente
	 * @param cliente Número de socket do cliente
	 */
	public TrataCliente(Socket cliente) {
		// TODO Auto-generated constructor stub
		this.cliente = cliente;
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
				//Ler a entrada do cliente
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
