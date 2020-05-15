package aopdemo.java;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String args[]){
        //read spring config class
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from container
        AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO themembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        AccountDAO acc=context.getBean("accountDAO",AccountDAO.class);
        //call the business method
        theAccountDAO.addAccount();
        themembershipDAO.addAccount();
        acc.addAccount(true);

        //close the method
        context.close();
    }
}
