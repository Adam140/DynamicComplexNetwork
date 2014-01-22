package experiments;

import baseElement.Graph;

public class Density extends Experiment{

	static float density = 0;
	public Density(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		
		int kn = graph.getNodes().size();
		density = (float)graph.getEdges().size()/(kn*(kn-1));
		result = "Densty = "+String.valueOf(density);
		System.out.println(result);

		
	}
		
	

}