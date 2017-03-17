
package mas_thirtyone;

import java.util.ArrayList;




public class player {
   public card [] hand;
   public String name;
   public int handvalue;
   public boolean threeOfsameSuit;
   public boolean twoOfSameSuit;
   private int twosuite;//the position of one of the cards that shapes the two suit
   private int twokind;//the position of one of the cards that shapes the two kind
   public boolean threeOfAKind;
   public boolean twoOfAKind;
   public card highestCard;
   public String highestSuit;
   public  int playerNumber;
   public ArrayList <cardKnowledge> knowsCard;
   

    public player(String argName, card argFirst, card argSecond, card argThird) {
        this.name=argName;
        this.hand= new card[3];
        this.knowsCard= new ArrayList<cardKnowledge>();
        
        hand[0]=argFirst;
        hand[1]=argSecond;
        hand[2]=argThird;
        
        knowsCard.add(new cardKnowledge(this, hand[0]));
         knowsCard.add(new cardKnowledge(this, hand[1]));
          knowsCard.add(new cardKnowledge(this, hand[2]));
          
          setThreeOfAKind();
       if(!threeOfAKind){setTwoOfAKind();} else{ twoOfAKind=false;}
       
        setThreeOfsameSuit();
        if(!threeOfsameSuit){
          //needs work
            setTwoOfSameSuit();
            sortCards();} else{twoOfSameSuit=false;}
        
        
      
       if (!threeOfAKind && !threeOfsameSuit && !twoOfAKind && !twoOfSameSuit)
       {
           setHighestSuit();
       }
       setHighestCard();
      
        
        
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
        if(hand[1].suit.equals(hand[2].suit)){this.highestSuit=hand[1].suit;this.twosuite=1;}
        else{this.highestSuit=hand[0].suit;this.twosuite=0;}
        }
        else
        {this.twoOfSameSuit=false;}
    }
    
    public void setHighestCard() {
    if(threeOfAKind){highestCard=hand[0];}
    else{
        if (twoOfAKind){highestCard=hand[twokind];}
        else{
            if(threeOfsameSuit){sortCards();highestCard=hand[0];}
            else{
                if(twoOfSameSuit){highestCard=hand[twosuite];}
                else{ highestCard=hand[0];}
            }
        }
        
    }
    }
    
    public void setHighestSuit(){
        sortCards();
        highestSuit=hand[0].suit;
    }
    
    public void sortCards(){
        System.out.println("Sorting player's "+name+" hand");
        System.out.println("before sorting: "+hand[0].name+" , "+hand[1].name+ " , "+hand[2].name);
       boolean sorted=false;
       boolean swapped=false;
       
       while(!sorted)
       {
           for(int i=0; i<=hand.length-2;i++)
           {
              if(hand[i].suit.equals(highestSuit) && hand[i+1].suit.equals(highestSuit))
              {
                   if(hand[i].value<hand[i+1].value )
               {
               
              //System.out.println("Swapped "+hand[i].suit + " "+ highestSuit+" swapped "+hand[i].name+" with "+hand[i+1].name);
               card temp=  hand[i];
               hand[i]=hand[i+1];
               hand[i+1]=temp;
               swapped=true;
               
               
               }
              }else{
                  if(!hand[i].suit.equals(highestSuit) && hand[i+1].suit.equals(highestSuit)){
                      card temp=  hand[i];
               hand[i]=hand[i+1];
               hand[i+1]=temp;
               swapped=true;
                  }
              }
           }
           if(swapped){sorted=false;swapped=false;}else{sorted=true;}
       }
       
         System.out.println("after sorting: "+hand[0].name+" , "+hand[1].name+ " , "+hand[2].name);
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
              if(hand[0].type.equals(hand[1].type)){this.twokind=0;}
              else{
                twokind=2;
              }
              
           }else{this.twoOfAKind=false;}
    }
    
    public boolean doesKnowCard(player p, card c){  
        boolean knowledge=false;
        for(int i=0;i<=knowsCard.size()-1;i++)
        {
            if(p.name.equals(knowsCard.get(i).targetPlayer.name))
            {
                if(knowsCard.get(i).targetCard.name.equals(c.name))
                {
                  knowledge=true;
                  break;
                }else{knowledge=false;}
            }else{knowledge=false;}
        }
        return knowledge;
    }
    
    public void swapCard(card yourCard, card widowCard){  
        int locationOftheCard= findAcardInYourHand(yourCard);
        card temp =hand[locationOftheCard];
        hand[locationOftheCard]= widowCard;
        System.out.println("Player "+name+" successfully exchanged card "+temp.name+" with card "+hand[locationOftheCard].name);
        updateKnowledgeAfterExchange(this, yourCard, widowCard);
    }
    
    public int findAcardInYourHand(card yourCard){
          int yourCardposition=0;
        for(int i=0;i<=hand.length-1;i++)
        {
            if(hand[i].name.equals(yourCard.name))
            {
                yourCardposition=i;
                return yourCardposition;
                
            }
        }
        System.out.println("Failed to find the card");
        return yourCardposition;
    }
    
    public void updateKnowledgeAfterExchange(player p , card argDropped, card argPickd) {
        //removing previous knowledge 
        for(int i=0;i<=knowsCard.size()-1;i++)
        {
            if(p.name.equals(knowsCard.get(i).targetPlayer.name))
            {
                if(knowsCard.get(i).targetCard.name.equals(argDropped.name))
                {
                 knowsCard.remove(i);
                    System.out.println("outdated Knoweledge was removed");
                  break;
                }
            }
        }
        
        knowsCard.add(new cardKnowledge(p, argPickd));
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    
}
