package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GamePointsTest {

    @Test
    void 같은_수가_같은_자리에_있다면_스트라이크() {
        List<Integer> computerPoints = List.of(3,2,1);
        List<Integer> points = InputParse.parseNumbers("123");

        GamePoints gameResult = new GamePoints(computerPoints, points);

        assertThat(gameResult.getStrikeCounts()).isEqualTo(1);
    }

    @Test
    void 같은_수가_다른_자리에_있다면_볼() {
        List<Integer> computerPoints = List.of(3,2,1);
        List<Integer> points = InputParse.parseNumbers("123");

        GamePoints gamePoints = new GamePoints(computerPoints, points);

        assertThat(gamePoints.getBallCounts()).isEqualTo(2);
    }

    @Test
    void 같은_수가_하나도_없을_경우_true_반환() {
        List<Integer> computerPoints = List.of(4,5,6);
        List<Integer> points = InputParse.parseNumbers("123");

        GamePoints gamePoints = new GamePoints(computerPoints, points);

        assertThat(gamePoints.isEmptyPoint()).isTrue();
    }
}
