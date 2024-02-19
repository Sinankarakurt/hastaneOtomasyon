package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Helper.*;
import Model.Bashekim;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel w_pane;
	private JTextField fld_hastaTc;
	private JPasswordField fld_hastaPass;
	private JTextField fld_doctorTc;
	private JPasswordField fld_doctorPass;
	private DBConnection conn=new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setTitle("hastaneOtomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("hast.png")));
		lbl_logo.setBounds(179, 0, 100, 55);
		w_pane.add(lbl_logo);

		JLabel lblNewLabel = new JLabel("Hastane Yönetim Sistemine Hoşgeldiniz...");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(79, 52, 312, 29);
		w_pane.add(lblNewLabel);

		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(10, 100, 464, 250);
		w_pane.add(w_tabpane);

		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Hasta Girişi"
				+ "", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);

		JLabel lblTcNumaranz = new JLabel("T.C. Numaranız:");
		lblTcNumaranz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTcNumaranz.setBounds(28, 25, 118, 29);
		w_hastaLogin.add(lblTcNumaranz);

		JLabel lblifre = new JLabel("Şifre:");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre.setBounds(28, 66, 118, 29);
		w_hastaLogin.add(lblifre);

		fld_hastaTc = new JTextField();
		fld_hastaTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		fld_hastaTc.setBounds(156, 25, 259, 29);
		w_hastaLogin.add(fld_hastaTc);
		fld_hastaTc.setColumns(10);

		fld_hastaPass = new JPasswordField();
		fld_hastaPass.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		fld_hastaPass.setBounds(156, 66, 259, 29);
		w_hastaLogin.add(fld_hastaPass);

		JButton btn_register = new JButton("Kayı ol");
		btn_register.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_register.setBounds(28, 157, 183, 37);
		w_hastaLogin.add(btn_register);

		JButton btn_hastaLogin = new JButton("Giriş Yap");
		btn_hastaLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_hastaLogin.setBounds(238, 157, 183, 37);
		w_hastaLogin.add(btn_hastaLogin);

		JPanel w_doktorLogin = new JPanel();
		w_tabpane.addTab("Doktor Girişi", null, w_doktorLogin, null);
		w_doktorLogin.setLayout(null);

		JPanel w_hastaLogin_1 = new JPanel();
		w_hastaLogin_1.setLayout(null);
		w_hastaLogin_1.setBackground(Color.WHITE);
		w_hastaLogin_1.setBounds(0, 0, 459, 222);
		w_doktorLogin.add(w_hastaLogin_1);

		JLabel lblTcNumaranz_1 = new JLabel("T.C. Numaranız:");
		lblTcNumaranz_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblTcNumaranz_1.setBounds(28, 25, 118, 29);
		w_hastaLogin_1.add(lblTcNumaranz_1);

		JLabel lblifre_1 = new JLabel("Şifre:");
		lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre_1.setBounds(28, 66, 118, 29);
		w_hastaLogin_1.add(lblifre_1);

		fld_doctorTc = new JTextField();
		fld_doctorTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		fld_doctorTc.setColumns(10);
		fld_doctorTc.setBounds(156, 25, 259, 29);
		w_hastaLogin_1.add(fld_doctorTc);

		fld_doctorPass = new JPasswordField();
		fld_doctorPass.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		fld_doctorPass.setBounds(156, 66, 259, 29);
		w_hastaLogin_1.add(fld_doctorPass);

		JButton btn_doctorLogin = new JButton("Giriş Yap");
		btn_doctorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (fld_doctorTc.getText().length()==0||fld_doctorPass.getPassword().length==0) 
				{
					//JOptionPane.showMessageDialog(null,"lütfen alanları doldurunuz..");
					Helper.showMsg("fill");
					
				}
				else
				{
					try {
						Connection con=conn.connDb();
						java.sql.Statement st= con.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM user");
						
						while (rs.next()) {
							
	/*						//System.out.println(rs.getString("tcno"));
if (fld_doctorTc.getText().equals(rs.getString("tcno")))
{
	
	System.out.println("selam");
	
	
}*/
							
							char[] passwordChars = fld_doctorPass.getPassword()
;							String password = new String(passwordChars);

							
						if (fld_doctorTc.getText().equals(rs.getString("tcno"))&& password.equals(rs.getString("password")))
						{
						
							Bashekim bhekim=new Bashekim();
							
							bhekim.setId(rs.getInt("id"));
							bhekim.setPassword("password");
							bhekim.setTcno(rs.getString("tcno"));
							bhekim.setName(rs.getString("name"));
							bhekim.setType(rs.getString("type"));
							
							BashekimGUI bGUI=new BashekimGUI(bhekim);
							bGUI.setVisible(true);
							dispose();						
							
						}
							
							
							
						
						}
	
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
					
				}
				
				
			}
		});
		btn_doctorLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_doctorLogin.setBounds(57, 159, 358, 37);
		w_hastaLogin_1.add(btn_doctorLogin);
	}
}