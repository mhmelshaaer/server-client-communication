import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MultiMsgMultiClientServerTesting {
    @Test
    public void givenClient1_whenServerResponds_thenCorrect() throws IOException {
        Client client1 = new Client("127.0.0.1", 6666);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
    }

    @Test
    public void givenClient2_whenServerResponds_thenCorrect() throws IOException {
        Client client2 = new Client("127.0.0.2", 6666);
        String msg1 = client2.sendMessage("hello");
        String msg2 = client2.sendMessage("world");
        String terminate = client2.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
    }
}
