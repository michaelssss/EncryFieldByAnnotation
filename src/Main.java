import com.liangyumingblog.SimilarDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String[] args)
    {
        String springXmlPath = "com/liangyumingblog/MyApplication.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(springXmlPath);

        SimilarDataBase printor = ctx.getBean(SimilarDataBase.class);

        System.out.println("UnCrypt " + ctx.getBean("HappyEnd"));

        printor.insert(ctx.getBean("HappyEnd"));

        System.out.println("UnCrypt " + ctx.getBean("HappyEnd"));

        printor.insert(ctx.getBean("banana"));

        System.out.println("UnCrypt " + ctx.getBean("banana"));
    }
}
