public class GameObject {
	
	 private int x, y; //les coordonnés de l'objet 
	 private char symbol;// symbol associé a l'objet
	
	//getters
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public char getSymbol() {
		return symbol;
	}

	// Setters
	public void setX(int newLocation) {
		this.x = newLocation;
	}
	
	public void setY(int newLocation) {
		this.y = newLocation;
	}
	
	public void setSymbol(char Symbol) {
		this.symbol = Symbol;
	}
}
