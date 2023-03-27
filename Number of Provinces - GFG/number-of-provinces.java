//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    // isVisited array size V hoga ya V+1  => matrix.length hoga or (no. of vertices)
    // Adj list me values kaise add hoti hai matrix se => jo jo matrix ki row me 1 hai i!=j k alawa use add kro
    // dfs func kasie work krra hai  => pick a node and traverse it then again repeat for next node in dfs func
    
    public static void dfs(Integer node, ArrayList<ArrayList<Integer>> adjList, boolean[] isVisited) {
        
        isVisited[node] = true;
        
        for(Integer i : adjList.get(node)) {
            if(isVisited[i] == false) {
                dfs(i, adjList, isVisited);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        // System.out.println(adj);
        // [[1, 0, 1], 
        //  [0, 1, 0], 
        //  [1, 0, 1]]
        
        // adjacencyMatrix to adjacencyList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(); 
        
        for(int r=0; r<V; r++) {
            adjList.add(new ArrayList<>());
            for(int c=0; c<V; c++) {
                if(adj.get(r).get(c) == 1 && r!=c) {
                    adjList.get(r).add(c);
                    // adjList.get(c).add(r);
                }
            }
        }
        
        // System.out.println(adjList);
        // [[2], [], [0]]
        
        // isVisited array
        boolean[] isVisited = new boolean[V];
        
        int count = 0;
        
        // this will go till last vertice, we will come back to this when we will have unconnected node
        for(int i=0; i<V; i++) {
            if(isVisited[i] == false) {
                count++;
                dfs(i, adjList, isVisited);
            }
        }
        
        return count;
        
    }
};