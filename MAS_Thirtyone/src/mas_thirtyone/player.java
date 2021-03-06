
package mas_thirtyone;

import java.util.ArrayList;
import javax.swing.JOptionPane;




public class player {
   public card [] hand;
   public String name;
   public double handvalue;
   public boolean threeOfsameSuit;
   public boolean twoOfSameSuit;
   private card twosuite;//the position of one of the cards that shapes the two suit
   private card twokind;//the position of one of the cards that shapes the two kind
   public boolean threeOfAKind;
   public boolean twoOfAKind;
   public card highestCard;
   public String highestSuit;
   public  int playerNumber;
   public ArrayList <cardKnowledge> knowsCard;
   public  ArrayList <playerHighSuitKnowledge>knowsPlayerhighSuit;
   public intention playerDecision;
   public ArrayList <OtherInetntion> otherIntention;
   public boolean call=false;
  
   
   
   

    public player(String argName, card argFirst, card argSecond, card argThird) {
        this.name=argName;
        this.hand= new card[3];
        this.knowsCard= new ArrayList<cardKnowledge>();
        this.knowsPlayerhighSuit= new ArrayList<playerHighSuitKnowledge>();
        this.playerDecision=new intention("self");
        
        
        hand[0]=argFirst;
        hand[1]=argSecond;
        hand[2]=argThird;
        
        knowsCard.add(new cardKnowledge(this, hand[0]));
        knowsCard.get(0).setType("self");
         knowsCard.add(new cardKnowledge(this, hand[1]));
         knowsCard.get(1).setType("self");
          knowsCard.add(new cardKnowledge(this, hand[2]));
          knowsCard.get(2).setType("self");
          
          otherIntention=new ArrayList<OtherInetntion>();
          
    updatePlayerEntireKnowledge();
          
        
        
    }

    public void initiateOtherIntention(player p){
       
            if(!name.equals(p.name) && !p.name.equals("widow"))
            {
                System.out.println(p.name);
                OtherInetntion x=new OtherInetntion(p.name);
               otherIntention.add(x); 
            }
        
        
    }
  
    public void updateOtherIntention(card picked, card Dropped, player p){
        for (int i=0;i<=otherIntention.size()-1;i++)
        {
            if(otherIntention.get(i).targetPlayer.equals(p.name)){
                otherIntention.get(i).setType(picked, Dropped);
                otherIntention.get(i).updateSuitKnowledge(picked.suit);
                otherIntention.get(i).setTargetHighsuit();
                otherIntention.get(i).setTOK();
                otherIntention.get(i).set=true;
            }
        }
    }
    
