import com.liangyumingblog.Printor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String[] args)
    {
        String springXmlPath = "com/liangyumingblog/MyApplication.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(springXmlPath);

        Printor printor = ctx.getBean(Printor.class);

        System.out.println("UnCrypt " + ctx.getBean("HappyEnd"));

        printor.print(ctx.getBean("HappyEnd"));
        printor.print(ctx.getBean("banana"));
    }
}
