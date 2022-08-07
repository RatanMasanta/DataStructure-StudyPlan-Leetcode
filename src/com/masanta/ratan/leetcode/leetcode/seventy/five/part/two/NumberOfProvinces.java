package com.masanta.ratan.leetcode.leetcode.seventy.five.part.two;

public class NumberOfProvinces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findCircleNum(int[][] isConnected) {
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[i][i]==0) continue;
            count++;
            dfs(isConnected,i);
        }
        return count;
    }
	
    public static void dfs(int[][] graph,int i){
        graph[i][i]=0;
        for(int j=0;j<graph.length;j++){
            if(graph[i][j]==0) continue;
            graph[i][j]=0;
            dfs(graph,j);
        }
    }

}
