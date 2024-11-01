/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.toedter.calendar.JCalendar;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author HP
 */
public class PenghitungHariFrame extends javax.swing.JFrame {

    /**
     * Creates new form PenghitungHariFrame
     */
    public PenghitungHariFrame() {
        initComponents();
        // Sinkronisasi saat tanggal di JCalendar pertama dipilih
        tanggalCalendar1.addPropertyChangeListener(evt -> {
            if ("calendar".equals(evt.getPropertyName())) {
                Calendar tanggal = tanggalCalendar1.getCalendar();
                int bulanTerpilih = tanggal.get(Calendar.MONTH);
                int tahunTerpilih = tanggal.get(Calendar.YEAR);
                
                // Update bulanComboBox dan tahunSpinner
                bulanComboBox.setSelectedIndex(bulanTerpilih);
                tahunSpinner.setValue(tahunTerpilih);
                
                // Update informasi hari pertama dan terakhir
                updateInfoHari(tahunTerpilih, bulanTerpilih + 1);
            }
        });

        // Listener untuk sinkronisasi saat bulan di JComboBox dipilih
        bulanComboBox.addActionListener(evt -> {
            int bulanTerpilih = bulanComboBox.getSelectedIndex();
            Calendar tanggal = tanggalCalendar1.getCalendar();
            tanggal.set(Calendar.MONTH, bulanTerpilih);
            tanggalCalendar1.setCalendar(tanggal);
            updateInfoHari((Integer) tahunSpinner.getValue(), bulanTerpilih + 1);
        });

        // Listener untuk sinkronisasi saat tahun di JSpinner diubah
        tahunSpinner.addChangeListener(evt -> {
            int tahunTerpilih = (Integer) tahunSpinner.getValue();
            int bulanTerpilih = bulanComboBox.getSelectedIndex() + 1;
            Calendar tanggal = tanggalCalendar1.getCalendar();
            tanggal.set(Calendar.YEAR, tahunTerpilih);
            tanggalCalendar1.setCalendar(tanggal);
            updateInfoHari(tahunTerpilih, bulanTerpilih);
        });

        // Event untuk tombol hitung selisih
        tombolSelisih.addActionListener(evt -> hitungSelisihHari());
    }

        // Method untuk menampilkan hari pertama dan terakhir dalam bulan
        private void updateInfoHari(int tahun, int bulan) {
            LocalDate tanggalPertama = LocalDate.of(tahun, bulan, 1);
            LocalDate tanggalTerakhir = tanggalPertama.withDayOfMonth(tanggalPertama.lengthOfMonth());
        
            hariPertamaLabel.setText("Hari Pertama: " + tanggalPertama.getDayOfWeek().name());
            hariTerakhirLabel.setText("Hari Terakhir: " + tanggalTerakhir.getDayOfWeek().name());
        }

        // Method untuk menghitung selisih hari antara dua tanggal
        private void hitungSelisihHari() {
            LocalDate tanggal1 = LocalDate.of(tanggalCalendar1.getCalendar().get(Calendar.YEAR),
                                              tanggalCalendar1.getCalendar().get(Calendar.MONTH) + 1,
                                              tanggalCalendar1.getCalendar().get(Calendar.DAY_OF_MONTH));
            LocalDate tanggal2 = LocalDate.of(tanggalCalendar2.getCalendar().get(Calendar.YEAR),
                                              tanggalCalendar2.getCalendar().get(Calendar.MONTH) + 1,
                                              tanggalCalendar2.getCalendar().get(Calendar.DAY_OF_MONTH));
        
            long selisih = ChronoUnit.DAYS.between(tanggal1, tanggal2);
            selisihHariLabel.setText("Selisih Hari: " + Math.abs(selisih) + " hari");
        }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bulanComboBox = new javax.swing.JComboBox<>();
        tahunSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        hasilLabel = new javax.swing.JLabel();
        hariPertamaLabel = new javax.swing.JLabel();
        hariTerakhirLabel = new javax.swing.JLabel();
        tanggalCalendar1 = new com.toedter.calendar.JCalendar();
        tombolSelisih = new javax.swing.JButton();
        tanggalCalendar2 = new com.toedter.calendar.JCalendar();
        selisihHariLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bulan");

        jLabel2.setText("Tahun");

        bulanComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        tahunSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tahunSpinnerStateChanged(evt);
            }
        });

        jButton1.setText("Hitung");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        hasilLabel.setText("Hasil");

        hariPertamaLabel.setText("Hari Pertama");

        hariTerakhirLabel.setText("Hari Terakhir");

        tombolSelisih.setText("Hitung Selisih");
        tombolSelisih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSelisihActionPerformed(evt);
            }
        });

        selisihHariLabel.setText("Selisih Hari");

        jLabel3.setText("Calender Untuk Menghitung Selisih Hari");

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hasilLabel)
                            .addComponent(hariTerakhirLabel)
                            .addComponent(hariPertamaLabel)
                            .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(bulanComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tahunSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(selisihHariLabel))
                        .addGap(18, 18, 18)
                        .addComponent(tanggalCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tombolSelisih)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggalCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(24, 24, 24))
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelLayout.createSequentialGroup()
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bulanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tahunSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(hasilLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hariPertamaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hariTerakhirLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selisihHariLabel)))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(tombolSelisih))
                    .addComponent(tanggalCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void hitungJumlahHari() {
        // Ambil tanggal dari JCalendar
        Calendar tanggal = tanggalCalendar1.getCalendar();

        // Ambil bulan dan tahun dari tanggal
        int tahun = tanggal.get(Calendar.YEAR);
        int bulan = tanggal.get(Calendar.MONTH) + 1; // Calendar.MONTH dimulai dari 0

        // Menggunakan YearMonth untuk menghitung jumlah hari
        YearMonth yearMonth = YearMonth.of(tahun, bulan);
        int jumlahHari = yearMonth.lengthOfMonth();
    
        // Tampilkan hasil
        hasilLabel.setText("Jumlah Hari: " + jumlahHari);
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hitungJumlahHari();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tahunSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tahunSpinnerStateChanged
        hitungJumlahHari();
    }//GEN-LAST:event_tahunSpinnerStateChanged

    private void tombolSelisihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSelisihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolSelisihActionPerformed

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
            java.util.logging.Logger.getLogger(PenghitungHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenghitungHariFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JComboBox<String> bulanComboBox;
    private javax.swing.JLabel hariPertamaLabel;
    private javax.swing.JLabel hariTerakhirLabel;
    private javax.swing.JLabel hasilLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel selisihHariLabel;
    private javax.swing.JSpinner tahunSpinner;
    private com.toedter.calendar.JCalendar tanggalCalendar1;
    private com.toedter.calendar.JCalendar tanggalCalendar2;
    private javax.swing.JButton tombolSelisih;
    // End of variables declaration//GEN-END:variables
}
