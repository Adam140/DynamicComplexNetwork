package manager;

import experiments.AverageShortestPath;
import experiments.clusteringCoefficient;
import baseElement.Graph;

public class main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
//		graph.init("data/p2p-Gnutella08.txt");
		graph.init("data/test.txt");
		graph.printAllEdges();
		AverageShortestPath e1 = new AverageShortestPath(graph);
		e1.doExperiment();
		e1.printResult();
		AverageDegree e2 = new AverageDegree(graph);
		e2.doExperiment();
	}

}
