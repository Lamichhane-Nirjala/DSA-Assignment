import java.util.*;

class Edge{

    int v;
    double weight;

    Edge(int v,double weight){
        this.v=v;
        this.weight=weight;
    }
}

public class Question6 {

    static void dijkstra(List<List<Edge>> graph,int src){

        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingDouble(e->e.weight));

        double[] dist=new double[graph.size()];
        Arrays.fill(dist,Double.MAX_VALUE);

        dist[src]=0;

        pq.add(new Edge(src,0));

        while(!pq.isEmpty()){

            Edge cur=pq.poll();

            for(Edge e:graph.get(cur.v)){

                if(dist[cur.v]+e.weight<dist[e.v]){

                    dist[e.v]=dist[cur.v]+e.weight;
                    pq.add(new Edge(e.v,dist[e.v]));
                }
            }
        }

        System.out.println("Safest path distances:");
        System.out.println(Arrays.toString(dist));
    }
}