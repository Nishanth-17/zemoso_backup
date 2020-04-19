package springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    //FIELD INJECTION USING AUTOWIRED
    @Autowired
    @Qualifier("cfs")
    private FortuneService fortuneService;

   /* @Autowired //Here we have used this instead of constructor-args in bean definitions
    // (CONSTRUCTOR INJECTION USING AUTOWIRED)
    public TennisCoach(FortuneService theFortuneService){
        fortuneService=theFortuneService;
    }*/

    /*@Autowired  //Here we have used this instead of property name and value
    // (SETTER INJECTION USING AUTOWIRED)
    //We can use any method nam, not only setFortuneService()
    public void setFortuneService(FortuneService theFortuneService){
        fortuneService=theFortuneService;
    }*/
    public TennisCoach(){
        System.out.println("Inside my default Constructor");
    }
    //Will execute after the default constructor and dependency injection and,
    // majorly used for initializations
    @PostConstruct
    public void startUp(){
        System.out.println("Inside the post construct: init");
    }

    // Will execute before the Container Clean Up
    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside the Pre destroy");
    }

    @Override
     public String getDailyWorkout()
    {
        return "Running for half an hour";
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }


}
