package asia.ptyin.springftpd.property.server;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/***
 * Configuration properties related to server PI.
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "springftpd.server.pi")
public class ServerPiProperties
{
    /**
     * The port listened on.
     */
    private int port;
    /**
     * The maximum length of request queue.
     */
    private int backlog;
    /**
     * The address bound to.
     */
    private InetAddress address;
    /**
     * The maximum number of connections.
     */
    private int maxConnection;
}