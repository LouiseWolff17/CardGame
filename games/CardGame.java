package games;
import java.util.*;

public class CardGame {

    // Attributes-------------------------------------------------------------------------------------------------------
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Board> board = new ArrayList<>();


    // Card class to represent rank and suit----------------------------------------------------------------------------
    public class Card {
        private final String rank;
        private final String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    // Board class to represent board decks-----------------------------------------------------------------------------
    public class Board {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        ArrayList<ArrayList<Card>> solvedDecks = new ArrayList<>();
        ArrayList<Card> pile = new ArrayList<>();
        ArrayList<Card> discardPile = new ArrayList<>();
        
        public Board(ArrayList<ArrayList<Card>> decks, ArrayList<ArrayList<Card>> solvedDecks, ArrayList<Card> pile, ArrayList<Card> discardPile){
            this.decks = decks;
            this.solvedDecks = solvedDecks;
            this.pile = pile;
            this.discardPile = discardPile;
        }
    }

    // Constructors-----------------------------------------------------------------------------------------------------
    public CardGame(ArrayList<Card> cards, ArrayList<Board> board) {
        this.cards = cards;
        this.board = board;
    }

    public CardGame() {
        System.out.println("CardGame created!");
        createGame();
    }

    // Getters and Setters----------------------------------------------------------------------------------------------
    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Board> getBoard() {
        return board;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setBoard(ArrayList<Board> board) {
        this.board = board;
    }

    // Method to create and initialize the game-------------------------------------------------------------------------
    private void createGame() {
        initializeDeck();
        shuffleDeck();
        initializeBoard();
        fillBoard();
    }

    // Helper method to initialize the deck of cards--------------------------------------------------------------------
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] faceCards = {"Ace", "Jack", "Queen", "King"};

        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                String rank = switch (i) {
                    case 1 -> faceCards[0];
                    case 11 -> faceCards[1];
                    case 12 -> faceCards[2];
                    case 13 -> faceCards[3];
                    default -> String.valueOf(i);
                };
                cards.add(new Card(rank, suit));
            }
        }
    }

    // Helper method to shuffle the deck--------------------------------------------------------------------------------
    private void shuffleDeck() {
        Collections.shuffle(cards, new Random());
    }

    // Helper method to initialize the board----------------------------------------------------------------------------
    private void initializeBoard() {
        ArrayList<ArrayList<Card>> decks = new ArrayList<>();
        ArrayList<ArrayList<Card>> solvedDecks = new ArrayList<>();
        ArrayList<Card> pile = new ArrayList<>();
        ArrayList<Card> discardPile = new ArrayList<>();

        // Create 7 decks
        for (int i = 0; i < 7; i++) {
            decks.add(new ArrayList<>());
        }

        // Create 4 solved decks
        for (int i = 0; i < 4; i++) {
            solvedDecks.add(new ArrayList<>());
        }

        Board newBoard = new Board(decks, solvedDecks, pile, discardPile);
        board.add(newBoard);
    }

    // Helper method to fill the board with cards-----------------------------------------------------------------------
    private void fillBoard(){

        Board currentBoard = board.get(0);
        ArrayList<ArrayList<Card>> decks = currentBoard.decks;
        ArrayList<Card> pile = currentBoard.pile;


        for (int i = 0; i < decks.size(); i++) {
            for (int j = 0; j <= i; j++) { 
                decks.get(i).add(cards.remove(0));
            }
            System.out.println(decks.get(i));
        }
        
        pile.addAll(cards);
        cards.clear();

        System.out.println("Board filled with cards!");
    }
}
