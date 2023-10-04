package cvetkov.homework.javaprodi.application;

import cvetkov.homework.javaprodi.application.services.EquationPreparer;
import cvetkov.homework.javaprodi.application.services.GameProcessor;
import cvetkov.homework.javaprodi.application.services.IOService;
import cvetkov.homework.javaprodi.application.services.PlayerService;
import cvetkov.homework.javaprodi.application.services.impl.EquationPreparerImpl;
import cvetkov.homework.javaprodi.application.services.impl.GameProcessorImpl;
import cvetkov.homework.javaprodi.application.services.impl.IOServiceStreams;
import cvetkov.homework.javaprodi.application.services.impl.PlayerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan //спринг сканирует от этого пакета и ниже
public class Application {
    public static void main(String[] args) {
//        //если бы небыло Спринга
//        EquationPreparer equationPreparer = new EquationPreparerImpl();//у этого класса нет зависимостей поэтому создаем его первым
//        IOService ioService = new IOServiceStreams(System.out, System.in);//это класс тоже
//        PlayerService playerService = new PlayerServiceImpl(ioService);//а вот этот класс зависит от IOServiceStreams поэтому он создается после создания IOServiceStreams
//        GameProcessor gameProcessor = new GameProcessorImpl(ioService, equationPreparer, playerService);//а этот класс зависит от трех предыдущих

        //говорим спрингу что нам нужно создать контекст
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class); //создаем контекст от класса AnnotationConfigApplicationContext и передаем ему класс нашего приложения с методом майн
        //можно вместо Application.class добавить классы конфигурации
        //в этот контекст можно добавлять бины
        GameProcessor gameProcessor = context.getBean(GameProcessor.class);//создаем объект от контекста (можно передать класс, интерфейс, id-бина)

        gameProcessor.startGame();//стартуем
    }
}
