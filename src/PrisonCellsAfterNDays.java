import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public static int[] prisonAfterNDaysNaive(int[] cells, int N) {
        int[] temp = new int[cells.length];

        while (N > 0) {
            temp[0] = 0;
            temp[cells.length - 1] = 0;
            for (int i = 1; i < cells.length - 1; i++) {
                if ((cells[i - 1] == 0 && cells[i + 1] == 0) || (cells[i - 1] == 1 && cells[i + 1] == 1)) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }
//            System.out.println(Arrays.toString(cells));
            cells = temp;
            temp = new int[cells.length];
            N--;
        }
        return cells;
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] firstSimulation = new int[8];
        for (int i = 1; i < 7; i++) {
            firstSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
        }
        cells = firstSimulation.clone();
        N -= 1;
        int cycle = 1;
        while (N > 0) {
            N--;
            int[] nextSimulation = new int[8];
            for (int i = 1; i < 7; i++) {
                nextSimulation[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
            }
            if (Arrays.equals(firstSimulation, nextSimulation)) {
                N %= cycle;
            }
            cells = nextSimulation.clone();
            cycle++;
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
//        System.out.println(Arrays.toString(prisonAfterNDaysNaive(ints, 7)));
        System.out.println(Arrays.toString(prisonAfterNDays(ints, 10000000)));
    }
}
