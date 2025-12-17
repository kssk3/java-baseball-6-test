package baseball;

import java.util.List;

public class GamePoints {

    private List<Integer> computerPoints;
    private List<Integer> points;
    private int strikeCounts;
    private int ballCounts;
    private boolean emptyPoint;

    public GamePoints(List<Integer> computerPoints, List<Integer> points) {
        this.computerPoints = computerPoints;
        this.points = points;
        calculateGamePoints(computerPoints, points);
        this.emptyPoint = isEmptyPoints(this.strikeCounts, this.ballCounts);
    }

    private void calculateGamePoints(List<Integer> computerPoints, List<Integer> points) {
        for (int i = 0; i < computerPoints.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j && computerPoints.get(i).equals(points.get(j))) {
                    this.strikeCounts++;
                }
                if (i != j && computerPoints.get(i).equals(points.get(j))) {
                    this.ballCounts++;
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
