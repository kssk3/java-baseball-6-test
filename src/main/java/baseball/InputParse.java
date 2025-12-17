package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputParse {

    private static final String REGEX_PATTERN_NUMBER = "^[\\d]*$";

    private InputParse() {}

    public static List<Integer> parseNumbers(String input) {
        validateNumbers(input);
        validateNumberLength(input);
        return Arrays.stream(input.trim().split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNumbers(String input) {
        if(!Pattern.matches(REGEX_PATTERN_NUMBER, input)) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static void validateNumberLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 3자리가 아닙니다.");
        }
    }
}
