/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AbstractFactory;

import Sql.SqlVeriIslemleriDepo;
import Sql.SqlVeriIslemleriUretim;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusagca
 */
public class UretimPage extends javax.swing.JFrame {

    /**
     * Creates new form UretimPage
     */
    Uretim u = new Uretim();

    public UretimPage() {
        initComponents();
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        SqlVeriIslemleriUretim v = new SqlVeriIslemleriUretim();
        List<Uretim> veri = v.Verileri_Listeleme();
        List<Depo> depoVeri = d.Verileri_Listeleme();
        DefaultTableModel dfTable = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel dfTableU = (DefaultTableModel) jTable3.getModel();
        for (Uretim c : veri) {
            Object[] obj = {c.uretim_id, c.urun_id, Character.toUpperCase(c.ulke.charAt(0)) + c.ulke.substring(1), Character.toUpperCase(c.urun_ad.charAt(0)) + c.urun_ad.substring(1), Character.toUpperCase(c.urun_renk.charAt(0)) + c.urun_renk.substring(1), c.satılan_miktar, c.maliyet};
            dfTable.addRow(obj);

        }
        for (Depo c : depoVeri) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            dfTableU.addRow(obj);
        }
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        urun_ad = new javax.swing.JComboBox<>();
        urun_id = new javax.swing.JTextField();
        urun_renk = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        urun_fabrika = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        satilan_urun = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        silBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        urun_ad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suet", "Suni" }));
        urun_ad.setToolTipText("");

