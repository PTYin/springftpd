package asia.ptyin.springftpd.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
    private ServerSocket serverPiSocket;
    private Socket clientSocket;

    @Autowired
    public void setServerPiSocket(ServerSocket serverPiSocket)
    {
        this.serverPiSocket = serverPiSocket;
    }

    @Override
    public void setClientSocket(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                var message = clientSocket.getInputStream();
                log.info(String.format("FROM %s: %s", clientSocket, message));
                // TODO do something
            }
        } catch (IOException e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
