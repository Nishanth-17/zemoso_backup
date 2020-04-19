package dbwebapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //Setup Logger
    private Logger myLoger= Logger.getLogger(getClass().getName());
    //setup pointcut declarations
    @Pointcut("execution(* dbwebapp.Controller.*.*(..))")
    public void forControllerPackage(){}
    @Pointcut("execution(* dbwebapp.service.*.*(..))")
    public void forServicePackage(){}
    @Pointcut("execution(* dbwebapp.dao.*.*(..))")
    public void fordaoPackage(){}
    @Pointcut("forControllerPackage() || forServicePackage() || fordaoPackage()")
    public void forAppFlow(){}

    //Add before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        String theMethod=theJoinPoint.getSignature().toShortString();
        myLoger.info("---------------> @Before: Calling Method: "+theMethod);
    }

    //Add AfterReturning Advice
    @AfterReturning(pointcut = "forAppFlow()",returning = "theRes")
    public void afterReturning(JoinPoint thejoinPoint, Object theRes){

        String theMethod=thejoinPoint.getSignature().toShortString();
        myLoger.info("---------------> @AfterReturning: From Method: "+theMethod);
        myLoger.info("result :"+theRes);
    }

}
