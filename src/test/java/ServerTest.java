import org.junit.Test;
import server.Server;

public class ServerTest {
    @Test
    public void serverTest() {
        Server server = new Server("props.xml");
        while (true) {
            server.getState().process();
        }
    }
}
