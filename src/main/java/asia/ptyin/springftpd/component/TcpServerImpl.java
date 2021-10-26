package asia.ptyin.springftpd.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;


@Log4j2
@Service
public class TcpServerImpl implements TcpServer
{
    private final int port;
    private ServerSocket socket;

    public TcpServerImpl(@Value("${server.port}") int port)
    {
        this.port = port;
        try
        {
            this.socket = new ServerSocket(port);

        } catch (IOException e)
        {
            log.error(e.getMessage());
            System.exit(e.hashCode());
        }
    }

    @Override
    public int getPort()
    {
        return this.port;
    }

    @Override
    public void listen()
    {
        try
        {
            socket.accept();
        } catch (IOException e)
        {
            log.error(e.getMessage());
            System.exit(e.hashCode());
        }
    }
}
