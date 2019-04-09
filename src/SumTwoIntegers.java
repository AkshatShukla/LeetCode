public class SumTwoIntegers {
    public static void main(String[] args) {
//        int num = 38;
//        int value=getsum(num);
//        while(value>10){
//            value=getsum(value);
//        }
//        System.out.println(value);
        int num = 46;
        int x = (num - 1) % 9;
        if (num == 0) System.out.println("0");
        else System.out.println(1 + (num - 1) % 9);

    }

//    public static int getsum(int num){
//        int sum=0;
//        while(num>0){
//            sum+=num%10;
//            num/=10;
//        }
//        return sum;
//    }
}