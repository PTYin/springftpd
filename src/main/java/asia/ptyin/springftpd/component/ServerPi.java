package asia.ptyin.springftpd.component;

import java.net.ServerSocket;

/***
 * Server Protocol Interpreter
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
public interface ServerPi extends TcpServer
{
    ControlConnection establishControlConnection();
    ServerSocket getSocket();
}
