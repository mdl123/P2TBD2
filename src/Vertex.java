import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

 class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);
		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
		}
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        Vertex v0 = new Vertex("Redvile");
	Vertex v1 = new Vertex("Blueville");
	Vertex v2 = new Vertex("Greenville");
	Vertex v3 = new Vertex("Orangeville");
	Vertex v4 = new Vertex("Purpleville");

	v0.adjacencies = new Edge[]{ new Edge(v1, 5),
	                             new Edge(v2, 10),
                               new Edge(v3, 8) };
	v1.adjacencies = new Edge[]{ new Edge(v0, 5),
	                             new Edge(v2, 3),
	                             new Edge(v4, 7) };
	v2.adjacencies = new Edge[]{ new Edge(v0, 10),
                               new Edge(v1, 3) };
	v3.adjacencies = new Edge[]{ new Edge(v0, 8),
	                             new Edge(v4, 2) };
	v4.adjacencies = new Edge[]{ new Edge(v1, 7),
                               new Edge(v3, 2) };
        
	
         ArrayList<Vertex> vx=new ArrayList<Vertex>();
         ArrayList<Vertex> ar=new ArrayList<Vertex>();
         ar.add(v0);
         ar.add(v1);
         ar.add(v2);
         ar.add(v3);
         ar.add(v4);
        Vertex[] vertices = new Vertex[ar.size()]; 
        for(int i=0;i<vertices.length;i++){
            vertices[i]=new Vertex(ar.get(i).toString());
        }
         for(int i2=0;i2<ar.size();i2++){
             vertices[i2].adjacencies=ar.get(i2).adjacencies;
           vertices[i2].minDistance= ar.get(i2).minDistance;
            vertices[i2].previous=ar.get(i2).previous;
         }//fin del for
         
        for(int i=0;i<vertices.length;i++){
            vx.add(new Vertex(vertices[i].name));
            vx.get(i).adjacencies=vertices[i].adjacencies;
            vx.get(i).minDistance=vertices[i].minDistance;
            vx.get(i).previous=vertices[i].previous;
        }//fin del for
        
        for(int i=0;i<vertices.length;i++){
            computePaths(vertices[i]);
             for (Vertex v : vertices) {
	    System.out.println("Distance to " + v + ": " + v.minDistance);
	    List<Vertex> path = getShortestPathTo(v);
	    System.out.println("Path: " + path);
	}//fin del for
         for(int i2=0;i2<vertices.length;i2++){
         
            vertices[i2].adjacencies=vx.get(i2).adjacencies;
           vertices[i2].minDistance= vx.get(i2).minDistance;
            vertices[i2].previous=vx.get(i2).previous;
        }//fin del for
         System.out.println("");
         System.out.println("");
        }//fin del for
        
        
       
    }
}

