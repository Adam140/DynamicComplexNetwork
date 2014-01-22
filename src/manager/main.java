package manager;

import experiments.AverageDegree;
import experiments.AverageShortestPath;
import experiments.Density;
import experiments.clusteringCoefficient;
import baseElement.Graph;

public class main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
//		graph.init("data/p2p-Gnutella08.txt");
		graph.init("data/test.txt");
		graph.printAllEdges();
		graph.displayGraph();
		AverageShortestPath e = new AverageShortestPath(graph);
		e.doExperiment();
		System.out.println(e.getParameter(AverageShortestPath.Parameters.AVERAGE_SHORTEST_PATH));
		clusteringCoefficient e1 = new clusteringCoefficient(graph);
		e1.doExperiment();
		AverageDegree e2 = new AverageDegree(graph);
		e2.doExperiment();
	}

}
