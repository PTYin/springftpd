package asia.ptyin.springftpd.component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public interface TcpServer
{

    /**
     * @return Returns true on success; otherwise returns false.
     */
    boolean listen() throws IOException;


    /**
     * @return Returns whether the server is listening.
     */
    boolean isListening();

    ServerSocket getSocket();

}
