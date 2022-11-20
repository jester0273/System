package managementsystem;
import java.awt.Color;
import java.sql.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import dashboard.*;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Toolkit;
import terms_condition.terms;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RescaleOp;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;

public class LogIn extends javax.swing.JFrame {
 static Connection con=null;
 static int height=0,width=0;
 static  byte [] b;
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
         screenSize();
         transparent();
         logo();
    }
public void logo(){
    try {
         
         connectors();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM system_info");
         ResultSet rs = ps.executeQuery();
        
         while(rs.next()){
             b = rs.getBytes("logo");
             
             //transparent(i);
             ImageIcon i = new ImageIcon(b);
             Image ii = i.getImage();
             Image iii = ii.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
             ImageIcon iv = new ImageIcon(iii);
             logo.setIcon(iv);
            
             
             
         }
     } catch (Exception ex) {
         Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
     }
}
public void screenSize(){
       Toolkit tk = Toolkit.getDefaultToolkit();
         width = (int)tk.getScreenSize().getWidth();
         height = (int)tk.getScreenSize().getHeight();
        Insets task = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int h  = task.bottom;
        setSize(width,height-h);
}
BufferedImage bim;
    public  void transparent(){
     try {
         /*new File(System.getProperty("user.dir")+"\\src\\images\\LOGO JOLLY CODE PNG.png")*/
      connectors();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM system_info");
         ResultSet rs = ps.executeQuery();
        byte[] bs=null;
         while(rs.next()){
             bs = rs.getBytes("logo");
         }
      InputStream is = new ByteArrayInputStream(bs);
       bim = ImageIO.read(is);
          BufferedImage img = new BufferedImage(bim.getWidth(), bim.getHeight(),BufferedImage.TYPE_INT_ARGB);
          Graphics2D createGraphics = img.createGraphics();
            createGraphics.drawImage(bim, null ,0, 0);
          float alp[] = new float[]{1f,1f,1f,.50f};
          float def[] = new float[]{0,0,0,0};
          RescaleOp f = new RescaleOp(alp,def,null);
          BufferedImage fil = f.filter(img, null);
          ImageIcon i = new ImageIcon(fil);
          Image ii = i.getImage();
          Image iii = ii.getScaledInstance(logo1.getWidth(), logo1.getHeight(), Image.SCALE_DEFAULT);
          ImageIcon iv = new ImageIcon(iii);
          logo1.setIcon(iv);
     } catch (Exception ex) {
         Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brgyname = new javax.swing.JLabel();
        MainFrame = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        LogInButton = new javax.swing.JButton();
        errors = new javax.swing.JLabel();
        ForgotPass = new javax.swing.JLabel();
        termsAndCondition = new javax.swing.JLabel();
        check = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        brgyname.setFont(new java.awt.Font("Novecento Bold", 0, 55)); // NOI18N
        brgyname.setForeground(new java.awt.Color(255, 255, 255));
        brgyname.setText("BARANGAY");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new Dimension(height,width));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainFrame.setMinimumSize(new java.awt.Dimension(1920, 1080));
        MainFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        MainFrame.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 150, 140));

        jLabel8.setFont(new java.awt.Font("Novecento Book", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("EFFIECIENCY AT ITS BEST");
        MainFrame.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 420, -1));
        MainFrame.add(logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 50, 700, 650));

        jLabel10.setFont(new java.awt.Font("Novecento Bold", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("JollyCode Management System");
        MainFrame.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Novecento Wide UltraLight", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TEAM JOLLYCODE | COPYRIGHT 2022");
        MainFrame.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1040, -1, 30));

        bg.setForeground(new java.awt.Color(255, 255, 255));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bg.png"))); // NOI18N
        MainFrame.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 1100));

        jLabel1.setFont(new java.awt.Font("Novecento Bold", 0, 36)); // NOI18N
        jLabel1.setText("Good Day!");
        MainFrame.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 210, 50));

        username.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        username.setBorder(null);
        username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        MainFrame.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 280, 430, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel2.setToolTipText("");
        MainFrame.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 460, 70));

        password.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password.setBorder(null);
        MainFrame.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 360, 430, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jLabel3.setToolTipText("");
        MainFrame.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 350, 460, 70));

        LogInButton.setBackground(new java.awt.Color(98, 186, 255));
        LogInButton.setFont(new java.awt.Font("Novecento Bold", 0, 24)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(255, 255, 255));
        LogInButton.setText("LogIn");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });
        MainFrame.add(LogInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 450, 60));

        errors.setFont(new java.awt.Font("Novecento Book", 1, 14)); // NOI18N
        errors.setForeground(new java.awt.Color(255, 102, 51));
        errors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MainFrame.add(errors, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 250, 420, 30));

        ForgotPass.setFont(new java.awt.Font("Novecento Bold", 2, 12)); // NOI18N
        ForgotPass.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ForgotPass.setText("Forgot Password?");
        MainFrame.add(ForgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 420, 140, 20));

        termsAndCondition.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        termsAndCondition.setForeground(new java.awt.Color(0, 112, 253));
        termsAndCondition.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        termsAndCondition.setText("Terms, Condition, & Polices");
        termsAndCondition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        termsAndCondition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                termsAndConditionMouseClicked(evt);
            }
        });
        MainFrame.add(termsAndCondition, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 540, 170, 20));

        check.setText("I agree with the ");
        MainFrame.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 540, 120, -1));

        jLabel5.setText("of Barangay Jollycode");
        MainFrame.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 560, -1, 30));

        jLabel6.setFont(new java.awt.Font("Novecento Wide UltraLight", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Copyright JollyCode 2022");
        MainFrame.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 1040, -1, 30));

        jLabel7.setFont(new java.awt.Font("Novecento Bold", 0, 36)); // NOI18N
        jLabel7.setText("LOGIN");
        MainFrame.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 210, 110, 50));

        getContentPane().add(MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 1940, 730));

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

    private void termsAndConditionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termsAndConditionMouseClicked
        // TODO add your handling code here:
        terms t = new terms();
        t.show();
        dispose();
    }//GEN-LAST:event_termsAndConditionMouseClicked

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
    private javax.swing.JLabel ForgotPass;
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel brgyname;
    public static javax.swing.JCheckBox check;
    private javax.swing.JLabel errors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel termsAndCondition;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
