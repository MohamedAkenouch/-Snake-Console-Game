public class Fruit extends GameObject {     //la classe Fruit est une subclass de la classe GameObjet
	public static int fruit_x; //l'abscisse du fruit
	public static int fruit_y ;//l'ordonnee du fruit
	
	
	// constructeur qui permet de creer le fruit apartir de symbole passé en argument  
	public Fruit(char symbol) {           
		setSymbol(symbol);
	}

	// ajouter un fruit d'une maniere aleatoire a condition qu'il ne soit pas partie du mur 
	public void addRandomFruit(GameScreen screen, Fruit fruit) {
		boolean nul=true;
		while (nul) {
			fruit_x = (int) (Math.random() * (screen.getScreenWidth() - 1));
			fruit_y =(int) (Math.random() * (screen.getScreenHeight() - 1));
			if (fruit_x!=0 && fruit_y!=0 )
				nul=false;
			
		}
		screen.setObjectOnLocation(fruit, fruit_x,fruit_y );
	}
	
	
}

