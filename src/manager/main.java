package manager;

import experiments.AverageDegree;
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
		clusteringCoefficient e1 = new clusteringCoefficient(graph);
		e1.doExperiment();
		AverageDegree e2 = new AverageDegree(graph);
		e2.doExperiment();
	}

}
