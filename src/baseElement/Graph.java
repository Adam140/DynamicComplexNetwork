package baseElement;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Graph {

	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public int init(String file)
	{
		try {
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";
			
			while ((strLine = br.readLine()) != null) {
				if('#' == strLine.charAt(0))	// ignore commented line
					continue;
				
				String[] nodes = strLine.split("\t");
				
				Node nodeFrom = this.getNode(nodes[0]);
				Node nodeTo = this.getNode(nodes[1]);
				
				if( nodeFrom == null)
				{
					nodeFrom = new Node(nodes[0]);
					this.nodes.add(nodeFrom);
				}
				if( nodeTo == null)
				{
					nodeTo = new Node(nodes[1]);
					this.nodes.add(nodeTo);
				}
				
				Edge edge = new Edge(nodeFrom, nodeTo);
				this.edges.add(edge);
				
				nodeFrom.addToNode(nodeTo);
				nodeFrom.addOutEdge(edge);
				
				nodeTo.addFromNode(nodeFrom);
				nodeTo.addInEdge(edge);
						
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			return -1;
		}
		return 0;
	}
	
	Node getNode(String id)
	{
		return getNode(Integer.parseInt(id));
	}
	
	Node getNode(int id)
	{
		for(Node n : this.nodes)
			if(n.getId() == id)
				return n;
		return null;
	}
	
	Edge getEdge(String id)
	{
		return getEdge(Integer.parseInt(id));
	}
	
	Edge getEdge(int id)
	{
		for(Edge e : this.edges)
			if(e.getId() == id)
				return e;
		return null;
	}
	
	Edge getEdge(Node from, Node to)
	{
		for(Edge e : this.edges)
			if(e.getFrom().equals(from) && e.getTo().equals(to))
				return e;
		
		return null;
	}
	
	public ArrayList<Node> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public void printAllEdges()
	{
		for(Edge e : edges)
			System.out.println(e);
	}
	
	
}
