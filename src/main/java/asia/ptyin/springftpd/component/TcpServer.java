package asia.ptyin.springftpd.component;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public interface TcpServer
{

    /**
     * @return Returns true on success; otherwise returns false.
     */
    boolean listen();

    /**
     * @return Returns whether the server is listening.
     */
    boolean isListening();
    void setOnConnected(Socket client);
    void setOnReleased(Socket client);

}
