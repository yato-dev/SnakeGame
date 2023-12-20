import java.util.Random;

public class SnakeGame {

    public static void main(String[] args) {
        playGame(2);
    }

    private static int[] initializePlayers(int numPlayers) {
        int[] playerPositions = new int[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            playerPositions[i] = 0;
        }
        return playerPositions;
    }

    private static void playGame(int numPlayers) {
        int[] playerPositions = initializePlayers(numPlayers);
        int[] diceRolls = new int[numPlayers];
        Random random = new Random();
        int currentPlayer = 0;

        while (true) {
            int diceValue = random.nextInt(6) + 1; 
            diceRolls[currentPlayer]++;
            
            int option = random.nextInt(3); 

            switch (option) {
                case 0:
                    
                    break;
                case 1:
                   
                    playerPositions[currentPlayer] += diceValue;
                    break;
                case 2:
                  
                    playerPositions[currentPlayer] -= diceValue;
                    break;
            }

            
            playerPositions[currentPlayer] = Math.max(playerPositions[currentPlayer], 0);

        
            if (playerPositions[currentPlayer] > 100) {
                playerPositions[currentPlayer] -= diceValue;
            }

          
            if (playerPositions[currentPlayer] == 100) {
                System.out.println("Player " + (currentPlayer + 1) + " wins!");
                break;
            }

            System.out.println("Player " + (currentPlayer + 1) + " rolled a " + diceValue +
                    " and is now at position " + playerPositions[currentPlayer]);

            if (option == 1) {
                continue;
            }

            currentPlayer = (currentPlayer + 1) % numPlayers;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " rolled the dice " + diceRolls[i] + " times.");
        }
    }
}
