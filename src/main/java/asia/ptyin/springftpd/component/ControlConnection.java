package asia.ptyin.springftpd.component;

import java.net.Socket;
import java.nio.channels.SocketChannel;

/***
 * control connection established from user PI to server PI
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
public interface ControlConnection extends Runnable
{
    void setClientSocket(Socket clientSocket);
}
