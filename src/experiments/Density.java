package experiments;

import java.util.ArrayList;

import baseElement.Graph;
import baseElement.Node;

public class Density extends Experiment implements IExperiment{

	public Density(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		float density = 0;
		int kn = graph.getNodes().size();
		density = (float)graph.getEdges().size()/(kn*(kn-1));
		result = "Densty = "+String.valueOf(density);

		
	}
		
	

}