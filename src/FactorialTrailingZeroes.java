public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

    /*
    Because all trailing 0 is from factors 5 * 2.
    But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors.
    In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.


    Let f(n) be the function that counts the number of factor 5 in n!. We use a dummy function COUNT5() to denote this action:
f(n)=COUNT5(n!)=COUNT5(1525...floor(n/5)5)
We have floor(n/5) here because, for example, if we wanna count 5s in 126!, the last position of interest is actually floor(126/5)5=125, as it's the last number with factor 5.
From the function COUNT5, we can extract the 5s that we already see:
f(n)=floor(n/5)+COUNT5(123...floor(n/5))
Notice that COUNT5(123...*floor(n/5)) is also f(floor(n/5)), by our definition.
Therefore, f(n)=floor(n/5)+f(floor(n/5)). And in programming, integer division itself does flooring automatically. So:
f(n)=n/5+f(n/5)
This is how we get the recursion.
     */
    private static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
