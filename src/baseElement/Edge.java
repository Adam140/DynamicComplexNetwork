package baseElement;

public class Edge {
	
	private int id;
	private Node from;
	private Node to;
	private String tie = "";
	private int weight = 1;
	
	public Edge()
	{
		
	}
	
	public Edge(Node from, Node to)
	{
		this.from = from;
		this.to = to;
	}
	
	public Edge(Node from, Node to, int id)
	{
		this(from, to);
		this.id = id;
	}
	
	public Edge(Node from, Node to, int id, int weight)
	{
		this(from, to, id);
		this.weight = weight;
	}
	
	public Edge(String id)
	{
		this.id = Integer.parseInt(id);
	}
	
	public Edge(int id)
	{
		this.id = id;
	}
	
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

	public String getTie() {
		return tie;
	}

	public void setTie(String tie) {
		this.tie = tie;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return from + "\t--" + tie + "--> \t" + to;
	}
	

}
