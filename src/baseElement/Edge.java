package baseElement;

public class Edge {
	
	private int id;
	private Node from;
	private Node to;
	private boolean strongeTie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}
	public boolean isStrongeTie() {
		return strongeTie;
	}
	public void setStrongeTie(boolean strongeTie) {
		this.strongeTie = strongeTie;
	}

}
