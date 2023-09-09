import java.util.Random;
import java.util.Scanner;

class LostPuppy {
	
	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);
        	Random random = new Random();

        	try {
        		System.out.print("Enter the number of rooms per floor: ");
        		int numRooms = scanner.nextInt();

        		System.out.print("Enter the number of floors: ");
        		int numFloors = scanner.nextInt();
        
        		Game game = new Game(numRooms,numFloors);
        		game.playGame();
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
	}

}