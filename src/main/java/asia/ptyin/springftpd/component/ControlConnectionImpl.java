package asia.ptyin.springftpd.component;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;

/***
 *
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
@Log4j2
@Scope("prototype")
@Component
public class ControlConnectionImpl implements ControlConnection
{
    private Socket clientSocket;

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
