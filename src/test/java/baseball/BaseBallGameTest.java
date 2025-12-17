package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    void gameStartTest() {
        List<Integer> computerPoints = List.of(3,2,1);
        List<Integer> points = InputParse.parseNumbers("123");

        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.run();


    }
}