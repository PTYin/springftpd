package asia.ptyin.springftpd.component;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

@Log4j2
@Getter
@Service
public abstract class ServerPiImpl implements ServerPi
{
    private ServerSocket socket;

    /**
     * @param port The port listened on.
     * @param backlog the maximum length of request queue.
     * @param address The local address of server.
     */
    public ServerPiImpl(@Value("${springftpd.server.pi.port}") int port,
                        @Value("${springftpd.server.pi.backlog}") int backlog,
                        @Value("${springftpd.server.pi.address}") InetAddress address)
    {
        try
        {
            this.socket = new ServerSocket(port, backlog, address);

        } catch (IOException e)
        {
            log.error(e.getMessage());
            System.exit(e.hashCode());
        }
    }

    @Override
    public boolean listen()
    {
        new Thread(() ->
        {
            try
            {
                while (true)
                {
                    var client = this.socket.accept();
                    var connection = establishControlConnection();
                    connection.setClientSocket(client);
                }
            } catch (IOException e)
            {
                log.error(e.getMessage());
                System.exit(e.hashCode());
            }
        }).start();
        return true;
    }

    @Lookup
    public abstract ControlConnection establishControlConnection();

    @Override
    public boolean isListening()
    {
        return false;
    }

    @Override
    public void setOnConnected(Socket client)
    {

    }

    @Override
    public void setOnReleased(Socket client)
    {

    }
}
