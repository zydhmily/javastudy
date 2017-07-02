import java.util.ArrayList;
import java.util.List;

public class Player{
	int id;         //玩家ID
	private List<Card> playerCards = new ArrayList<Card>();;     //玩家手牌

    public Player(int id){
    	this.id = id;   	
    }

    public void putCard(Card card){
    	playerCards.add(card);
    }

    public String getPlayerCardFace(int index){
        return playerCards.get(index).getFace();
    }

    public int getPlayerCardNumber(){
    	return playerCards.size();
    }

}