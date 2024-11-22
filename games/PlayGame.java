package games;

import games.CardGame.Card;
import java.util.*;


public class PlayGame {

    public PlayGame() {
        System.out.println("PlayGame created!");
    }

    // Think about deleting this and just use moveCard instead----------------------------------------------------------
    public void drawCard(ArrayList<Card> pile, ArrayList<Card> discardPile){
        int x = pile.size()-1;
        discardPile.add(pile.remove(x));
    }

    // Method to move card from one deck to another---------------------------------------------------------------------
    public void moveCard(ArrayList<Card> xDeck, ArrayList<Card> yDeck){
        int x = xDeck.size()-1;
        yDeck.add(xDeck.remove(x));
    }

    //Method to
    public void ruleSolvedDecks(){

    }

    // Method to
    public void ruleDeck(){

    }
    
}