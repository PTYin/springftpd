package asia.ptyin.springftpd.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/***
 *
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
@Slf4j
@Scope("prototype")
@Component
public class ControlConnectionImpl implements ControlConnection
{
    private ServerPi serverPi;
    private Socket clientSocket;

    @Autowired
    public void setServerPi(ServerPi serverPi)
    {
        this.serverPi = serverPi;
    }

    @Override
    public void setClientSocket(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    private synchronized void modifyServerPiLiveConnections()
    {
        serverPi.getLiveConnections();
    }

    private void processCommand(String message)
    {

    }

    private void response(String message) throws IOException
    {
        var outputStream = clientSocket.getOutputStream();
        var dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(message);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                var inputStream = clientSocket.getInputStream();
                var dataInputStream = new DataInputStream(inputStream);
                log.info(String.format("FROM %s: %s", clientSocket, dataInputStream.readUTF()));
                // TODO do something

            } catch (IOException e)
            {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
