package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Util.Log;

public class Server {

	private static int port = 654321;
	private ServerSocket serverSocketsocket;
	private Socket socket;
	private Log log;
	
	public Server() {
		// TODO Auto-generated constructor stub
		log = new Log();
		log.show(true);
		initSever();
	}
	
	public void initSever() {
		try {
			serverSocketsocket = new ServerSocket(port);
			
			while (true) {
				socket = serverSocketsocket.accept();
				Thread thread = new Thread(new TrataCliente(socket));
				thread.start(); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.i(e.getMessage());
			e.printStackTrace();
		}
	}
}
