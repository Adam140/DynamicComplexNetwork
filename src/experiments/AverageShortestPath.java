package experiments;

import algorithms.Dijkstra;
import baseElement.Graph;
import baseElement.Node;

/**
 * Dijkstra algorithm
 * 
 * @author Adam
 * 
 */
public class AverageShortestPath extends Experiment implements IExperiment {

	public enum Parameters {
		  NETWORK_DIAMETER, SUM_PATH, CONNECTED_NODES, AVERAGE_SHORTEST_PATH, LENGTH_DISTRIBUTION;
	}
	private final int MAXNODES;
	
	private int networkDiameter = 0; // the maximum length of shortest paths between
									// two nodes
	private int sumPath = 0;
	private int connectedNodes = 0; // number of not connected nodes
	private float avgPath = 0;
	private float lengthDistribution;


	public AverageShortestPath(Graph graph) {
		super(graph);
		this.MAXNODES = graph.getNodes().size();
	}

	public void doExperiment() {
		for (Node fromNode : graph.getNodes()) {
			Dijkstra dijkstra = new Dijkstra(MAXNODES);
			dijkstra.computePaths(fromNode);

			for (Node toNode : graph.getNodes()) {
				if (toNode == fromNode)
					continue;
				
				int shortest = dijkstra.getShortestPathTo(toNode);
				if(shortest != Dijkstra.INFINITY)	// if is connected
				{
					connectedNodes++;
					sumPath += shortest;
					if(networkDiameter > shortest)
						networkDiameter = shortest;
				}
					
				System.out.println(fromNode + " to " + toNode + " -> " + dijkstra.getShortestPathTo_S(toNode));
			}
		}
		
		this.avgPath = (float) sumPath /  (float) connectedNodes;
		
		parameters.put(Parameters.CONNECTED_NODES.toString(), Double.valueOf(connectedNodes));
		parameters.put(Parameters.SUM_PATH.toString(), Double.valueOf(sumPath));
		parameters.put(Parameters.NETWORK_DIAMETER.toString(), Double.valueOf(networkDiameter));
		parameters.put(Parameters.LENGTH_DISTRIBUTION.toString(), Double.valueOf(lengthDistribution));
		parameters.put(Parameters.AVERAGE_SHORTEST_PATH.toString(), Double.valueOf(avgPath));
	}

}


