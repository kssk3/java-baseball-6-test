package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

    @DisplayName("입력값이_3자리_수_일_경우_테스트_통과")
    @Test
    void 입력값이_3자리_수_일_경우_테스트_통과() {
        String input = "123";

        assertThat(input.length()).isEqualTo(3);
    }

    @DisplayName("입력값이_3자리_수가_아니면_테스트_실패")
    @Test
    void 입력값이_3자리_수가_아니면_테스트_실패() {
        String input = "1234";

        assertThat(input.length()).isNotEqualTo(3);
    }
}
