import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        /*
        Say we have our answer as a stack with rightmost asteroid top, and a new asteroid comes in. If new is moving
        right (new > 0), or if top is moving left (top < 0), no collision occurs.
        Otherwise, if abs(new) < abs(top), then the new asteroid will blow up; if abs(new) == abs(top) then both
        asteroids will blow up; and if abs(new) > abs(top), then the top asteroid will blow up (and possibly more
        asteroids will, so we should continue checking.)
         */
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    if (stack.peek() < Math.abs(asteroid)) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == Math.abs(asteroid)) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0 && !stack.isEmpty(); i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -2, 1, -2})));
    }
}
