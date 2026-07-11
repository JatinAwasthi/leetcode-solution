class Solution {

    List<List<Integer>> adj;
    boolean[] visited;
    int vertexCount;
    int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        visited = new boolean[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                vertexCount = 0;
                edgeCount = 0;

                dfs(i);

                int actualEdges = edgeCount / 2;
                int requiredEdges = vertexCount * (vertexCount - 1) / 2;

                if (actualEdges == requiredEdges)
                    ans++;
            }
        }

        return ans;
    }

    void dfs(int node) {

        visited[node] = true;
        vertexCount++;

        for (int next : adj.get(node)) {

            edgeCount++;   // every undirected edge is counted twice

            if (!visited[next])
                dfs(next);
        }
    }
}