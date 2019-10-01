import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TwoCityScheduling {
    /*
    1 iterate the costs, choose the cheaper cost's destination regardless of N.
2 record the price difference in two ArrayList: changA and changeB, if a person chooses to go to A, then add the price difference into changeB, vice versa
3 check which arraylist is bigger, then add the smaller differences
for example
50 400 ans+= 50 B.add(350)
40 10 ans+= 10 A.add(30)
30 20 ans+= 20 A.add(10)
70 20 ans+= 20 A.add(50)
A.size() > B.size(), then ans = ans + 10;
done
     */
    public static int twoCitySchedCost1(int[][] costs) {
        ArrayList<Integer> changeA = new ArrayList<>();
        ArrayList<Integer> changeB = new ArrayList<>();
        int ans = 0;

        for (int[] c : costs) {
            if (c[0] < c[1]) {
                ans += c[0];
                changeB.add(c[1] - c[0]);
            } else {
                ans += c[1];
                changeA.add(c[0] - c[1]);
            }
        }

        if (changeA.size() > changeB.size()) {
            Collections.sort(changeA);
            for (int i = 0; i < changeA.size() - costs.length / 2; i++) {
                ans += changeA.get(i);
            }
        } else if (changeA.size() < changeB.size()) {
            Collections.sort(changeB);
            for (int i = 0; i < changeB.size() - costs.length / 2; i++) {
                ans += changeB.get(i);
            }
        }
        return ans;
    }

    public static int twoCitySchedCost(int[][] costs) {
        // sorting based on the difference of flying cost to A and B.
        Arrays.sort(costs, (a, b) -> {
            return (a[1] - a[0]) - (b[1] - b[0]);
        });

        int totalCost = 0, len = costs.length, mid = len / 2;

        for (int i = 0; i < len; i++) {
            // since need to divide 2N people equally,
            if (i < mid) {
                // taking the highest price for scenario where the different between high and low is less.
                totalCost += costs[i][1];
            } else {
                // taking the lowest price for scenario where the different between high and low is more.
                // e.g if input is : [20, 30], [50, 150]
                // the best way to divide these two people will be by taking high of first entry and low of second entry.
                totalCost += costs[i][0];
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCitySchedCost(costs));
        System.out.println(twoCitySchedCost1(costs));
    }
}
