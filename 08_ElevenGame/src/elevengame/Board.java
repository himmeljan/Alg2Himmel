package elevengame;

import java.util.ArrayList;

/**
 * Represents the table with cards to play and a deck
 *
 * @author jan.himmel
 */
public class Board implements BoardInterface {

    private Card[] cards;
    private Deck deck;

    public Board() {
        //create deck
        this.deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        //deal cards
        this.cards = new Card[DataStore.getNCards()];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = deck.deal();
        }
    }

    @Override
    public String gameName() {
        return "Hra jedenactka";
    }

    @Override
    public int nCards() {
        return cards.length;
    }

    @Override
    public int getDeckSize() {
        return deck.getDeckSize();
    }

    @Override
    public String getCardDescriptionAt(int index) {
        if (cards[index] == null) {
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        boolean eleven= false;
        
        boolean JQK = false;
        for(Card card : cards){
             for (int i = 0; i < cards.length; i++) {
                if( card.getnPoints() +cards[i].getnPoints()==11){
                    eleven = true;
                }
            }       
        }
        int[]a = new int[cards.length];
        for (int i = 0; i < a.length; i++) {
            a[i]=i;                      
        }
        
        JQK = getJQK(a);
        if(eleven ==true ||JQK == true){
            return true;
        }
        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        int[] npoints = DataStore.loadNPoints();
        int sum = 0;
        for (int selectCard : iSelectedCards) {
            System.out.println(selectCard);
            sum = sum + cards[selectCard].getnPoints();
        }

        if (sum == 11 || getJQK(iSelectedCards)) {
            for (int selectCard : iSelectedCards) {
                this.cards[selectCard] = deck.deal();

            }

        }else{
            return false;
        }
        return true;
    }
    private boolean getJQK(int[] iSelectedCards) {
       
        String[] JQK = new String[iSelectedCards.length];
        for (int i = 0; i < JQK.length; i++) {
            
            JQK[i] = cards[iSelectedCards[i]].getValue();   
            
           
        }
        
        String[] triple = DataStore.getTriple();
        int[] zero = new int[triple.length];
        for (int i = 0; i < zero.length; i++) {
            zero[i] = 0;
        }
        for (int i = 0; i < JQK.length; i++) {
            for (int j = 0; j < zero.length; j++) {
                if (JQK[i] == triple[j] && zero[j] != 1) {
                    zero[j] = 1;
                    
                }

            }

        }
        for (int i = 0; i < zero.length; i++) {
            if (zero[i] == 0) {
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean isWon() {
        return getDeckSize() == 0 && cards.length == 0;
    }
    
    public static void main(String[]args){
        int[] b = {1,3,4,5,6,7,8,9};
        boolean a;
        
    }
}
