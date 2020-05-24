package elevengame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a deck //balicek karet
 * @author jan.himmel
 */
public class Deck {
    //do not have to change during the game, deckSize can simulate removing the cards
    private List<Card> deckCards; 
    private int deckSize; //actual deck size
    
    public static void main(String[]args){
        Deck d = new Deck(DataStore.loadSymbols(),DataStore.loadValues(),DataStore.loadNPoints());
        System.out.println(d);
    }
    
    public Deck(String[] symbols, String[] values, int[] nPoints){
        deckCards = new ArrayList<>();
        generateAllCards(symbols, values, nPoints);
        this.deckSize = deckCards.size();
        shuffle();
    }

    @Override
    public String toString() {
        return "Deck{" + "deckCards=" + deckCards + ", deckSize=" + deckSize + '}';
    }
        
    /**
     * Generate List of all cards e.g. using DataStore class with arrays of symbols, values, nPoints
     */
    private void generateAllCards(String[] symbols, String[] values, int[] nPoints){
        for (String symbol : symbols) {
            for (int j =0;j<values.length;j++) {
                if(j<values.length-3){
                    Card tmp = new Card(symbol,values[j],nPoints[j]);
                    deckCards.add(tmp);
                }else{
                    Card tmp = new Card(symbol,values[j],0);
                    deckCards.add(tmp);
                }
                
            }
        }
    }
    
    /**
     * Shuffle list of cards
     * An algorithm to permute an array.
     */
    private void shuffle(){
        Collections.shuffle(deckCards);
    }
    
    /**
     * Deal one card
     * Get the card at deckSize-1 index and decrement deckSize by one 
     * @return the dealt card, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal(){
       if(deckSize<1){
           return null;
       }else{
            Card a = deckCards.get(deckSize-1);
            this.deckSize = deckSize - 1;
            return a;
       }
    }

    public int getDeckSize() {
        return this.deckSize;
    }

}
