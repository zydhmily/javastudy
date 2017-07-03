import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class PokerGame{
	public PokerGame(){		

	}
    //洗牌1
	public void shuffle1(Deck deck){
		int j = 27;
		for(int i = 0;i < 54;i += 2){
		    deck.addCard(i,deck.pop(j));
		    j = j + 1;
		}		    
	}
    //洗牌2
	public void shuffle2(Deck deck){
		Calendar cld = Calendar.getInstance();
		//取得系统时间的毫秒
		int MI = cld.get(Calendar.MILLISECOND);
		//毫秒后两位
		int MIAfterTwo = Integer.parseInt(String.valueOf(MI).substring(1));
		if(MI > 10){
			for(int i = 1;i <= MIAfterTwo*10;i++){
				shuffle1(deck);
			}
		}else{
			for(int i = 1;i <= MIAfterTwo;i++){
                shuffle1(deck);
            }
		}
	}
    //向玩家发牌
	public void deal(List<Player> players,Deck deck){
		while(deck.getCardNumber() > 0){
		    for(int i = 0;i < players.size();i++){
			    Card a = deck.pop();
			    players.get(i).putCard(a);
			}
		}
	}

	public static void main(String[] args){
		PokerGame game = new PokerGame();
		List<Player> players = new ArrayList<Player>();  
		Deck deck = new Deck();
		//向玩家列表添加玩家
		players.add(new Player(1));
		players.add(new Player(2));
		players.add(new Player(3));
		//有洗牌2方法洗牌
		game.shuffle2(deck);
		//向玩家发牌
		game.deal(players,deck);
		//打印玩家手牌的牌面
		System.out.println("玩家：" + players.get(0).id + "的手牌");
		for(int i = 0;i < players.get(0).getPlayerCardNumber();i++){
			System.out.println(players.get(0).getPlayerCardFace(i));
		}
		System.out.println("玩家：" + players.get(1).id + "的手牌");
		for(int i = 0;i < players.get(1).getPlayerCardNumber();i++){
			System.out.println(players.get(1).getPlayerCardFace(i));
		}
		System.out.println("玩家：" + players.get(2).id + "的手牌");
		for(int i = 0;i < players.get(2).getPlayerCardNumber();i++){
			System.out.println(players.get(2).getPlayerCardFace(i));
		}
	}
}