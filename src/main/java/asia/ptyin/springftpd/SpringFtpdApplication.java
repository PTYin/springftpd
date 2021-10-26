package asia.ptyin.springftpd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class SpringFtpdApplication
{

    public static void main(String[] args)
    {
        var ctx = SpringApplication.run(SpringFtpdApplication.class, args);
        ctx.registerShutdownHook();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
