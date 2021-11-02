package asia.ptyin.springftpd.component;

import asia.ptyin.springftpd.SpringFtpDApplication;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Log4j2
@ContextConfiguration(classes = SpringFtpDApplication.class)
@SpringBootTest
class ServerPiImplTest
{
    @Autowired
    private ServerPi server;

    @Test
    @DisplayName("❤")
    void testListen()
    {
        server.listen();
    }

    @Test
    void testSingleConnection() throws IOException
    {
        log.info(server.getSocket());
        server.listen();
        assert server.isListening();

        var client = new Socket(server.getSocket().getInetAddress(), server.getSocket().getLocalPort());
        var outputStream = client.getOutputStream();
        var dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hello, world.");

        var inputStream = client.getInputStream();
        var dataInputStream = new DataInputStream(inputStream);
        log.info(dataInputStream.readUTF());
        client.close();
    }

    @Test
    void testMultipleConnection() throws  IOException
    {

    }
}