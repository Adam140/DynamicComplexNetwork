package experiments;

import baseElement.Graph;

public class Density extends Experiment{

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