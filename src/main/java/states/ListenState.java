package states;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListenState extends State {

    public ListenState(Server server) {
        super(server);
    }
    public void process() {
        try {
            System.out.println("listen");
            if (server.getClientSocket() == null) {
                server.setClientSocket(server.getServerSocket().accept());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getClientSocket().getInputStream()));
            server.setInputData(in.readLine());
            server.setState(new ProcessState(server));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
