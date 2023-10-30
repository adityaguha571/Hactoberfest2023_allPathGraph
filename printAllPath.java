import java.util.*;
public class UltiGraph {
    static class edge{
        int src;
        int des;
        edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void createGraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));
        graph[1].add(new edge(1,3));
        graph[2].add(new edge(2,4));
        graph[3].add(new edge(3,4));
        graph[3].add(new edge(3,5));
        graph[4].add(new edge(4,3));
        graph[4].add(new edge(4,5));
        graph[5].add(new edge(5,6));
    }
    
    public static void printAllPath(ArrayList<edge> graph[],boolean []vis,int start,int target,String path){
        if(start==target){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[start].size();i++){
            edge e=graph[start].get(i);
            if(!vis[e.des]){
                vis[e.des]=true;
                printAllPath(graph,vis,e.des,target,path+e.des);
                vis[e.des]=false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<edge> graph[]=new ArrayList[7];
        boolean vis[]=new boolean[7];
        createGraph(graph);
        String s="";
       printAllPath(graph,vis,0,5,"0"); //lets say i want to go from 0 to 5
    }
}
