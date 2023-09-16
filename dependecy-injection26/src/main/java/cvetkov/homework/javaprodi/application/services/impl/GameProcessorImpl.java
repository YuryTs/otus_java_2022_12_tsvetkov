package cvetkov.homework.javaprodi.application.services.impl;



import cvetkov.homework.javaprodi.application.model.Equation;
import cvetkov.homework.javaprodi.application.model.GameResult;
import cvetkov.homework.javaprodi.application.model.Player;
import cvetkov.homework.javaprodi.application.services.EquationPreparer;
import cvetkov.homework.javaprodi.application.services.GameProcessor;
import cvetkov.homework.javaprodi.application.services.IOService;
import cvetkov.homework.javaprodi.application.services.PlayerService;

import java.util.List;


//у этого класса нет аннотации потому что он создан через конфигурационный класс
public class GameProcessorImpl implements GameProcessor {

    private static final String MSG_HEADER = "Проверка знаний таблицы умножения";
    private static final String MSG_INPUT_BASE = "Введите цифру от 1 до 10";
    private static final String MSG_RIGHT_ANSWER = "Верно\n";
    private static final String MSG_WRONG_ANSWER = "Не верно\n";

    private final IOService ioService;
    private final EquationPreparer equationPreparer;
    private final PlayerService playerService;

    public GameProcessorImpl(IOService ioService,
                             EquationPreparer equationPreparer,
                             PlayerService playerService) {
        this.ioService = ioService;
        this.equationPreparer = equationPreparer;
        this.playerService = playerService;
    }

    @Override
    public void startGame() {
        ioService.out(MSG_HEADER);
        ioService.out("---------------------------------------");
        Player player = playerService.getPlayer();
        GameResult gameResult = new GameResult(player);

        int base = ioService.readInt(MSG_INPUT_BASE);
        List<Equation> equations = equationPreparer.prepareEquationsFor(base);
        equations.forEach(e -> {
            boolean isRight = ioService.readInt(e.toString()) == e.getResult();
            gameResult.incrementRightAnswers(isRight);
            ioService.out(isRight? MSG_RIGHT_ANSWER : MSG_WRONG_ANSWER);
        });
        ioService.out(gameResult.toString());
    }
}
