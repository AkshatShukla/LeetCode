public class BulbSwitcher {
    public static int bulbSwitch(int n) {
        // [off, off, off, off, off]
        // [on, on, on, on, on]
        // [on, off, on, off, on]
        // [on, off, off, off, on]
        // [on, off, off, on, on]
        // [on, off, off, on, off]
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(3));
        System.out.println(bulbSwitch(5));
    }
}
