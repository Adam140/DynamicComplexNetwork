package baseElement;

import java.util.ArrayList;

public class Node {
	
	private int id;
	private float threshold;
	private float coeffcient;

	private ArrayList<Node> toNode = new ArrayList<Node>();
	private ArrayList<Node> fromNode = new ArrayList<Node>();
	
	private ArrayList<Edge> inEdges = new ArrayList<Edge>();
	private ArrayList<Edge> outEdges = new ArrayList<Edge>();
	
	
	public Node()
	{
		
	}
	
	public Node(String id)
	{
		this.id = Integer.parseInt(id);
	}
	
	public Node(int id)
	{
		this.id = id;
	}
	
	public void addFromNode(Node n)
	{
		this.fromNode.add(n);
	}
	
	public void addToNode(Node n)
	{
		this.toNode.add(n);
	}
	
	public void addInEdge(Edge e)
	{
		this.inEdges.add(e);
	}
	
	public void addOutEdge(Edge e)
	{
		this.outEdges.add(e);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getThreshold() {
		return threshold;
	}
	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}
	public ArrayList<Node> getToNode() {
		return toNode;
	}
	public void setToNode(ArrayList<Node> toNode) {
		this.toNode = toNode;
	}
	public ArrayList<Node> getFromNode() {
		return fromNode;
	}
	public void setFromNode(ArrayList<Node> fromNode) {
		this.fromNode = fromNode;
	}
	public ArrayList<Edge> getInEdges() {
		return inEdges;
	}
	public void setInEdges(ArrayList<Edge> in) {
		this.inEdges = in;
	}
	public ArrayList<Edge> getOutEdges() {
		return outEdges;
	}
	public void setOutEdges(ArrayList<Edge> out) {
		this.outEdges = out;
	}

	public float getCoeffcient() {
		return coeffcient;
	}

	public void setCoeffcient(float coeffcient) {
		this.coeffcient = coeffcient;
	}

	@Override
	public String toString() {
		return  id + "";// + "(" + threshold + ")";
	}

}
