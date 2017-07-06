import java.util.*;

public class PokerGame{
	public List<Player> players;
	public Deck deck;

	public PokerGame(List<Player> players,Deck deck){
	    this.players = players;
	    this.deck = deck;		
	}
    //洗牌1
	public void shuffle1(){
		int j = 27;
		for(int i = 0;i < 54;i += 2){
		    this.deck.addCard(i,deck.pop(j));
		    j = j + 1;
		}		    
	}
    //洗牌2
	public void shuffle2(){
		Calendar cld = Calendar.getInstance();
		//取得系统时间的毫秒
		int MI = cld.get(Calendar.MILLISECOND);
		//毫秒后两位
		int MIAfterTwo = MI % 100;
		
		if(MIAfterTwo > 10){
			for(int i = 1;i <= MIAfterTwo*10;i++){
				this.shuffle1();
			}
		}else{
			for(int i = 1;i <= MIAfterTwo;i++){
                this.shuffle1();
            }
		}
	}
    //向玩家发牌
	public void deal(){
		while(this.deck.getCardNumber() > 0){
		    for(int i = 0;i < this.players.size();i++){
		    	//从deck最前面取一张牌
			    Card a = this.deck.pop();
			    //把这张牌发给玩家
			    this.players.get(i).putCard(a);
			}
		}
	}

	public static void main(String[] args){
		List<Player> players = new ArrayList<Player>();
	    //向玩家列表添加玩家
		players.add(new Player(1));
		players.add(new Player(2));
		players.add(new Player(3));	
		Deck deck = new Deck();	 
		PokerGame game = new PokerGame(players,deck);
		//有洗牌2方法洗牌
		game.shuffle2();
		//向玩家发牌
		game.deal();
		//打印玩家手牌的牌面
		System.out.println("玩家：" + game.players.get(0).id + "的手牌");
		for(int i = 0;i < game.players.get(0).getPlayerCardNumber();i++){
			System.out.println(game.players.get(0).getPlayerCardFace(i));
		}
		System.out.println("玩家：" + game.players.get(1).id + "的手牌");
		for(int i = 0;i < game.players.get(1).getPlayerCardNumber();i++){
			System.out.println(players.get(1).getPlayerCardFace(i));
		}
		System.out.println("玩家：" + players.get(2).id + "的手牌");
		for(int i = 0;i < game.players.get(2).getPlayerCardNumber();i++){
			System.out.println(game.players.get(2).getPlayerCardFace(i));
		}
	}
}