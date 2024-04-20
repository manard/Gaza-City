
public class Edge {
	private Vertix source;
	private Vertix Target;
	private double weight;

	public Edge(Vertix source, Vertix target, double weight) {//double
		super();
		this.source = source;
		this.Target = target;
		this.weight = weight;
	}

	public Vertix getSource() {
		return source;
	}

	public void setSource(Vertix source) {
		this.source = source;
	}

	public Vertix getTarget() {
		return Target;
	}

	public void setTarget(Vertix target) {
		Target = target;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", Target=" + Target + ", weight=" + weight + "]";
	}
	

}
