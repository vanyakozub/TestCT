package server;

import states.ListenState;
import states.State;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
    private State state;
    private int portNumber;
    private int minProcessingTime;
    private String inputData;

    public Server (String configFilename) {
        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(configFilename));
            minProcessingTime = Integer.parseInt(prop.getProperty("processingTime"));
            portNumber = Integer.parseInt(prop.getProperty("port"));
            serverSocket = new ServerSocket(portNumber);
            state = new ListenState(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getMinProcessingTime() {
        return minProcessingTime;
    }

    public void setMinProcessingTime(int minProcessingTime) {
        this.minProcessingTime = minProcessingTime;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    ServerSocket serverSocket;
    Socket clientSocket;

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }



    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
