package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GameController {
    @GetMapping("/")
    public int getOutOfTheWoods() throws IOException {
        try {
            Game game = new GameImpl();
            ResourceImpl resource = new ResourceImpl();
            return game.escapeFromTheWoods(resource);
        } catch (RuntimeException exception) {
            return 0;
        }
    }
}
