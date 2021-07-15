package states;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListenState extends State {
    private final Listener listener;
    private BufferedReader in;

    public ListenState(Server server) {
        super(server);
        listener = new Listener();

    }

    public void process() {
        try {
            System.out.println("listen");
            if (server.getClientSocket() == null) {
                server.setClientSocket(server.getServerSocket().accept());
                in = new BufferedReader(new InputStreamReader(server.getClientSocket().getInputStream()));
                listener.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (server.getInputData().size() > 0) {
            server.setState(new ProcessState(server));
        }
    }
    public  class Listener extends Thread {
        @Override
        public void run() {
            String tmp;
            try {
                while ((tmp = in.readLine()) != null) {
                    server.getInputData().offerLast(tmp);
                    System.out.println(server.getInputData());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
