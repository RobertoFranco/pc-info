package pcinfo;

import java.net.Inet4Address;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto.franco
 */
public class PCInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            // Local host info
            InetAddress localHost = Inet4Address.getLocalHost();
            
            /* Create and display the dialog */
            java.awt.EventQueue.invokeLater(() -> {
                MainDialog dialog = new MainDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                dialog.setIPAddress(localHost.getHostAddress());
                dialog.setHostname(localHost.getHostName());
                dialog.setUsername(System.getProperty("user.name"));
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
