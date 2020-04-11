package initializer;

import com.tbot.initializer.InitializerClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class InitClass {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.tbot");
        InitializerClass bean = context.getBean(InitializerClass.class);
        bean.init();
    }
}
