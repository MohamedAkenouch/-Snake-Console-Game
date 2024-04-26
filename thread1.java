import java.util.ArrayList;

public class thread1 extends Thread{
    public void run(Snake snake ,GameScreen screen,Fruit fruit,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) throws NullPointerException,InterruptedException {

        snake.moveLeft(screen, snake, Main.snake_body_X, Main.snake_body_Y);//faire deplacer le snake vers la gauche
        Thread.sleep(500);//la periode des mouvements successives est 500 ms 
        screen.PrintScreen();
        //apres chaque deplacement on verifie si le le snake a heurté le fruite , si c'etait le cas on ajoute une autre fruit de maniere aleatoire
        if ( fruit.fruit_x== snake.getX() && fruit.fruit_y== snake.getY()) {
            Fruit fruit1 = new Fruit('*');
            fruit1.addRandomFruit(screen, fruit);
            Main.counter+=1;   //si la condition est verifié , on ajoute une unité au serpent 
            snake_body_X.add(snake_body_X.get(snake_body_X.size() - 1)); 
            snake_body_Y.add(snake_body_Y.get(snake_body_Y.size() - 1));

        }

    }

}