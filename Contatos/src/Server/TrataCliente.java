package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TrataCliente implements Runnable{

	private Socket cliente = null;
	
	public TrataCliente(Socket cliente) {
		// TODO Auto-generated constructor stub
		this.cliente = cliente;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner entrada = null;
		
		try {
			entrada = new Scanner(cliente.getInputStream());
			
			while (entrada.hasNextLine()) {
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
