import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppIOC{
    public static void main(String args[]){
        //Creating a Container and providing the configuration Metadata xml
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");

        //Retrieve the bean from Spring Container
        Sport sport=context.getBean("mySport",Sport.class);
        // SingleTon Design Pattern(Bean Scope)- Object Created once.
        Sport sl=context.getBean("mySport",Sport.class);
        //Access the methods on the bean
        String s=sport.playSport();
        System.out.println(s);

        //Close the container
        context.close();
    }
}
