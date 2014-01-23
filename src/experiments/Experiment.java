package experiments;

import baseElement.Graph;

public class Experiment implements IExperiment {

	protected Graph graph;
	protected String result = "";	// print all result
	
	public Experiment(Graph graph)
	{
		this.graph = graph;
	}
	
	public void doExperiment()
	{
		
	}
	
	public void printResult()
	{
		System.out.println(result);
	}
}
