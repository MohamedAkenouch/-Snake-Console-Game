//la classe Snake est une subclass de la classe GameObjet
import java.util.ArrayList;
public class Snake extends GameObject{
	//constructeur qui construit un objet de type snake definit par "symbol" et dont la position est (xInitial, yInitil)
	public Snake(char symbol, int xInitial, int yInitial) {
		setSymbol(symbol);
		setX(xInitial);
		setY(yInitial);
	}
	

	/*
	 snake_body_x est un tableau dynamique qui contient les ordonnees des unités du corps du snake 
	 et snake_body_y est un tableau dynamique qui contient les abscisses des unités du corps du snake.
	 */
	// diriger le snake a gauche
	public void moveLeft(GameScreen screen, Snake snake,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) {
		int last_snake_part_X=snake_body_X.get(snake_body_X.size() - 1);//on recupere l'ordonnee de la derniere unité du snake.
		int last_snake_part_Y=snake_body_Y.get(snake_body_Y.size() - 1);//on recupere labscisse de la derniere unité du snake.
		for (int i=(snake_body_X.size()-1);i>0;i--)   //on attribu a chaque unité du snake (sauf la 1er) la position de l'unite precedente. 
		{	
			snake_body_X.set (i,snake_body_X.get(i - 1));
			snake_body_Y.set (i,snake_body_Y.get(i - 1));
			
		}
		snake.setX(getX() - 1); // on modifie l'ordonnee de la premiere unité du snake.
		
		snake_body_X.set (0,snake.getX());// on insert  la position 0 du tableau sake_body_x l'ordonnee precedement modifié , la position 0 du tableau sake_body_y n'est pas changé
		for (int i=0;i<snake_body_X.size();i++) //on affiche dans l'ecran les unités du snake on utilisant les cordonnées donnees par les deux tableux  
		{
			screen.setObjectOnLocation(snake,snake_body_X.get(i),snake_body_Y.get(i));			
		}
		screen.ClearScreenLocation(last_snake_part_X,last_snake_part_Y);// on supprime la derniere unite du snake (de l'etat precedent , avant le momvement) dans l'ecran
		
	}
	// diriger le snake a droite on suivant le meme principe
	public void moveRight(GameScreen screen, Snake snake,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) {
		int last_snake_part_X=snake_body_X.get(snake_body_X.size() - 1);
		int last_snake_part_Y=snake_body_Y.get(snake_body_Y.size() - 1);
		for (int i=(snake_body_X.size()-1);i>0;i--) {
			snake_body_X.set (i,snake_body_X.get(i - 1));
			snake_body_Y.set (i,snake_body_Y.get(i - 1));			
		}
	
		snake.setX(getX() + 1); 
		
		snake_body_X.set (0,snake.getX());
		for (int i=0;i<snake_body_X.size();i++) {
			screen.setObjectOnLocation(snake,snake_body_X.get(i),snake_body_Y.get(i));			
		}
		screen.ClearScreenLocation(last_snake_part_X,last_snake_part_Y);
	
	}
	//diriger le snake vers le haut en suivant le meme principe
	public void moveUp(GameScreen screen, Snake snake,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) {
		int last_snake_part_X=snake_body_X.get(snake_body_X.size() - 1);
		int last_snake_part_Y=snake_body_Y.get(snake_body_Y.size() - 1);
		for (int i=(snake_body_X.size()-1);i>0;i--) {
		snake_body_X.set (i,snake_body_X.get(i - 1));
		snake_body_Y.set (i,snake_body_Y.get(i - 1));			
		}
		snake.setY(getY() - 1);
		snake_body_Y.set (0,snake.getY());
		for (int i=0;i<snake_body_X.size();i++) {
			screen.setObjectOnLocation(snake,snake_body_X.get(i),snake_body_Y.get(i));			
		}
		screen.ClearScreenLocation(last_snake_part_X,last_snake_part_Y);
	}
	//diriger le snake vers le  bas en suivant le meme principe 
	public void moveDown(GameScreen screen, Snake snake,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) {

		int last_snake_part_X=snake_body_X.get(snake_body_X.size() - 1);
		int last_snake_part_Y=snake_body_Y.get(snake_body_Y.size() - 1);
		for (int i=(snake_body_X.size()-1);i>0;i--) {
			snake_body_X.set (i,snake_body_X.get(i - 1));
			snake_body_Y.set (i,snake_body_Y.get(i - 1));			
		}
		snake.setY(getY() + 1);
		snake_body_Y.set (0,snake.getY());
		for (int i=0;i<snake_body_X.size();i++) {
			screen.setObjectOnLocation(snake,snake_body_X.get(i),snake_body_Y.get(i));

		}
		screen.ClearScreenLocation(last_snake_part_X,last_snake_part_Y);
		
	}		
	// verifier que le snake n'a pas heurté le mur ou d'autre parties de son corps
	public boolean isDie(GameScreen screen, Snake snake, ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) {
		
        for (int i=1;i<(snake_body_X.size()-1);i++) {//si le snake a heurté une partie de sont corps , la methode isDie va retourner true
        	if(snake_body_X.get(0)==snake_body_X.get(i) && snake_body_Y.get(0)==snake_body_Y.get(i)) {
        		return true;
        	}
        }
      //si le snake a heurté le mur , la methode isDie va retourner true
		if ((snake.getX()==0) || (snake.getY()==screen.getScreenHeight()-1) || (snake.getY()==0)||(snake.getX()==screen.getScreenWidth()-1) ) {
            return true;
        }
		
        return false ;
	}
	
}
