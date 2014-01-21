package manager;

import experiments.clusteringCoefficient;
import baseElement.Graph;

public class main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
//		graph.init("data/p2p-Gnutella08.txt");
		graph.init("data/test.txt");
		graph.printAllEdges();
		clusteringCoefficient e1 = new clusteringCoefficient(graph);
		e1.doExperiment();
	}

}
