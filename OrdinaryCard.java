public class OrdinaryCard extends Card{
    String rank,suit;
	
    public OrdinaryCard(String rank,String suit){
    	this.rank = rank;
        this.suit = suit;
    }
    
    //得到扑克牌牌面
    public String getFace(){
        return "the " + rank + " of " + suit;
    }
}