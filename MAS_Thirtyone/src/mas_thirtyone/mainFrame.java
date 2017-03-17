
package mas_thirtyone;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;


public class mainFrame extends javax.swing.JFrame {
private ArrayList <card> cardPool; //array list for all cards
private ArrayList <player> playerPool;
private int numberofPlayer;
private int playerTurn=0;
   
    public mainFrame() {
        initComponents();
        pageSetup(); //page setup function
        
    }
    
    public void testWithRandomPlayer(){
        player p = new player( "P1", cardPool.get(2), cardPool.get(6), cardPool.get(15));
        player d = new player("P2", cardPool.get(3), cardPool.get(11), cardPool.get(6));
        
        System.out.println("Testing player p1 with these cards: "+p.hand[0].name+" , "+ p.hand[1].name+" , "+p.hand[2].name);
        System.out.println("Testing player p2 with these cards: "+d.hand[0].name+" , "+ d.hand[1].name+" , "+d.hand[2].name);
        
        System.out.println("Testing for player :"+p.name);
        System.out.println("First card: "+p.hand[0].name+" /type:"+p.hand[0].type+"/value: "+p.hand[0].value+" /suit: "+p.hand[0].suit+" \n"
                + "Second card: "+p.hand[1].name+" /type: "+p.hand[1].type+" /value: "+p.hand[1].value+" /suit: "+p.hand[1].suit+" \n"
                        + "Third card: "+p.hand[2].name+" /type:"+p.hand[2].type+"/value: "+p.hand[2].value+" /suit: "+p.hand[2].suit+" \n"
                                + "Does he have three of same suit? "+p.threeOfsameSuit+ " \n"
                                        + "Does he have only two of the same suit? "+p.twoOfSameSuit+"\n"
                                                + "What is his highest suit? "+p.highestSuit+"\n"
                                                         + "What is his highest card? "+p.highestCard.name+"\n"
                                                        + "Does he have three of a kind? "+p.threeOfAKind+"\n"
                                                        + "Does he have two of a kind? "+p.twoOfAKind+"\n"
                                                                + "Does p1 Knows he has "+p.hand[0].name+"? "+ p.doesKnowCard(p, p.hand[0])+"\n"
                                                                        + "Does p1 Knows he has "+cardPool.get(19).name+"? "+ p.doesKnowCard(p, cardPool.get(19))+""
                                                                                + "");
       card temp=p.hand[0];
        p.swapCard(p.hand[0],cardPool.get(19));
        System.out.println("Does p1 Knows he has "+temp.name+"? "+ p.doesKnowCard(p, temp)+"\n"
                                                                        + "Does p1 Knows he has "+cardPool.get(19).name+"? "+ p.doesKnowCard(p, cardPool.get(19))+""
                                                                                + "");
    }
   
    
    private void pageSetup()
    {
        this.cardPool=new ArrayList<card>(); //initi array list for all cards
        setCardPool(); //setting all the cards
        printPlayableCards();
        numberofPlayer=0;
        this.playerPool= new ArrayList<player>();
        
        System.out.println("Page setup was successful");
        Player_Panes.setVisible(false);
        viewPlayerComboBox.setVisible(false);
    }
    
    private void setupMatch(){
        
        //get number of players
        numberofPlayer=playerCombobox.getSelectedIndex()+1;
         //update combobox of viewing player
        viewPlayerComboBox.removeAllItems(); //removing all the boxes 
        viewPlayerComboBox.setVisible(true);
        viewPlayerComboBox.addItem("Widow");
        //create players
        for(int i=0; i<=numberofPlayer;i++)
        {   //creating random player
            card temp1= getArandomCard();
            
            card temp2=getArandomCard();
            
            card temp3=getArandomCard();
            
            playerPool.add(new player("p"+(i+1), temp1, temp2, temp3));
            playerPool.get(i).setPlayerNumber(i);
            viewPlayerComboBox.addItem(playerPool.get(i).name);
        }
         card temp1= getArandomCard();
            card temp2=getArandomCard();
            card temp3=getArandomCard();
         playerPool.add(new player("widow", temp1, temp2,temp3));
         playerPool.get(playerPool.size()-1).setPlayerNumber(100);
        
        Player_Panes.setVisible(true);
        for(int i=0;i<=numberofPlayer+1;i++)
        {
            setPlayerPanel(playerPool.get(i));
        }
    }
    
