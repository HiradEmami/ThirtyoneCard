
package mas_thirtyone;

import java.util.ArrayList;
import java.util.Random;


public class mainFrame extends javax.swing.JFrame {
private ArrayList <card> cardPool; //array list for all cards
   
    public mainFrame() {
        initComponents();
        pageSetup(); //page setup function
        test();
    }
    
    public void test()
    {
        player p = new player( "P1", cardPool.get(2), cardPool.get(20), cardPool.get(5));
        System.out.println("Testing for player :"+p.name);
        System.out.println("First card: "+p.hand[0].name+" /type:"+p.hand[0].type+"/value: "+p.hand[0].value+" /suit: "+p.hand[0].suit+" \n"
                + "Second card: "+p.hand[1].name+" /type:"+p.hand[1].type+"/value: "+p.hand[1].value+" /suit: "+p.hand[1].suit+" \n"
                        + "Third card: "+p.hand[2].name+" /type:"+p.hand[2].type+"/value: "+p.hand[2].value+" /suit: "+p.hand[2].suit+" \n"
                                + "Does he have three of same suit? "+p.threeOfsameSuit+ " \n"
                                        + "Does he have only two of the same suit? "+p.twoOfSameSuit+"\n"
                                                + "What is his highest card? "+p.highestSuit);
    }
   
    
    private void pageSetup()
    {
        this.cardPool=new ArrayList<card>(); //initi array list for all cards
        setCardPool(); //setting all the cards
        printPlayableCards();
        
        System.out.println("Page setup was successful");
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
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta_playablecards = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
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

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton1)))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        jPanel1.add(jPanel7, "card6");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
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
            .addGap(0, 651, Short.MAX_VALUE)
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
            .addGap(0, 651, Short.MAX_VALUE)
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
            .addGap(0, 651, Short.MAX_VALUE)
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
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta_playablecards;
    // End of variables declaration//GEN-END:variables
}
