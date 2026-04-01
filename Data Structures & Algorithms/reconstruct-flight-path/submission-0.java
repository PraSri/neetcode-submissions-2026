class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> adj = new HashMap<>();
        //tickets = [["HOU","JFK"],["SEA","JFK"],["JFK","SEA"],["JFK","HOU"]]
        for(List<String> ticket: tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        for(List<String> destinations: adj.values()) {
            destinations.sort(Collections.reverseOrder());
        }
        dfs("JFK", adj, res);
        Collections.reverse(res);
        return res;
    }

    private void dfs(String src, Map<String, List<String>> adj, List<String> res) {
        List<String> destinations = adj.getOrDefault(src, new ArrayList<>());
        while(destinations != null && !destinations.isEmpty()) {
            String nextDest = destinations.remove(destinations.size() - 1);
            dfs(nextDest, adj, res);
        }
        res.add(src);
    }
}
