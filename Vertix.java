import javafx.scene.shape.Circle;

public class Vertix {
	private int Index;
	private String Name;
	private double x;
	private double y;
	private Circle c;

	public Vertix() {

	}

	public Vertix(int Index, String name, double x, double y) {
		this.Index = Index;
		this.Name = name;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Circle getC() {
		return c;
	}

	public void setC(Circle c) {
		this.c = c;
	}

	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}

	@Override
	public String toString() {
		return "Vertix [Name=" + Name + "]";
	}
	

}
