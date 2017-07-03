import java.util.ArrayList;
import java.util.List;

public class Player{
	int id;         //玩家ID
	private List<Card> playerCards = new ArrayList<Card>();;     //玩家手牌

    public Player(int id){
    	this.id = id;   	
    }
    //向玩家手里添加卡牌
    public void putCard(Card card){
    	playerCards.add(card);
    }
    //取得玩家手里指定的牌面
    public String getPlayerCardFace(int index){
        return playerCards.get(index).getFace();
    }
    //取得玩家手牌数
    public int getPlayerCardNumber(){
    	return playerCards.size();
    }

}