package asia.ptyin.springftpd.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/***
 * Configuration properties related to server.
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "springftpd.server.pi")
public class ServerProperties
{
    /**
     * The port listened on.
     */
    private int port;
    /**
     * the maximum length of request queue.
     */
    private int backlog;
    /**
     * the maximum length of request queue.
     */
    private InetAddress address;
}