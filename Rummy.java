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

    public Rummy(List<Card> cards,Card jokerCard)
    {
        int jokerFaceValue=jokerCard.getFaceValue();
        this.handCards=cards;
        this.numOfJokers=removeJokers(jokerFaceValue);
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

    public  int removeJokers(int jokerFaceValue){
        int numOfJokers = 0;
        //List<Card.Suit> suits = CardUtils.getSuitValues(this.handCards);
        List<Integer> faceValues=CardUtils.getFaceValues(this.handCards);

        for (int i = 0; i < faceValues.size(); i++)
        {
            if(faceValues.get(i)== -1 || faceValues.get(i)==jokerFaceValue)
            {
                numOfJokers++;
                faceValues.remove(i);
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
