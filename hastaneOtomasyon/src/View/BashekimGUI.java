package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Bashekim;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BashekimGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	static Bashekim bashekim =new Bashekim();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dTcno;
	private JPasswordField fld_dPass;
	private JTextField fld_DocotID;
	private JTable table_doctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BashekimGUI frame = new BashekimGUI(bashekim);
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
	public BashekimGUI(Bashekim bashekim) {
		setTitle("Hastane Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz Sayın"+" "+bashekim.getName());
		lblNewLabel.setBounds(10, 11, 317, 39);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.setBounds(598, 11, 115, 39);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBackground(Color.WHITE);
		w_tab.setBounds(10, 86, 703, 364);
		w_pane.add(w_tab);
		
		JPanel w_doctor = new JPanel();
		w_doctor.setBackground(Color.WHITE);
		w_tab.addTab("Doktor Yönetimi", null, w_doctor, null);
		w_doctor.setLayout(null);
		
		JLabel label = new JLabel("Ad Soyad");
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		label.setBounds(476, 11, 103, 26);
		w_doctor.add(label);
		
		fld_dName = new JTextField();
		fld_dName.setBounds(476, 36, 212, 26);
		w_doctor.add(fld_dName);
		fld_dName.setColumns(10);
		
		JLabel label_1 = new JLabel("T.C.No");
		label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		label_1.setBounds(476, 66, 103, 26);
		w_doctor.add(label_1);
		
		fld_dTcno = new JTextField();
		fld_dTcno.setColumns(10);
		fld_dTcno.setBounds(476, 92, 212, 26);
		w_doctor.add(fld_dTcno);
		
		JLabel label_2 = new JLabel("Şifre");
		label_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		label_2.setBounds(476, 117, 70, 26);
		w_doctor.add(label_2);
		
		fld_dPass = new JPasswordField();
		fld_dPass.setBounds(476, 146, 212, 26);
		w_doctor.add(fld_dPass);
		
		JLabel label_3 = new JLabel("Kullanıcı ID\r\n");
		label_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		label_3.setBounds(476, 220, 103, 19);
		w_doctor.add(label_3);
		
		JButton btn_addDoctor = new JButton("Ekle\r\n");
		btn_addDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_addDoctor.setBackground(Color.LIGHT_GRAY);
		btn_addDoctor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_addDoctor.setBounds(476, 183, 212, 26);
		w_doctor.add(btn_addDoctor);
		
		JButton btn_delDoctor = new JButton("Sil");
		btn_delDoctor.setBackground(Color.LIGHT_GRAY);
		btn_delDoctor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btn_delDoctor.setBounds(476, 285, 212, 26);
		w_doctor.add(btn_delDoctor);
		
		fld_DocotID = new JTextField();
		fld_DocotID.setBackground(Color.LIGHT_GRAY);
		fld_DocotID.setColumns(10);
		fld_DocotID.setBounds(476, 250, 212, 26);
		w_doctor.add(fld_DocotID);
		
		JScrollPane w_scroolDoctor = new JScrollPane();
		w_scroolDoctor.setBounds(10, 11, 456, 300);
		w_doctor.add(w_scroolDoctor);
		
		table_doctor = new JTable();
		w_scroolDoctor.setViewportView(table_doctor);
	}
}
