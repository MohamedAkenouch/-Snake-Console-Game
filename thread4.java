import java.util.ArrayList;
//on refait la meme chose que le thread 1 , mais dans ce cas le snake se deplace vers le haut 
public class thread4 extends Thread{
    public void run(Snake snake ,GameScreen screen,Fruit fruit,ArrayList<Integer> snake_body_X,ArrayList<Integer> snake_body_Y) throws NullPointerException,InterruptedException {

        snake.moveUp(screen, snake, Main.snake_body_X, Main.snake_body_Y);
        Thread.sleep(500);
        screen.PrintScreen();
        if ( fruit.fruit_x== snake.getX() && fruit.fruit_y== snake.getY()){
        	Fruit fruit1 = new Fruit('*');
            fruit1.addRandomFruit(screen, fruit);
            Main.counter+=1;
            snake_body_X.add(snake_body_X.get(snake_body_X.size() - 1));
            snake_body_Y.add(snake_body_Y.get(snake_body_Y.size() - 1));
        }

      }

}