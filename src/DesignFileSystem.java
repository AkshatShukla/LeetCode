import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    Map<String, Integer> map;

    public DesignFileSystem() {
        map = new HashMap<>();
        map.put("", 0);
    }

    public boolean createPath(String path, int value) {
        int lastSlashIndex = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastSlashIndex);
        if (!map.containsKey(parentPath) || map.containsKey(path)) {
            return false;
        }
        map.put(path, value);
        return true;
    }

    public int get(String path) {
        if (!map.containsKey(path))
            return -1;
        return map.get(path);
    }
}
