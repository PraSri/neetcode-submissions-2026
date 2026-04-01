class Solution {
    
    List<Integer> sortedOrder = new LinkedList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int counter = 0;
        if (numCourses <= 0) return false;

        // build graph of prerequisites
        // build indegree of prerequisites
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            indegree.put(child, indegree.get(child) + 1);
            graph.get(parent).add(child);
        }

        // bfs
        Queue<Integer> sources = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int node = sources.poll();
            counter++;
            sortedOrder.add(node);
            for (Integer neighbour : graph.get(node)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    sources.add(neighbour);
                }
            }
        }

        // topological sort is not possible if counter is not equal to numCourses, signifying there is a cycle in graph
        return counter == numCourses;

    }

    // CourseSchedule II -> return order of courses
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(canFinish(numCourses, prerequisites))
        return sortedOrder.stream().mapToInt(Integer::intValue).toArray();
        else
        return new int[]{};
    }
}

