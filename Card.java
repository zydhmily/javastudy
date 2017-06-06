public class Card{
    String rank,suit,joker;
	
    public Card(String rank,String suit){
    	this.rank = rank;
    	this.suit = suit;
    }

    public Card(String joker){
        this.joker = joker;
    }
    
    //得到扑克牌牌面
    public String getFace(){
        if(rank == null){
            return joker;       
        }else{
            return rank + " of " + suit;
        }
    }
}
