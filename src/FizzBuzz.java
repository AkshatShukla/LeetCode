import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        if (n == 1) {
            result.add("1");
            return result;
        }

        for (int i = 1; i<=n ; i++)
        {
            if (i%15 == 0)
                result.add("FizzBuzz");
            else if ((i%3==0) || (i%5==0)) {
                if (i%3 == 0)
                    result.add("Fizz");
                else if (i%5 == 0)
                    result.add("Buzz");
            }
            else
                result.add(Integer.toString(i));

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> r = new ArrayList<>();

        r = fizzBuzz(15);
        System.out.println(Arrays.asList(r));
    }
}
