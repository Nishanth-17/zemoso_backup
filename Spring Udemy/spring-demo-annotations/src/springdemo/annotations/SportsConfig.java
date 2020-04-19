package springdemo.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springdemo.annotations")
@PropertySource("sport.properties")
public class SportsConfig {
    private FortuneService getFortune(){
        return new HappyFortuneService();
    }
    @Bean
    public Coach swimCoach()  { //swimCoach is the bean ID for the bean.
        return new SwimCoach(getFortune());
    }

}
