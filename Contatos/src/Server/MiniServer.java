package Server;

import java.net.Socket;

public class MiniServer extends Thread{

    private Socket socket = null;

    public MiniServer(Socket socket){

        super("Mini Server");
        this.socket = socket;

    }

    public void run(){
        // Ler input e processo aqui
    }

    // implementar metodos aqui
}
