package experiments;

import java.util.ArrayList;

import baseElement.Graph;
import baseElement.Node;

public class clusteringCoefficient extends Experiment implements IExperiment{

	public clusteringCoefficient(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		float avg_coefficient = 0;
		for(Node n : graph.getNodes())
		{
			int en = getNeighboursNumberConnection(n);
			int kn =  n.getToNode().size();
			if(kn > 1)
			{
				float result = (float)en/(kn*(kn-1));
				n.setCoeffcient(result);
				avg_coefficient += result;
			}
			
		}
		avg_coefficient = avg_coefficient/graph.getNodes().size();
		
	}
	
	public int getNeighboursNumberConnection(Node n)
	{
		int counter = 0;
		ArrayList<Node> n_neighbours;
		ArrayList<Node> t_neighbours;

		n_neighbours = n.getToNode();
		
		for(Node t : n_neighbours )
		{
			t_neighbours = t.getToNode();
			
			for(int i=0;i<t_neighbours.size();i++)
			{
				Node current = t_neighbours.get(i);
				if(n_neighbours.contains(current))
					counter++;
			}
		}

		
		return counter;
		
		
	}
	
	

}