import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    private Map<String, List<Pair<String, Integer>>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<String, Integer>> search = map.get(key);
        // search the index of timestamp in the value list sorted by timestamp
        // use binary search
        int lo = 0;
        int hi = search.size() - 1;
        String ret = "";
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int ts = search.get(mid).getValue();
            if (ts == timestamp) {
                return search.get(mid).getKey();
            } else if (ts < timestamp) {
                ret = search.get(mid).getKey();
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ret;
    }
}
