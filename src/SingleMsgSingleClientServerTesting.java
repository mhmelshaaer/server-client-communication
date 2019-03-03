import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleMsgSingleClientServerTesting {

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        Client client = new Client("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        assertEquals("Hello client", response);
    }

}
