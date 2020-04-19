package springdemo.annotations;

import org.springframework.stereotype.Component;

@Component("cfs")
public class ClueFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "Meaningless Clue less Fortune";
    }
}
