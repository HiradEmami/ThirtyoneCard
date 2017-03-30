
package mas_thirtyone;


public class OtherInetntion {
public int[] swappedSuit;
public player targetPlayer;
public String targetHighsuit;
public int[] swappedtype ={0,0,0,0,0,0,0,0,0};
public String TOK;

    public OtherInetntion(player argPlayer) {
        this.targetPlayer=argPlayer;
        swappedSuit=new int[5];
        swappedSuit[0]=0; //spade
        swappedSuit[1]=0; //dimond
        swappedSuit[2]=0; //heart
        swappedSuit[3]=0; //clubs
        swappedSuit[4]=0; //idontknow what suit it is
        TOK=null;
        
    }

    private void setTargetHighsuit()
    {
        int temp=swappedSuit[4];
        int position=4;
        boolean swap= true;
        while (swap){
            swap=false;
        for(int i=0;i<=swappedSuit.length-2;i++)
        {
            if(temp<swappedSuit[i])
            {
                temp=swappedSuit[i];
                position=i;
                swap=true;
                
            }
        }
        }
        
        switch(position){
            case 0:{
                targetHighsuit="spade";
                break;
            }
            case 1:{
                targetHighsuit="dimond";
                break;
            }
            case 2:{
                targetHighsuit="heart";
                break;
            }
            case 3:{
                targetHighsuit="club";
                break;
            }
            
            default:{
                targetHighsuit="Not found";
                break;
            }
        }
    }
    public void updateSuitKnowledge(String argSuit)
    {
        switch(argSuit){
            case "spade":{
                swappedSuit[0]++;
                break;
            }
            case "dimond":{
                swappedSuit[1]++;
                break;
            }
            case "heart":{
                swappedSuit[2]++;
                break;
            }
            case "club":{
               swappedSuit[3]++;
                break;
            }
        } 
    }
    
  public String setTOK(){
      for(int i=0;i<swappedtype.length-2;i++)
      {
          if(swappedtype[i]>=2){
              switch(i)
              {
                  case 0:{TOK="7"; break;}
                  case 1:{TOK="8"; break;}
                  case 2:{TOK="9"; break;}
                  case 3:{TOK="10"; break;}
                  case 4:{TOK="jack"; break;}
                  case 5:{TOK="queen"; break;}
                  case 6:{TOK="king"; break;}
                  case 7:{TOK="ace"; break;}
                  
                  
              }
          }
      }
      
      return TOK; 
  }
    
public void setType(card pickedCard, card DroppedCard)
{
    String [] tempArray = pickedCard.name.split("");
    System.out.print(tempArray[1]);
    if((DroppedCard.value>pickedCard.value) && (DroppedCard.suit.equals(pickedCard.suit)))
    {
         switch  (tempArray[1])
    {
        case "7": {swappedtype[0]=swappedtype[0]+2; break;}
        case "8": {swappedtype[1]=swappedtype[1]+2; break;}
        case "9": {swappedtype[2]=swappedtype[2]+2; break;}
        case "1": {swappedtype[3]=swappedtype[3]+2; break;}
        case "q": {swappedtype[4]=swappedtype[4]+2; break;}
        case "k": {swappedtype[5]=swappedtype[5]+2; break;}
        case "j": {swappedtype[6]=swappedtype[6]+2; break;}
        case "a": {swappedtype[7]=swappedtype[7]+2; break;}
        default: {swappedtype[8]=swappedtype[8]+2;break;}
    }
   
    }else{
         switch  (tempArray[1])
    {
        case "7": {swappedtype[0]++;; break;}
        case "8": {swappedtype[1]++;; break;}
        case "9": {swappedtype[2]++;; break;}
        case "1": {swappedtype[3]++;; break;}
        case "q": {swappedtype[4]++;; break;}
        case "k": {swappedtype[5]++;; break;}
        case "j": {swappedtype[6]++;; break;}
        case "a": {swappedtype[7]++;; break;}
        default: {swappedtype[8]++;;break;}
    }
   
    }   
   
    
     String [] argtempArray = pickedCard.name.split("");
    System.out.print(argtempArray[1]);
 
    switch  (argtempArray[1])
    {
        case "7": {swappedtype[0]--; break;}
        case "8": {swappedtype[1]--; break;}
        case "9": {swappedtype[2]--; break;}
        case "1": {swappedtype[3]--; break;}
        case "q": {swappedtype[4]--; break;}
        case "k": {swappedtype[5]--; break;}
        case "j": {swappedtype[6]--; break;}
        case "a": {swappedtype[7]--; break;}
        default: {swappedtype[8]--;break;}
    }
    
 
}

}
