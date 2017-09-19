package Server;

import Util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int port = 654321;
	private ServerSocket serverSocketsocket;
	private Socket socket;
	private Log log;
	
	public Server() {
		log = new Log();
		log.show(true);
		initSever();
	}
	
	public void initSever() {
		try {
			serverSocketsocket = new ServerSocket(port);
			
			while (true) {
				socket = serverSocketsocket.accept();
				//Thread thread = new Thread(new TrataCliente(socket));
				//thread.start();
			}
		} catch (IOException e) {
			log.i(e.getMessage());
			e.printStackTrace();
		}
	}
}
