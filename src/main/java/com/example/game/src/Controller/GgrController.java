package com.example.game.src.Controller;

import com.example.game.src.GGRService;
import com.example.game.src.model.Game;
import com.example.game.src.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class GgrController {

    @Autowired
    private GGRService ggrService;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @RequestMapping("/getHighestProfitPlayer")
    @ResponseBody
    Player getHighestProfitPlayer() {
        String uri = "https://challenge.dev.amusnetgaming.net/players?page=0&pageSize=30";
        String uriGameActivity = "https://challenge.dev.amusnetgaming.net/game-activity?page=0&pageSize=100";
        Player[] players = restTemplate.getForObject(uri, Player[].class);
        Game[] games= restTemplate.getForObject(uriGameActivity, Game[].class);

        return ggrService.findPlayerWithHighestGGR(players,games);
    }

}