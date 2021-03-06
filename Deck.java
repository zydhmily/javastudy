import java.util.ArrayList;
import java.util.List;

public class Deck{
    //定义一副扑克牌集合
    private ArrayList<Card> list = new ArrayList<Card>(); 

    public Deck(){
	//扑克牌的点数　
    String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; 
	//扑克牌的花色
	String[] suits = {"heart","spade","diamond","club"};   
	//扑克牌的大王和小王
	String[] jokers = {"red joker","black joker"};  

	//生成一副扑克牌里的每张扑克牌
        for(int i = 0;i < ranks.length;i++){
            for(int j = 0;j < suits.length;j++){
        	list.add(new OrdinaryCard(ranks[i],suits[j]));
            }
        }
        list.add(new JokerCard(jokers[0]));
        list.add(new JokerCard(jokers[1]));
    }
    
    //取得deck中的卡牌元素
    public Card getCard(int index){
        return list.get(index);
    }

    //得到一副扑克牌有多少张
    public int getCardNumber(){
        return list.size();
    }
    //取牌
    public Card pop(){
        return list.remove(0);
    }
    //取出指定牌
    public Card pop(int index){
        return list.remove(index);
    }
    //指定位置加入牌
    public void addCard(int index,Card card){
        list.add(index,card);
    }


    public static void main(String[] args){
	//创建扑克牌实例
        Deck deck = new Deck();
        //打印扑克牌张数
        int number = deck.getCardNumber();
        System.out.println("一副牌有" + number + "张");
        //打印扑克牌牌面
        System.out.println("牌面:");
        for(int z = 0;z < number;z++){
            System.out.println(deck.getCard(z).getFace());
        }
    }
}
