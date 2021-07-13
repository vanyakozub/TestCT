package states;

import server.Server;

import java.io.IOException;

public class ListenState extends State {

    public ListenState(Server server) {
        super(server);
    }
    public void process() {
        try {
            System.out.println("listen");
            server.setClientSocket(server.getServerSocket().accept());
            server.setState(new ProcessState(server));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
