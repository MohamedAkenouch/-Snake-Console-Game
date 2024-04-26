import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	public static char input;
	public static int counter=3;
	public static ArrayList<Integer> snake_body_X = new ArrayList<Integer>();
	public static ArrayList<Integer> snake_body_Y = new ArrayList<Integer>();
	


    public static void main(String[] args) throws InterruptedException {

        final int SCREEN_WIDTH =40;//largeur du plateau de jeu
        final int SCREEN_HEIGHT = 20; //longueur du plateau de jeu
        int SNAKE_STARTING_X=0;
        int SNAKE_STARTING_Y=0;
        //choisir la position intiale du snake a condition que ses coordonnées ne soient pas 0
        boolean nuul=true;
        while (nuul) {
            SNAKE_STARTING_X = (int) (Math.random() * ( SCREEN_WIDTH- 1));
            SNAKE_STARTING_Y=(int) (Math.random() * (SCREEN_HEIGHT - 1));
            if (SNAKE_STARTING_X!=0 && SNAKE_STARTING_Y!=0 )
                nuul=false;

        }



        // Initialisation du plateau de jeu
        GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen.InitScreen();

        //intialisation du mure
        Mur mur = new Mur('#');
        mur.addMursRow(screen, mur, 0); 
        mur.addMursRow(screen, mur, screen.getScreenHeight() - 1); 
        mur.addMursColumn(screen, mur, 0); 
        mur.addMursColumn(screen, mur, screen.getScreenWidth() - 1);

        //initailisation du snake 
        Snake snake = new Snake('¤', SNAKE_STARTING_X, SNAKE_STARTING_Y);
        screen.setObjectOnLocation(snake, snake.getX(), snake.getY());
        snake_body_X.add(snake.getX());
        snake_body_Y.add(snake.getY());
        screen.setObjectOnLocation(snake, snake.getX()-1, snake.getY());
        snake_body_X.add(snake.getX()-1);
        snake_body_Y.add(snake.getY());
        screen.setObjectOnLocation(snake, snake.getX()-2, snake.getY());
        snake_body_X.add(snake.getX()-2);
        snake_body_Y.add(snake.getY());

        
        //intalisation du fruit
        Fruit fruit = new Fruit('*');
        fruit.addRandomFruit(screen, fruit);

        

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
       
        screen.PrintScreen();   //affaicher le screen
        input = 'd';  //le snake est initalement diriger vers la droite 
        
        while (isRunning) {
                switch (input) {
                case 'g':
                		thread1 thread11 = new thread1();   //on a instancier un objet thread11 de type thread1
                		thread3 thread33 = new thread3();  // on a instancier un objet thread33 de type thread3 
                        thread33.start();  // le thread33 a commencé son execution et attend un autre input de la part du joueur pour changer la direction du serpent
                        
                        for (int i=0 ;i<SCREEN_WIDTH;i++) { // le max des deplacements que le serpent peut faire vers la gauche avant d'heurter le mur=la largeur du screen 
                            thread11.run(snake ,screen,fruit, Main.snake_body_X, Main.snake_body_Y); //le tHread11 commence son execution et le serpent se deplace tout seul vers la gauche
                            if (Main.input=='h' || Main.input=='b') { // la valeur de l'input change a partir du thred33 , si le joueur a entre une autre direction , on arrete la boucle qui deplace le serpent tout seul
                            	break;
                            }
                            if (snake.isDie(screen, snake, Main.snake_body_X, Main.snake_body_Y))
                                break;
                        }

                        isRunning=!snake.isDie(screen , snake, Main.snake_body_X, Main.snake_body_Y);
                        break;
                // on repete la meme procedure si la lettre entré par le joueur est 'd'         
                case 'd':
                	thread2 thread22 = new thread2();
            		thread3 thread31 = new thread3();      
                    thread31.start();                    
                    for (int i=0 ;i<SCREEN_WIDTH;i++) {
                        thread22.run(snake ,screen,fruit, Main.snake_body_X, Main.snake_body_Y);
                        if (Main.input=='h' || Main.input=='b') {
                        	break;
                        }
                        if (snake.isDie(screen, snake, Main.snake_body_X, Main.snake_body_Y))
                            break;
                    }

                    isRunning=!snake.isDie(screen , snake, Main.snake_body_X, Main.snake_body_Y);
                    break;
                    
                 // on repete la meme procedure si la lettre entré par le joueur est 'h'  
                case 'h':
                	thread4 thread44 = new thread4();
            		thread3 thread32 = new thread3();      
                    thread32.start();                    
                    for (int i=0 ;i<SCREEN_WIDTH;i++) {
                        thread44.run(snake ,screen,fruit, Main.snake_body_X, Main.snake_body_Y);
                        if (Main.input=='d' || Main.input=='g') {
                        	break;
                        }
                        if (snake.isDie(screen, snake, Main.snake_body_X, Main.snake_body_Y))
                            break;
                    }

                    isRunning=!snake.isDie(screen , snake, Main.snake_body_X, Main.snake_body_Y);
                    break;
                 // on repete la meme procedure si la lettre entré par le joueur est 'b'  
                case 'b':
                	thread5 thread55 = new thread5();
            		thread3 thread34 = new thread3();      
                    thread34.start();                    
                    for (int i=0 ;i<SCREEN_WIDTH;i++) {
                        thread55.run(snake ,screen,fruit, Main.snake_body_X, Main.snake_body_Y);
                        if (Main.input=='d' || Main.input=='g') {
                        	break;
                        }
                        if (snake.isDie(screen, snake, Main.snake_body_X, Main.snake_body_Y))
                            break;
                    }

                    isRunning=!snake.isDie(screen , snake, Main.snake_body_X, Main.snake_body_Y);
                    break;
                }
              
                               
                }
        //la condition pour quitter la boucle while est lorsque isRunning=false , càd lorsque le snake isDie  
        System.out.println("GAME OVER");
        System.out.println("SCORE: "+(counter-3)*10);  //on affaiche le score tq pour chaque fruit heurté on gagne 10pts 

        }
      
}

