
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import java.net.*;
import sun.net.ftp.FtpClient;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * bot.java
 *
 * Created on 16 Mar, 2012, 3:35:19 PM
 * downloaded xml file will always name soxml.xml
 * downloaded pdf will always be orks.pdf
 * downloaded qcm will always be orks.qcm
 * all the files downloaded must be deleted by the program before terminating
 *
 */

/**
 *
 * @author aditya
 */
public class bot extends javax.swing.JFrame {

    String[] args = new String[5];
    String examiner,subcode,branch,year;
    String regno;
    boolean type,typeselect,mode,modeselect;
    Process process;
    Thread thread;
    Runtime runtime;
    FtpClient ftp;
    /**
     * type= 0 examiner 1 student
     * mode= 0 analysis 1 checking
     */
    /** Creates new form bot */
    public bot() {
        initComponents();
        init();
    }

    public void init() {
        typeselect=false;
        modeselect=false;
    }
    public void examshow() {
        jLabel1.setEnabled(true);
        jLabel2.setEnabled(true);
        texaminer.setEnabled(true);
        tsubcode.setEnabled(true);
        oanalysis.setEnabled(true);
        ochecking.setEnabled(true);
    }
    public void studshow() {
        jLabel1.setEnabled(false);
        jLabel2.setEnabled(false);
        texaminer.setText("");
        tsubcode.setText("");
        texaminer.setEnabled(false);
        tsubcode.setEnabled(false);
        oanalysis.setEnabled(false);
        ochecking.setEnabled(false);

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        texaminer = new javax.swing.JTextField();
        tsubcode = new javax.swing.JTextField();
        tbranch = new javax.swing.JTextField();
        tyear = new javax.swing.JTextField();
        tregno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        oanalysis = new javax.swing.JRadioButton();
        ochecking = new javax.swing.JRadioButton();
        cbexam = new javax.swing.JCheckBox();
        cbstud = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Continue...");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        texaminer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texaminerActionPerformed(evt);
            }
        });

        jLabel1.setText("Examiner Name");

        jLabel2.setText("Subject Code");

        jLabel3.setText("Branch");

        jLabel4.setText("Year");

        jLabel5.setText("Reg. No.");

        oanalysis.setText("Analysis");
        oanalysis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oanalysisMouseClicked(evt);
            }
        });

        ochecking.setText("Checking");
        ochecking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ocheckingMouseClicked(evt);
            }
        });

        cbexam.setText("Non-Student");
        cbexam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbexamMouseClicked(evt);
            }
        });

        cbstud.setText("Student");
        cbstud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbstudMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbstud)
                            .addComponent(cbexam))
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(oanalysis))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tsubcode)
                                    .addComponent(tbranch)
                                    .addComponent(tyear)
                                    .addComponent(tregno)
                                    .addComponent(texaminer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(ochecking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texaminer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tsubcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbexam))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbstud))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oanalysis)
                    .addComponent(ochecking, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(typeselect==false || (modeselect==false && type==false)) {
            JOptionPane.showMessageDialog(this,"Please select appropiate options","Error!!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        examiner=args[0]=texaminer.getText();
        subcode=args[1]=tsubcode.getText();
        branch=args[2]=tbranch.getText();
        year=args[3]=tyear.getText();
        regno=args[4]=tregno.getText();
        if(type==false && mode==false) {
            System.out.println("Going to Analysis by examiner");
            if(args[2]==null || args[3]==null) {
                JOptionPane.showMessageDialog(this,"Enter Appropiate info","Error!!",JOptionPane.ERROR_MESSAGE);
            }
            ftpdl("mnnit/"+year+"_year/"+branch+"/"+branch+".xml","soxml.xml");
           // ftpup("ss");
            analysis alsis = new analysis(type,args[2],args[3],null);
            alsis.setVisible(true);
        }
        else if(type == false && mode == true) {
            ftpdl("mnnit/"+year+"_year/"+branch+"/"+subcode+"/"+regno+".pdf","orks.pdf");
            ftpdl("mnnit/"+year+"_year/"+branch+"/"+subcode+"/"+regno+".qcm","orks.qcm");
            PDFEditor editor = new PDFEditor(true,args,true);
        }
        if(type==true) {
            if(args[2]==null || args[3]==null || args[4]==null) {
                JOptionPane.showMessageDialog(this,"Enter Appropiate info plz","Error!!",JOptionPane.ERROR_MESSAGE);
            }
            analysis alsis = new analysis(type,args[2],args[3],args[4]);
             alsis.setVisible(true);
        }
        dispose();
        
    }//GEN-LAST:event_jButton1MouseClicked

    public void ftpdl(String path,String filename) {
        try {
        URL url = new URL("ftp://guest:guest@172.31.77.48/"+path);
        URLConnection con = url.openConnection();
        BufferedInputStream in = new BufferedInputStream(con.getInputStream());
        FileOutputStream out = new FileOutputStream(filename);

        int i = 0;
        byte[] bytesIn = new byte[1024];
        while ((i = in.read(bytesIn)) >= 0) {
                out.write(bytesIn, 0, i);
        }
        out.close();
        in.close();
        }

        catch(Exception e) {
                System.out.println("ftpdl: "+e.getMessage());
        }

    }
    public void ftpup(String path) {
        try {
            runtime = Runtime.getRuntime();
            process = runtime.exec("ftpup.sh "+"127.0.0.1 "+"high.png "+"");

        }
        catch(Exception e) {
                System.out.println("ftpup: "+e.getMessage());
        }

    }
    private void texaminerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texaminerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texaminerActionPerformed

    private void oanalysisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oanalysisMouseClicked
        // TODO add your handling code here:
        ochecking.setSelected(false);
        modeselect=true;
        tsubcode.setEnabled(false);
        texaminer.setEnabled(false);
        tregno.setEnabled(false);
        jLabel2.setEnabled(false);
        jLabel1.setEnabled(false);
        jLabel5.setEnabled(false);
        mode=false;
    }//GEN-LAST:event_oanalysisMouseClicked

    private void ocheckingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocheckingMouseClicked
        // TODO add your handling code here:
        oanalysis.setSelected(false);
        modeselect=true;
        tsubcode.setEnabled(true);
        texaminer.setEnabled(true);
        tregno.setEnabled(true);
        jLabel2.setEnabled(true);
        jLabel1.setEnabled(true);
        jLabel5.setEnabled(true);
        mode=true;
    }//GEN-LAST:event_ocheckingMouseClicked

    private void cbexamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbexamMouseClicked
        // TODO add your handling code here:
        cbstud.setSelected(false);
        typeselect=true;
        type=false;
        examshow();
    }//GEN-LAST:event_cbexamMouseClicked

    private void cbstudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbstudMouseClicked
        // TODO add your handling code here:
        cbexam.setSelected(false);
        typeselect=true;
        type=true;
        studshow();
    }//GEN-LAST:event_cbstudMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbexam;
    private javax.swing.JCheckBox cbstud;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton oanalysis;
    private javax.swing.JRadioButton ochecking;
    private javax.swing.JTextField tbranch;
    private javax.swing.JTextField texaminer;
    private javax.swing.JTextField tregno;
    private javax.swing.JTextField tsubcode;
    private javax.swing.JTextField tyear;
    // End of variables declaration//GEN-END:variables

}
