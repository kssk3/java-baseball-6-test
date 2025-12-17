package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallTest {

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

    @Test
    void 중복된_값이_없을_경우_테스트_통과() {
        // given
        List<Integer> points = InputParse.parseNumbers("123");

        // when
        final BaseBall game = new BaseBall(points);

        // then
        assertThat(game.getPoints()).isEqualTo(points);
    }

    @Test
    void 중복된_값이_있을_경우_테스트_실패() {
        // given when
        List<Integer> points = InputParse.parseNumbers("122");

        // then
        assertThatThrownBy(() -> new BaseBall(points))
                .isInstanceOf(IllegalArgumentException.class);
    }
}