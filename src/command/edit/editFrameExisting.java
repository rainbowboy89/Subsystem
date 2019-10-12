package command.edit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import decoder.FileDecoderEncoder;
import filesystem.FSLoader;
import modules.Out;
import modules.Prefix;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class editFrameExisting {

	private JFrame frame;
	public static String gg = "";
	/**
	 * Launch the application.
	 */
	public static void main(String args0) {
					gg = args0;
					editFrameExisting window = new editFrameExisting();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public editFrameExisting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 540);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 826, 429);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		//load
		boolean first = true;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"rootfs"+FSLoader.currdir+gg));
			String line = reader.readLine();
			while (line != null) {
				//textArea.setText(textArea.getText()+"\n"+line);
				if(first) {
					textArea.setText(FileDecoderEncoder.encode(line)+"\n");
				}else {
					textArea.setText(textArea.getText()+"\n"+FileDecoderEncoder.encode(line));
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//end load
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File("rootfs"+FSLoader.currdir+gg);
				f.delete();
					try {
						f.createNewFile();
						PrintWriter writer = new PrintWriter("rootfs"+FSLoader.currdir+gg, "UTF-8");
						for(String line : textArea.getText().split("\n")) {
							writer.println(FileDecoderEncoder.decode(line));
							writer.flush();
						}
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null , "File Saved!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				
			}
		});
		btnSaveChanges.setBounds(12, 455, 134, 25);
		frame.getContentPane().add(btnSaveChanges);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(741, 455, 97, 25);
		frame.getContentPane().add(btnExit);
		
		
	}
}
