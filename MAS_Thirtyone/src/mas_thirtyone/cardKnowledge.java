
package mas_thirtyone;


public class cardKnowledge {
    public player targetPlayer;
    public card targetCard;
    public String type; //can be self or others or widow

    public cardKnowledge(player targetPlayer, card targetCard) {
        this.targetPlayer = targetPlayer;
        this.targetCard = targetCard;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
