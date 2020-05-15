package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class NewAspect {
    @Before("execution(public void addAccount(*))")
    public void beforeAddAccount(){
        System.out.println("This aspect has an order 2 and runs before addAccount method is called");
    }
}
