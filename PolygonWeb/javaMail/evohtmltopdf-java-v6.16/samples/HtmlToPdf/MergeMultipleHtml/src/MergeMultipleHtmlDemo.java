package com.evopdf.htmltopdfdemo;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.evopdf.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MergeMultipleHtmlDemo {

	private JFrame frameMergeMultipleHtml;

	private JTextArea textServerIP;
	private JTextArea textServerPort;

	private JTextArea textServicePassword;

	private JTextArea textFirstUrl;
	private JTextArea textSecondUrl;

	private JCheckBox chckbxStartSecondOnNewPage;

	private byte[] createPdfDocument() throws Exception {
		String serverIP = textServerIP.getText();
		int port = Integer.parseInt(textServerPort.getText());

		// create a document
		Document pdfDocument = new Document(serverIP, port);

		// set license key
		pdfDocument.setLicenseKey("B4mYiJubiJiInoaYiJuZhpmahpGRkZGImg==");

		// set service password if necessary
		if (textServicePassword.getText().length() > 0)
			pdfDocument.setServicePassword(textServicePassword.getText());

		// add a page to PDF document
		PdfPage firstPdfPage = pdfDocument.addPage();

		// create the first HTML to PDF element
		HtmlToPdfElement firstHtml = new HtmlToPdfElement(0, 0, textFirstUrl.getText());

		// optionally set a delay before conversion to allow asynchronous
		// scripts to finish
		firstHtml.setConversionDelay(2);

		// add the first HTML to PDF document
		firstPdfPage.addElement(firstHtml);

		// create the second HTML to PDF element
		HtmlToPdfElement secondHtml = new HtmlToPdfElement(0, 0, textSecondUrl.getText());

		// optionally set a delay before conversion to allow asynchronous
		// scripts to finish
		secondHtml.setConversionDelay(2);

		if (chckbxStartSecondOnNewPage.isSelected()) {
			// create a PDF page where to add the second HTML
			PdfPage secondPdfPage = pdfDocument.addPage();

			// add the second HTML to PDF element
			secondPdfPage.addElement(secondHtml);
		} else {
			// adds the second HTML to PDF element
			// with an offset of 10 points under the first HTML
			pdfDocument.addElement(secondHtml, 10);
		}

		// save the PDF document in a memory buffer
		byte[] outPdfBuffer = pdfDocument.save();

		return outPdfBuffer;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MergeMultipleHtmlDemo window = new MergeMultipleHtmlDemo();
					window.frameMergeMultipleHtml.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void writeBytesToFile(byte[] bytes, String outFilePath) throws Exception {
		// write the bytes into a file
		OutputStream fs = null;
		try {
			fs = new FileOutputStream(outFilePath);
			fs.write(bytes, 0, bytes.length);
		} catch (Exception ex) {
			throw new Exception(
					String.format("Could not write the output file '%1$s' : %2$s", outFilePath, ex.getMessage()));
		} finally {
			if (fs != null)
				fs.close();
		}
	}

	/**
	 * Create the application.
	 */
	public MergeMultipleHtmlDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMergeMultipleHtml = new JFrame();
		frameMergeMultipleHtml.setTitle("Merge Multiple HTML Documents in a PDF");
		frameMergeMultipleHtml.setBounds(100, 100, 600, 400);
		frameMergeMultipleHtml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMergeMultipleHtml.getContentPane().setLayout(null);

		JLabel label = new JLabel("Converter Settings");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 11, 153, 34);
		frameMergeMultipleHtml.getContentPane().add(label);

		JLabel label_1 = new JLabel("Server IP:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 57, 65, 20);
		frameMergeMultipleHtml.getContentPane().add(label_1);

		textServerIP = new JTextArea();
		textServerIP.setText("127.0.0.1");
		textServerIP.setBounds(72, 59, 115, 22);
		frameMergeMultipleHtml.getContentPane().add(textServerIP);

		JLabel label_2 = new JLabel("Server Port:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(208, 57, 74, 20);
		frameMergeMultipleHtml.getContentPane().add(label_2);

		textServerPort = new JTextArea();
		textServerPort.setText("40001");
		textServerPort.setBounds(289, 59, 55, 22);
		frameMergeMultipleHtml.getContentPane().add(textServerPort);

		JLabel label_3 = new JLabel("Service Password:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(365, 57, 105, 20);
		frameMergeMultipleHtml.getContentPane().add(label_3);

		textServicePassword = new JTextArea();
		textServicePassword.setBounds(469, 59, 94, 22);
		frameMergeMultipleHtml.getContentPane().add(textServicePassword);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 102, 553, 4);
		frameMergeMultipleHtml.getContentPane().add(separator);

		JLabel lblFirstHtmlPage = new JLabel("First HTML Page URL:");
		lblFirstHtmlPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstHtmlPage.setBounds(10, 117, 136, 20);
		frameMergeMultipleHtml.getContentPane().add(lblFirstHtmlPage);

		textFirstUrl = new JTextArea();
		textFirstUrl.setText("http://www.evopdf.com");
		textFirstUrl.setBounds(10, 148, 407, 22);
		frameMergeMultipleHtml.getContentPane().add(textFirstUrl);

		JButton btnCreatePdf = new JButton("Create PDF");
		btnCreatePdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// create the PDF document in a buffer
					byte[] outPdfBuffer = createPdfDocument();

					String outFilePath = "EvoMergeMultipleHtml.pdf";

					// write the buffer to a file
					writeBytesToFile(outPdfBuffer, outFilePath);

					Desktop.getDesktop().open(new File(outFilePath));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frameMergeMultipleHtml,
							String.format("Conversion failed: %1$s", ex.getMessage()));
				}
			}
		});
		btnCreatePdf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreatePdf.setBounds(10, 307, 185, 23);
		frameMergeMultipleHtml.getContentPane().add(btnCreatePdf);

		JLabel lblSecondHtmlPage = new JLabel("Second HTML Page URL:");
		lblSecondHtmlPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSecondHtmlPage.setBounds(10, 189, 177, 20);
		frameMergeMultipleHtml.getContentPane().add(lblSecondHtmlPage);

		textSecondUrl = new JTextArea();
		textSecondUrl.setText("http://www.google.com");
		textSecondUrl.setBounds(10, 220, 407, 22);
		frameMergeMultipleHtml.getContentPane().add(textSecondUrl);

		chckbxStartSecondOnNewPage = new JCheckBox("Start the second HTML on a new PDF page");
		chckbxStartSecondOnNewPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxStartSecondOnNewPage.setBounds(10, 261, 334, 23);
		frameMergeMultipleHtml.getContentPane().add(chckbxStartSecondOnNewPage);
	}

}
