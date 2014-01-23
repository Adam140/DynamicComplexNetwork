package manager;

import baseElement.Graph;
import experiments.AverageDegree;

public class main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.init("data/p2p-Gnutella06.txt");
		//graph.init("data/test.txt");
//		graph.printAllEdges();
//		graph.displayGraph();
//		ShortestPaths e = new ShortestPaths(graph);
//		e.doExperiment();
//		e.printResult();
		//System.out.println(e.getParameter(AverageShortestPath.Parameters.AVERAGE_SHORTEST_PATH));
//		ClusteringCoefficient e1 = new ClusteringCoefficient(graph);
//		e1.doExperiment();
		AverageDegree e2 = new AverageDegree(graph);
		e2.doExperiment();
//		StrongConnectivity e3 = new StrongConnectivity(graph);
//		e3.doExperiment();
	}

}
