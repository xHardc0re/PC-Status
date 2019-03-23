import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import org.hyperic.sigar.SigarException; //Anoikei sth vivliothikh ths Hyperic kai mas epitrepei na paroume sxedon ola ta apotelesmata pou xriazomaste gia auto to programa


public class Frame_1 {

	private JFrame frmPcStatus;
	private JTextField txtV;

	/**
	 * Ksekinima tou programatos.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_1 window = new Frame_1();
					window.frmPcStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Dimiourgia tou "Frame_1" pou einai to kentriko frame.
	 */
	public Frame_1() {
		initialize();
	}

	/**
	 * Oles oi rithmiseis gia to "Frame_1".
	 */
	private void initialize() {
		frmPcStatus = new JFrame();
		frmPcStatus.setResizable(false);
		frmPcStatus.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmPcStatus.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\logo.png"));
		frmPcStatus.setForeground(Color.LIGHT_GRAY);
		frmPcStatus.setTitle("PC Status");
		frmPcStatus.setBounds(100, 100, 650, 580);
		frmPcStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		frmPcStatus.setJMenuBar(menuBar);
		
		/**
		 * Dimiourgia koumpiou "screenshot" kai tou action pou kalei to koumpi.
		 */
		JButton btnNewButton_1 = new JButton("Screenshot");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setToolTipText("Captures a screenshot on your current location");
		menuBar.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Screenshot captured on your current location.", "Screenshot", JOptionPane.INFORMATION_MESSAGE);
				try {
					captureScreen("Screenshot.png");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		/**
		 * Dimiourgia koumpiou "Help" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_3 = new JButton("Help");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(btnNewButton_3);
		frmPcStatus.getContentPane().setLayout(null);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Distixos den egrapsa kati edo giati variomoun :(", "Error 404 oreksi gia grapsimo not found", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		/**
		 * Dimiourgia textfield.
		*/
		
		txtV = new JTextField();
		txtV.setBounds(0, 504, 642, 20);
		txtV.setText("Developed by Omada Piravlos");
		frmPcStatus.getContentPane().add(txtV);
		txtV.setColumns(10);
		
		/**
		 * Dimiourgia JPanel.
		*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Support Us", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(246, 433, 176, 46);
		frmPcStatus.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/**
		 * Dimiourgia koumpiou "Donate" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setToolTipText("GIVE US YOUR MONEYYY");
		btnDonate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDonate.setBounds(6, 16, 160, 23);
		panel_1.add(btnDonate);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmPcStatus, "Thanks for your support, now we can feed ourselves with TIDE.");
			}
		});
		
		/**
		 * Dimiourgia JPanel.
		*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Actions", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(259, 262, 134, 102);
		frmPcStatus.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		/**
		 * Dimiourgia koumpiou "Shut Down" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_2 = new JButton("Shut Down");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\shutdown.png"));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setToolTipText("Shuts down the computer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int reply = JOptionPane.showConfirmDialog(null, "Would you like to turn off your computer ?", "Shut down", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			            Runtime runtime = Runtime.getRuntime();
			            try {
							@SuppressWarnings("unused")
							Process proc = runtime.exec("shutdown -s -t 0");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			            System.exit(0);
			        }
			        else {
			           //do nothing
			        }
			}
		});
		btnNewButton_2.setBounds(10, 16, 118, 23);
		panel_2.add(btnNewButton_2);
		
		/**
		 * Dimiourgia koumpiou "Restart" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_7 = new JButton("Restart");
		btnNewButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_7.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\restart.png"));
		btnNewButton_7.setToolTipText("Reboots the computer");
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setBounds(10, 46, 118, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int reply = JOptionPane.showConfirmDialog(null, "Would you like to restart your computer ?", "Restart", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			            Runtime runtime = Runtime.getRuntime();
			            try {
							@SuppressWarnings("unused")
							Process proc = runtime.exec("shutdown /r -t 0");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			            System.exit(0);
			        }
			        else {
			           //do nothing
			        }
			}
		});
		panel_2.add(btnNewButton_7);
		
		/**
		 * Dimiourgia koumpiou "Hibernate" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_5 = new JButton("Hibernate");
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\hibernate.png"));
		btnNewButton_5.setToolTipText("Puts the computer into sleep mode");
		btnNewButton_5.setBounds(10, 74, 118, 23);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int reply = JOptionPane.showConfirmDialog(null, "Would you like to put your computer into sleep mode ?", "Hibernate", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
			            Runtime runtime = Runtime.getRuntime();
			            try {
							@SuppressWarnings("unused")
							Process proc = runtime.exec("shutdown /h -t 0");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
			            System.exit(0);
			        }
			        else {
			           //do nothing
			        }
			}
		});
		panel_2.add(btnNewButton_5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Utilization", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(164, 102, 327, 80);
		frmPcStatus.getContentPane().add(panel);
		panel.setLayout(null);
		
		/**
		 * Dimiourgia koumpiou "Memory" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnRamUsage = new JButton("Memory");
		btnRamUsage.setHorizontalAlignment(SwingConstants.LEFT);
		btnRamUsage.setBounds(6, 50, 146, 23);
		panel.add(btnRamUsage);
		btnRamUsage.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\ram.png"));
		btnRamUsage.setToolTipText("Displays RAM Utilization");
		btnRamUsage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRamUsage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RAM_Usage ram = null;
				ram = new RAM_Usage();
				ram.getFrame().setVisible(true);
			}
		});
		
		/**
		 * Dimiourgia koumpiou "Ping Test" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_6 = new JButton("Ping Test");
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton_6.setBounds(162, 50, 155, 23);
		panel.add(btnNewButton_6);
		btnNewButton_6.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\network.png"));
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setToolTipText("Starts a Ping test");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Network_Usage ntwk = null;
				try {
					ntwk = new Network_Usage();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ntwk.getFrame().setVisible(true);
			}
		});
		
		/**
		 * Dimiourgia koumpiou "Processor" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton = new JButton("Processor");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(6, 16, 146, 23);
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\cpu.png"));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setToolTipText("Displays CPU Utilization");
		
		/**
		 * Dimiourgia koumpiou "Storage" kai tou action pou kalei to koumpi.
		 */
		
		JButton btnNewButton_4 = new JButton("Storage");
		btnNewButton_4.setToolTipText("Displays Storage Utilization");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setIcon(new ImageIcon("F:\\Programs\\Eclipse\\Projects\\Images\\PC Status\\storage.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Storage_Usage su = null;
				su = new Storage_Usage();
				su.getFrmStorageUtilization().setVisible(true);
			}
		});

		btnNewButton_4.setBounds(162, 16, 155, 23);
		panel.add(btnNewButton_4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CPU_Usage cpu = null;
				try {
					cpu = new CPU_Usage();
				} catch (SigarException e) {
					e.printStackTrace();
				}
				cpu.frmCpuUsage.setVisible(true);
			}
		});
	}
	
	/**
	 * H void pou kalei to koumpi "screenshot" gia na dimiourgisei ena arxeio .png me to stigmiotipo pou fenete sthn othonh ekeinh th stigmh.
	 */
	
	public void captureScreen(String fileName) throws Exception {
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize);
		   Robot robot = new Robot();
		   BufferedImage image = robot.createScreenCapture(screenRectangle);
		   ImageIO.write(image, "png", new File(fileName));
	}
}
