import java.util.Scanner;
public class thread3 extends Thread{
	public void run() {
        char input='g';
        Scanner scanner = new Scanner(System.in);
        if( Main.input=='g') {
            input = scanner.nextLine().charAt(0);
            /* si le serpent se deplace a gauche et on veut changer sa direction , on a seulement deux possibilités : vers le haut/ vers le bas .
              donc les deux lettres qui sont acceptables dans ce cas sont 'b' et 'h' */
            while(input!='b' && input!='h') {   
                input = scanner.nextLine().charAt(0);
            }

        }
        if( Main.input=='d') {
            input = scanner.nextLine().charAt(0);
            /* si le serpent se deplace a droite et on veut changer sa direction , on a seulement deux possibilités : vers le haut/ vers le bas .
            donc les deux lettres qui sont acceptables dans ce cas sont 'b' et 'h' */
            while(input!='b' && input!='h') {
                input = scanner.nextLine().charAt(0);
            }

        }
        if( Main.input=='b') {
            input = scanner.nextLine().charAt(0);
            /* si le serpent se deplace vers le bas et on veut changer sa direction , on a seulement deux possibilités : vers le haut/ vers le bas .
            donc les deux lettres qui sont acceptables dans ce cas sont 'g' et 'd' */
            while(input!='d' && input!='g') {
                input = scanner.nextLine().charAt(0);
            }

        }
        if( Main.input=='h') {
            input = scanner.nextLine().charAt(0);
            /* si le serpent se deplace vers le haut et on veut changer sa direction , on a seulement deux possibilités : vers le haut/ vers le bas .
            donc les deux lettres qui sont acceptables dans ce cas sont 'g' et 'd' */
            while(input!='d' && input!='g') {
                input = scanner.nextLine().charAt(0);
            }

        }
        Main.input=input;


    }
}