package com.evopdf.htmltosvgdemo;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.evopdf.*;

public class GettingStartedDemo {

	private JTextArea textServerIP;
	private JTextArea textServerPort;

	private JTextArea textServicePassword;

	private JFrame frameHtmlToSvg;
	private JTextArea textHtmlViewerWidth;
	private JTextArea textHtmlViewerHeight;
	private JTextArea textTimeout;
	private JTextArea textConversionDelay;

	private JTextArea textUrl;
	private JTextArea textHtml;
	private JTextArea textBaseUrl;

	private byte[] convertHtmlToSvg(boolean convertURL) throws Exception {

		String serverIP = textServerIP.getText();
		int port = Integer.parseInt(textServerPort.getText());

		// create the HTML to SVG converter
		HtmlToSvgConverter htmlToSvgConverter = new HtmlToSvgConverter(serverIP, port);

		// set license key
		htmlToSvgConverter.setLicenseKey("B4mYiJubiJiInoaYiJuZhpmahpGRkZGImg==");

		// set service password if necessary
		if (textServicePassword.getText().length() > 0)
			htmlToSvgConverter.setServicePassword(textServicePassword.getText());

		// set HTML viewer width
		int viewerWidth = Integer.parseInt(textHtmlViewerWidth.getText());
		htmlToSvgConverter.setHtmlViewerWidth(viewerWidth);

		// set HTML viewer height if necessary
		if (textHtmlViewerHeight.getText().length() > 0) {
			int viewerHeight = Integer.parseInt(textHtmlViewerHeight.getText());
			htmlToSvgConverter.setHtmlViewerHeight(viewerHeight);
		}

		// set navigation timeout
		int navigationTimeout = Integer.parseInt(textHtmlViewerWidth.getText());
		htmlToSvgConverter.setNavigationTimeout(navigationTimeout);

		// set conversion delay if necessary
		if (textConversionDelay.getText().length() > 0) {
			int conversionDelay = Integer.parseInt(textConversionDelay.getText());
			htmlToSvgConverter.setConversionDelay(conversionDelay);
		}

		byte[] outSvgBuffer = null;

		if (convertURL) {
			// convert URL to SVG

			String urlToConvert = textUrl.getText();

			outSvgBuffer = htmlToSvgConverter.convertUrl(urlToConvert);
		} else {
			// convert HTML to PDF

			String html = textHtml.getText();
			String baseUrl = textBaseUrl.getText();

			outSvgBuffer = htmlToSvgConverter.convertHtml(html, baseUrl);
		}

		return outSvgBuffer;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GettingStartedDemo window = new GettingStartedDemo();
					window.frameHtmlToSvg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GettingStartedDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHtmlToSvg = new JFrame();
		frameHtmlToSvg.setTitle("EVO HTML to SVG Demo");
		frameHtmlToSvg.setBounds(100, 100, 600, 675);
		frameHtmlToSvg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHtmlToSvg.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Convert URL to SVG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 178, 153, 34);
		frameHtmlToSvg.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter URL to Convert:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 229, 136, 20);
		frameHtmlToSvg.getContentPane().add(lblNewLabel_1);

		textUrl = new JTextArea();
		textUrl.setText("http://www.evopdf.com");
		textUrl.setBounds(156, 230, 407, 22);
		frameHtmlToSvg.getContentPane().add(textUrl);

		JLabel lblConverterSettings = new JLabel("Converter Settings");
		lblConverterSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConverterSettings.setBounds(10, 11, 153, 34);
		frameHtmlToSvg.getContentPane().add(lblConverterSettings);

		JLabel lblHtmlViewerWidth = new JLabel("HTML Viewer Width:");
		lblHtmlViewerWidth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHtmlViewerWidth.setBounds(10, 99, 121, 20);
		frameHtmlToSvg.getContentPane().add(lblHtmlViewerWidth);

		textHtmlViewerWidth = new JTextArea();
		textHtmlViewerWidth.setText("1024");
		textHtmlViewerWidth.setBounds(141, 100, 44, 22);
		frameHtmlToSvg.getContentPane().add(textHtmlViewerWidth);

		JLabel lblPx = new JLabel("px");
		lblPx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPx.setBounds(195, 99, 19, 20);
		frameHtmlToSvg.getContentPane().add(lblPx);

		JLabel lblHtmlViewerHeight = new JLabel("HTML Viewer Height:");
		lblHtmlViewerHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHtmlViewerHeight.setBounds(256, 99, 121, 20);
		frameHtmlToSvg.getContentPane().add(lblHtmlViewerHeight);

		textHtmlViewerHeight = new JTextArea();
		textHtmlViewerHeight.setBounds(387, 100, 44, 22);
		frameHtmlToSvg.getContentPane().add(textHtmlViewerHeight);

		JLabel label_1 = new JLabel("px");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(441, 98, 19, 20);
		frameHtmlToSvg.getContentPane().add(label_1);

		JLabel lblTimeout = new JLabel("Timeout:");
		lblTimeout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTimeout.setBounds(10, 131, 55, 20);
		frameHtmlToSvg.getContentPane().add(lblTimeout);

		textTimeout = new JTextArea();
		textTimeout.setText("60");
		textTimeout.setBounds(72, 132, 44, 22);
		frameHtmlToSvg.getContentPane().add(textTimeout);

		JLabel lblSec = new JLabel("sec");
		lblSec.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSec.setBounds(126, 131, 29, 20);
		frameHtmlToSvg.getContentPane().add(lblSec);

		JLabel lblDelayConversion = new JLabel("Delay Conversion:");
		lblDelayConversion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDelayConversion.setBounds(256, 131, 121, 20);
		frameHtmlToSvg.getContentPane().add(lblDelayConversion);

		textConversionDelay = new JTextArea();
		textConversionDelay.setText("2");
		textConversionDelay.setBounds(387, 132, 44, 22);
		frameHtmlToSvg.getContentPane().add(textConversionDelay);

		JLabel label_2 = new JLabel("sec");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(441, 131, 29, 20);
		frameHtmlToSvg.getContentPane().add(label_2);

		JButton btnConvertUrl = new JButton("Convert URL to SVG");
		btnConvertUrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// convert the URL to a SVG document in a buffer
					byte[] outSvgBuffer = convertHtmlToSvg(true);

					String outFilePath = "EvoHtmlToSvg.svg";

					// write the buffer to a file
					writeBytesToFile(outSvgBuffer, outFilePath);

					Desktop.getDesktop().open(new File(outFilePath));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frameHtmlToSvg,
							String.format("Conversion failed: %1$s", ex.getMessage()));
				}
			}
		});
		btnConvertUrl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConvertUrl.setBounds(10, 265, 185, 23);
		frameHtmlToSvg.getContentPane().add(btnConvertUrl);

		JLabel lblConvertHtmlTo = new JLabel("Convert HTML to SVG");
		lblConvertHtmlTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConvertHtmlTo.setBounds(10, 324, 175, 34);
		frameHtmlToSvg.getContentPane().add(lblConvertHtmlTo);

		JLabel lblEnterHtmlTo = new JLabel("Enter HTML to Convert:");
		lblEnterHtmlTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterHtmlTo.setBounds(10, 375, 153, 20);
		frameHtmlToSvg.getContentPane().add(lblEnterHtmlTo);

		textHtml = new JTextArea();
		textHtml.setWrapStyleWord(true);
		textHtml.setLineWrap(true);
		textHtml.setText(
				"Enter the HTML String to Convert and optionally set a Base URL if the HTML string references external resources by relative URLs");

		JButton btnConvertHtml = new JButton("Convert HTML to SVG");
		btnConvertHtml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// convert the HTML string to a SVG document in a buffer
					byte[] outSvgBuffer = convertHtmlToSvg(false);

					String outFilePath = "EvoHtmlToSvg.svg";

					// write the buffer to a file
					writeBytesToFile(outSvgBuffer, outFilePath);

					Desktop.getDesktop().open(new File(outFilePath));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frameHtmlToSvg,
							String.format("Conversion failed: %1$s", ex.getMessage()));
				}
			}
		});
		btnConvertHtml.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConvertHtml.setBounds(10, 585, 185, 23);
		frameHtmlToSvg.getContentPane().add(btnConvertHtml);

		JLabel lblEnterBaseUrl = new JLabel("Enter Base URL:");
		lblEnterBaseUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterBaseUrl.setBounds(10, 516, 136, 20);
		frameHtmlToSvg.getContentPane().add(lblEnterBaseUrl);

		textBaseUrl = new JTextArea();
		textBaseUrl.setBounds(10, 538, 407, 22);
		frameHtmlToSvg.getContentPane().add(textBaseUrl);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 309, 553, 4);
		frameHtmlToSvg.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 163, 553, 4);
		frameHtmlToSvg.getContentPane().add(separator_1);

		JLabel lblServerIp = new JLabel("Server IP:");
		lblServerIp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServerIp.setBounds(10, 57, 65, 20);
		frameHtmlToSvg.getContentPane().add(lblServerIp);

		textServerIP = new JTextArea();
		textServerIP.setText("127.0.0.1");
		textServerIP.setBounds(72, 58, 113, 22);
		frameHtmlToSvg.getContentPane().add(textServerIP);

		JLabel lblServerPort = new JLabel("Server Port:");
		lblServerPort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServerPort.setBounds(208, 57, 74, 20);
		frameHtmlToSvg.getContentPane().add(lblServerPort);

		textServerPort = new JTextArea();
		textServerPort.setText("40001");
		textServerPort.setBounds(289, 58, 55, 22);
		frameHtmlToSvg.getContentPane().add(textServerPort);

		JLabel lblServicePassword = new JLabel("Service Password:");
		lblServicePassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblServicePassword.setBounds(365, 57, 105, 20);
		frameHtmlToSvg.getContentPane().add(lblServicePassword);

		textServicePassword = new JTextArea();
		textServicePassword.setBounds(469, 58, 94, 22);
		frameHtmlToSvg.getContentPane().add(textServicePassword);

		JScrollPane scrollPaneTextHtml = new JScrollPane(textHtml);
		scrollPaneTextHtml.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTextHtml.setBounds(10, 406, 564, 99);
		frameHtmlToSvg.getContentPane().add(scrollPaneTextHtml);

	}
}
