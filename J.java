package HT8;

public class J {
    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][n];
        int[] c = new int[m];
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            a[u][v] = 1;
            a[v][u] = 1;
        }
        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt() - 1;
        }
        int[] visited = new int[n];
        System.out.println(dfs(a, c[0], visited, c));
    }

    private static Pair dfs(int[][] a, int x, int[] visited, int[] c) {
        int n = a.length;
        int maxDepth = 0, maxDepthForCity = 0;
        int numOfV = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (a[i][x] == 1) {
                    int tmp = 1 + dfs(a, i, visited, c).first();
                    if (tmp >= maxDepth) {
                        maxDepth = tmp;
                        if (contains(c, i)) {
                            maxDepthForCity = Math.max(maxDepthForCity, tmp);
                            numOfV = i;
                        }
                    }
                }
            }
        }
        return new Pair(maxDepth, maxDepthForCity);
    }

    private static boolean contains(int[] a, int x) {
        for (int i : a) {
            if (i == x) {
                return true;
            }
        }
        return false;
    }
}