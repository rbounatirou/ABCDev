package utils;

public class Mouvement {
	private Coordonees[] coords;
	
	public Mouvement(Mouvement from) {
		this(from.coords[0],from.coords[1]);
	}
	
	public Mouvement(Coordonees from, Coordonees to) {
		coords = new Coordonees[2];
		coords[0] = from;
		coords[1] = to;
	}
	
	public Coordonees getFrom() {
		return coords[0];
	}
	
	public Coordonees getTo() {
		return coords[1];
	}
	
	public boolean equals(Mouvement compare) {
		return (coords[0].equals(compare.getFrom())) && (coords[1].equals(compare.getTo()));
	}
	
	@Override
	public String toString() {
		return "from ["+coords[0].getX()+";"+coords[0].getY()+"] to ["+coords[1].getX()+";"+coords[1].getY()+"]";
	}
	
}
