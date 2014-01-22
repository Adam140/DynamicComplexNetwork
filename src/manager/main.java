package manager;

import baseElement.Graph;
import experiments.AverageDegree;
import experiments.Density;

public class main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.init("data/p2p-Gnutella08.txt");
//		graph.init("data/test.txt");
//		graph.printAllEdges();
//		graph.displayGraph();
//		ShortestPaths e = new ShortestPaths(graph);
//		e.doExperiment();
//		e.printResult();
//		clusteringCoefficient e1 = new clusteringCoefficient(graph);
//		e1.doExperiment();
//		e1.printResult();
		AverageDegree e2 = new AverageDegree(graph);
		e2.doExperiment();
		e2.printResult();
		Density e3 = new Density(graph);
		e3.doExperiment();
		e3.printResult();
	}

}
