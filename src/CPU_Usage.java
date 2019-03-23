import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.hyperic.sigar.CpuPerc; //Anoikei sth vivliothikh ths Hyperic kai mas epitrepei na paroume to cpu usage %
import org.hyperic.sigar.Sigar; //Anoikei sth vivliothikh ths Hyperic
import org.hyperic.sigar.SigarException; //Anoikei sth vivliothikh ths Hyperic
import java.awt.Toolkit;
import javax.swing.JProgressBar;

public class CPU_Usage {

	JFrame frmCpuUsage;

	/**
	 * ksekinima tou programatos.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPU_Usage window = new CPU_Usage();
					window.frmCpuUsage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CPU_Usage() throws SigarException {
		initialize();
	}

	/**
	 * Oles oi rithmiseis gia auto to frame.
	 */
	
	private void initialize() throws SigarException {
		frmCpuUsage = new JFrame();
		frmCpuUsage.setTitle("CPU Usage");
		frmCpuUsage.setResizable(false);
		frmCpuUsage.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Users\\xHardc0re\\Documents\\Stuff\\Java Program\\PC Status\\images\\logo.png"));
		frmCpuUsage.setBounds(100, 100, 450, 280);
		frmCpuUsage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCpuUsage.getContentPane().setLayout(null);
		
		/**
		 * Dimiourgia antikimenou "Sigar" kai antistixisi tou getCpuPerc() se metavliti.
		 */
		
		Sigar sigar = new Sigar();
		CpuPerc cpuperc = null;
		cpuperc = sigar.getCpuPerc();

		/**
		 * Dimiourgia JLabel.
		 */
		
		JLabel lblCpuModel = new JLabel("CPU Available Cores: " + Runtime.getRuntime().availableProcessors()); //h methodos Runtime.getRuntime().availableProcessors() mas dinei posous logikous kai fisikous pirines exoume diathesimous
		lblCpuModel.setBounds(10, 27, 422, 22);
		frmCpuUsage.getContentPane().add(lblCpuModel);
		
		/**
		 * Dimiourgia JLabel.
		 */
		
		JLabel lblCpuLoad = new JLabel("CPU Load: "+Math.round(cpuperc.getCombined()*100)+"%"); //Xrisimopoihsame th Math.round giati to noumero alliws tha htan terastio. To cpuperc.getCombined() mas dinei mazi to usage kai gia logikous kai gia fisikous pirines
		lblCpuLoad.setBounds(10, 51, 422, 14);
		frmCpuUsage.getContentPane().add(lblCpuLoad);
		
		/**
		 * Dimiourgia JProgressBar.
		 */
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(100, 51, 146, 14);
		frmCpuUsage.getContentPane().add(progressBar);
		progressBar.setValue((int) Math.round(cpuperc.getCombined()*100)); //To apotelesma tou cpu usage se ProgressBar
		
		/**
		 * Dimiourgia JLabel.
		 */
		
		org.hyperic.sigar.CpuInfo[] cpuInfoList = sigar.getCpuInfoList(); 
		for(org.hyperic.sigar.CpuInfo info : cpuInfoList){
		JLabel lblCpuModel_1 = new JLabel("CPU Model: "+info.getModel());
		lblCpuModel_1.setBounds(10, 11, 432, 14);
		frmCpuUsage.getContentPane().add(lblCpuModel_1);

	}
}
}
