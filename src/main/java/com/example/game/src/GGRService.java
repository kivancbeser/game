package com.example.game.src;

import com.example.game.src.model.Game;
import com.example.game.src.model.Player;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GGRService {
    long playerWithHighestGGR ;
    public Player findPlayerWithHighestGGR(Player[] players, Game[] games) {
        List<Player> last20Players = Arrays.asList(players);
        List<Game> gameList = Arrays.asList(games);

        double highestGGR = Double.NEGATIVE_INFINITY;
        Map<Long, List<Game>> listGrouped =
                gameList.stream().collect(Collectors.groupingBy(w -> w.getPlayerId()));

        for (Map.Entry<Long, List<Game>> set :
                listGrouped.entrySet()) {
            double playerGGR = calculatePlayerGGR(set.getValue());
            if (playerGGR > highestGGR) {
                highestGGR = playerGGR;
                playerWithHighestGGR = set.getKey();
            }
        }
        System.out.printf("Highest GGR:  %.2f %n", highestGGR);
        System.out.println("Player Id: " + playerWithHighestGGR);
        return last20Players.stream()
                .filter(player -> player.getId() == playerWithHighestGGR).findAny().orElseThrow();
    }

    private double calculatePlayerGGR(List<Game> gameList) {
        double totalBets = gameList.stream().mapToDouble(Game::getBetAmount).sum();
        double totalWins = gameList.stream().mapToDouble(Game::getWinAmount).sum();

        return totalBets - totalWins;
    }
}
