package aopdemo.java;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String args[]){
        //read spring config class
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from container
        AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
        List<Account> myAcc=theAccountDAO.findAccounts();
        System.out.println("\nMain program :AfterReturningDemoApp");
        System.out.println("----------");
        System.out.println(myAcc);
        //AfterThrowing Advice
        try{
            System.out.println("Inside try block");
        }
        catch (Exception exc){
            System.out.println("Caught Exception :"+ exc);
        }
        //close the method
        context.close();
    }
}
