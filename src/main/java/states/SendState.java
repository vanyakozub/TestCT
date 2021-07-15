package states;

import server.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class SendState extends State {

    public SendState(Server server) {
        super(server);
    }

    public void process() {
        try {
            System.out.println("send " + server.getInputData().getFirst());
            PrintWriter out = new PrintWriter(server.getClientSocket().getOutputStream(), true);
            TimeUnit.SECONDS.sleep(server.getMinProcessingTime());//add time delay
            out.write(server.getInputData().pollFirst());
            server.setState(new ListenState(server));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
