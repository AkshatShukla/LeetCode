import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        // map with content as key and filenames with this content as value
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                int p = files[i].indexOf('(');
                String key = files[i].substring(p);
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(files[0] + "/" + files[i].substring(0, p));
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }
}
