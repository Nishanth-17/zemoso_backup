package springdemo.annotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getDailyFortune() {
        return "Happy and Lucky";
    }
}
