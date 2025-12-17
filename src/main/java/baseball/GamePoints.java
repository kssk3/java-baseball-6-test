package baseball;

import java.util.List;

public class GamePoints {

    private List<Integer> computePoints;
    private List<Integer> points;
    private int strikeCounts;
    private int ballCounts;
    private boolean emptyPoint;

    public GamePoints(List<Integer> computePoints, List<Integer> points) {
        this.computePoints = computePoints;
        this.points = points;
        calculateGamePoints(computePoints, points);
        this.emptyPoint = isEmptyPoints(strikeCounts, ballCounts);
    }

    private void calculateGamePoints(List<Integer> computerPoints, List<Integer> points) {
        for (int i = 0; i < computerPoints.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j && computerPoints.get(i).equals(points.get(j))) {
                    strikeCounts++;
                }
                if (i != j && computerPoints.get(i).equals(points.get(j))) {
                    ballCounts++;
                }
            }
        }
    }

    private boolean isEmptyPoints(int strikeCounts, int ballCounts) {
        return strikeCounts == 0 && ballCounts == 0;
    }

    public int getStrikeCounts() {
        return strikeCounts;
    }

    public int getBallCounts() {
        return ballCounts;
    }

    public boolean isEmptyPoint() {
        return emptyPoint;
    }
}
