import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Rummy extends Game{

    private  List<Card> handCards;
    private int numOfJokers=0;
    public static List<Integer> getFaceValues(List<Card> cards) {
        List<Integer> values = new ArrayList<Integer>();
        for (Card card : cards) {
            values.add(card.getFaceValue());
        }
        return values;
    }

    public Rummy(List<Card> cards)
    {
        this.handCards=cards;
        this.numOfJokers=removeJokers();
    }

    public static boolean areSequential(List<Card> cards) {
      //  int numOfJokers = 0;
        List<Integer> values = getFaceValues(cards);
        Collections.sort(values);
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i + 1) - values.get(i) != 1)
                    return false;
        }
        return true;
    }

    public  int removeJokers(){
        int numOfJokers = 0;
        List<Card.Suit> suits = CardUtils.getSuitValues(this.handCards);

        for (int i = 0; i < suits.size(); i++)
        {
            if(suits.get(i)== Card.Suit.JOKER)
            {
                numOfJokers++;
                suits.remove(i);
            }
        }

        return numOfJokers;

    }
//
//    int evaluateRummy(List<Card> cards) {
//        int neededCards=0;
//        return neededCards;
//    }
}
