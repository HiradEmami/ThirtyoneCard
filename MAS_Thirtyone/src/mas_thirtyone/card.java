/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mas_thirtyone;


public class card {
    public String name;
    public int value;
    public String suit;
    public String type; // 7, 8 ,9 10, queen, king, jack, ace

    public card(String name, int value, String suit) {
        this.name = name;
        this.value = value;
        this.suit = suit;
        setType();
    }
    

private void setType()
{
    String [] tempArray = name.split("");
    System.out.print(tempArray[1]);
    switch  (tempArray[1])
    {
        case "7": {this.type="7"; break;}
        case "8": {this.type="8"; break;}
        case "9": {this.type="9"; break;}
        case "1": {this.type="10"; break;}
        case "q": {this.type="queen"; break;}
        case "k": {this.type="king"; break;}
        case "j": {this.type="jack"; break;}
        case "a": {this.type="ace"; break;}
        default: {this.type=null;break;}
    }
}

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
