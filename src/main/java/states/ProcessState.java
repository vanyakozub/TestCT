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
            System.out.println("process " + server.getInputData());
            TimeUnit.SECONDS.sleep(server.getMinProcessingTime());//add time delay
            server.setState(new SendState(server));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
