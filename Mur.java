public class Mur extends GameObject {
	// constructeur pour definir une unité du mur 
	public Mur(char symbol) {
		setSymbol(symbol);
	}

	// ajouter le mur dans la 1er et la derniere ligne du screen
	public void addMursRow(GameScreen screen, Mur mur, int rowNumber) {
		for (int i = 0; i < screen.getScreenWidth(); i++) {
			screen.setObjectOnLocation(mur, i, rowNumber);
		}
	}

	//  ajouter le mur dans la 1er et la derniere colone du screen
	public void addMursColumn(GameScreen screen, Mur mur, int columnNumber) {
		for (int i = 0; i < screen.getScreenHeight(); i++) {
			screen.setObjectOnLocation(mur, columnNumber, i);
		}
	}
}
