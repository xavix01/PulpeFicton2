package vue;

import beans.Client;
import classes.CreationProjet;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p1207333
 */
public class NouveauProjet extends javax.swing.JFrame {

    StringBuffer date = new StringBuffer();
    public Client client;

    /**
     * Creates new form NouveauProjet
     */
    public NouveauProjet() {
        initComponents();
        client = new Client();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numeroProjet = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomProjet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dureeProjet = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateFinPrevue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        prixJournee = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        validerNouvProjet = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        clientSelectionne = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nouveau Projet");

        jLabel1.setText("Numero de Projet :");

        jLabel2.setText("Nom Projet :");

        nomProjet.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                activerBouton1(evt);
            }
        });

        jLabel3.setText("Durée du Projet  (en semaine):");

        dureeProjet.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                activerBouton2(evt);
            }
        });
        dureeProjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keytypedDuree(evt);
            }
        });

        jLabel4.setText("Date Fin prévue  JJ/MM/AAAA :");

        dateFinPrevue.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                activerBouton3(evt);
            }
        });
        dateFinPrevue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyTypeDate(evt);
            }
        });

        jLabel5.setText("Prix/journée :");

        prixJournee.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                activerBouton4(evt);
            }
        });
        prixJournee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keytypedPrixJ(evt);
            }
        });

        jLabel6.setText("Id client :");

        validerNouvProjet.setText("Valider");
        validerNouvProjet.setEnabled(false);
        validerNouvProjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider(evt);
            }
        });

        jButton1.setText("Recherche Client");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheClient(evt);
            }
        });

        jButton2.setText("Retour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourMenu(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(numeroProjet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clientSelectionne, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dureeProjet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(dateFinPrevue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(prixJournee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(nomProjet)))))
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(validerNouvProjet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numeroProjet, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dureeProjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinPrevue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prixJournee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientSelectionne, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validerNouvProjet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retourMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourMenu
        this.dispose();
    }//GEN-LAST:event_retourMenu
/**
 * Ouvre la fenetre de recherche de client
 * @param evt 
 */
    private void rechercheClient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheClient
        new RechercheClient(this, true, client).setVisible(true);
        clientSelectionne.setText(String.valueOf(client.getId_client()));
        verifBouton();
    }//GEN-LAST:event_rechercheClient
/**
 * Envoi à la méthode addProjet de la classe CreationProjet , les informations entré par l'utilisateur
 * @param evt 
 */
    private void valider(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider
        JOptionPane res = null;
        try {
            new CreationProjet().addProjet(clientSelectionne.getText(), nomProjet.getText(), dureeProjet.getText(), dateFinPrevue.getText(), prixJournee.getText());
            res.showMessageDialog(this, "Projet enregistré avec succès ");
        } catch (Exception e) {
            res.showMessageDialog(this, "Erreur d'enregistrement");
        }
    }//GEN-LAST:event_valider

    /**
     * permet une validation de date JJ/MM/AAAA
     * @param evt 
     */
    private void keyTypeDate(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyTypeDate
        char t = evt.getKeyChar();
        if (t == KeyEvent.VK_BACK_SPACE && date.length() != 0) {
            date.deleteCharAt(date.length() - 1);
        } else {
            if (date.length() > 9) {
                evt.consume();
            }
            if (date.length() == 2 || date.length() == 5) {
                if (t == '/') {
                    date.append(t);
                } else {
                    evt.consume();
                }
            } else {
                if (!(Character.isDigit(t))) {

                    evt.consume();
                } else {
                    if (date.length() == 0 && Character.getNumericValue(t) > 3) {

                        evt.consume();
                    } else if (date.length() == 1 && Character.getNumericValue(date.charAt(0)) == 3 && Character.getNumericValue(t) > 1) {
                        evt.consume();
                    } else if (date.length() == 1 && Character.getNumericValue(date.charAt(0)) == 0 && Character.getNumericValue(t) == 0) {
                        evt.consume();
                    } else if (date.length() == 3 && Character.getNumericValue(t) > 1) {
                        evt.consume();
                    } else if (date.length() == 4 && ((Character.getNumericValue(date.charAt(3)) == 1 && Character.getNumericValue(t) > 2) || (Character.getNumericValue(date.charAt(3)) == 0 && Character.getNumericValue(t) == 0))) {
                        evt.consume();
                    } else {
                        date.append(t);
                    }
                }
            }
        }
    }//GEN-LAST:event_keyTypeDate

    private void activerBouton1(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_activerBouton1
        verifBouton();
    }//GEN-LAST:event_activerBouton1

    private void activerBouton2(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_activerBouton2
        verifBouton();
    }//GEN-LAST:event_activerBouton2

    private void activerBouton3(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_activerBouton3
        verifBouton();
    }//GEN-LAST:event_activerBouton3

    private void activerBouton4(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_activerBouton4
        verifBouton();
    }//GEN-LAST:event_activerBouton4

    private void keytypedDuree(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keytypedDuree
        char t = evt.getKeyChar();
        if (!Character.isDigit(t)) {
            evt.consume();
        }
    }//GEN-LAST:event_keytypedDuree
/**
 * Si le caractère entré n'est pas numérique, alors on ne fait rien (ne s'affiche pas)
 * @param evt 
 */
    private void keytypedPrixJ(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keytypedPrixJ
        char t = evt.getKeyChar();
        if (!Character.isDigit(t)) {
            evt.consume();
        }
    }//GEN-LAST:event_keytypedPrixJ

    /**
     * Si les champs sont tous rempli alors le bouton "Valider" est activé
     * sinon on le désactive
     */
    private void verifBouton() {
        if ((!nomProjet.getText().isEmpty() && !dateFinPrevue.getText().isEmpty()
                && !dureeProjet.getText().isEmpty() && !prixJournee.getText().isEmpty()
                && !clientSelectionne.getText().isEmpty())) {
            validerNouvProjet.setEnabled(true);
        } else {
            validerNouvProjet.setEnabled(false);
        }
    }

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
            java.util.logging.Logger.getLogger(NouveauProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouveauProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouveauProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouveauProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouveauProjet().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clientSelectionne;
    private javax.swing.JTextField dateFinPrevue;
    private javax.swing.JTextField dureeProjet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nomProjet;
    private javax.swing.JLabel numeroProjet;
    private javax.swing.JTextField prixJournee;
    private javax.swing.JButton validerNouvProjet;
    // End of variables declaration//GEN-END:variables
}
