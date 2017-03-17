
package mas_thirtyone;




public class player {
   public card [] hand;
   public String name;
   public int handvalue;
   public boolean threeOfsameSuit;
   public boolean twoOfSameSuit;
   public boolean threeOfAKind;
   public boolean twoOfAKind;
   public card highestCard;
   public String highestSuit;

    public player(String argName, card argFirst, card argSecond, card argThird) {
        this.name=argName;
        this.hand= new card[3];
        hand[0]=argFirst;
        hand[1]=argSecond;
        hand[2]=argThird;
        
        setThreeOfsameSuit();
        if(!threeOfsameSuit){setTwoOfSameSuit();} else{twoOfSameSuit=false;}
        
        setThreeOfAKind();
       if(!threeOfAKind){setTwoOfAKind();} else{ twoOfAKind=false;}
       
        
      
        
        
    }

    public void setThreeOfsameSuit() {
        if(hand[0].suit.equals(hand[1].suit) && hand[1].suit.equals(hand[2].suit))
        {this.threeOfsameSuit=true; this.highestSuit=hand[1].suit;}
        else
        {this.threeOfsameSuit=false;}
    }
    
    public void setTwoOfSameSuit(){
        if(hand[0].suit.equals(hand[1].suit) || hand[1].suit.equals(hand[2].suit) || hand[0].suit.equals(hand[2].suit))
        {this.twoOfSameSuit=true; 
        if(hand[0].suit.equals(hand[1].suit)){this.highestSuit=hand[1].suit;}
        else{if(hand[1].suit.equals(hand[2].suit)){this.highestSuit=hand[1].suit;} else{this.highestSuit=hand[0].suit;}}
        }
        else
        {this.twoOfSameSuit=false;}
    }
    
    public void setHighestCard() {
        
    }
    
    public void setThreeOfAKind() {
        if(threeOfsameSuit || twoOfSameSuit)
        {
            this.threeOfAKind=false;
        }else{
           if(hand[0].type.equals(hand[1].type) && hand[1].type.equals(hand[2].type))
           {
               this.threeOfAKind=true;
           }
           else{
               this.threeOfAKind=false;
           }
        }
    }
    
    public void setTwoOfAKind(){
           if(hand[0].type.equals(hand[1].type) || hand[1].type.equals(hand[2].type) || hand[0].type.equals(hand[2].type))
           {
              this.twoOfAKind=true;
           }else{this.twoOfAKind=false;}
    }
    
    
}
