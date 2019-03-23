import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;


public class RAM_Usage {

	private JFrame frmRamusage;

	/**
	 * ksekinima tou programatos.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RAM_Usage window = new RAM_Usage();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RAM_Usage() {
		initialize();
	}

	/**
	 * Oles oi rithmiseis gia auto to frame.
	 */
	
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 280);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRamusage.getContentPane().setLayout(null);
		
		JLabel lblMaxMemory = new JLabel("Max Memory available to JVM: "+Runtime.getRuntime().maxMemory()/1048576+" MBs"); //me th Runtime.getRuntime().maxMemory() pairnoume to sinoliko megethos ths ram se bytes kai epita to dieroume me to 1024*1024=1048576 gia na to paroume se megabytes
		lblMaxMemory.setBounds(10, 11, 483, 14);
		frmRamusage.getContentPane().add(lblMaxMemory);
		
		JLabel lblFreeMemory = new JLabel("Free Memory available to JVM: " +Runtime.getRuntime().freeMemory()/1048576+ " MBs"); //antistixa gia edw
		lblFreeMemory.setBounds(10, 36, 483, 14);
		frmRamusage.getContentPane().add(lblFreeMemory);
	}

	public JFrame getFrame() {
		return frmRamusage;
	}

	public void setFrame(JFrame frame) {
		this.frmRamusage = frame;
		frmRamusage.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Users\\xHardc0re\\Documents\\Stuff\\Java Program\\PC Status\\images\\logo.png"));
		frmRamusage.setResizable(false);
		frmRamusage.setTitle("RAM Usage");
	}
}
