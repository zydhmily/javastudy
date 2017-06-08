public class JokerCard extends Card{
	String joker;
	
	public JokerCard(String joker){
	    this.joker = joker;
	}

    //得到扑克牌牌面
    public String getFace(){
        return joker;       
    }
}