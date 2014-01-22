package experiments;

import java.util.ArrayList;

import baseElement.Graph;
import baseElement.Node;

public class AverageDegree extends Experiment{

	public AverageDegree(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		int highest_degree = 0;
		float avg_total_degree = 0;
		float avg_in_degree = 0;
		float avg_out_degree = 0;
		Boolean is_balanced = true;
		int num_of_sinks = 0;
		int num_of_sources = 0;
		
		for(Node n : graph.getNodes())
		{
			int n_out = n.getToNode().size();
			int n_in = n.getFromNode().size();
			
			if(n_out == 0)
				num_of_sinks++;
			if(n_in == 0)
				num_of_sources++;
			if(n_out != n_in)
				is_balanced = false;
			
			if(n_out+n_in > highest_degree)
				highest_degree = n_out + n_in;
			
			avg_total_degree += n_out + n_in;
			avg_in_degree += n_in;
			avg_out_degree += n_out;
			
		}
		int num_of_nodes = graph.getNodes().size();
		avg_total_degree /= (float)num_of_nodes;
		avg_in_degree /= (float)num_of_nodes;
		avg_out_degree /= (float)num_of_nodes;
		
		result = "Avg total degree: "+ String.valueOf(avg_total_degree)+"\n";
		result += "Avg in degree: "+ String.valueOf(avg_in_degree)+"\n";
		result += "Avg out degree: "+ String.valueOf(avg_out_degree)+"\n";
		result += "Highest degree: "+ String.valueOf(highest_degree)+"\n";
		result += "Is balanced: "+ String.valueOf(is_balanced)+"\n";
		result += "Number of sinks: "+ String.valueOf(num_of_sinks)+"\n";
		result += "Number of sources: "+ String.valueOf(num_of_sources)+"\n";


		
	}
		
	

}