public class LemonadeChange {
    public static void main(String[] args) {
        //int[] bills = new int[]{5,5,5,10,20};
        //int[] bills = new int[]{5,5,5,10,5,20,5,10,5,20};
        int[] bills = new int[]{5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {
        if (bills.length == 0 || bills[0] != 5)
            return false;
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five > 0)
                    five--;
                else
                    return false;
            } else {
                if (ten > 0) {
                    if (five > 0) {
                        ten--;
                        five--;
                    } else
                        return false;
                } else {
                    if (five >= 3) {
                        five -= 3;
                    } else
                        return false;
                }
            }
        }
        return true;
    }
}
