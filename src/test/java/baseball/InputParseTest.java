package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParseTest {

    @DisplayName("입력값이_전부_숫자가_아닐_경우_예외_발생")
    @Test
    void 입력값이_전부_숫자가_아닐_경우_예외_발생() {
        // given && when && then
        assertThatThrownBy(() -> InputParse.parseNumbers("12e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_3자리_수가_아닐_경우_예외_발생() {
        assertThatThrownBy(() -> InputParse.parseNumbers("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputParse.parseNumbers("32"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputParse.parseNumbers("3245"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_3자리_수_테스트_통과() {
        List<Integer> numbers = InputParse.parseNumbers("123");

        assertThat(numbers.size()).isEqualTo(3);
    }
}