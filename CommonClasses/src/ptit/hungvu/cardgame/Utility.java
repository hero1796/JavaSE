/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author HungVu
 */
public class Utility {
    public ArrayList<Card> getAllCards() {
        ArrayList<Card> listCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(i + 1, j + 1);
                listCards.add(card);
            }
        }
        return listCards;
    }
    
    public ArrayList<ArrayList<Card>> dividingCards(int playerTotal) {
        ArrayList<Card> allCards = getAllCards();
        Collections.shuffle(allCards);
        ArrayList<ArrayList<Card>> listListCards = new ArrayList<>();
        int beginIndex, endIndex;
        for (int i = 0; i < playerTotal; i++) {
            ArrayList<Card> cardsForOnePlayer = new ArrayList<>();
            beginIndex = 13 * i;
            endIndex = beginIndex + 13;
            for (int j = beginIndex; j < endIndex; j++) {
                cardsForOnePlayer.add(allCards.get(j));
            }
            listListCards.add(cardsForOnePlayer);
        }
        return listListCards;
    }
}
