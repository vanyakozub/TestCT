import java.io.*;
import java.net.*;
public class tcpClient {
    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1";
        int portNumber = 9876;

        try {
            Socket kkSocket = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            String fromServer;
            Input input = new Input(kkSocket);
            input.start();
            while (true){
                if((fromServer = in.readLine()) != null) {
                    System.out.println(fromServer);
                }
                else {
                    System.out.println("Server is closed");
                }
            }





        }
        catch (UnknownHostException e) {  }
        catch (IOException e) {  }
    }
}
