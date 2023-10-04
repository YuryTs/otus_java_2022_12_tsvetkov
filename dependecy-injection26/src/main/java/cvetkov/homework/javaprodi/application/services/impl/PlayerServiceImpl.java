package cvetkov.homework.javaprodi.application.services.impl;

import cvetkov.homework.javaprodi.application.model.Player;
import cvetkov.homework.javaprodi.application.services.IOService;
import cvetkov.homework.javaprodi.application.services.PlayerService;
import org.springframework.stereotype.Component;


@Component
public class PlayerServiceImpl implements PlayerService {

    private IOService ioService;

    public PlayerServiceImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public Player getPlayer() {
        ioService.out("Представьтесь пожалуйста");
        String playerName = ioService.readLn("Введите имя: ");
        return new Player(playerName);
    }
}
