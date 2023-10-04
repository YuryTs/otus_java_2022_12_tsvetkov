package cvetkov.homework.javaprodi.application.config;

import cvetkov.homework.javaprodi.application.services.EquationPreparer;
import cvetkov.homework.javaprodi.application.services.GameProcessor;
import cvetkov.homework.javaprodi.application.services.IOService;
import cvetkov.homework.javaprodi.application.services.PlayerService;
import cvetkov.homework.javaprodi.application.services.impl.GameProcessorImpl;
import cvetkov.homework.javaprodi.application.services.impl.IOServiceStreams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration//конфигурационный класс в котором методы по созданию бинов
public class AppConfig {

    @Bean
    public GameProcessor gameProcessor(IOService ioService,
                                       PlayerService playerService,
                                       EquationPreparer equationPreparer) {
        return new GameProcessorImpl(ioService, equationPreparer, playerService); //говорим что для создания объекта GameProcessorImpl мы передаем три интерфейса в качестве параметра метода и передаем в конструктор
    }

    @Bean
    public IOService ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}
