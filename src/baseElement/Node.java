package baseElement;

import java.util.ArrayList;

public class Node {
	
	private int id;
	private float threshold;
	
	private ArrayList<Node> toNode;
	private ArrayList<Node> fromNode;
	
	private ArrayList<Edge> in;
	private ArrayList<Edge> out;
	
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
	public ArrayList<Edge> getIn() {
		return in;
	}
	public void setIn(ArrayList<Edge> in) {
		this.in = in;
	}
	public ArrayList<Edge> getOut() {
		return out;
	}
	public void setOut(ArrayList<Edge> out) {
		this.out = out;
	}

}
