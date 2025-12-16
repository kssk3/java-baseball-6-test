package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {

    @BeforeEach
    void setUp() {
        List<Integer> points = new ArrayList<>();
        while(points.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!points.contains(number)) {
                points.add(number);
            }
        }
    }

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
}
