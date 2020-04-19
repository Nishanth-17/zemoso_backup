package aopdemo.aspect;

import aopdemo.java.Account;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.aspectj.apache.bcel.classfile.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(1)
@Component
public class DemoLoggingAspect {

    //Add relative advices for logging

        //@Before advice
    //@Before("execution(public void aopdemo.dao.AccountDAO.addAccount())")
    /*public void beforeAddAccount(){
        System.out.println("-------------- Executing before addAccount() is executed!!!!!!!!");
    }*/
    //@Before("execution(* addA*(*))") // Matches a Single parameter
    //@Before("execution(* addA*(..))") //Matches any number of parameters

    //POINTCUT DECLARATION
    /*@Pointcut("execution(* addA*())")
    private void daopointcut(){}

    @Before("daopointcut()")
    public void beforeAddAccount(){
        System.out.println("-------------- Executing before addAccount() is executed!!!!!!!!");
    }*/

    /*@Before("execution(public void aopdemo.dao.AccountDAO.addAccount(*))")
    public void beforeAddAccount(JoinPoint theJoinPoint){
        //JoinPoint has MetaData about the method call
        MethodSignature method=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("method Signature :"+method);
        //LETS DISPLAY METHOD ARGUMENTS
        Object args[]=theJoinPoint.getArgs();
        for(Object temp:args){
            System.out.println("Method Args: "+temp);
        }
    }
    */

    //Add a new advice for @AfterReturning on findAccounts method
    /*@AfterReturning(pointcut = "execution(public void aopdemo.dao.AccountDAO.findAccounts())",returning = "result")
    public void afterReturningFindAccounts(JoinPoint thejoinPoint, List<Account> result){
         String method=thejoinPoint.getSignature().toShortString();
         System.out.println("_-------------------Executing afterReturn advice on method: "+method);
         System.out.println("------Results: "+result);
    }*/
    /*
    @AfterThrowing(pointcut = "execution(public void aopdemo.dao.AccountDAO.findAccounts())", throwing="theExec")
    public void afterThrowingFindAccounts(Throwable theExec){
        System.out.println("-----Executing afterThrowing Advice ");
        System.out.println("Excecption is : "+ theExec);
    }
    */
     @Around("execution(public void aopdemo.dao.AccountDAO.findAccounts())")
    public Object aroundgetMethod(ProceedingJoinPoint theprojoin) throws Throwable {
         Object result=null;
         DebugLogger mylogger=new DebugLogger();
         mylogger.info("LOGGER WARNING");
         try{
             result=theprojoin.proceed();
         }
         catch (Exception exc){
             System.out.println("@Around advice : "+exc);
             result="Find the root cause";
         }
         return result;
     }
}
