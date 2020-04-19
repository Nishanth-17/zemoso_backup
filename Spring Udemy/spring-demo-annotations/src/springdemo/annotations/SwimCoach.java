package springdemo.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class SwimCoach implements Coach{
    private FortuneService fortuneService;
    public SwimCoach(FortuneService fortuneService1){
        fortuneService=fortuneService1;
    }
    @Value("${fab.team}")
    private String team;
    @Override
    public String getDailyWorkout() {
        return "Swim for 2 K meters "+team;
    }
    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }
}
