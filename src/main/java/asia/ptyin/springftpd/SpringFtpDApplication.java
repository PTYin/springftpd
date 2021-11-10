package asia.ptyin.springftpd;

import asia.ptyin.springftpd.property.server.ServerPiProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;


@SpringBootApplication
public class SpringFtpDApplication
{

    public static void main(String[] args)
    {
        var ctx = SpringApplication.run(SpringFtpDApplication.class, args);
        ctx.registerShutdownHook();
//        ServerPi pi  = (ServerPi) ctx.getBean("serverPiImpl");
//        System.out.println(pi.getSocket());
    }

    @Bean
    public ServerSocket serverPiSocket(@Value("${springftpd.server.pi.port}") int port,
                                       @Value("${springftpd.server.pi.backlog}") int backlog,
                                       @Value("${springftpd.server.pi.address}") InetAddress address) throws IOException
    {
        return new ServerSocket(port, backlog, address);
    }

    @Bean
    public ServerSocket serverDtpSocket(@Value("${springftpd.server.dtp.port}") int port,
                                        @Value("${springftpd.server.dtp.backlog}") int backlog,
                                        @Value("${springftpd.server.dtp.address}") InetAddress address) throws IOException
    {
        return new ServerSocket(port, backlog, address);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
