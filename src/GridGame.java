import java.util.*;

public class GridGame {
    public static List<List<Integer>> gridGame(List<List<Integer>> grid, int k, List<String> rules) {
        if (grid == null || grid.size() == 0) {
            return grid;
        }

        while (k > 0) {
            k--;
            List<List<Integer>> neighbourCount = getNeighbourCount(grid);
            for (int i = 0; i < neighbourCount.size(); i++) {
                for (int j = 0; j < neighbourCount.get(0).size(); j++) {
                    if (rules.get(neighbourCount.get(i).get(j)).equals("alive")) {
                        grid.get(i).set(j, 1);
                    } else {
                        grid.get(i).set(j, 0);
                    }
                }
            }
        }

        return grid;
    }

    private static List<List<Integer>> getNeighbourCount(List<List<Integer>> grid) {
        int[] dirs = {-1, 0, 1};
        int[][] directions = {{0,1},{0,-1},{1,0},{1,-1},{1,1},{-1,0},{-1,1},{-1,-1}};
        List<List<Integer>> neighbours = new ArrayList<>();
        for (int row = 0; row < grid.size(); row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < grid.get(0).size(); col++) {
                int liveNeighbours = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(dirs[i] == 0 && dirs[j] == 0)) {
                            int nextRow = row + dirs[i];
                            int nextCol = col + dirs[j];
                            if (nextRow < 0 || nextCol < 0 || nextRow >= grid.size() || nextCol >= grid.get(0).size()
                                    || grid.get(nextRow).get(nextCol) != 1) {
                                continue;
                            }
                            liveNeighbours += 1;
                        }
                    }
                }
                rowList.add(liveNeighbours);
            }
            neighbours.add(rowList);
        }
        return neighbours;
    }


    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 0, 0));
        grid.add(Arrays.asList(0, 0, 0, 0));
        List<String> rules = Arrays.asList("dead", "alive", "dead", "dead", "dead", "alive", "dead", "dead", "dead");
        System.out.println(gridGame(grid, 2, rules));
    }
}
