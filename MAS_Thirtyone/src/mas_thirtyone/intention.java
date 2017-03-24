/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_thirtyone;

/**
 *
 * @author Hirad Gorgoroth
 */
public class intention {
    public card yourCard;
    public card widowCard;
    public String [] possibleIntentions;
    public int playerIntention;
    public String type; //self , others

    public intention(card yourCard, card widowCard) {
        this.yourCard = yourCard;
        this.widowCard = widowCard;
    }

    public intention(String argType) {
        this.type=argType;
    }
    

    public void setPossibleIntentions() {
        this.possibleIntentions=new String[6];
        possibleIntentions[0]="Fold";
        possibleIntentions[1]="Raise your hand value from the same suit ";
        possibleIntentions[2]="Raise your hand value from Three of a kind ";
        possibleIntentions[3]="Block a player from Raising same suit ";
        possibleIntentions[4]="Block a player from Three of a kind ";
        possibleIntentions[5]="Make a random move";
                
    }
    
    
}
