package states;

import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class ProcessState extends State {

    public ProcessState(Server server) {
        super(server);
    }

    public void process() {
        try {
            System.out.println("process");
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getClientSocket().getInputStream()));
            server.setInputData(in.readLine());
            TimeUnit.SECONDS.sleep(server.getMinProcessingTime());//add time delay
            server.setState(new SendState(server));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
