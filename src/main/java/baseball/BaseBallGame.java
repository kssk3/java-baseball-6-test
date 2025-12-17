package baseball;

import baseball.view.InputView;
import java.util.List;
import java.util.function.Supplier;

public class BaseBallGame {

    private InputView inputView;

    public void run() {
        GamePoints gamePoints = getGamePoints();
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private GamePoints getGamePoints() {
        return retryOnException(() -> {
            List<Integer> computerPoints = List.of(3, 2, 1);
            List<Integer> numbers = InputParse.parseNumbers("123");
//        List<Integer> numbers = InputParse.parseNumbers(inputView.readLine());
            return new GamePoints(computerPoints, numbers);
        });
    }
}
