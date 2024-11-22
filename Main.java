
import games.CardGame;
import games.PlayGame;

public class Main {

    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        CardGame game = new CardGame();
        System.out.println("Cards: " + game.getCards());
        System.out.println("Board: " + game.getBoard());
    }
}
