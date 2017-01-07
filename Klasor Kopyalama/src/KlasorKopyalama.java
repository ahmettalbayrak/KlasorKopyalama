
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Bu sınıf seçilen klasörü tüm alt klasör ve dosyalarıyla birlikte
 * seçilen hedefe kopyalanması için hazırlanmıştır.
 * 
 * @author Ahmet ALBAYRAK <ahmetalbayrak92@hotmail.com>
 */
public class KlasorKopyalama extends javax.swing.JFrame {

    String secilenKlasor;
    String secilenYol;
    FileInputStream fis;
    FileOutputStream fos;
    public KlasorKopyalama()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kopyalanacak Dosya ");

        jButton1.setText("Seç");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Kopyalanacak Yer ");

        jButton2.setText("Seç");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Kopyala");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Filechooser ile kopyalanacak klasörün yolu alınıp değişkene atanır.
     * Kullanıcıya seçtiği yolu göstermek için textfield'a aldığımız yol yazdırılır. 
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jFileChooser1.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
        int sonuc=jFileChooser1.showOpenDialog(this);
        if(sonuc==0)
        {
            secilenKlasor=jFileChooser1.getSelectedFile().toString();
            jTextField1.setText(secilenKlasor.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Filechooser ile hedef kullnıcıdan alıp değişkene atanır.
     * Kullanıcıya seçtiği yolu göstermek için textfield'a aldığımız yol yazdırılır.
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jFileChooser2.setFileSelectionMode(jFileChooser1.DIRECTORIES_ONLY);
        int sonuc=jFileChooser2.showOpenDialog(this);
        if(sonuc==0)
        {
            secilenYol=jFileChooser2.getSelectedFile().toString();
            jTextField2.setText(secilenYol.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Klasör yollarını alınırr değişkenlere atanır.
     * Yolları copyFolder methotuna vererek kopyalama işleminin yapılmasını sağlanır.
     * @param evt 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        File srcFolder = new File(secilenKlasor);
        File destFolder = new File(secilenYol+"/"+srcFolder.getName());
        
        if(!srcFolder.exists())
        {
           System.out.println("Kaynak bulunamadı.");
           System.exit(0);
        }
        else
        {
            try
            {
                copyFolder(srcFolder,destFolder);
            }
            catch(Exception e)
            {            
                e.printStackTrace();
                System.exit(0);
            }
        }
        System.out.println("İşlem bitti");
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * Parametre olarak verilen dosya yolları ve kopyalanacağı yeri alınır.
     * Eğer klasör ise ve o klasör hedefte yoksa klaör oluşturulur.
     * Eğer dosya ise o dosya alınırr belirtilen hedefe kopyalanır.
     * @param src
     * @param dest
     * @throws Exception 
     */
    public void copyFolder(File src, File dest) throws Exception
    {
        if(src.isDirectory())
        {
            if(!dest.exists())
            {
               dest.mkdir();
               System.out.println(src + "  kopyalanıyor  " + dest);
            }
            
            String files[] = src.list();

            for (String file : files)
            {
               File srcFile = new File(src, file);
               File destFile = new File(dest, file);
               copyFolder(srcFile,destFile);
            }
        }
        else
        {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest); 

            byte[] buffer = new byte[1024];
            int length;                
            while ((length = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("Dosya kaynaktan " + src + ", " + dest + " hedefe kopyalandı.");
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
            java.util.logging.Logger.getLogger(KlasorKopyalama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KlasorKopyalama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KlasorKopyalama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KlasorKopyalama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KlasorKopyalama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
