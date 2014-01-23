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
		int highest = 0;
		for(ArrayList<Node> h: scc)
		{
			if(h.size() > highest)
				highest = h.size();
		}
		result = "SCC size of compontents: "+scc.size();
		result += "\nSCC highest size of compontent: "+highest;
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
			Node n1 = null;
			ArrayList<Node> new_list = new ArrayList<Node>();
			//scc.add( (ArrayList<Node>) s.clone() );
			int s_size = 0;
            do {
            	s_size = s.size()-1;
            	n1 = s.get(s_size);
            	new_list.add(n1);
            	s.remove(s_size);
            	
                //w = this.stack.vertices.pop();
                // add w to current strongly connected component
                //vertices.push(w);
            } while (!n.equals(n1));
            if(new_list.size() > 0)
            	scc.add(new_list);
			//s.clear();
			
		}
		
		
		
		
	}
		

}