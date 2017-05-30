public class Card{
	String rank;
	String suit;
    public Card(String rank,String suit){
    	this.rank = rank;
    	this.suit = suit;
    }
    
    //得到扑克牌牌面
	public String getCard(){
		if(rank != " "){
            return rank + " of " + suit;
        }else{
        	return suit;
        }
	}
}