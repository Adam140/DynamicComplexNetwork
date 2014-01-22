package experiments;

import java.util.HashMap;
import java.util.Map;

import baseElement.Graph;

public class Experiment implements IExperiment {

	protected Graph graph;
	protected String result = "";	// print all result
	protected Map<String, Double> parameters = new HashMap<String, Double>(); // numeric value from experiment
	
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
	
	public double getParameter(Enum arg)
	{
		return parameters.get(arg.toString());
	}
}
