/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.juan.problems;
import java.util.*;
/**
 *
 * @author ubidotsjd
 */
public class BreathFirstSearchShortestPath {
    public static class Node implements Comparable<Node>{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v = v;this.cost=cost;
        }
        @Override
        public int compareTo(Node node){
            if(Integer.compare(cost, node.cost) != 0){
                return Integer.compare(cost, node.cost);
            }
            return Integer.compare(v, node.v);
        }
    }
    public static void bfs(List<Integer>[] adj, int s){
        int n = adj.length;
        TreeSet<Node> queue = new TreeSet<>();
        queue.add(new Node(s-1, 0));
        boolean visited[] = new boolean[n];
        int[] d = new int[n];
        Arrays.fill(d, -1);
        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            
            if(visited[node.v]){
                continue;
            }
            if(node.v != s-1){
                d[node.v] = node.cost;
            }
            visited[node.v] = true;
            adj[node.v].stream().forEach((x) -> {
                queue.add(new Node(x, node.cost+6));
            });
        }
        for(int i = 0; i < n; i++){
            if(i != s-1){
                System.out.print(d[i]+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Integer> adj[] = new List[n];
            for(int k = 0; k < n; k++){
                adj[k] = new ArrayList<>();
            }
            for(int k = 0; k < m; k++){
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                adj[r-1].add(c-1);
                adj[c-1].add(r-1);
            }
            int s = scanner.nextInt();
            bfs(adj, s);
        }
    }
}
