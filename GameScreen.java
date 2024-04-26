public class GameScreen {

	private int width, height; // largeur et longueur du screen
	private char[][] screenMatrix;  // matrice representative du screen

	//constructeur de la classe GameScreen 
	public GameScreen(int width, int height) //affecter une largeur et une longueur au screen 
	{ 
		this.width = width;
		this.height = height;
		this.screenMatrix = new char[this.height][this.width];
	}

	//initialisation du screen vide 
	public void InitScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.screenMatrix[i][j] = ' ';
			}
		}
	}

	// affichage du screen 
	public void PrintScreen() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				System.out.print(this.screenMatrix[i][j]);
			}
			System.out.println();
		}
	}

	//vider la position de coordonnees (x,y)
	public void ClearScreenLocation(int x, int y) {
		this.screenMatrix[y][x] = ' ';
	}

	// Getters
	public int getScreenWidth() {
		return this.width;
	}

	public int getScreenHeight() {
		return this.height;
	}

	public char getObjectOnLocation(int x, int y) {
		return this.screenMatrix[y][x];
	}

	// Setters
	public void setObjectOnLocation(GameObject object, int x, int y) {
		this.screenMatrix[y][x] = object.getSymbol();
	}

}
