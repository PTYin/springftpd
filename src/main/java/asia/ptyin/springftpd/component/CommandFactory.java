package asia.ptyin.springftpd.component;

/***
 * Factory class to produce Command object.
 * @version 0.1.0
 * @author PTYin
 * @since 0.1.0
 */
public interface CommandFactory
{
    Command getCommand(String message);
}
