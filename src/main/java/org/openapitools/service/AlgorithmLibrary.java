// Java Examples of Commonly Asked Algorithms for Senior Software Engineers

import java.util.*;

public class AlgorithmLibrary {

    // 1. Binary Search (Recursive)
    // Searches for a target value in a sorted array using divide and conquer
    // Returns the index of the target or -1 if not found
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1; // base case: target not found
        int mid = left + (right - left) / 2; // prevent overflow
        if (arr[mid] == target) return mid;
        if (arr[mid] > target) return binarySearch(arr, target, left, mid - 1); // search left
        return binarySearch(arr, target, mid + 1, right); // search right
    }

    // 2. Merge Sort
    // Recursively divides array into halves and merges them in sorted order
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // base case
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right); // merge the two halves
    }

    // Helper method to merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // temp array for merged result
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++]; // copy remaining left half
        while (j <= right) temp[k++] = arr[j++]; // copy remaining right half
        System.arraycopy(temp, 0, arr, left, temp.length); // overwrite original array
    }

    // 3. Depth-First Search (Graph)
    // Recursively visits all nodes reachable from the start node
    public static void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true; // mark as visited
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, visited, graph); // visit unvisited neighbors
        }
    }

    // 4. Breadth-First Search (Graph)
    // Visits all nodes at the current level before moving to the next
    public static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // 5. Dijkstra's Algorithm (Shortest Path)
    // Uses a priority queue to find shortest paths from source to all other nodes
    public static int[] dijkstra(int start, List<List<int[]>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // initialize distances
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0}); // node and distance

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if (d > dist[u]) continue; // skip if not optimal
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist; // shortest distances from start
    }

    // 6. Topological Sort (Kahn's Algorithm)
    // Orders nodes such that for every directed edge u -> v, u appears before v
    public static List<Integer> topologicalSort(int n, List<List<Integer>> graph) {
        int[] inDegree = new int[n];
        for (List<Integer> neighbors : graph) {
            for (int neighbor : neighbors) inDegree[neighbor]++; // count incoming edges
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i); // start with no dependencies
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor); // ready to process
            }
        }
        return topoOrder; // valid topological order
    }

    // 7. Sliding Window (Max Sum of Subarray Length k)
    // Efficiently finds max sum of any subarray of size k
    public static int maxSumSubarray(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += nums[i]; // initial window
        maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // slide the window
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // 8. Kadane’s Algorithm (Max Subarray Sum)
    // Finds the max sum of a contiguous subarray in linear time
    public static int maxSubArray(int[] nums) {
        int max = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]); // extend or restart
            max = Math.max(max, current); // update global max
        }
        return max;
    }

    // 9. Union Find (Disjoint Set Union)
    // Tracks disjoint sets and allows union and find in near constant time
    static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i; // each node is its own root initially
        }

        // Recursively finds the root parent with path compression
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]); // path compression
            return parent[x];
        }

        // Merges two sets
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) parent[rootY] = rootX; // merge y into x
        }
    }

    // 10. Backtracking (Subset generation)
    // Recursively builds all possible subsets of the input array
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    // Helper method for recursive backtracking
    private static void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp)); // add current subset
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]); // choose
            backtrack(i + 1, nums, temp, result); // explore
            temp.remove(temp.size() - 1); // un-choose (backtrack)
        }
    }
}
