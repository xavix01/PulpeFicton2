package vue;
import beans.Client;

import classes.CreationPdfConvention;
import classes.CreationProjet;
import classes.RechercherProjet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p1207333
 */
public class EditionConvention extends javax.swing.JFrame {

    Client client;
    RechercherProjet rechercherProjet;
    CreationProjet creationProjet;

    int idProjet;

    /**
     * Creates new form EditionConvention
     */
    public EditionConvention() {
        initComponents();
        creationProjet=new CreationProjet();
        client = new Client();
        rechercherProjet=new RechercherProjet();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectionClient = new javax.swing.JButton();
        editionConvNomClient = new javax.swing.JLabel();
        editionConvNumClient = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editionConvProjetSelectionne = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        validerEditionConv = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        editionConvAfficheNumConv = new javax.swing.JLabel();
        imprimerConvention = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAfficheProjet = new javax.swing.JTable();
        equipe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edition Convention");

        selectionClient.setText("Selection du client");
        selectionClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionClient(evt);
            }
        });

        editionConvNomClient.setText("LABEL NOM CLIENT");

        editionConvNumClient.setText("LABEL ID CLIENT");

        jLabel3.setText("Projets du client :");

        editionConvProjetSelectionne.setText("LABEL PROJET SELECTIONNE");

        jLabel5.setText("Projet selectionné :");

        validerEditionConv.setText("Valider Convention");
        validerEditionConv.setEnabled(false);
        validerEditionConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonValiderConvention(evt);
            }
        });

        jLabel1.setText("Numero de convention :");

        editionConvAfficheNumConv.setText("LABEL NUMERO CONVENTION");

        imprimerConvention.setText("Impression Convetion");
        imprimerConvention.setEnabled(false);
        imprimerConvention.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPDF(evt);
            }
        });

        jButton1.setText("Retour ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourMenu(evt);
            }
        });

        tableAfficheProjet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAfficheProjet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectionProjet(evt);
            }
        });
        jScrollPane2.setViewportView(tableAfficheProjet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(editionConvProjetSelectionne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(selectionClient)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(editionConvNomClient, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editionConvNumClient, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jButton1))
                            .addComponent(validerEditionConv)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editionConvAfficheNumConv))
                            .addComponent(imprimerConvention))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(equipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectionClient)
                    .addComponent(editionConvNomClient)
                    .addComponent(editionConvNumClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equipe, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editionConvProjetSelectionne)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validerEditionConv)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(editionConvAfficheNumConv))
                .addGap(18, 18, 18)
                .addComponent(imprimerConvention)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retourMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourMenu
        this.dispose();
        
    }//GEN-LAST:event_retourMenu

    private void selectionClient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionClient

        new RechercheClient(this, true, client).setVisible(true);

        
        
        editionConvNumClient.setText(String.valueOf(client.getId_client()));      
        Vector vector=new Vector();
        vector= rechercherProjet.projetClient(String.valueOf(client.getId_client()));


        Vector columnNames = new Vector();
        columnNames.add("numéro de projet");
        columnNames.add("Numéro de client");
        columnNames.add("Numéro de l'étudiant responsable");
        columnNames.add("Numéro de convention");
        columnNames.add("Nom du Projet");
        columnNames.add("Durée du projet");
        columnNames.add("Date de fin prévue");
        columnNames.add("prix journée");
        columnNames.add("Cout total du Projet");

        tableAfficheProjet.setModel(new DefaultTableModel(vector, columnNames));
        
    }//GEN-LAST:event_selectionClient

    private void selectionProjet(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectionProjet
        int ligneSelectionnee = tableAfficheProjet.getSelectedRow();
        idProjet = (int) tableAfficheProjet.getValueAt(ligneSelectionnee, 0);
        boolean reponse = rechercherProjet.aUneEquipe(String.valueOf(idProjet));
        
        
        Integer idconvention = (Integer) tableAfficheProjet.getValueAt(ligneSelectionnee, 3);
        editionConvProjetSelectionne.setText(String.valueOf(idProjet));
        
        if(reponse){
            equipe.setText("Equipe selectionnée");
        }else{
            equipe.setText("Vous devez choisir une equipe avent la validation de convention");
        }
        if (idconvention == 0 && reponse) {
            validerEditionConv.setEnabled(true);

        } else {
            editionConvAfficheNumConv.setText(String.valueOf(idconvention));
            validerEditionConv.setEnabled(false);
        }
        
        
        if (idconvention>0&& reponse) {
            imprimerConvention.setEnabled(true);
        } else {
            imprimerConvention.setEnabled(false);
        }

    }//GEN-LAST:event_selectionProjet

    private void boutonValiderConvention(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonValiderConvention

        int ligneSelectionnee = tableAfficheProjet.getSelectedRow();
        idProjet = (int) tableAfficheProjet.getValueAt(ligneSelectionnee, 0);
        
        int convention=creationProjet.ajoutConvention(idProjet,client);
        
        Vector vector = new Vector();
        vector = rechercherProjet.projetClient(String.valueOf(client.getId_client()));

        Vector columnNames = new Vector();
        columnNames.add("numéro de projet");
        columnNames.add("Numéro de client");
        columnNames.add("Numéro de l'étudiant responsable");
        columnNames.add("Numéro de convention");
        columnNames.add("Nom du Projet");
        columnNames.add("Durée du projet");
        columnNames.add("Date de fin prévue");
        columnNames.add("prix journée");
        columnNames.add("Cout total du Projet");

        tableAfficheProjet.setModel(new DefaultTableModel(vector, columnNames));
        
        
        
        editionConvAfficheNumConv.setText(String.valueOf(convention));
        
        validerEditionConv.setEnabled(false);
        imprimerConvention.setEnabled(true);


    }//GEN-LAST:event_boutonValiderConvention

    private void createPDF(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPDF
        
        
        new CreationPdfConvention(idProjet);
    }//GEN-LAST:event_createPDF

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EditionConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditionConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditionConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditionConvention.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditionConvention().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel editionConvAfficheNumConv;
    private javax.swing.JLabel editionConvNomClient;
    private javax.swing.JLabel editionConvNumClient;
    private javax.swing.JLabel editionConvProjetSelectionne;
    private javax.swing.JLabel equipe;
    private javax.swing.JButton imprimerConvention;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton selectionClient;
    private javax.swing.JTable tableAfficheProjet;
    private javax.swing.JButton validerEditionConv;
    // End of variables declaration//GEN-END:variables
}
