package asia.ptyin.springftpd.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import static java.nio.channels.SelectionKey.*;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public abstract class ServerPiImpl implements ServerPi
{
    private final ExecutorService pool;
    private final ExecutorService listener;

    private final ServerSocket serverPiSocket;

    private int liveConnections;
    private boolean listening;

    /**
     * @param serverPiSocket Server PI socket.
     * @throws IOException If an I/O error occurs.
     */
    @Autowired
    public ServerPiImpl(ServerSocket serverPiSocket,
                        @Value("${springftpd.server.pi.max-connection}") int maxConnection) throws IOException
    {
        this.serverPiSocket = serverPiSocket;
        this.pool = Executors.newFixedThreadPool(maxConnection);
        this.listener = Executors.newSingleThreadExecutor();

        this.liveConnections = 0;
        this.listening = false;
    }

    @Override
    public boolean listen()
    {
        listening = true;
        listener.execute(() ->
        {
            while (true)
            {
                try
                {
                    var client = this.serverPiSocket.accept();  // block
                    var connection = establishControlConnection();
                    connection.setClientSocket(client);
                    pool.execute(connection);
                } catch (IOException e)
                {
                    listening = false;
                    log.error(e.getMessage());
                    System.exit(e.hashCode());
                }
            }
        });

        return true;
    }

    @Lookup
    public abstract ControlConnection establishControlConnection();  // method injection

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

    @Override
    public int getLiveConnections()
    {
        return liveConnections;
    }
}
