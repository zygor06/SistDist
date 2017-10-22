package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
		try {
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new Scanner(cliente.getInputStream());
			while (entrada.hasNextLine()) {
				switch (entrada.nextLine()) {
				case "1":
					System.out.println("recebi 1");
					oos.writeObject("Teste: resposta ao comando 1");
					//TO DO: inserir código para listar os registros
					break;
				case "2":
					System.out.println("recebi 2");
					oos.writeObject("Teste: resposta ao comando 2");
					//TO DO: inserir código para armazenar registro
					break;
				case "3":
					System.out.println("recebi 3");
					oos.writeObject("Teste: resposta ao comando 3");
					//TO DO: inserir código para remover registro
					break;
				case "4":
					System.out.println("recebi 4");
					oos.writeObject("Teste: resposta ao comando 4");
					//TO DO: inserir código para recuperar registro 
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