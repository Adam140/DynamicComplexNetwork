package experiments;

import java.util.ArrayList;

import baseElement.Graph;
import baseElement.Node;

public class Density extends Experiment implements IExperiment{

	static float density = 0;
	public Density(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		
		int kn = graph.getNodes().size();
		density = (float)graph.getEdges().size()/(kn*(kn-1));
		result = "Densty = "+String.valueOf(density);

		
	}
		
	

}