package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputParse {

    private InputParse() {}

    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.trim().split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
