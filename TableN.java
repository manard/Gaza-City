
public class TableN implements Comparable<TableN> {
	private double Distance;
	private boolean isKnown;
	private Vertix vertix;
	private Vertix prevVertix;

	public TableN() {
	}

	public TableN(Vertix v) {
		this.vertix = v;
	}

	public TableN(Vertix v, int weight) {
		vertix = v;
	}

	public double getDistance() {
		return Distance;
	}

	public void setDistance(double distance) {
		Distance = distance;
	}

	public boolean isKnown() {
		return isKnown;
	}

	public void setKnown(boolean isKnown) {
		this.isKnown = isKnown;
	}

	public Vertix getVertix() {
		return vertix;
	}

	public void setVertix(Vertix vertix) {
		this.vertix = vertix;
	}

	public Vertix getPrevVertix() {
		return prevVertix;
	}

	public void setPrevVertix(Vertix prevVertix) {
		this.prevVertix = prevVertix;
	}

	@Override
	public int compareTo(TableN o) {
		if (this.getDistance() > o.getDistance()) {
			return 1;
		} else if (this.getDistance() < o.getDistance()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "TableN [Distance=" + Distance + ", isKnown=" + isKnown + ", vertix=" + vertix + ", prevVertix="
				+ prevVertix + "]";
	}
	

}
