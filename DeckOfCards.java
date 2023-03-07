package assignments.ObjectOrientedPrograms;

import java.util.Random;

public class DeckOfCards {
    String[] deck = new String[52];  //total 52 cards
    String[] suit = {"Club", "Diamond", "Heart", "Spade"};
    String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    String[][] playCards = new String[4][9];   //4 player, 9 cards each

    Random random = new Random();

//getting card according to their rank and suits

    public void getCards() {

        int deckIndex = 0;  //start with 0
        for (int first = 0; first < suit.length; first++) {
            for (int second = 0; second < rank.length; second++) {
                //aligning ranks and suits together
                deck[deckIndex] = rank[second] + " " + suit[first];
                deckIndex++;
            }
        }
    }

    // suffling of cards
    public String[] suffleCards() {
        int second = 0;

        for (int first = 0; first < deck.length; first++) {
            second = random.nextInt(52); //swapping existing data with random data
            String temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
        return deck;
    }

    //displaying cards
    public void displayCards(String[] deck) {
        int deckIndex = 0;

        for (int first = 0; first < playCards.length; first++) {          //for suit
            System.out.println("Player : " + (first + 1));
            for (int second = 0; second < playCards[first].length; second++) {    //for rank
                playCards[first][second] = deck[deckIndex];
                System.out.println(playCards[first][second]);
                deckIndex++;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DeckOfCards player = new DeckOfCards();
        player.getCards();
        String[] deck = player.suffleCards();
        player.displayCards(deck);
    }
}
