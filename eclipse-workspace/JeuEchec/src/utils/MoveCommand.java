package utils;

public class MoveCommand implements Command, java.io.Serializable{
	Plateau plateau;
	Mouvement mouvement;
	boolean estNoir;
	
	public MoveCommand(MoveCommand c) {
		this(c.plateau, c.mouvement, c.estNoir);
	}
	
	public MoveCommand(Plateau _plateau, Mouvement _mouvement, boolean _estNoir) {
		plateau = _plateau;
		mouvement = _mouvement;
		estNoir = _estNoir;
	}
	
	@Override
	public boolean deplacer() {
		return plateau.deplacerPiece(mouvement, estNoir);
	}
	
	@Override
	public String toString() {
		return  "[estNoir: " + estNoir + " mouvement: " + mouvement + "]";
	}
	
	
}
