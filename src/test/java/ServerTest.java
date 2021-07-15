import org.junit.Test;
import server.Server;

import java.util.concurrent.TimeUnit;

public class ServerTest {
    @Test
    public void serverTest() throws InterruptedException {
        Server server = new Server("props.xml");
        while (true) {
            server.getState().process();
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }
}