    public void updatePlayerEntireKnowledge()
    {
 
          setThreeOfAKind();
       if(!threeOfAKind){setTwoOfAKind();} else{ twoOfAKind=false;}
       
        setThreeOfsameSuit();
        if(!threeOfsameSuit){
          //needs work
            setTwoOfSameSuit();
            sortCards();} else{twoOfSameSuit=false;}
        if(twoOfAKind){
            
        }
        
        
     
       if (!threeOfAKind && !threeOfsameSuit && !twoOfAKind && !twoOfSameSuit)
       {   
           setHighestSuit();
          
          
       }
        setHighestCard();
       System.out.println("Player "+name +"'s highsest card is :"+highestCard.name);
        System.out.println("Player "+name +"'s highest suit is :"+highestSuit);
        calculateHandValue();
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
        if(hand[1].suit.equals(hand[2].suit)){this.highestSuit=hand[1].suit;this.twosuite=hand[1];}
        else{this.highestSuit=hand[0].suit;this.twosuite=hand[0];}
        }
        else
        {this.twoOfSameSuit=false;}
    }
    
    public void setHighestCard() {
    if(threeOfAKind){highestCard=hand[0];}
    else{
        if (twoOfAKind){
            for(int i=0;i<=2;i++)
            {if(hand[i].suit.equals(highestSuit))
            {
               highestCard=hand[i];
               break;
            }
            }
        }
        else{
            if(threeOfsameSuit){sortCards();highestCard=hand[0];}
            else{
                if(twoOfSameSuit){sortCards();highestCard=hand[0];}
                else{ highestCard=hand[0];}
            }
        }
        
    }
    }
    
    public void setHighestSuit(){
        if(!twoOfAKind && !threeOfAKind)
        {
            sortCardsWithoutSuit();
        }
        highestSuit=hand[0].suit;
    }
    public void sortCardsWithoutSuit(){
        System.out.println("Sorting player's "+name+" hand");
        System.out.println("before sorting: "+hand[0].name+" , "+hand[1].name+ " , "+hand[2].name);
       boolean sorted=false;
       boolean swapped=false;
        while(!sorted)
       {
           for(int i=0; i<=hand.length-2;i++)
           {
              
                   if(hand[i].value<hand[i+1].value )
               {
               
              //System.out.println("Swapped "+hand[i].suit + " "+ highestSuit+" swapped "+hand[i].name+" with "+hand[i+1].name);
               card temp=  hand[i];
               hand[i]=hand[i+1];
               hand[i+1]=temp;
               swapped=true;
               }
               
             
           }
           if(swapped){sorted=false;swapped=false;}else{sorted=true;}}
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
               highestSuit=hand[0].suit;
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
              if(hand[0].type.equals(hand[1].type)){ this.twokind=this.hand[1]; highestSuit=hand[1].suit;}
              else{
                this.twokind=this.hand[2];
                highestSuit=hand[2].suit;
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
        if(p.name.equals(this.name))
        {
          knowsCard.get(knowsCard.size()-1).type="self";
        }else{
           if(p.name.equals("widow"))
        {
          knowsCard.get(knowsCard.size()-1).type="widow";
        }else{
          knowsCard.get(knowsCard.size()-1).type="others";  
        } 
        }
        
        
    }

   
    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    
    public  void calculateHandValue()
    {
        if(threeOfAKind){this.handvalue = 30.5;}
        //the following is if the hand value is determined by two of a kind
        else{if(twoOfAKind && !twoOfSameSuit){
        handvalue=0;
        for(int i=0;i<=2;i++)
        {
            if(hand[i].type.equals(twokind.type))
            { handvalue = handvalue+ (double)(hand[i].value);
            }
        }
        }
        else{
            handvalue=0;
            for(int i=0; i<=2;i++)
            {
                if(hand[i].suit.equals(highestSuit))
                {
                    handvalue = handvalue+ (double)(hand[i].value);
                }
            }
        }
        }
        System.out.println("Player "+name +"'s hand value is :"+handvalue);
    }
    
   
    
   public void updateWidowKnowledge(player argWidow)
   {
//       for(int y=0; y<=2;y++)
//       {
//           //removing previous knowledge 
//        for(int i=0;i<=knowsCard.size()-1;i++)
//        {
//            if(knowsCard.get(i).targetPlayer.name.equals(argWidow.name))
//            {
//                //System.out.println(knowsCard.get(i).targetPlayer.name+" && "+argWidow.name);
//                //System.out.println(knowsCard.get(i).targetCard.name+" && "+argWidow.hand[y].name);
//                if(knowsCard.get(i).targetCard.name.equals(argWidow.hand[y].name))
//                {
//                     
//                 knowsCard.remove(i);
//                    System.out.println("outdated Knoweledge was removed");
//                  break;
//                }
//            }
//        }
//        
//        knowsCard.add(new cardKnowledge(argWidow, argWidow.hand[y]));
//        knowsCard.get(knowsCard.size()-1).setType("widow");
//       }
       removeWidow();
       knowsCard.add(new cardKnowledge(argWidow, argWidow.hand[0]));
       knowsCard.get(knowsCard.size()-1).setType("widow");
       knowsCard.add(new cardKnowledge(argWidow, argWidow.hand[1]));
       knowsCard.get(knowsCard.size()-1).setType("widow");
       knowsCard.add(new cardKnowledge(argWidow, argWidow.hand[2]));
       knowsCard.get(knowsCard.size()-1).setType("widow");
   }
   
  public void setPlayerIntention()
  {
      if((this.handvalue == 31) || threeOfAKind)
      {
          //we put intention to call / fold
          this.playerDecision.playerIntention=12;
          call=true;
          
         
      }else{
          if(threeOfsameSuit){//of three of same suit
             if(checkWidowRaiseValue()){
                // JOptionPane.showMessageDialog(null,"CheckWidowRaiseHand TOS" );
                 this.playerDecision.playerIntention=1;
             }else{
                 this.playerDecision.playerIntention=12;
             }
              
          }else{
              if(twoOfAKind && !twoOfSameSuit )
          {//if two of same suit
             if(checkWidowTOK()){
                // JOptionPane.showMessageDialog(null,"CheckWidowTOK TOK but no TOS" );
                 this.playerDecision.playerIntention=2;
             }else{
                 if(checkTomakeNewTOK()){
                    // JOptionPane.showMessageDialog(null,"CheckNewWidowTOK TOK but no TOS" );
                     this.playerDecision.playerIntention=2;
                 }else{
                     if(checkWidowRaiseValue()){
                       //  JOptionPane.showMessageDialog(null,"CheckWidowRaiseHand TOK but no TOS" );
                         this.playerDecision.playerIntention=1;
                     }else{
                       //  JOptionPane.showMessageDialog(null,"CheckWidowRandom TOK but no TOS" );
                         makeBestRandomMove();
                     }
                 }
             }
              //we check the widow's deck to see if we can make any improvement
              //if we couldn't then we check if we can assume we can win
              //if we could make assumption, then we fold , if not we block 
          }else{
              if(twoOfAKind && twoOfSameSuit)
              {
               //if he had two of a kind and two of the same suit 
                  if(checkWidowTOK()){
                    //  JOptionPane.showMessageDialog(null,"CheckWidowTOK TOK but TOS" );
                 this.playerDecision.playerIntention=2;
             }else{
                 if(checkWidowRaiseValue()){
                     //JOptionPane.showMessageDialog(null,"CheckWidowRaiseHand TOK but TOS" );
                     this.playerDecision.playerIntention=2;
                 }else{
                     if(checkTomakeNewTOK()){
                        // JOptionPane.showMessageDialog(null,"CheckNewWidowTOK TOK but TOS" );
                         this.playerDecision.playerIntention=1;
                     }else{
                       // JOptionPane.showMessageDialog(null,"CheckWidowRandom TOK but TOS" );
                         makeBestRandomMove();
                     }
                 }
             }
              }else{
                  if(!twoOfAKind && twoOfSameSuit)
              {
                 //if he only had two of same suit 
                   
                 if(checkWidowRaiseValue()){
                     //JOptionPane.showMessageDialog(null,"CheckWidowRaiseHand noTOK but TOS" );
                     this.playerDecision.playerIntention=2;
                 }else{
                     if(checkTomakeNewTOK()){
                       //  JOptionPane.showMessageDialog(null,"CheckNewWidowTOK noTOK but TOS" );
                         
                         this.playerDecision.playerIntention=1;
                     }else{
                       //  JOptionPane.showMessageDialog(null,"CheckWidowRandom noTOK but TOS" );
                         makeBestRandomMove();
                     }
                 }
             
                  
              }else{
                  //if he didnt have anything
                  makeBestRandomMove();
                  //JOptionPane.showMessageDialog(null,"CheckWidowRandom only Random" );
              }
                  
              }
          }
          }
      }
  }
  
private void removeWidow()
{
   boolean remains=true;
   while(remains)
   {remains=false;
         for(int i=0;i<=knowsCard.size()-1;i++)
    {
        System.out.println(knowsCard.get(i).targetPlayer.name+" "+i+" "+knowsCard.size());
        if(knowsCard.get(i).targetPlayer.name.equals("widow"))
        {
            knowsCard.remove(i);
            System.out.println("removed");
        }
    }
           for(int i=0;i<=knowsCard.size()-1;i++)
    {
        System.out.println(knowsCard.get(i).targetPlayer.name+" "+i+" "+knowsCard.size());
        if(knowsCard.get(i).targetPlayer.name.equals("widow"))
        {
            remains=true;
        }
    }
         
   }
}
  


  
  public boolean checkWidowForTOK()
  {
      if(twoOfSameSuit){
          
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.type.equals(highestCard.type) ){
         System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[2].name+" with "+knowsCard.get(i).targetCard.name+
                          " to make 3 of a kind : "+highestCard.name);
              playerDecision.yourCard=hand[2];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
          }}
          
      }else{
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.type.equals(highestCard.type) ){
         System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[2].name+" with "+knowsCard.get(i).targetCard.name+
                          " to make 3 of a kind : "+highestCard.name);
              playerDecision.yourCard=hand[2];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
          }}
      }
      return  false;
  }
  public boolean checkTomakeNewTOK(){
      
       int counter=0;
       for(int z=0;z<=2;z++)
       {
           switch(z)
           {
               case 0:
               {
                   counter=2;
                   break;
               }
               case 1:
               {counter=2;
                   break;
               }
               case 2:
               {counter=0;
                   break;
               }
           }
           
            for(int i=0; i<=knowsCard.size()-1;i++){
          
          if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.type.equals(hand[z].type) ){
         if(!hand[counter].type.equals(hand[z].type)){
             System.out.println(this.name +" can make a new two of a kind if he swaps "+hand[counter].name+" with "+knowsCard.get(i).targetCard.name+
                          " to make 3 of a kind : "+highestCard.name);
              playerDecision.yourCard=hand[counter];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
         }
                  
          }
          
          
      }
       }
      return  false;
      
  }
  public boolean checkWidowTOK()
{ if(twoOfAKind){
    int swapPosition=0;
        
          
          for(int j=2;j>=0;j--)
              
          {if(hand[j].type.equals(twokind.type)){}else{swapPosition=j;}}
         
    for(int i=0;i<=knowsCard.size()-1;i++)
    {
      if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.type.equals(twokind.type) ){
          System.out.println(this.name +" can raise his value of same type if he swaps "+hand[2].name+" with "+knowsCard.get(i).targetCard.name+
                          " to make 3 of a kind highest card: "+highestCard.name);
           playerDecision.yourCard=hand[swapPosition];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
          return true; 
              
          }  
    }
}
      return false;
}
  
  
  
  public boolean checkWidowRaiseValue()
  {
      
      
      if(twoOfAKind && !twoOfSameSuit)
          {
          //JOptionPane.showMessageDialog(null, twokind.name);
          int swapPosition=0;
          int otherposition1 =0;
          int otherposition2=0;
          
          for(int j=2;j>=0;j--)
              
          {if(hand[j].type.equals(twokind.type)){}else{swapPosition=j;}}
          switch(swapPosition){
              case 0:
              {
                  otherposition2=1;
                  otherposition1=2;
                  break;
              }
               case 1:
              {otherposition2=0;
                  otherposition1=2;
                  break;
              }
               case 2:
              {otherposition2=1;
                  otherposition1=0;
                  break;
              }
          }
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          if(knowsCard.get(i).targetPlayer.name.equals("widow") ){
              if( knowsCard.get(i).targetCard.suit.equals(hand[otherposition1].suit) || knowsCard.get(i).targetCard.suit.equals(hand[otherposition2].suit)){
                  playerDecision.yourCard=hand[swapPosition];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
              }
              
          }
          }
          }else{
      
      for(int i=0; i<=knowsCard.size()-1;i++){
          
          if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.suit.equals(highestSuit)){
         if(threeOfsameSuit){
             for(int j=2;j>=0;j--)
              
          {
              if(hand[j].value<knowsCard.get(i).targetCard.value)
              {
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[j].name+" with "+knowsCard.get(i).targetCard.name+
                          " and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[j];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
          }
         }else{
            for(int j=2;j>=0;j--)
              
          {System.out.println(hand[j].name+" card is being checked");
              if(!hand[j].suit.equals(highestCard.suit))
              {
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[j].name+" with "+knowsCard.get(i).targetCard.name+
                          " and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[j];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
          } 
         }
           
          }
          
           
      }}
      return false;
  }
  
  public boolean makeBestRandomMove()
  {
     
      //check to make new TOK
      
      for(int j=0;j<=2;j++)
    {
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          
        
              if(knowsCard.get(i).targetPlayer.name.equals("widow") && hand[j].type.equals(knowsCard.get(i).targetCard.type))
              {
                  int counter=0;
                  switch(j)
           {
               case 0:
               {
                   counter=2;
                   break;
               }
               case 1:
               {counter=2;
                   break;
               }
               case 2:
               {counter=0;
                   break;
               }
           }
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[counter].name+" with "+knowsCard.get(i).targetCard.name+
                          " To be the best random move and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[counter];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
 
      }
    }
      
      //check to get same suit
      
      for(int j=0;j<=2;j++)
    {
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          
        
              if(knowsCard.get(i).targetPlayer.name.equals("widow") && hand[j].suit.equals(knowsCard.get(i).targetCard.suit))
              {
                  int counter=0;
                  switch(j)
           {
               case 0:
               {
                   counter=2;
                   break;
               }
               case 1:
               {counter=2;
                   break;
               }
               case 2:
               {counter=0;
                   break;
               }
           }
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[counter].name+" with "+knowsCard.get(i).targetCard.name+
                          " To be the best random move and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[counter];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
 
      }
    }
      
      
      System.out.println("Random Move");
   
    if(CanIblock()){
        return true;
    }else{
        for(int j=0;j<=2;j++)
    {
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          
        
              if(knowsCard.get(i).targetPlayer.name.equals("widow") && hand[j].value<knowsCard.get(i).targetCard.value)
              {
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[j].name+" with "+knowsCard.get(i).targetCard.name+
                          " To be the best random move and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[j];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
 
      }
    }
    }
      return false;
  }
  
  public boolean CanIblock(){
       for(int j=0;j<=otherIntention.size()-1;j++)
    {
          for(int i=0; i<=knowsCard.size()-1;i++){
          
          
        
              if(knowsCard.get(i).targetPlayer.name.equals("widow") && knowsCard.get(i).targetCard.suit.equals(otherIntention.get(j).targetHighsuit))
              {
                  JOptionPane.showConfirmDialog(null, "Blocking player "+otherIntention.get(j).targetPlayer);
                  System.out.println(this.name +" can raise his value of same suit if he swaps "+hand[0].name+" with "+knowsCard.get(i).targetCard.name+
                          " To be the best random move and the highest suit is : "+highestSuit);
                  playerDecision.yourCard=hand[0];
                  playerDecision.widowCard=knowsCard.get(i).targetCard;
                  return true;
              }
 
      }
    }
      
      return false;
  }

  public void updateKnowledgeplayerhighsuite(player target, String suit)
  {
      for (int i=0; i<=knowsPlayerhighSuit.size()-1;i++){
          if(target.name.equals(knowsPlayerhighSuit.get(i).targetPlayer.name))
          {
              knowsPlayerhighSuit.remove(i);
          }
      }
      knowsPlayerhighSuit.add(new playerHighSuitKnowledge(target, suit));
  }
  
  
  
  
  private double CalculateOpponent(ArrayList<card> givenCards){
      
      return 0.0;
  }
  
  
}
