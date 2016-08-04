import com.liangyumingblog.SimilarDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

    public static void main(String[] args)
    {
        String springXmlPath = "com/liangyumingblog/MyApplication.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(springXmlPath);

        SimilarDataBase DB = ctx.getBean(SimilarDataBase.class);

        print("Now Insert these Object " + ctx.getBean("HappyEnd") + "|" + ctx.getBean("HappyEnd"));
        
        DB.insert(ctx.getBean("HappyEnd"));

        DB.insert(ctx.getBean("banana"));

        print("Now query these Object " + ctx.getBean("HappyEnd") + "|" + ctx.getBean("HappyEnd"));

        DB.query(ctx.getBean("HappyEnd"));

        DB.query(ctx.getBean("banana"));
    }

    static void print(Object o)
    {
        System.out.println(o);
    }
}
