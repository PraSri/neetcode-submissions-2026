class Solution {
    public String foreignDictionary(String[] words) {
      List<String> w = new ArrayList<>();
      for (String x : words) w.add(x);
      return alienOrder(w);
    }
    private final Map<Character, Set<Character>> adjList = new HashMap<>();
        private final Map<Character, Integer> inDegree = new HashMap<>();
        private final Set<Character> uniqueCharacters = new HashSet<>();

        public String alienOrder(List<String> words) {
            if (words == null || words.isEmpty()) {
                return "";
            }
            // initialize all unique characters
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    uniqueCharacters.add(c);
                    inDegree.putIfAbsent(c, 0);
                    adjList.putIfAbsent(c, new HashSet<>());
                }
            }
            // build graph from word pair comparisons
            for (int i = 0; i < words.size() - 1; i++) {
                String curr = words.get(i);
                String next = words.get(i + 1);
                if (curr.length() > next.length() && curr.startsWith(next)) {
                    return "";
                }
                int minLen = Math.min(curr.length(), next.length());
                for (int j = 0; j < minLen; j++) {
                    char from = curr.charAt(j);
                    char to = next.charAt(j);
                    if (from != to) {
                        if (adjList.get(from).add(to)) {
                            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
                        }
                        break;
                    }
                }
            }
            // apply topological sort to get character ordering
            Queue<Character> queue = new ArrayDeque<>();
            StringBuilder result = new StringBuilder();
            for (char c : uniqueCharacters) {
                if (inDegree.get(c) == 0) {
                    queue.add(c);
                }
            }
            while (!queue.isEmpty()) {
                char curr = queue.poll();
                result.append(curr);
                for (char neighbour : adjList.getOrDefault(curr, Collections.emptySet())) {
                    inDegree.put(neighbour, inDegree.getOrDefault(neighbour, 0) - 1);
                    if (inDegree.getOrDefault(neighbour, 0) == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            if (result.length() < uniqueCharacters.size()) {
                return "";
            }
            return result.toString();
        }
}