package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

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

    @DisplayName("입력값이_전부_숫자가_아닐_경우_예외_발생")
    @Test
    void 입력값이_전부_숫자가_아닐_경우_예외_발생() {
        // given && when && then
        assertThatThrownBy(() -> InputParse.parseNumbers("12e"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}