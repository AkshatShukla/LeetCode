import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[rooms.size()];
        stack.push(0); // start at room 0
        seen[0] = true;

        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (int keysToOtherRoom : rooms.get(room)) {
                if (!seen[keysToOtherRoom]) {
                    seen[keysToOtherRoom] = true;
                    stack.push(keysToOtherRoom);
                }
            }
        }

        for (boolean b : seen) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}
