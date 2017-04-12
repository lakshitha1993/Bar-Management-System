/*
 * curstock.java
 *
 * Created on April 30, 2013, 5:30 PM
 */
package BMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Owner
 */
public class curstock extends javax.swing.JFrame {

    /** Creates new form curstock */
    public curstock() {
        initComponents();
        curstock();
    }

    void curstock() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            Connection a = DB.createConnection();
            ResultSet r = a.createStatement().executeQuery("select * from stock ");

            boolean b = false;
            while (r.next()) {
                b = true;
                Vector v = new Vector();
                v.add(r.getString("itemid"));
                v.add(r.getString("itemname"));
                v.add(r.getString("pup"));
                v.add(r.getString("sup"));
                v.add(r.getString("qty"));
                dtm.addRow(v);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CURRENT STOCK");
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item id", "Item name", "Pup", "Sup", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 452, 402);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BMS/01022_grassbycosmic_2560x1600.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-18, -50, 1080, 690);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-480)/2, (screenSize.height-457)/2, 480, 457);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new curstock().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}