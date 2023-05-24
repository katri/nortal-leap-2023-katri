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
        Game game = new GameImpl();

        MyResource resource = new MyResource();
        char [][] map = resource.readFile();


        game.escapeFromTheWoods(resource);
        return 77;
    }
}
