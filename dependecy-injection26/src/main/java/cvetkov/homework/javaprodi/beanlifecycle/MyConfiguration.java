package cvetkov.homework.javaprodi.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean(initMethod = "beanInitMethod", destroyMethod = "beanDestroyMethod")
    public Experiment experiment() {
        return new Experiment();
    }
}
