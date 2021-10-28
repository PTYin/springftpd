package asia.ptyin.springftpd;

import asia.ptyin.springftpd.component.ServerPi;
import asia.ptyin.springftpd.property.ServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@EnableConfigurationProperties(ServerProperties.class)
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
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
