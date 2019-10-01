public class RollDice {
    public static int minNoOfMoves(int[] dice) {
        int minMoves = Integer.MAX_VALUE;
        int temp;
        int[] countMap = new int[7];

        for (int n : dice)
            countMap[n]++;

        int numOfDice = dice.length;

        for (int i = 1; i < 7; i++) {
            int countToRotateCompliments = 2 * countMap[7 - i];
            int countToRotateNonCompliments = numOfDice - countMap[7 - i];
            temp = countToRotateCompliments + countToRotateNonCompliments - countMap[i];
            minMoves = Math.min(minMoves, temp);
        }
        return minMoves;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        System.out.println(minNoOfMoves(num));
        num = new int[]{1, 1, 6};
        System.out.println(minNoOfMoves(num));
        num = new int[]{1, 6, 2, 3};
        System.out.println(minNoOfMoves(num));
    }
}
