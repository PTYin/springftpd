package asia.ptyin.springftpd.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
@Component
public class FtpConnectionImpl implements FtpConnection
{
    private TcpServer server;

    @Autowired
    public void setServer(TcpServer server)
    {
        this.server = server;
    }
}
