package pieces;

import java.util.ArrayList;

import utils.Coordonees;
import utils.Mouvement;
import utils.Plateau;

public class Piece_Cavalier extends Piece {
	public Piece_Cavalier(Piece from) {
		super(from);
	}
	
	@Override
	public String toString() {
		return "[Cavalier" + position+"]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Piece_Cavalier(this);
	}
	

	public Piece_Cavalier(Piece_Cavalier from) {
		this(from.position,from.isBlack);
	}
	
	public Piece_Cavalier(Coordonees _position, boolean _isBlack) {
		super(_position,_isBlack);
	}
	

	
	@Override
	public ArrayList<Mouvement> calculerMouvement(Plateau p) {
		ArrayList<Mouvement> mouvementsPossibles = new ArrayList<Mouvement>();
		Coordonees test;
		Piece tmp = null;
		if (position.getX()-2 >= 0) {
			if (position.getY()+2 < p.getHeight()) {
				test = new Coordonees((byte)(position.getX()-1),(byte)(position.getY()+2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add((new Mouvement(new Coordonees(this.position), new Coordonees(test))));
				}					
				tmp = null;
				test = new Coordonees((byte)(position.getX()-2),(byte)(position.getY()+1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			} else if (position.getY()+1< p.getHeight()) {
				test = new Coordonees((byte)(position.getX()-2),(byte)(position.getY()+1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			}

			if (position.getY()-2>=0) {
				test = new Coordonees((byte)(position.getX()-1),(byte)(position.getY()-2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
				test = new Coordonees((byte)(position.getX()-2),(byte)(position.getY()-1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			} else if (position.getY()-1 >= 0) {
				test = new Coordonees((byte)(position.getX()-2),(byte)(position.getY()-1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			}
		} else if (position.getX()-1 >= 0) {
			if (position.getY()+2 < p.getHeight()) {
				test = new Coordonees((byte)(position.getX()-1),(byte)(position.getY()+2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
			}
			if (position.getY()-2>=0) {
				test = new Coordonees((byte)(position.getX()-1),(byte)(position.getY()-2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
			}
		}
		if (position.getX()+2<p.getWidth()) {
			if (position.getY()+2 < p.getHeight()) {
				test = new Coordonees((byte)(position.getX()+1),(byte)(position.getY()+2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
				test = new Coordonees((byte)(position.getX()+2),(byte)(position.getY()+1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			} else if (position.getY()+1< p.getHeight()) {
				test = new Coordonees((byte)(position.getX()+2),(byte)(position.getY()+1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			}

			if (position.getY()-2>=0) {
				test = new Coordonees((byte)(position.getX()+1),(byte)(position.getY()-2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
				test = new Coordonees((byte)(position.getX()+2),(byte)(position.getY()-1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			} else if (position.getY()-1 >= 0) {
				test = new Coordonees((byte)(position.getX()+2),(byte)(position.getY()-1));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}
				tmp = null;
			} 
		} else if (position.getX()+1<p.getWidth()) {
			if (position.getY()+2 < p.getHeight()) {
				test = new Coordonees((byte)(position.getX()+1),(byte)(position.getY()+2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
			}
			if (position.getY()-2>=0) {
				test = new Coordonees((byte)(position.getX()+1),(byte)(position.getY()-2));
				tmp = p.getPieceFromCoord(test);
				if (tmp == null || tmp.estNoir() != isBlack) {
					mouvementsPossibles.add(new Mouvement(new Coordonees(this.position), new Coordonees(test)));
				}					
				tmp = null;
			}		
		}

		Plateau simulation;
		Piece tmpRoi;
		for (int i = mouvementsPossibles.size() -1 ; i >= 0; i--) {
			simulation = p.simulerMouvement(mouvementsPossibles.get(i));
			tmpRoi = simulation.getRoi(isBlack);
			if (tmpRoi.estEnEchec(simulation).size()>0) {
				mouvementsPossibles.remove(i);
			}
		}

		return mouvementsPossibles;
	}
}
