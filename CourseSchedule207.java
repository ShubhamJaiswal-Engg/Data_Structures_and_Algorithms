
// 207. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inCourse = new int[numCourses];

        // Initialize graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        };

        // create prerequisites
        for(int[] pre : prerequisites) {

            // pre[0] is course
            // pre[1] is prerequisites (Dependency)
            // for taking a, firstly b must be completed

            graph.get(pre[1]).add(pre[0]);

            // Indegree
            inCourse[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {

            // i is node here
            if(inCourse[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for(int next : graph.get(curr)) {
                inCourse[next]--;
                if(inCourse[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}