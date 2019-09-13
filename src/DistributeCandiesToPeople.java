import java.util.Arrays;

public class DistributeCandiesToPeople {
    public static int[] distributeCandies(int candies, int num_people) {
        int candiesToGive = 1;
        int[] distribution = new int[num_people];
        int idx = 0;

        while (candies - candiesToGive > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies - candiesToGive > 0) {
                    distribution[i] += candiesToGive;
                    candies -= candiesToGive;
                    idx = (i + 1) % num_people;
                    candiesToGive++; // give 1 more candy in next turn
                }
            }
        }
        distribution[idx] += candies;
        return distribution;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }
}
