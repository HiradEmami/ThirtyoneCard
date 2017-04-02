
package mas_thirtyone;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class mainFrame extends javax.swing.JFrame {
private ArrayList <card> cardPool; //array list for all cards
private ArrayList <player> playerPool;
private int numberofPlayer;
private int playerTurn=0;
private boolean gameInProgress=false;
   
    public mainFrame() {
        initComponents();
        pageSetup(); //page setup function
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("spades-poker-icon-37083.png")));
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
     
        viewPlayerComboBox.setVisible(true);
    }
    
    private void setupMatch(){
        playerTurn=0;
        
        //get number of players
        numberofPlayer=playerCombobox.getSelectedIndex()+1;
         //update combobox of viewing player
        viewPlayerComboBox.removeAllItems(); //removing all the boxes 
        viewPlayerComboBox.setVisible(true);
        gameLog_TA.setText(gameLog_TA.getText()+"=================\n"+"Selected Number of players : "+numberofPlayer);
        
        //create players
        for(int i=0; i<=numberofPlayer;i++)
        {   //creating random player
//            card temp1= getArandomCard();
//            
//            card temp2= getArandomCard();
//            
//            card temp3= getArandomCard();
            
            playerPool.add(new player("p"+(i+1), getArandomCard(), getArandomCard(), getArandomCard()));
            playerPool.get(i).setPlayerNumber(i);
            gameLog_TA.setText(gameLog_TA.getText()+"\nPlayer "+playerPool.get(i).name+" is created");
            gameLog_TA.setText(gameLog_TA.getText()+"\nCards after sorting "+playerPool.get(i).hand[0].name+" , "+playerPool.get(i).hand[1].name+" , "+playerPool.get(i).hand[2].name+" , "+"\n");
            viewPlayerComboBox.addItem(playerPool.get(i).name);
        }
        viewPlayerComboBox.addItem("Widow");
//         card temp1= getArandomCard();
//            card temp2=getArandomCard();
//            card temp3=getArandomCard();
         playerPool.add(new player("widow", getArandomCard(), getArandomCard(),getArandomCard()));
         playerPool.get(playerPool.size()-1).setPlayerNumber(100);
         
        for(int z=0;z<=playerPool.size()-1;z++)
        {
            playerPool.get(z).updateWidowKnowledge(playerPool.get(playerPool.size()-1));
            for (int k=0;k<=playerPool.size()-2;k++)
            {
                playerPool.get(z).initiateOtherIntention(playerPool.get(k));
            }
        }
        
        
jlb_playerTurn.setText(playerPool.get(playerTurn).name);
    }
    
   
    
    private card getArandomCard()
    {int randNumber= randInt(0, cardPool.size()-1);
        card temp = cardPool.get(randNumber);
        cardPool.remove(randNumber);
       
        
        return temp;
    }
    
  
    
    private void setCardPool()
    {
        //adding cards from 7 to 10 
        for (int i=7; i<=10;i++)
    {
        cardPool.add(new card("s"+i, i,"spade")); //spade suit
        cardPool.add(new card("d"+i, i, "diamond")); //diamond suit
        cardPool.add(new card("h"+i, i, "heart")); //heart suit
        cardPool.add(new card("c"+i, i, "club")); //club suit 
        
    }
     cardPool.add(new card("s"+"k", 10,"spade"));cardPool.add(new card("s"+"q", 10,"spade"));cardPool.add(new card("s"+"j", 10,"spade"));cardPool.add(new card("s"+"a", 11,"spade"));
     cardPool.add(new card("d"+"k", 10, "diamond"));cardPool.add(new card("d"+"q", 10, "diamond"));cardPool.add(new card("d"+"j", 10, "diamond"));cardPool.add(new card("d"+"a", 11, "diamond"));
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
         jta_playablecards.setText(jta_playablecards.getText()+"diamond cards: ");
        for (int i=0;i<=cardPool.size()-1;i++)
        {
         if(cardPool.get(i).suit.equals("diamond"))
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
        jLabel_CardPool = new javax.swing.JLabel();
        playerCombobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        viewPlayerComboBox = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        answer = new javax.swing.JTextArea();
        showButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gameLog_TA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Knowledge = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlb_playerTurn = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Other_Intention = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray));
        jPanel1.setLayout(new java.awt.CardLayout());

        jta_playablecards.setEditable(false);
        jta_playablecards.setColumns(20);
        jta_playablecards.setRows(5);
        jScrollPane1.setViewportView(jta_playablecards);

        jLabel_CardPool.setText("All the cards in cardpool");

        playerCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 players", "3 players", "4 players", "5 players", "6 players", "7 players" }));

        jLabel2.setText("Select the number of players:");

        startButton.setText("Start ");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        viewPlayerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPlayerComboBoxActionPerformed(evt);
            }
        });

        answer.setColumns(20);
        answer.setRows(5);
        jScrollPane12.setViewportView(answer);

        showButton.setText("show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Next Turn");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        gameLog_TA.setColumns(20);
        gameLog_TA.setRows(5);
        jScrollPane2.setViewportView(gameLog_TA);

        Knowledge.setColumns(20);
        Knowledge.setRows(5);
        jScrollPane3.setViewportView(Knowledge);

        jLabel1.setText("Game Log:");

        jLabel3.setText("Select a Player: ");

        jLabel4.setText("Player knowledge");

        jLabel5.setText("Next Turn:");

        jlb_playerTurn.setText("Not Started");

        jButton2.setText("Specific Move");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Other_Intention.setColumns(20);
        Other_Intention.setRows(5);
        jScrollPane4.setViewportView(Other_Intention);

        jLabel6.setText("Other's intention");

        javax.swing.GroupLayout setupPaneLayout = new javax.swing.GroupLayout(setupPane);
        setupPane.setLayout(setupPaneLayout);
        setupPaneLayout.setHorizontalGroup(
            setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addGap(306, 318, Short.MAX_VALUE)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(startButton))
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewPlayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showButton))))
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setupPaneLayout.createSequentialGroup()
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setupPaneLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)
                                .addComponent(jlb_playerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58))
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setupPaneLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_CardPool)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4)
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        setupPaneLayout.setVerticalGroup(
            setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupPaneLayout.createSequentialGroup()
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(playerCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startButton)))
                    .addGroup(setupPaneLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jlb_playerTurn))
                        .addGap(11, 11, 11)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(viewPlayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showButton)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CardPool)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(setupPane, "card6");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, "card5");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, "card4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, "card3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, "card2");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setText("Restart");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("GitHub");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Website");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setText("test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Quit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
     if(!gameInProgress){
         gameLog_TA.setText(gameLog_TA.getText()+"=================\n"+"Starting a New match"+"\n=================\n");
         setupMatch(); 
         gameInProgress=true;
         jLabel_CardPool.setText("Player's Hands");
         jta_playablecards.setText("");
         for(int i=0;i<=playerPool.size()-1;i++)
         {
             jta_playablecards.setText(jta_playablecards.getText()+playerPool.get(i).name+" has :"+
                     playerPool.get(i).hand[0].name+" , "+playerPool.get(i).hand[1].name+" , "+playerPool.get(i).hand[2].name+"\n");
         }
     }else{
         JOptionPane.showMessageDialog(null, "The game Still in Progress!\nPlease Click  the restart button. ");
         
     }
    }//GEN-LAST:event_startButtonActionPerformed

    private void viewPlayerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPlayerComboBoxActionPerformed
    //showPan();
    
    }//GEN-LAST:event_viewPlayerComboBoxActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
       
        try {
            if(gameInProgress){
                player p = playerPool.get(viewPlayerComboBox.getSelectedIndex());
      String b =("Testing for player :"+p.name);
        String a =("First card: "+p.hand[0].name+" /type:"+p.hand[0].type+"/value: "+p.hand[0].value+" /suit: "+p.hand[0].suit+" \n"
                + "Second card: "+p.hand[1].name+" /type: "+p.hand[1].type+" /value: "+p.hand[1].value+" /suit: "+p.hand[1].suit+" \n"
                        + "Third card: "+p.hand[2].name+" /type:"+p.hand[2].type+"/value: "+p.hand[2].value+" /suit: "+p.hand[2].suit+" \n"
                                + "Does he have three of same suit? "+p.threeOfsameSuit+ " \n"
                                        + "Does he have only two of the same suit? "+p.twoOfSameSuit+"\n"
                                                + "What is his highest suit? "+p.highestSuit+"\n"
                                                         + "What is his highest card? "+p.highestCard.name+"\n"
                                                        + "Does he have three of a kind? "+p.threeOfAKind+"\n"
                                                        + "Does he have two of a kind? "+p.twoOfAKind+"\n"
                                                                + "Does p1 Knows he has "+p.hand[0].name+"? "+ p.doesKnowCard(p, p.hand[0])+"\n"
                                                                        + "hand's value "+p.handvalue+""
                                                                                + "");
        
        answer.setText(b+"\n"+a);   
        Knowledge.setText("");
        
        for (int i=0; i<=p.knowsCard.size()-1;i++)
        {
           Knowledge.setText(Knowledge.getText()+"\n Player "+p.name+" knows that player "
                   +p.knowsCard.get(i).targetPlayer.name+ " has the card : "+p.knowsCard.get(i).targetCard.name);
        }
        p.checkTomakeNewTOK(); //two of a kind
        p.checkWidowTOK(); //
        p.checkWidowRaiseValue();
        Other_Intention.setText("\nPlayer "+p.name+" considers: \n");
       for(int w=0;w<=p.otherIntention.size()-1;w++)
       {if(p.otherIntention.get(w).set){
           
            Other_Intention.setText("\n"+Other_Intention.getText()+p.otherIntention.get(w).targetPlayer +" has high suit of "+p.otherIntention.get(w).targetHighsuit);
            if(!p.otherIntention.get(w).hasTOK){
                Other_Intention.setText(Other_Intention.getText()+"\n"+p.otherIntention.get(w).targetPlayer +" does not have TOK ");
            
            }else{
               Other_Intention.setText(Other_Intention.getText()+"\n"+p.otherIntention.get(w).targetPlayer+" has TOK with kind: "+ p.otherIntention.get(w).TOK);
             
            }
       }}
        
            }else{
                 JOptionPane.showMessageDialog(null, "The game is not in progress");
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Failed");
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      if(gameInProgress){
           if(playerTurn<=playerPool.size()-2)
       {
          this.playerTurn=playerTurn;
 
       }else{
           playerTurn=0;
       }
       
        
        playerPool.get(playerTurn).setPlayerIntention();
        System.out.println(playerPool.get(playerTurn).name+playerPool.get(playerTurn).playerDecision.playerIntention);
       // actionExchangeCard(selectedPlayer, selectedPlayer.hand[0], playerPool.get(playerPool.size()-1).hand[0]);
      
        if(playerPool.get(playerTurn).playerDecision.playerIntention==12 || playerPool.get(playerTurn).call){ endgame(playerPool.get(playerTurn).name);gameLog_TA.setText( playerPool.get(playerTurn).name+" won");} else{
             if(playerPool.get(playerTurn).playerDecision.yourCard != null)
       {
//             gameLog_TA.setText(gameLog_TA.getText()+"player intention: "+playerPool.get(playerTurn).playerDecision.possibleIntentions[playerPool.get(playerTurn).playerDecision.playerIntention]);
           actionExchangeCard(playerPool.get(playerTurn), playerPool.get(playerTurn).playerDecision.yourCard, playerPool.get(playerTurn).playerDecision.widowCard);
           // gameLog_TA.setText(gameLog_TA.getText()+"Player "+playerPool.get(playerTurn).name+" changed his "+playerPool.get(playerTurn).playerDecision.yourCard.name+" with "+playerPool.get(playerTurn).playerDecision.widowCard.name);
             jlb_playerTurn.setText(playerPool.get(playerTurn).name);
            playerTurn++; 
       }else{
                 playerPool.get(playerTurn).makeBestRandomMove();
                actionExchangeCard(playerPool.get(playerTurn), playerPool.get(playerTurn).playerDecision.yourCard, playerPool.get(playerTurn).playerDecision.widowCard);
           jlb_playerTurn.setText(playerPool.get(playerTurn).name);
           playerTurn++;
             }
        }
        
        
      }else{
          JOptionPane.showMessageDialog(null, "Please start the game first!");
      }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //the main restart button 
        while(playerPool.size()!=0)
        {
          playerPool.remove(0);
        }
        playerTurn=0;
        gameLog_TA.setText(gameLog_TA.getText()+"=================\n"+"Reseting Everything"+"\n=================\n");
        gameInProgress=false;
        jta_playablecards.setText("");
        pageSetup();
        jLabel_CardPool.setText("All the cards in cardpool");
        
        
       int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to restard the match?", "Restart", dialogButton);
if(dialogResult == 0) {
   mainFrame m = new mainFrame();
       m.setVisible(true);
        this.dispose();
} else {
  System.out.println("No Option was selected");
}
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //opening Github page
        try {
           
                openWebpage(new URL("https://github.com/HiradEmami/ThirtyoneCard"));
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(MAS_Thirtyone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // opening website
           try {
           
                openWebpage(new URL("https://sites.google.com/view/thirtyone-rug"));
           
        } catch (MalformedURLException ex) {
            Logger.getLogger(MAS_Thirtyone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     player selectedPlayer = playerPool.get(viewPlayerComboBox.getSelectedIndex());
selectedPlayer.setPlayerIntention();
        System.out.println(selectedPlayer.name+selectedPlayer.playerDecision.playerIntention);
       // actionExchangeCard(selectedPlayer, selectedPlayer.hand[0], playerPool.get(playerPool.size()-1).hand[0]);
      
        if(selectedPlayer.playerDecision.playerIntention==12 || selectedPlayer.call){endgame(selectedPlayer.name);gameLog_TA.setText(selectedPlayer.name+" won");} else{
             if(selectedPlayer.playerDecision.yourCard != null)
       {
             actionExchangeCard(selectedPlayer, selectedPlayer.playerDecision.yourCard, selectedPlayer.playerDecision.widowCard);
//             gameLog_TA.setText(gameLog_TA.getText()+"player intention: "+playerPool.get(playerTurn).playerDecision.possibleIntentions[playerPool.get(playerTurn).playerDecision.playerIntention]);
            gameLog_TA.setText(gameLog_TA.getText()+"Player "+selectedPlayer.name+" changed his "+selectedPlayer.playerDecision.yourCard.name+" with "+selectedPlayer.playerDecision.widowCard.name);
              
       }else{
                 gameLog_TA.setText("No good action");
             }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed
   
     public static void openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public static void openWebpage(URL url) {
    try {
        openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
} 
    private void actionExchangeCard(player argPlayer, card argPlayercard, card argWidowcard){
      if(playerPool.get(viewPlayerComboBox.getSelectedIndex()).name.equals("widow"))
      {
        JOptionPane.showMessageDialog(null, "You selected widow");
      }else{
           int playerNumber = argPlayer.playerNumber;
        //updating widow cards
        playerPool.get(playerPool.size()-1).swapCard(argWidowcard, argPlayercard);
        System.out.println("widow has to lose : "+argWidowcard.name +"and pick up "+argPlayercard.name);
        playerPool.get(playerPool.size()-1).updateWidowKnowledge(playerPool.get(playerPool.size()-1));
        playerPool.get(playerPool.size()-1).updatePlayerEntireKnowledge();
        //update player cards
        playerPool.get(playerNumber).swapCard(argPlayercard, argWidowcard);
        playerPool.get(playerNumber).updatePlayerEntireKnowledge();
        playerPool.get(playerNumber).updateWidowKnowledge(playerPool.get(playerPool.size()-1));
        playerPool.get(playerNumber).playerDecision.playerIntention=0;
        
        for(int i=0;i<=playerPool.size()-2;i++)
        {
           if(playerPool.get(i).name.equals(playerPool.get(playerNumber).name)){
              //skip 
           }else{
                playerPool.get(i).updateKnowledgeAfterExchange(playerPool.get(playerNumber), argPlayercard, argWidowcard);
                 playerPool.get(i).updateWidowKnowledge(playerPool.get(playerPool.size()-1));
           }
        }
        
      //  System.out.println(playerPool.get(playerNumber).name+" Exchanged with widow such that it dropped "+playerPool.get(playerPool.size()-1).hand[0].name
       // +" that meant to be "+argPlayercard.name+ " While it wanted to pick  "+argWidowcard.name+" and actually picked "+playerPool.get(playerNumber).hand[0].name);
    gameLog_TA.setText(gameLog_TA.getText()+"\n=================\n Player "+playerPool.get(playerNumber).name +" Swapped the Drpped the card "+argPlayercard.name+" and picked up "+argWidowcard.name);
    jta_playablecards.setText("");
    for(int i=0;i<=playerPool.size()-1;i++)
         {
             jta_playablecards.setText(jta_playablecards.getText()+playerPool.get(i).name+" has :"+
                     playerPool.get(i).hand[0].name+" , "+playerPool.get(i).hand[1].name+" , "+playerPool.get(i).hand[2].name+"\n");
             
             playerPool.get(i).updateOtherIntention(argWidowcard, argPlayercard, argPlayer);
         }
      }
    }
    
    
    private void endgame(String name){
        
        double highest= playerPool.get(0).handvalue;
        boolean draw =false;
        boolean changed_afterDraw=false;
        int currentHighest=0;
        int drawposition=0;
        for(int i =1; i<=playerPool.size()-2;i++)
        {
            if(!playerPool.get(i).name.equals("widow"))
            {
                if(highest==playerPool.get(i).handvalue)
                {
                    draw=true;
                    drawposition=0;
                }else{
                    if(highest<playerPool.get(i).handvalue){
                        if(draw){changed_afterDraw=true; currentHighest=i; highest=playerPool.get(i).handvalue;}
                        
                        else{currentHighest=i; highest=playerPool.get(i).handvalue;}
                    }
                }
            }
            
           
        }
         if(changed_afterDraw){
                JOptionPane.showMessageDialog(null, "The game is over. Player "+name+
                        " called!"+"\n After evaluation player "+playerPool.get(currentHighest).name+
                        " with hand value of "+highest+" won this round"+"\n his hand was "
                        +playerPool.get(currentHighest).hand[0].name+" , "+playerPool.get(currentHighest).hand[1].name+" , "+playerPool.get(currentHighest).hand[2].name
                            +"\n\nThe game will restart now");
            }else{
                if(draw){
                    JOptionPane.showMessageDialog(null, "The game is over. Player "+name+
                        " called!"+"\n After evaluation there is a draw between player "+playerPool.get(currentHighest).name+
                        " with hand value of "+highest+" and player " +playerPool.get(drawposition).name+
                        " with hand value of "+playerPool.get(drawposition).handvalue +"\n player's  "+playerPool.get(currentHighest).name +"hand was "
                        +playerPool.get(currentHighest).hand[0].name+" , "+playerPool.get(currentHighest).hand[1].name+" , "+playerPool.get(currentHighest).hand[2].name
                            +"\n player's  "+playerPool.get(drawposition).name +"hand was "
                        +playerPool.get(drawposition).hand[0].name+" , "+playerPool.get(drawposition).hand[1].name+" , "+playerPool.get(drawposition).hand[2].name
                            +"\n\nThe game will restart now"); 
                }else{
                   JOptionPane.showMessageDialog(null, "The game is over. Player "+name+
                        " called!"+"\n After evaluation player "+playerPool.get(currentHighest).name+
                        " with hand value of "+highest+" won this round"+"\n his hand was "
                        +playerPool.get(currentHighest).hand[0].name+" , "+playerPool.get(currentHighest).hand[1].name+" , "+playerPool.get(currentHighest).hand[2].name
                            +"\n\nThe game will restart now");;  
                }
            }
         int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "Would you like to restard the match?", "Restart", dialogButton);
if(dialogResult == 0) {
   mainFrame m = new mainFrame();
       m.setVisible(true);
        this.dispose();
} else {
  System.out.println("No Option was selected");
} 
       
    }
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
    private javax.swing.JTextArea Knowledge;
    private javax.swing.JTextArea Other_Intention;
    private javax.swing.JTextArea answer;
    private javax.swing.JTextArea gameLog_TA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_CardPool;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlb_playerTurn;
    private javax.swing.JTextArea jta_playablecards;
    private javax.swing.JComboBox<String> playerCombobox;
    private javax.swing.JPanel setupPane;
    private javax.swing.JButton showButton;
    private javax.swing.JButton startButton;
    private javax.swing.JComboBox<String> viewPlayerComboBox;
    // End of variables declaration//GEN-END:variables
}
