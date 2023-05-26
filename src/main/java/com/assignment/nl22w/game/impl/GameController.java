package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class GameController {
    @GetMapping("new")
    public int getOutOfTheWoods() throws IOException {
        try {
            Game game = new GameImpl();
            MyResource resource = new MyResource();
            resource.setMapFile();
            return game.escapeFromTheWoods(resource);
        } catch (RuntimeException exception) {
            return 0;
        }
    }
}
