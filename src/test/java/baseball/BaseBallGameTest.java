package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {


    @DisplayName("입력값이_3자리_수_일_경우_테스트_통과")
    @Test
    void 입력값이_3자리_수_일_경우_테스트_통과() {
        String input = "123";

        assertThat(input.length()).isEqualTo(3);
    }

    @DisplayName("입력값이_3자리_수가_아니면_테스트_실패")
    @Test
    void 입력값이_3자리_수가_아니면_테스트_실패() {
        String textLengthOne = "1";
        String textLengthForth = "1234";

        assertThat(textLengthOne.length()).isNotEqualTo(3);
        assertThat(textLengthForth.length()).isNotEqualTo(3);
    }

    @DisplayName("입력값에 일치한 값이 있을 경우 테스트 통과")
    @Test
    void 입력값에_일치한_값이_있을_경우_테스트_통과() {
        // given
        List<Integer> points = List.of(1, 2, 3);

        // when
        List<Integer> numbers = InputParse.parseNumbers("124");

        long count = numbers.stream()
                .filter(points::contains)
                .count();

        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    void 입력값에_일치한_값이_하나도_없을_경우_테스트_실패() {
        // given
        List<Integer> points = List.of(1, 2, 3);

        // when
        List<Integer> numbers = InputParse.parseNumbers("456");

        long count = numbers.stream()
                .filter(points::contains)
                .count();

        assertThat(count).isEqualTo(0);
    }

    @Test
    void 중복된_값이_없을_경우_테스트_통과() {
        // given
        List<Integer> points = InputParse.parseNumbers("123");

        // when
        final BaseBallGame game = new BaseBallGame(points);

        // then
        assertThat(game.getPoints()).isEqualTo(points);
    }

    @Test
    void 중복된_값이_있을_경우_테스트_실패() {
        // given when
        List<Integer> points = InputParse.parseNumbers("122");

        // then
        assertThatThrownBy(() -> new BaseBallGame(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 같은_수가_자리에_있다면_스트라이크() {
        List<Integer> targetNumbers = List.of(3,2,1);
        List<Integer> points = InputParse.parseNumbers("123");

        int strikeCount = 0;
        int ballCount = 0;
        for(int i = 0; i < targetNumbers.size(); i++) {
            for(int j = 0; j < points.size(); j++) {
                if(i == j && targetNumbers.get(i).equals(points.get(j))) {
                    strikeCount++;
                }

                if(i != j && targetNumbers.get(i).equals(points.get(j))) {
                    ballCount++;
                }
            }
        }

        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }
}