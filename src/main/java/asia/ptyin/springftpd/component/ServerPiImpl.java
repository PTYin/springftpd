package asia.ptyin.springftpd.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
@Service
public abstract class ServerPiImpl implements ServerPi
{
    private final ServerSocket serverPiSocket;
    private boolean listening;

    @Autowired
    public ServerPiImpl(ServerSocket serverPiSocket)
    {
        this.serverPiSocket = serverPiSocket;
    }

    @Override
    public boolean listen()
    {
        new Thread(() ->
        {
            try
            {
                listening = true;
                while (true)
                {
                    var client = this.serverPiSocket.accept();
                    var connection = establishControlConnection();
                    connection.setClientSocket(client);
                }
            } catch (IOException e)
            {
                listening = false;
                log.error(e.getMessage());
                System.exit(e.hashCode());
            }
        }).start();

        return listening;
    }

    @Lookup
    public abstract ControlConnection establishControlConnection();

    @Override
    public boolean isListening()
    {
        return listening;
    }

    @Override
    public ServerSocket getSocket()
    {
        return serverPiSocket;
    }
}