        urun_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urun_idActionPerformed(evt);
            }
        });

        urun_renk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urun_renkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("ÜRETİM MENÜSÜ");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        urun_fabrika.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amerika", "Turkiye" }));
        urun_fabrika.setToolTipText("");
        urun_fabrika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urun_fabrikaActionPerformed(evt);
            }
        });

        jLabel2.setText("Satılan Ürün Miktarı");

        jLabel3.setText("Ürün Rengi");

        jLabel4.setText("Fabrika Seçimi");

        jLabel5.setText("Ürün Türü");

        satilan_urun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satilan_urunActionPerformed(evt);
            }
        });

        jLabel6.setText("Ürün ID");

        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "uretim_id", "urun_id", "uretilen_ulke", "urun_adı", "urun_renk", "uretilen_miktar", "maliyet"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jTable2.setOpaque(false);
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "urun_id", "urun_adi", "renk", "birim_maliyet", "satis_fiyati", "birim_kar", "stok_miktarı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setGridColor(new java.awt.Color(0, 0, 0));
        jTable3.setOpaque(false);
        jTable3.setShowGrid(true);
        jTable3.setSurrendersFocusOnKeystroke(true);
        jScrollPane3.setViewportView(jTable3);

        silBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        silBtn.setText("Sil");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel7.setText("ÜRETİM TABLOSU");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel8.setText("DEPO TABLOSU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(urun_renk, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(urun_id, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(urun_ad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(urun_fabrika, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(satilan_urun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 338, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_fabrika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(satilan_urun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_renk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urun_renkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urun_renkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urun_renkActionPerformed

    private void urun_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urun_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urun_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (jTable2.getSelectedRow() > -1) {
                tableChanged();
            } else {

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                DefaultTableModel modelD = (DefaultTableModel) jTable3.getModel();
                model.setRowCount(0);
                modelD.setRowCount(0);
                if (urun_fabrika.getSelectedItem().toString().equals("Amerika")) {
                    if (urun_ad.getSelectedItem().toString().equals("Suet")) {

                        AmerikaSuetFactory amerikasuet = new AmerikaSuetFactory();
                        ISuetDeri AmerikaSuet = amerikasuet.Suetderiyap(urun_renk.getText(), Integer.parseInt(urun_id.getText()), Integer.parseInt(satilan_urun.getText()), 0);
                        if (AmerikaSuet == null) {
                            JOptionPane.showMessageDialog(null, "İşlem esnasında bir hata oluştu. Girilen değerleri kontrol edin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (urun_ad.getSelectedItem().toString().equals("Suni")) {
                        AmerikaSuniFactory amerikasuni = new AmerikaSuniFactory();
                        ISuniDeri AmerikaSuni = amerikasuni.Sunideriyap(urun_renk.getText(), Integer.parseInt(urun_id.getText()), Integer.parseInt(satilan_urun.getText()), 0);
                        if (AmerikaSuni == null) {
                            JOptionPane.showMessageDialog(null, "İşlem esnasında bir hata oluştu. Girilen değerleri kontrol edin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } else if (urun_fabrika.getSelectedItem().toString().equals("Turkiye")) {
                    if (urun_ad.getSelectedItem().toString().equals("Suet")) {
                        TurkiyeSuetFactory turkiyesuet = new TurkiyeSuetFactory();
                        ISuetDeri TurkiyeSuet = turkiyesuet.Suetderiyap(urun_renk.getText(), Integer.parseInt(urun_id.getText()), Integer.parseInt(satilan_urun.getText()), 0);
                        if (TurkiyeSuet == null) {
                            JOptionPane.showMessageDialog(null, "İşlem esnasında bir hata oluştu. Girilen değerleri kontrol edin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                        }
                    } else if (urun_ad.getSelectedItem().toString().equals("Suni")) {
                        TurkiyeSuniFactory turkiyesuni = new TurkiyeSuniFactory();
                        ISuniDeri TurkiyeSuni = turkiyesuni.Sunideriyap(urun_renk.getText(), Integer.parseInt(urun_id.getText()), Integer.parseInt(satilan_urun.getText()), 0);
                        if (TurkiyeSuni == null) {
                            JOptionPane.showMessageDialog(null, "Ham madde yetersizliğinden üretim yapılamaz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                tabloGuncelle();
                JTable depoTablo = jTable3;
                SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
                List<Depo> depoVeri = d.Verileri_Listeleme();
                DefaultTableModel dfTableD = (DefaultTableModel) depoTablo.getModel();
                dfTableD.setRowCount(0);
                for (Depo c : depoVeri) {
                    Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
                    dfTableD.addRow(obj);
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Boş alan bırakılamaz", "Uyarı", JOptionPane.WARNING_MESSAGE);
            tabloGuncelle();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void urun_fabrikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urun_fabrikaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urun_fabrikaActionPerformed

    private void satilan_urunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satilan_urunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satilan_urunActionPerformed

    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
        if (jTable2.getSelectedRow() > -1) {
            int uretim_id = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
            u.UretimSil(uretim_id);
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            tabloGuncelle();

        }
    }//GEN-LAST:event_silBtnActionPerformed
    private void tabloGuncelle() {
        JTable tablo = jTable2;

        List<Uretim> veri = u.UretimleriGöster();
        DefaultTableModel dfTable = (DefaultTableModel) tablo.getModel();

        for (Uretim c : veri) {
            Object[] obj = {c.uretim_id, c.urun_id, Character.toUpperCase(c.ulke.charAt(0)) + c.ulke.substring(1), Character.toUpperCase(c.urun_ad.charAt(0)) + c.urun_ad.substring(1), Character.toUpperCase(c.urun_renk.charAt(0)) + c.urun_renk.substring(1), c.satılan_miktar, c.maliyet};
            dfTable.addRow(obj);
        }

        JTable depoTablo = jTable3;
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        List<Depo> depoVeri = d.Verileri_Listeleme();
        DefaultTableModel dfTableD = (DefaultTableModel) depoTablo.getModel();
        dfTableD.setRowCount(0);
        for (Depo c : depoVeri) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            dfTableD.addRow(obj);
        }

    }

    public void tableChanged() {

        int row = jTable2.getSelectedRow(); // Seçilen satırın indeksi
        int column = jTable2.getSelectedColumn(); // Seçilen sütunun indeksi
        String cName = jTable2.getColumnName(column);
        Object data = jTable2.getValueAt(row, column); // Seçilen hücrenin değeri

        int uretim_id = (int) jTable2.getValueAt(jTable2.getSelectedRow(), 0);
        System.out.println(uretim_id);

        System.out.println(cName);
        if (column == 3 || column == 4 || column == 0) {
            JOptionPane.showMessageDialog(null, "Bu değerlerde değişiklik yapılamaz.", "Uyarı", JOptionPane.WARNING_MESSAGE);
        } else if (column == 1 || column == 5 || column == 6) {
            String a = u.UretimGuncelle(cName, "", uretim_id, (Integer) data, 0);

            JOptionPane.showMessageDialog(null, a, "Uyarı", JOptionPane.WARNING_MESSAGE);
        } else if (column == 2) {
            if (data.toString().equals("Turkiye") || data.toString().equals("Amerika")) {
                u.UretimGuncelle(cName, data.toString(), uretim_id, 0, 0);
            }

        }

        System.out.println(data + ":" + cName + ":" + column);
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        tabloGuncelle();

        // Burada istediğiniz işlemleri yapabilirsiniz
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
            java.util.logging.Logger.getLogger(UretimPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UretimPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UretimPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UretimPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UretimPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    public javax.swing.JTable jTable3;
    private javax.swing.JTextField satilan_urun;
    private javax.swing.JButton silBtn;
    private javax.swing.JComboBox<String> urun_ad;
    private javax.swing.JComboBox<String> urun_fabrika;
    private javax.swing.JTextField urun_id;
    private javax.swing.JTextField urun_renk;
    // End of variables declaration//GEN-END:variables
}
