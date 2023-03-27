//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // bfs ArrayList to return
        ArrayList<Integer> bfs = new ArrayList<>();
        
        // isVisited Array
        boolean[] isVisited = new boolean[V+1];
        
        // Queue for bfs
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        isVisited[0] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            Integer node = queue.poll();
            bfs.add(node);  // adding nodes from queue to bfs arraylist
            
            for(int i=0; i<adj.get(node).size(); i++) {
                int n = adj.get(node).get(i);
                if(isVisited[n] == false) {
                    queue.add(n);   // only not visited nodes are getting added in queue.
                    isVisited[n] = true;
                }
            }
        }
        return bfs;
    }
}