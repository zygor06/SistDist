package Server;

import Util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int port = 654321;
	private static Log log;
	
	public static void main(String[] args) {
		Log log = new Log();
		log.show(true);
		initSever();
	}
	
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
