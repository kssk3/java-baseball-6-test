package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
}