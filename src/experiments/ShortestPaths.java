package experiments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import algorithms.Dijkstra;
import baseElement.Graph;
import baseElement.Node;

/**
 * Dijkstra algorithm
 * 
 * @author Adam
 * 
 */
public class ShortestPaths extends Experiment{
	private final int MAXNODES;
	
	static int networkDiameter = 0; // the maximum length of shortest paths between two nodes
	private int sumPath = 0;
	static int connectedNodes = 0; // number of not connected nodes
	static int unconnectedNodes = 0; // number of not connected nodes
	static float avgPath = 0;
	static HashMap<Integer, Integer> shortestLengthDistribution = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> stressDistribution = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> stressDistributionRange = new HashMap<Integer, Integer>();
	static boolean sixDegreesOfSeparation = true;


	public ShortestPaths(Graph graph) {
		super(graph);
		this.MAXNODES = graph.getNodes().size();

	}

	public void doExperiment() {
		int i = 0;
		long startTime = System.currentTimeMillis();
		for (Node fromNode : graph.getNodes()) {
			Dijkstra dijkstra = new Dijkstra(MAXNODES);
			dijkstra.computePaths(fromNode);
			if(++i % 100 == 0)
			{
				long endTime   = System.currentTimeMillis();
				long totalTime = (endTime - startTime) / 1000;
				int hours = (int) totalTime / 3600;
			    int remainder = (int) totalTime - hours * 3600;
			    int mins = remainder / 60;
			    remainder = remainder - mins * 60;
			    int secs = remainder;
				System.out.println("Iteration: " + i + "\nTime passed " + hours + ":" + mins + ":" + secs + "s");
			}
			for (Node toNode : graph.getNodes()) {
				if (toNode == fromNode)
					continue;
				
				int shortest = dijkstra.getShortestPathTo(toNode);
				if(shortest != Dijkstra.INFINITY)	// if is connected
				{
//					if(i < 100)
						stressDistribution(fromNode, toNode, dijkstra);
					Integer count = shortestLengthDistribution.get(shortest);
					if (count == null) {
						shortestLengthDistribution.put(shortest, 1);
					}
					else {
						shortestLengthDistribution.put(shortest, count + 1);
					}
					connectedNodes++;
					sumPath += shortest;
					if(networkDiameter < shortest)
						networkDiameter = shortest;
				}
				else
				{
					unconnectedNodes++;
				}
					
				//System.out.println(fromNode + " to " + toNode + " -> " + dijkstra.getShortestPathTo_S(toNode));
			}
		}
		
		avgPath = (float) sumPath /  (float) connectedNodes;
		sixDegreesOfSeparation = networkDiameter <= 6 && unconnectedNodes == 0;
		
		setResult();
	}
	
	private void setResult()
	{
		if(stressDistribution.size() < 100)
			this.result += "Stress distribution = " + stressDistribution + "\n";
		else
		{
			for(Integer value : stressDistribution.values())
			{
				int i = 10;
				Integer key = 1;
				while(!(value >= key && value < key * i))
					key *= i;
				
				Integer count = stressDistributionRange.get(key);
				if (count == null) {
					stressDistributionRange.put(key, 1);
				}
				else {
					stressDistributionRange.put(key, count + 1);
				}
			}
			this.result += "Stress distribution range = " + stressDistributionRange + "\n";
		}
		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		for(Integer key : stressDistribution.values())
		{
			Integer count = temp.get(key);
			if (count == null) {
				temp.put(key, 1);
			}
			else {
				temp.put(count, count + 1);
			}
		}
		this.result += "Stress distribution = " + temp + "\n";
		this.result += "Node with the max stress distribution = " + Collections.max(stressDistribution.values()) + "\n";
		this.result += "Node with the min stress distribution = " + Collections.min(stressDistribution.values()) + "\n";
		this.result += "Shortest path length distribution = " + shortestLengthDistribution + "\n";
		this.result += "Average path = " + avgPath + "\n";
		this.result += "Unconnected pairs of nodes = " + unconnectedNodes + "\n";
		this.result += "Connected pairs of nodes = " + connectedNodes + "\n";
		this.result += "Network diameter = " + networkDiameter + "\n";
		this.result += "Six degrees of separation occurs = " + sixDegreesOfSeparation + "\n";
	}
	
	private void stressDistribution(Node from, Node to, Dijkstra dijkstra)
	{
		for(Node n : graph.getNodes())
		{
			if( n.getId() == from.getId() || n.getId() == to.getId())
				continue;
				
			ArrayList<Integer> al = dijkstra.getPathTo(to);
			if(al.contains(n.getId()))
			{
				Integer count = stressDistribution.get(n.getId());
				if (count == null) {
					stressDistribution.put(n.getId(), 1);
				}
				else {
					stressDistribution.put(n.getId(), count + 1);
				}
			}
		}
		
	}

}