class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        /*
        boolean[] visited = new boolean[isConnected.length];

        int provinces = 0;

        for (int nodeNum = 0; nodeNum < isConnected.length; nodeNum ++) {

            if (!visited[nodeNum]) {
                provinces ++;
                dfs(isConnected, visited, nodeNum);
            }

        }

        return provinces;
        */

        return bfs(isConnected);

    }

    public void dfs(int[][] isConnected, boolean[] visited, int startNode) {

        for (int destNode = 0; destNode < isConnected.length; destNode ++) {

            if (isConnected[startNode][destNode] == 1 && !visited[destNode]) {
                visited[destNode] = true;
                dfs(isConnected, visited, destNode);
            }


        }

    }

    public int bfs(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];

        Queue<Integer> q = new LinkedList<>();

        int provinces = 0;

        for (int nodeNum = 0; nodeNum < isConnected.length; nodeNum ++) {

            if (!visited[nodeNum]) {
                q.add(nodeNum);
                provinces ++;
                while (!q.isEmpty()) {

                    int currentNode = q.remove();
                    visited[currentNode] = true;

                    for (int destNode = 0; destNode < isConnected.length; destNode ++) {
                        if (isConnected[currentNode][destNode] == 1 && !visited[destNode]) {
                            q.add(destNode);
                        }
                    }

                }

            }

        }

        return provinces;



    }
}