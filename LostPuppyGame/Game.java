import java.util.Random;
import java.util.Scanner;
class Game{
		 int[][] building;
	     int player1Row ,player1Col ,player2Row ,player2Col, puppyRow , puppyCol, numRooms, numFloors;
	     Random random=new Random();
	     
	     public Game(int numRooms,int numFloors) {
	    	 this.numRooms = numRooms;
	    	 this.numFloors = numFloors;
	    	 building = new int[numFloors][numRooms];
	    	 player1Row = random.nextInt(numFloors);
	    	 player1Col = random.nextInt(numRooms);
	    	 player2Row = random.nextInt(numFloors);
	    	 player2Col = random.nextInt(numRooms);
	    	 puppyRow = random.nextInt(numFloors);
	    	 puppyCol = random.nextInt(numRooms);
	     
	      // Initialize the positions of the puppy    
	         if((puppyRow==player1Row && puppyCol == player1Col) || (puppyRow==player2Row && puppyCol == player2Col)) {
	        	//new position for puppy
	        	 puppyRow = random.nextInt(numFloors);
	             puppyCol = random.nextInt(numRooms);
	         }else {
	             building[puppyRow][puppyCol] = 3; // Puppy
	         }
	        
	      // Initialize the positions of the  players
	         if(player1Row==player2Row && player1Col==player2Col)
	        	 building[player1Row][player1Col] = 4;  //both players
	         else {
	        	 building[player1Row][player1Col] = 1; // Player 1
	        	 building[player2Row][player2Col] = 2; // Player 2
	         }
	        
	         System.out.println("Initial Positions:");
	         printBuilding(building, numRooms);
	     
	     }
	     
	     public void playGame() {
	    	// Player 1's turn
	            int player1Move = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right
	            int newPlayer1Row = player1Row;
	            int newPlayer1Col = player1Col;
	            if (player1Move == 0 && player1Row > 0) {
	                newPlayer1Row--;
	            } else if (player1Move == 1 && player1Row < numFloors - 1) {
	                newPlayer1Row++;
	            } else if (player1Move == 2 && player1Col > 0) {
	                newPlayer1Col--;
	            } else if (player1Move == 3 && player1Col < numRooms - 1) {
	                newPlayer1Col++;
	            }

	   
	            // Update player 1's position
	            if(building[player1Row][player1Col]==4)
	            {
	            	building[player2Row][player2Col] = 2;
	                player1Row = newPlayer1Row;
	                player1Col = newPlayer1Col;
	            	building[player1Row][player1Col] = 1;
	            }
	            else {
	            	building[player1Row][player1Col] = 0;
	                player1Row = newPlayer1Row;
	                player1Col = newPlayer1Col;
	                if(building[player1Row][player1Col]==2)
	                	building[player1Row][player1Col] =4;
	                else
	                	building[player1Row][player1Col] = 1;
	            }
	            
	            System.out.println("P's Turn:");
	            printBuilding(building, numRooms);

	         // Check if Player 1 found the puppy
	            if (player1Row == puppyRow && player1Col == puppyCol) {
	                System.out.println("Player 1 found the puppy and wins!");
	                return;
	            }

	         // Player 2's turn
	            int player2Move = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right
	            int newPlayer2Row = player2Row;
	            int newPlayer2Col = player2Col;
	            
	            if (player2Move == 0 && player2Row > 0) 
	                newPlayer2Row--;
	            else if (player2Move == 1 && player2Row < numFloors - 1) 
	                newPlayer2Row++;
	             else if (player2Move == 2 && player2Col > 0) 
	                newPlayer2Col--;
	            else if (player2Move == 3 && player2Col < numRooms - 1) 
	                newPlayer2Col++;
	           
	            
	         // Update player 2's position
	            if(building[player2Row][player2Col]==4) {
	            	 building[player1Row][player1Col] = 1;
	                 player2Row = newPlayer2Row;
	                 player2Col = newPlayer2Col;
	                 building[player2Row][player2Col] = 2;
	            }
	            else {
	            	 building[player2Row][player2Col] = 0;
	                 player2Row = newPlayer2Row;
	                 player2Col = newPlayer2Col;
	            	if(building[player2Row][player2Col]==1)
	            		building[player2Row][player2Col] =4;
	            	else
	            		building[player2Row][player2Col] = 2;
	            }
	            
	            System.out.println("Q's Turn:");
	            printBuilding(building, numRooms);

	         // Check if Player 2 found the puppy
	            if (player2Row == puppyRow && player2Col == puppyCol) {
	                System.out.println("Player 2 found the puppy and wins!");
	                return;
	            }
	            playGame();
	        }
	     

	      private void printBuilding(int[][] building, int numRooms) {
	         // Print the top border
	     	//System.out.println("Turn: "+i++);
	         System.out.print("-");
	         for (int i = 0; i <= numRooms; i++) {
	             System.out.print("---");
	         }
	         System.out.println();

	         for (int[] row : building) {
	             // Print the left border
	             System.out.print("|");
	             for (int room : row) {
	                 if (room == 0) {
	                     System.out.print("   ");
	                 } else if (room == 1) {
	                     System.out.print(" P1");
	                 } else if (room == 2) {
	                     System.out.print(" P2");
	                 } else if (room == 3) {
	                     System.out.print(" P ");
	                 }else if(room==4) {
	                 	System.out.print(" B");
	                 }
	                 System.out.print("|");
	             }
	             System.out.println();

	             // Print the row separator
	             System.out.print("-");
	             for (int i = 0; i <= numRooms; i++) {
	                 System.out.print("---");
	             }
	             System.out.println();
	         }
	     	System.out.println();
	     }
	}
