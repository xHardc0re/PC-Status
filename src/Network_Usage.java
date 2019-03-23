import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Cursor;

import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress; //Vivliothiki pou mas epitrepei na mporoume na diavasoume IP dieuthinseis
import java.net.UnknownHostException; //Vivliothiki pou dinei error otan eisagoume lathos IP deuthinsi
import java.util.GregorianCalendar; //vivliothiki pou mas dinei akrivh wra kai hmeromhnia gia na mporesoume na upologisoume se posh wra stilame to ping paketo


public class Network_Usage {

	private JFrame frmNetworkUsage;
	private JTextField textField;

	/**
	 * ksekinima tou programatos.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Network_Usage window = new Network_Usage();
					window.frmNetworkUsage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Network_Usage() throws UnknownHostException {
		initialize();

	}

	public JFrame getFrame() {
		return frmNetworkUsage;
	}

	public void setFrame(JFrame frame) {
		this.frmNetworkUsage = frame;
	}

	/**
	 * Oles oi rithmiseis gia auto to frame.
	 */
	
	private void initialize() throws UnknownHostException {
		frmNetworkUsage = new JFrame();
		frmNetworkUsage.setResizable(false);
		frmNetworkUsage.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Users\\xHardc0re\\Documents\\Stuff\\Java Program\\PC Status\\images\\logo.png"));
		frmNetworkUsage.setTitle("Ping Test");
		frmNetworkUsage.setBounds(100, 100, 450, 280);
		frmNetworkUsage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNetworkUsage.getContentPane().setLayout(null);
		
  		final JLabel lblPing = new JLabel();
		lblPing.setVisible(false);
  		
		/**
		 * Dimiourgia koumpiou "ping test" kai tou action pou kalei to koumpi.
		 */
		
  		lblPing.setBounds(92, 39, 214, 14);
		frmNetworkUsage.getContentPane().add(lblPing);
  		
		JButton btnPingTest = new JButton("Ping Test");
		btnPingTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPingTest.setBounds(92, 64, 89, 23);
		frmNetworkUsage.getContentPane().add(btnPingTest);
		btnPingTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {
			    	String ip = textField.getText(); //pairnoume thn IP pou eisagame apo to text field se tipo string.
			        String ipAddress = ip;
			        InetAddress inet = InetAddress.getByName(ipAddress); //metatrepoume thn ip apo tipo string se tipo InetAddress
			        
			        long finish = 0;
			        long start = new GregorianCalendar().getTimeInMillis(); //Pairnoume ton xrono auth th stigmh se milliseconds
			        if (inet.isReachable(5000)){ //ean to paketo ftasei se perithorio 5000 milliseconds tote sinexizei 
			          finish = new GregorianCalendar().getTimeInMillis(); //pernoume ton sinoliko xrono pou ekane to paketo na ftasei se milliseconds

				  		long ping=finish-start; //afairoume ton arxiko xrono(otan arxisame to ping test) apo ton teliko xrono gia na paroume to apotelesma
				  		String x=Long.toString(ping); //metatrepoume to ping se string gia na mporesoume na to valoume sto label mas
				  		lblPing.setText("Ping: "+ x + "ms");
						lblPing.setVisible(true); //to label emfanizete mono otan exoume apotelesma
			        } else {
			        	lblPing.setText("This IP is not reachable");
			        	lblPing.setVisible(true); //to label emfanizete mono otan exoume apotelesma
			        }
			      } catch ( Exception e ) {
			        System.out.println("Exception: Wrong IP " + e.getMessage()); //otan vazoume lathos ip
			      }
			}
		});
		
		/**
		 * Dimiourgia JLabel.
		 */
		
		JLabel lblIpAddress = new JLabel("IP Address: ");
		lblIpAddress.setBounds(10, 11, 71, 14);
		frmNetworkUsage.getContentPane().add(lblIpAddress);
		
		/**
		 * Dimiourgia JTextField.
		 */
		
		textField = new JTextField();
		textField.setBounds(92, 8, 143, 20);
		frmNetworkUsage.getContentPane().add(textField);
		textField.setColumns(10);
		      

	
		}
	}
