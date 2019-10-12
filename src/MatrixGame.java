import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MatrixGame {
    public static int play(List<List<Integer>> arr) {
        int tomScore = 0;
        int jerryScore = 0;
        List<Integer> maxValues = new ArrayList<>();
        for (int j = 0; j < arr.get(0).size(); j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < arr.size(); i++) {
                maxVal = Math.max(arr.get(i).get(j), maxVal);
            }
            maxValues.add(maxVal);
        }
        maxValues.sort((o1, o2) -> o2 - o1);
        boolean tomTurn = true;
        for (int val : maxValues) {
            if (tomTurn) {
                tomScore += val;
            } else {
                jerryScore += val;
            }
            tomTurn = !tomTurn;
        }
        return tomScore - jerryScore;
    }

    public static void main(String[] args) {

    }
}
