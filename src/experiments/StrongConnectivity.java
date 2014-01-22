package experiments;

import java.util.ArrayList;

import baseElement.Graph;
import baseElement.Node;

public class StrongConnectivity extends Experiment implements IExperiment{
	int index = 0;
	ArrayList<Node> s = new ArrayList<Node>();
	ArrayList<ArrayList<Node>> scc = new ArrayList<ArrayList<Node>>();

	public StrongConnectivity(Graph graph) {
		super(graph);
	}
	
	public void doExperiment()
	{
		for(Node n: graph.getNodes())
		{
			if(n.getIndex() == -1)
				tarjanAlgorithm(n);
		}
		result = "SCC size: "+scc.size();
		System.out.println(result);
		
	
		
	}
	
	private void tarjanAlgorithm(Node n)
	{
		n.setIndex(index);
		n.setLowlink(index);
		index++;
		s.add(n);
		for(Node c: n.getToNode())
		{
			if(c.getIndex() == -1)
			{
				tarjanAlgorithm(c);
				n.setLowlink(Math.min(n.getLowlink(), c.getLowlink()));
			}
			else if(s.contains(c))
			{
				n.setLowlink(Math.min(n.getLowlink(), c.getIndex()));
			}
		}
		if(n.getLowlink() == n.getIndex())
		{
			scc.add( (ArrayList<Node>) s.clone() );
			s.clear();
			
		}
		
		
		
		
	}
		

}