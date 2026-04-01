class Solution {

    // initialize adjList for building graph
    // initialize count for maintaining indegree frequency
    // take one set of characters
    // take one list of chars as result
    // start comparing two adjacent words -> we can do this because it is given that 
    // given words are sorted lexicographically
    // while comparing two adjacent words
    // compare each character
    // add edges but avoid adding duplicate edges
    // check for invalid input, if word2 is prefix of word1, return empty string
    // take one deque
    // apply topological sort
    // add all indegree = 0 nodes in queue
    // pop one node from front
    // access to neighbours 
    // decrease their indegree 
    // if indegree becomes zero, add to queue
    // after iterating whole queue, if result is less than original characters, 
    // there must be a cycle, return empty string
    // else build the res list to string

    public String foreignDictionary(String[] words) {

        if(true) {
            return AlienDictionary.alienOrderV2(Arrays.asList(words));
        }

        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();

        for(String word : words) {
            for(char ch: word.toCharArray()) {
                count.put(ch, 0);
            }
        }

        Set<Character> characters = new HashSet<>(count.keySet());

        List<Character> res = new ArrayList<>();
        Deque<Character> q = new ArrayDeque<>();

        // compare words

        int n = words.length;
        for(int i = 0; i<n-1;i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int j = 0;
            for(j=0;j<word1.length() &&j< word2.length();j++) {
                char c = word1.charAt(j);
                char d = word2.charAt(j);
                if(c!=d) {
                    adjList.putIfAbsent(c, new ArrayList<>());
                    adjList.putIfAbsent(d, new ArrayList<>());
                    boolean found = false;
                    for(int k = 0;k<adjList.get(c).size();i++) {
                        if(adjList.get(c).get(k) == d) {
                            found = true;
                        }
                    }
                    if(!found) {
                        adjList.get(c).add(d);
                        count.put(d, count.get(d) + 1);
                    }
                    break;
                }
            }
            if(j>=word1.length() || j>=word2.length()) {
                if(word1.length()>word2.length()) {
                    return "";
                }
            }
        }

        for(char ch : count.keySet()) {
            if(count.get(ch) == 0) {
                q.add(ch);
            }
        }

        while (!q.isEmpty()) {
            char c = q.removeFirst();
            res.add(c);

            adjList.computeIfAbsent(c, k -> new ArrayList<>());

            for (int f = 0; f < adjList.get(c).size(); f++) {
                char d = adjList.get(c).get(f);
                count.put(d, count.get(d) - 1);

                if (count.get(d) == 0) {
                    q.add(d);
                }
            }
        }

        if(res.size() < characters.size()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : res) {
            sb.append(ch);
        }

        return sb.toString();
      
    }
}


public static class AlienDictionary {
    public static String alienOrderV2(List<String> words) {
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();

        for (String word : words) {
            char[] strArray = word.toCharArray();
            for (char c : strArray) {
                count.put(c, 0);
            }
        }

        Set<Character> characters = count.keySet();

        for (int i = 0; i < words.size() - 1; i++) {
            String word1 = words.get(i);
            String word2 = words.get(i + 1);

            int j = 0;
            for (j = 0; j < word1.length() && j < word2.length(); j++) {
                char c = word1.charAt(j);
                char d = word2.charAt(j);

                if (c != d) {
                    if (adjList.get(c) == null) {
                        adjList.put(c, new ArrayList<>());
                    }

                    if (adjList.get(d) == null) {
                        adjList.put(d, new ArrayList<>());
                    }

                    boolean found = false;
                    for (int k = 0; k < adjList.get(c).size(); k++) {
                        if (adjList.get(c).get(k) == d) {
                            found = true;
                        }
                    }

                    if (!found) {
                        adjList.get(c).add(d);
                        count.put(d, count.get(d) + 1);
                    }

                    break;
                }
            }

            // Check that second word isn't a prefix of first word.
            if (j >= word1.length() || j >= word2.length()) {
                if (word2.length() < word1.length()) {
                    return "";
                }
            }
        }

        // Step 2: We need to repeatedly pick off nodes with an indegree of 0.
        List<Character> result = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();

        for (char c : count.keySet()) {
            if (count.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.removeFirst();
            result.add(c);

            adjList.computeIfAbsent(c, k -> new ArrayList<>());

            for (int f = 0; f < adjList.get(c).size(); f++) {
                char d = adjList.get(c).get(f);
                count.put(d, count.get(d) - 1);

                if (count.get(d) == 0) {
                    queue.add(d);
                }
            }
        }

        // If not all letters are in result, that means there was a cycle and so
        // no valid ordering. Return "".
        if (result.size() < characters.size()) {
            return "";
        }

        // Otherwise, convert the ordering we found into a string and return it.
        StringBuilder sb = new StringBuilder();

        // Appends characters one by one
        for (Character ch : result) {
            sb.append(ch);
        }

        String output = sb.toString();
        return output;
    }

}