    private void setPlayerPanel(player p)
    { int playernumber =p.playerNumber;
        switch (playernumber)
        {
            case 0:{
                jplayername.setText("Player :"+p.name);
                jTAcards.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 1:{ jplayername1.setText("Player :"+p.name);
                jTAcards1.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 2:{ jplayername2.setText("Player :"+p.name);
                jTAcards2.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 3:{jplayername3.setText("Player :"+p.name);
                jTAcards3.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 4:{ jplayername4.setText("Player :"+p.name);
                jTAcards4.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 5:{ jplayername5.setText("Player :"+p.name);
                jTAcards5.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 6:{jplayername6.setText("Player :"+p.name);
                jTAcards6.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 7:{jplayername7.setText("Player :"+p.name);
                jTAcards7.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 8:{jplayername8.setText("Player :"+p.name);
                jTAcards8.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
            case 100:{jplayername9.setText("Player :"+p.name);
                jTAcards9.setText("Player Cards: "+p.hand[0].name+" , "+p.hand[1].name+" , "+p.hand[2].name);
                break;}
        }
    }
    
    private card getArandomCard()
    {int randNumber= randInt(0, cardPool.size()-1);
        card temp = cardPool.get(randNumber);
        cardPool.remove(randNumber);
        System.out.println(temp.name+" "+cardPool.get(randNumber).name);
        
        return temp;
    }
    
    private void setCardPool()
    {
        //adding cards from 7 to 10 
        for (int i=7; i<=10;i++)
    {
        cardPool.add(new card("s"+i, i,"spade")); //spade suit
        cardPool.add(new card("d"+i, i, "dimond")); //dimond suit
        cardPool.add(new card("h"+i, i, "heart")); //heart suit
        cardPool.add(new card("c"+i, i, "club")); //club suit 
        
    }
     cardPool.add(new card("s"+"k", 10,"spade"));cardPool.add(new card("s"+"q", 10,"spade"));cardPool.add(new card("s"+"j", 10,"spade"));cardPool.add(new card("s"+"a", 11,"spade"));
     cardPool.add(new card("d"+"k", 10, "dimond"));cardPool.add(new card("d"+"q", 10, "dimond"));cardPool.add(new card("d"+"j", 10, "dimond"));cardPool.add(new card("d"+"a", 11, "dimond"));
     cardPool.add(new card("h"+"k", 10, "heart"));cardPool.add(new card("h"+"q", 10, "heart"));cardPool.add(new card("h"+"j", 10, "heart"));cardPool.add(new card("h"+"a", 11, "heart"));
     cardPool.add(new card("c"+"k", 10, "club"));cardPool.add(new card("c"+"q", 10, "club"));cardPool.add(new card("c"+"j", 10, "club"));cardPool.add(new card("c"+"a", 11, "club"));
    
     System.out.println("All cards created Successfully");
    }
    
    private void printPlayableCards()
    {
          jta_playablecards.setText(jta_playablecards.getText()+"Spade cards: ");
        for (int i=0;i<=cardPool.size()-1;i++)
        {
         if(cardPool.get(i).suit.equals("spade"))
         {
               jta_playablecards.setText(jta_playablecards.getText()+" , "+cardPool.get(i).name);
         }
        }
        jta_playablecards.setText(jta_playablecards.getText()+"\n");
         jta_playablecards.setText(jta_playablecards.getText()+"Dimond cards: ");
        for (int i=0;i<=cardPool.size()-1;i++)
        {
         if(cardPool.get(i).suit.equals("dimond"))
         {
               jta_playablecards.setText(jta_playablecards.getText()+" , "+cardPool.get(i).name);
         }
        }
        jta_playablecards.setText(jta_playablecards.getText()+"\n");
         jta_playablecards.setText(jta_playablecards.getText()+"Heart cards: ");
        for (int i=0;i<=cardPool.size()-1;i++)
        {
         if(cardPool.get(i).suit.equals("heart"))
         {
               jta_playablecards.setText(jta_playablecards.getText()+" , "+cardPool.get(i).name);
         }
        }
        jta_playablecards.setText(jta_playablecards.getText()+"\n");
         jta_playablecards.setText(jta_playablecards.getText()+"Club cards: ");
        for (int i=0;i<=cardPool.size()-1;i++)
        {
         if(cardPool.get(i).suit.equals("club"))
         {
               jta_playablecards.setText(jta_playablecards.getText()+" , "+cardPool.get(i).name);
         }
        }
        
        System.out.println("All cards were printed in text area successfully");
    }
    
    private int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        setupPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_playablecards = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        playerCombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Player_Panes = new javax.swing.JPanel();
        panePlayer10 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTAcards9 = new javax.swing.JTextArea();
        jplayername9 = new javax.swing.JLabel();
        panePlayer1 = new javax.swing.JPanel();
        jplayername = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAcards = new javax.swing.JTextArea();
        panePlayer2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAcards1 = new javax.swing.JTextArea();
        jplayername1 = new javax.swing.JLabel();
        panePlayer3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAcards2 = new javax.swing.JTextArea();
        jplayername2 = new javax.swing.JLabel();
        panePlayer4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTAcards3 = new javax.swing.JTextArea();
        jplayername3 = new javax.swing.JLabel();
        panePlayer5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTAcards4 = new javax.swing.JTextArea();
        jplayername4 = new javax.swing.JLabel();
        panePlayer6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTAcards5 = new javax.swing.JTextArea();
        jplayername5 = new javax.swing.JLabel();
        panePlayer7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTAcards6 = new javax.swing.JTextArea();
        jplayername6 = new javax.swing.JLabel();
        panePlayer8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTAcards7 = new javax.swing.JTextArea();
        jplayername7 = new javax.swing.JLabel();
        panePlayer9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTAcards8 = new javax.swing.JTextArea();
        jplayername8 = new javax.swing.JLabel();
        viewPlayerComboBox = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        jPanel1.setLayout(new java.awt.CardLayout());

        jta_playablecards.setEditable(false);
        jta_playablecards.setColumns(20);
        jta_playablecards.setRows(5);
        jScrollPane1.setViewportView(jta_playablecards);

        jButton1.setText("Test with a Random Player ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("All the cards in cardpool");

        playerCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 players", "3 players", "4 players", "5 players", "6 players", "7 players", "8 players", "9 players" }));

        jLabel2.setText("Select the number of players:");

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Player_Panes.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.lightGray));
        Player_Panes.setLayout(new java.awt.CardLayout());

        jTAcards9.setColumns(20);
        jTAcards9.setRows(5);
        jScrollPane11.setViewportView(jTAcards9);

        jplayername9.setText("jLabel3");

        javax.swing.GroupLayout panePlayer10Layout = new javax.swing.GroupLayout(panePlayer10);
        panePlayer10.setLayout(panePlayer10Layout);
        panePlayer10Layout.setHorizontalGroup(
            panePlayer10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer10Layout.setVerticalGroup(
            panePlayer10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer10, "card10");

        jplayername.setText("jLabel3");

        jTAcards.setColumns(20);
        jTAcards.setRows(5);
        jScrollPane2.setViewportView(jTAcards);

        javax.swing.GroupLayout panePlayer1Layout = new javax.swing.GroupLayout(panePlayer1);
        panePlayer1.setLayout(panePlayer1Layout);
        panePlayer1Layout.setHorizontalGroup(
            panePlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer1Layout.setVerticalGroup(
            panePlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer1, "card9");

        jTAcards1.setColumns(20);
        jTAcards1.setRows(5);
        jScrollPane3.setViewportView(jTAcards1);

        jplayername1.setText("jLabel3");

        javax.swing.GroupLayout panePlayer2Layout = new javax.swing.GroupLayout(panePlayer2);
        panePlayer2.setLayout(panePlayer2Layout);
        panePlayer2Layout.setHorizontalGroup(
            panePlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer2Layout.setVerticalGroup(
            panePlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer2, "card8");

        jTAcards2.setColumns(20);
        jTAcards2.setRows(5);
        jScrollPane4.setViewportView(jTAcards2);

        jplayername2.setText("jLabel3");

        javax.swing.GroupLayout panePlayer3Layout = new javax.swing.GroupLayout(panePlayer3);
        panePlayer3.setLayout(panePlayer3Layout);
        panePlayer3Layout.setHorizontalGroup(
            panePlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer3Layout.setVerticalGroup(
            panePlayer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer3, "card7");

        jTAcards3.setColumns(20);
        jTAcards3.setRows(5);
        jScrollPane5.setViewportView(jTAcards3);

        jplayername3.setText("jLabel3");

        javax.swing.GroupLayout panePlayer4Layout = new javax.swing.GroupLayout(panePlayer4);
        panePlayer4.setLayout(panePlayer4Layout);
        panePlayer4Layout.setHorizontalGroup(
            panePlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer4Layout.setVerticalGroup(
            panePlayer4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer4, "card6");

        jTAcards4.setColumns(20);
        jTAcards4.setRows(5);
        jScrollPane6.setViewportView(jTAcards4);

        jplayername4.setText("jLabel3");

        javax.swing.GroupLayout panePlayer5Layout = new javax.swing.GroupLayout(panePlayer5);
        panePlayer5.setLayout(panePlayer5Layout);
        panePlayer5Layout.setHorizontalGroup(
            panePlayer5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer5Layout.setVerticalGroup(
            panePlayer5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer5, "card5");

        jTAcards5.setColumns(20);
        jTAcards5.setRows(5);
        jScrollPane7.setViewportView(jTAcards5);

        jplayername5.setText("jLabel3");

        javax.swing.GroupLayout panePlayer6Layout = new javax.swing.GroupLayout(panePlayer6);
        panePlayer6.setLayout(panePlayer6Layout);
        panePlayer6Layout.setHorizontalGroup(
            panePlayer6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer6Layout.setVerticalGroup(
            panePlayer6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer6, "card4");

        jTAcards6.setColumns(20);
        jTAcards6.setRows(5);
        jScrollPane8.setViewportView(jTAcards6);

        jplayername6.setText("jLabel3");

        javax.swing.GroupLayout panePlayer7Layout = new javax.swing.GroupLayout(panePlayer7);
        panePlayer7.setLayout(panePlayer7Layout);
        panePlayer7Layout.setHorizontalGroup(
            panePlayer7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer7Layout.setVerticalGroup(
            panePlayer7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer7, "card3");

        jTAcards7.setColumns(20);
        jTAcards7.setRows(5);
        jScrollPane9.setViewportView(jTAcards7);

        jplayername7.setText("jLabel3");

        javax.swing.GroupLayout panePlayer8Layout = new javax.swing.GroupLayout(panePlayer8);
        panePlayer8.setLayout(panePlayer8Layout);
        panePlayer8Layout.setHorizontalGroup(
            panePlayer8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer8Layout.setVerticalGroup(
            panePlayer8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer8, "card2");

        jTAcards8.setColumns(20);
        jTAcards8.setRows(5);
        jScrollPane10.setViewportView(jTAcards8);

        jplayername8.setText("jLabel3");

        javax.swing.GroupLayout panePlayer9Layout = new javax.swing.GroupLayout(panePlayer9);
        panePlayer9.setLayout(panePlayer9Layout);
        panePlayer9Layout.setHorizontalGroup(
            panePlayer9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jplayername8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panePlayer9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );
        panePlayer9Layout.setVerticalGroup(
            panePlayer9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panePlayer9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplayername8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Player_Panes.add(panePlayer9, "card10");

        viewPlayerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPlayerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout setupPaneLayout = new javax.swing.GroupLayout(setupPane);
        setupPane.setLayout(setupPaneLayout);
        setupPaneLayout.setHorizontalGroup(
            setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Player_Panes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(viewPlayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        setupPaneLayout.setVerticalGroup(
            setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(playerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(65, 65, 65)
                .addComponent(viewPlayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Player_Panes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setupPaneLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setupPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        jPanel1.add(setupPane, "card6");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, "card5");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, "card4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, "card3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       testWithRandomPlayer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     setupMatch();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void viewPlayerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPlayerComboBoxActionPerformed
     int temp=viewPlayerComboBox.getSelectedIndex();
     switch (temp)
     {
         case 0:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(true);
 
             break;
         }
         case 1:
         {panePlayer1.setVisible(true);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 2:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(true);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 3:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(true);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 4:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(true);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 5:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(true);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 6:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(true);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 7:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(true);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 8:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(true);
         panePlayer9.setVisible(false);
         panePlayer10.setVisible(false);
             break;
         }
         case 9:
         {panePlayer1.setVisible(false);
         panePlayer2.setVisible(false);
         panePlayer3.setVisible(false);
         panePlayer4.setVisible(false);
         panePlayer5.setVisible(false);
         panePlayer6.setVisible(false);
         panePlayer7.setVisible(false);
         panePlayer8.setVisible(false);
         panePlayer9.setVisible(true);
         panePlayer10.setVisible(false);
             break;
         }
     }
    }//GEN-LAST:event_viewPlayerComboBoxActionPerformed
    // Variables declaration - do not modify                     
    // End of variables declaration   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Player_Panes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTAcards;
    private javax.swing.JTextArea jTAcards1;
    private javax.swing.JTextArea jTAcards2;
    private javax.swing.JTextArea jTAcards3;
    private javax.swing.JTextArea jTAcards4;
    private javax.swing.JTextArea jTAcards5;
    private javax.swing.JTextArea jTAcards6;
    private javax.swing.JTextArea jTAcards7;
    private javax.swing.JTextArea jTAcards8;
    private javax.swing.JTextArea jTAcards9;
    private javax.swing.JLabel jplayername;
    private javax.swing.JLabel jplayername1;
    private javax.swing.JLabel jplayername2;
    private javax.swing.JLabel jplayername3;
    private javax.swing.JLabel jplayername4;
    private javax.swing.JLabel jplayername5;
    private javax.swing.JLabel jplayername6;
    private javax.swing.JLabel jplayername7;
    private javax.swing.JLabel jplayername8;
    private javax.swing.JLabel jplayername9;
    private javax.swing.JTextArea jta_playablecards;
    private javax.swing.JPanel panePlayer1;
    private javax.swing.JPanel panePlayer10;
    private javax.swing.JPanel panePlayer2;
    private javax.swing.JPanel panePlayer3;
    private javax.swing.JPanel panePlayer4;
    private javax.swing.JPanel panePlayer5;
    private javax.swing.JPanel panePlayer6;
    private javax.swing.JPanel panePlayer7;
    private javax.swing.JPanel panePlayer8;
    private javax.swing.JPanel panePlayer9;
    private javax.swing.JComboBox<String> playerCombobox;
    private javax.swing.JPanel setupPane;
    private javax.swing.JComboBox<String> viewPlayerComboBox;
    // End of variables declaration//GEN-END:variables
}
