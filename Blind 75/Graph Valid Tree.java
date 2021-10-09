class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges == null || edges.length == 0) {
            return false;
        }

        boolean[][] adjacency = new boolean[n][n];

        for (int i = 0; i < edges.length; i ++) {
            
            int origin = edges[i][0];
            int dest = edges[i][1];

            adjacency[origin][dest] = true;
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            q.add(i);
            colors[i] = 0;

            int components = 0;

            while (!q.isEmpty()) {

                int currentNode = q.remove();
                colors[currentNode] = 0;
                for (int j = 0; j < adjacency.length; j ++) {

                    int neighborNode = j;

                    // there is an edge between
                    if (adjacency[currentNode][neighborNode]) {

                        if (colors[neighborNode] == 0) {
                            return false;
                        }
                        
                        q.add(neighborNode);
                        colors[neighborNode] = 0;
                    }
                }

                colors[currentNode] = 1;

            }


        }
        

        return true;


    }
}