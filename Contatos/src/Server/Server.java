package Server;

import Util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int port = 4321;
	private static Log log;
	
	/*
	 * Inicia o servidor
	 */
	public static void main(String[] args) {
		Log log = new Log();
		log.show(true);
		initSever();
	}
	
	/**
	 * Lida com o socket do cliente
	 * 
	 */
	public static void initSever() {
		try {
			ServerSocket serverSocketsocket = new ServerSocket(port);
			
			while (true) {
				Socket socket = serverSocketsocket.accept();
				Thread thread = new Thread(new TrataCliente(socket));
				thread.start();
			}
		} catch (IOException e) {
			log.i(e.getMessage());
			e.printStackTrace();
		}
	}
}
