import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        System.out.println(Arrays.toString(indegree));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        // How many courses don't need prerequisites.
        int canFinishCount = queue.size();
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }

    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1, 0}, {1, 2}, {2, 5}, {0, 2}}));
    }
}
