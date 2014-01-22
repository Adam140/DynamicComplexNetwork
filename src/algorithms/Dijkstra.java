package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import baseElement.Edge;
import baseElement.Node;

public class Dijkstra {
	
	// Algorithm source
	// http://www.cse.ust.hk/faculty/golin/COMP271Sp03/Notes/MyL09.pdf

	public static final int INFINITY = Integer.MAX_VALUE;
	private final int MAXNODES;
	private int[] distance;
	private int[] pred;
	private Node source;

	public Dijkstra(int maxNodes) {
		this.MAXNODES = maxNodes;
		this.distance = new int[MAXNODES];
		this.pred = new int[MAXNODES];
	}

	public void computePaths(Node source) {
		this.source = source;
		PriorityQueue<Pair> nodeQueue = new PriorityQueue<Pair>();
		nodeQueue.add(new Pair(0,source));
//		System.out.println(source);
		for(int i = 0; i < distance.length; i++)
		{
			distance[i] = INFINITY;
			pred[i] = -1;
		}
		distance[source.getId()] = 0;

		while (!nodeQueue.isEmpty()) {
			Pair u = nodeQueue.poll();

			for (Edge edge : u.node.getOutEdges()) {
				Node v = edge.getTo();
				if (u.distance + 1 < distance[v.getId()]) {
					nodeQueue.remove(v);
					distance[v.getId()] = u.distance + 1;
					pred[v.getId()] = u.node.getId();
					nodeQueue.add(new Pair(u.distance + 1, v));
				}
			}
		}
//		System.out.println(Arrays.toString(pred));
	}

	public String getShortestPathTo_S(Node target) {
		if(this.distance[target.getId()] == INFINITY)
			return "not connected";
		return String.valueOf(this.distance[target.getId()]);
	}
	
	public ArrayList<Integer> getPathTo(Node target) {
		if(getShortestPathTo(target) == INFINITY)
			return null;
		else
		{
//			System.out.println("From " + source + " to " + target);
			int p = target.getId();
			ArrayList<Integer> result = new ArrayList<>();
			result.add(p);
			do{
				p = pred[p];
				result.add(p);
			}while(p != source.getId());
			Collections.reverse(result);
			return result;
		}
	}
	
	public int getShortestPathTo(Node target) {
		return this.distance[target.getId()];
	}
	
	class Pair implements Comparable<Pair> {
		public int distance;
		public Node node;

		Pair(int distance, Node n) {
			this.distance = distance;
			this.node = n;
		}
		
		public int getID()
		{
			return this.node.getId();
		}

		@Override
		public int compareTo(Pair o) {
			return Double.compare(distance, o.distance);
		}

	}
}