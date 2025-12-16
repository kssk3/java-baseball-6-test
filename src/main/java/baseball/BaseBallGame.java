package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGame {

    private List<Integer> points;

    public BaseBallGame(List<Integer> points) {
        validateNullAndEmpty(points);
        validateDuplicateNumbers(points);
        this.points = points;
    }

    private void validateNullAndEmpty(List<Integer> otherNumbers) {
        if(otherNumbers == null || otherNumbers.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> otherNumbers) {
        Set<Integer> otherNumberSet = new HashSet<>(otherNumbers);
        if (otherNumberSet.size() != otherNumbers.size()) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    public List<Integer> getPoints() {
        return points;
    }
}
