import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppDI {
    public static void main(String args[]){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");
        //Constructor Injection
        Sport sport1=context.getBean("mySportCI",Sport.class);
        System.out.println(sport1.getStadium());
        //Setter Injection
        Sport sport2=context.getBean("mySportSI",Sport.class);
        System.out.println(sport2.getStadium());
    }
}
