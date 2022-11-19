package managementsystem;
import java.awt.Color;
import java.sql.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import dashboard.*;

public class LogIn extends javax.swing.JFrame {
 static Connection con=null;

  public static void connectors(){
  try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system","root","");
   
  }catch(Exception e){
      e.printStackTrace();
  }
         
        }
  
public LogIn() {
        initComponents();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        brgyname = new javax.swing.JLabel();
        brgyname1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        LogInButton = new javax.swing.JButton();
        errors = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brgyname.setFont(new java.awt.Font("Novecento Bold", 0, 55)); // NOI18N
        brgyname.setForeground(new java.awt.Color(255, 255, 255));
        brgyname.setText("BARANGAY");
        jPanel1.add(brgyname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 640, 60));

        brgyname1.setFont(new java.awt.Font("Novecento Bold", 0, 55)); // NOI18N
        brgyname1.setForeground(new java.awt.Color(255, 255, 255));
        brgyname1.setText("MANAGEMENT SYSTEM");
        jPanel1.add(brgyname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 640, 60));

        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 1080));

        jLabel1.setFont(new java.awt.Font("Novecento Bold", 0, 36)); // NOI18N
        jLabel1.setText("LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 250, 110, 50));

        username.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        username.setBorder(null);
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 330, 430, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 890, 70));

        password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password.setBorder(null);
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 430, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 890, 70));

        LogInButton.setBackground(new java.awt.Color(98, 186, 255));
        LogInButton.setFont(new java.awt.Font("Novecento Bold", 0, 24)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(255, 255, 255));
        LogInButton.setText("LogIn");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LogInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 480, 450, 60));

        errors.setFont(new java.awt.Font("Novecento Book", 1, 14)); // NOI18N
        errors.setForeground(new java.awt.Color(255, 102, 51));
        errors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(errors, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 420, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
       
       try {
           connectors();
       
        PreparedStatement ps;
			ps = con.prepareStatement("SELECT * FROM user_login");
			ResultSet rs = ps.executeQuery();
                        
                        while(rs.next()){
                           if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))) {
							errors.setForeground(Color.GREEN);
                                                        errors.setText("LogIn Successful!");
                                                        homepage page = new homepage();
                                                        page.show();
                                                        dispose();
                                                        
						}else {
							//JOptionPane.showMessageDialog(null, "WRONG CREDENTIALS","Warning!!!",JOptionPane.WARNING_MESSAGE);
						errors.setText("LogIn Unsuccessful!");
                           }
                        }
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
	
    }//GEN-LAST:event_LogInButtonActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
             
                new LogIn().setVisible(true);
            }
        });
    }
        public static ImageIcon setSize(ImageIcon icon, int width, int height){
            
            Image img = icon.getImage();
            Image scale = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon icons = new ImageIcon(scale);
            
            return icons;
            
           
        }
        
        
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogInButton;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel brgyname;
    private javax.swing.JLabel brgyname1;
    private javax.swing.JLabel errors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
