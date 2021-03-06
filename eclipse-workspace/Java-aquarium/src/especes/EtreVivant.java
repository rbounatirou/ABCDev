package especes;
import utils.Aquarium;

public abstract class EtreVivant implements java.io.Serializable, Cloneable {
	protected short pv;
	protected short age;
	
	public EtreVivant() {
		pv = 10;
		age = 0;
	}
	
	public EtreVivant(short _pv) {
		pv = _pv;
		age = 0;
	}
	
	public EtreVivant(short _pv, short _age) {
		pv = _pv;
		age = _age;
	}
	
	public short getPV() {
		return pv;
	}
	
	public short getAge() {
		return age;
	}
	
	@Override
	public abstract String toString();
	public abstract void onTurn(Aquarium aquarium);
	
	public abstract void onEat(Poisson p);
	
	public abstract Object clone() throws CloneNotSupportedException;
	
}
