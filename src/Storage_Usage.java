import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.io.File;


public class Storage_Usage {

	private JFrame frmStorageUtilization;

	/**
	 * ksekinima tou programatos.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Storage_Usage window = new Storage_Usage();
					window.frmStorageUtilization.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Storage_Usage() {
		initialize();
	}

	public JFrame getFrmStorageUtilization() {
		return frmStorageUtilization;
	}

	/**
	 * Oles oi rithmiseis gia auto to frame.
	 */
	
	private void initialize() {
		frmStorageUtilization = new JFrame();
		frmStorageUtilization.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Users\\xHardc0re\\Documents\\Stuff\\Java Program\\PC Status\\images\\logo.png"));
		frmStorageUtilization.setResizable(false);
		frmStorageUtilization.setTitle("Storage Usage");
		frmStorageUtilization.setBounds(100, 100, 450, 280);
		frmStorageUtilization.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStorageUtilization.getContentPane().setLayout(null);
    	File file = new File("c:");
    	long totalSpace = file.getTotalSpace(); //h getTotalSpace() epistrefei ton sinoliko xwro diskou pou vriskete to arxeio pou trexoume se bytes.
    	@SuppressWarnings("unused")
		long usableSpace = file.getUsableSpace(); //epistrefei ton eleuthero xwro se bytes pou einai diathesimos.
    	long freeSpace = file.getFreeSpace(); //epistrefei ton eleuthero xwro se bytes pou einai diathesimos.
    	
		JLabel lblNewLabel = new JLabel("Total Usable Space: " + totalSpace/1048576 + " MBs");
		lblNewLabel.setBounds(10, 11, 422, 14);
		frmStorageUtilization.getContentPane().add(lblNewLabel);
		
		JLabel lblFreeSpace = new JLabel("Free Space: "+ freeSpace/1048576 + " MBs");
		lblFreeSpace.setBounds(10, 36, 422, 14);
		frmStorageUtilization.getContentPane().add(lblFreeSpace);
		
		JLabel lblprimaryDriveOnly = new JLabel("*Primary drive only");
		lblprimaryDriveOnly.setBounds(10, 87, 422, 14);
		frmStorageUtilization.getContentPane().add(lblprimaryDriveOnly);
	}
}
