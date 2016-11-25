package com.evopdf.htmltoimagedemo;

import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JScrollPane;

import com.evopdf.*;

public class GettingStartedDemo {

	private JFrame frameHtmlToImage;

	private JTextArea textServerIP;
	private JTextArea textServerPort;

	private JTextArea textServicePassword;

	private JTextArea textHtmlViewerWidth;
	private JTextArea textHtmlViewerHeight;
	private JTextArea textTimeout;
	private JTextArea textConversionDelay;

	private JTextArea textUrl;
	private JTextArea textHtml;
	private JTextArea textBaseUrl;

	private JComboBox comboBoxImageFormat;
	private JCheckBox chckbxTransparentBackground;

	private byte[] convertHtmlToImage(boolean convertURL, ImageType imageType) throws Exception {

		String serverIP = textServerIP.getText();
		int port = Integer.parseInt(textServerPort.getText());

		// create the HTML to Image converter
		HtmlToImageConverter htmlToImageConverter = new HtmlToImageConverter(serverIP, port);

		// set license key
		htmlToImageConverter.setLicenseKey("B4mYiJubiJiInoaYiJuZhpmahpGRkZGImg==");

		// set service password if necessary
		if (textServicePassword.getText().length() > 0)
			htmlToImageConverter.setServicePassword(textServicePassword.getText());

		// set HTML viewer width
		int viewerWidth = Integer.parseInt(textHtmlViewerWidth.getText());
		htmlToImageConverter.setHtmlViewerWidth(viewerWidth);

		// set HTML viewer height if necessary
		if (textHtmlViewerHeight.getText().length() > 0) {
			int viewerHeight = Integer.parseInt(textHtmlViewerHeight.getText());
			htmlToImageConverter.setHtmlViewerHeight(viewerHeight);
		}

		// set navigation timeout
		int navigationTimeout = Integer.parseInt(textHtmlViewerWidth.getText());
		htmlToImageConverter.setNavigationTimeout(navigationTimeout);

		// set conversion delay if necessary
		if (textConversionDelay.getText().length() > 0) {
			int conversionDelay = Integer.parseInt(textConversionDelay.getText());
			htmlToImageConverter.setConversionDelay(conversionDelay);
		}

		// optionally for PNG image set if the background is transparent
		if (imageType == ImageType.Png)
			htmlToImageConverter.setTransparentBackground(chckbxTransparentBackground.isSelected());

		byte[] outImageBuffer = null;

		if (convertURL) {
			// convert URL to Image

			String urlToConvert = textUrl.getText();

			outImageBuffer = htmlToImageConverter.convertUrl(urlToConvert, imageType);
		} else {
			// convert HTML to Image

			String html = textHtml.getText();
			String baseUrl = textBaseUrl.getText();

			outImageBuffer = htmlToImageConverter.convertHtml(html, baseUrl, imageType);
		}

		return outImageBuffer;
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

	private ImageType selectedImageType() {
		String imageTypeName = comboBoxImageFormat.getSelectedItem().toString();
		if (imageTypeName == "Png")
			return ImageType.Png;
		if (imageTypeName == "Jpg")
			return ImageType.Jpeg;
		if (imageTypeName == "Bmp")
			return ImageType.Bmp;

		return ImageType.Png;
	}

	private String getImageFileExtension(ImageType imageType) {
		if (imageType == ImageType.Png)
			return "png";
		if (imageType == ImageType.Jpeg)
			return "jpg";
		if (imageType == ImageType.Bmp)
			return "bmp";
		if (imageType == ImageType.Gif)
			return "gif";
		if (imageType == ImageType.Icon)
			return "ico";
		if (imageType == ImageType.Tiff)
			return "tiff";

		return "png";
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GettingStartedDemo window = new GettingStartedDemo();
					window.frameHtmlToImage.setVisible(true);
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
		frameHtmlToImage = new JFrame();
		frameHtmlToImage.setTitle("EVO HTML to Image Demo");
		frameHtmlToImage.setBounds(100, 100, 600, 775);
		frameHtmlToImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHtmlToImage.getContentPane().setLayout(null);

		JLabel label = new JLabel("Converter Settings");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 11, 153, 34);
		frameHtmlToImage.getContentPane().add(label);

		JLabel label_1 = new JLabel("Server IP:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 57, 65, 20);
		frameHtmlToImage.getContentPane().add(label_1);

		textServerIP = new JTextArea();
		textServerIP.setText("127.0.0.1");
		textServerIP.setBounds(72, 58, 113, 22);
		frameHtmlToImage.getContentPane().add(textServerIP);

		JLabel label_2 = new JLabel("Server Port:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(208, 57, 74, 20);
		frameHtmlToImage.getContentPane().add(label_2);

		textServerPort = new JTextArea();
		textServerPort.setText("40001");
		textServerPort.setBounds(289, 58, 55, 22);
		frameHtmlToImage.getContentPane().add(textServerPort);

		JLabel label_3 = new JLabel("Service Password:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(365, 57, 105, 20);
		frameHtmlToImage.getContentPane().add(label_3);

		textServicePassword = new JTextArea();
		textServicePassword.setBounds(469, 58, 94, 22);
		frameHtmlToImage.getContentPane().add(textServicePassword);

		JLabel label_4 = new JLabel("HTML Viewer Width:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(10, 99, 121, 20);
		frameHtmlToImage.getContentPane().add(label_4);

		textHtmlViewerWidth = new JTextArea();
		textHtmlViewerWidth.setText("1024");
		textHtmlViewerWidth.setBounds(141, 100, 44, 22);
		frameHtmlToImage.getContentPane().add(textHtmlViewerWidth);

		JLabel label_5 = new JLabel("px");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(195, 99, 19, 20);
		frameHtmlToImage.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("HTML Viewer Height:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(256, 99, 121, 20);
		frameHtmlToImage.getContentPane().add(label_6);

		textHtmlViewerHeight = new JTextArea();
		textHtmlViewerHeight.setBounds(387, 100, 44, 22);
		frameHtmlToImage.getContentPane().add(textHtmlViewerHeight);

		JLabel label_7 = new JLabel("px");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(441, 98, 19, 20);
		frameHtmlToImage.getContentPane().add(label_7);

		JLabel label_8 = new JLabel("Timeout:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_8.setBounds(10, 131, 55, 20);
		frameHtmlToImage.getContentPane().add(label_8);

		textTimeout = new JTextArea();
		textTimeout.setText("60");
		textTimeout.setBounds(72, 132, 44, 22);
		frameHtmlToImage.getContentPane().add(textTimeout);

		JLabel label_9 = new JLabel("sec");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_9.setBounds(126, 131, 29, 20);
		frameHtmlToImage.getContentPane().add(label_9);

		JLabel label_10 = new JLabel("Delay Conversion:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_10.setBounds(256, 131, 121, 20);
		frameHtmlToImage.getContentPane().add(label_10);

		textConversionDelay = new JTextArea();
		textConversionDelay.setText("2");
		textConversionDelay.setBounds(387, 132, 44, 22);
		frameHtmlToImage.getContentPane().add(textConversionDelay);

		JLabel label_11 = new JLabel("sec");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_11.setBounds(441, 131, 29, 20);
		frameHtmlToImage.getContentPane().add(label_11);

		JLabel lblConvertUrlTo = new JLabel("Convert URL to Image");
		lblConvertUrlTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConvertUrlTo.setBounds(10, 270, 215, 34);
		frameHtmlToImage.getContentPane().add(lblConvertUrlTo);

		JLabel label_13 = new JLabel("Enter URL to Convert:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(10, 321, 136, 20);
		frameHtmlToImage.getContentPane().add(label_13);

		textUrl = new JTextArea();
		textUrl.setText("http://www.evopdf.com");
		textUrl.setBounds(156, 322, 407, 22);
		frameHtmlToImage.getContentPane().add(textUrl);

		JButton btnConvertUrlToImage = new JButton("Convert URL to Image");
		btnConvertUrlToImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					// get output image format
					ImageType imageType = selectedImageType();

					// convert the URL to an Image in a buffer
					byte[] outImageBuffer = convertHtmlToImage(true, imageType);

					String outFilePath = "EvoHtmlToImage." + getImageFileExtension(imageType);

					// write the buffer to a file
					writeBytesToFile(outImageBuffer, outFilePath);

					Desktop.getDesktop().open(new File(outFilePath));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frameHtmlToImage,
							String.format("Conversion failed: %1$s", ex.getMessage()));
				}
			}
		});
		btnConvertUrlToImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConvertUrlToImage.setBounds(10, 357, 185, 23);
		frameHtmlToImage.getContentPane().add(btnConvertUrlToImage);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 255, 553, 4);
		frameHtmlToImage.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 401, 553, 4);
		frameHtmlToImage.getContentPane().add(separator_1);

		JLabel lblConvertHtmlTo = new JLabel("Convert HTML to Image");
		lblConvertHtmlTo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConvertHtmlTo.setBounds(10, 416, 231, 34);
		frameHtmlToImage.getContentPane().add(lblConvertHtmlTo);

		JLabel label_15 = new JLabel("Enter HTML to Convert:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(10, 467, 153, 20);
		frameHtmlToImage.getContentPane().add(label_15);

		textHtml = new JTextArea();
		textHtml.setWrapStyleWord(true);
		textHtml.setText(
				"Enter the HTML String to Convert and optionally set a Base URL if the HTML string references external resources by relative URLs");
		textHtml.setLineWrap(true);

		JLabel label_16 = new JLabel("Enter Base URL:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(10, 608, 136, 20);
		frameHtmlToImage.getContentPane().add(label_16);

		textBaseUrl = new JTextArea();
		textBaseUrl.setBounds(10, 630, 407, 22);
		frameHtmlToImage.getContentPane().add(textBaseUrl);

		JButton btnConvertHtmlToImage = new JButton("Convert HTML to Image");
		btnConvertHtmlToImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// get output image format
					ImageType imageType = selectedImageType();

					// convert the HTML string to an Image document in a buffer
					byte[] outImageBuffer = convertHtmlToImage(false, imageType);

					String outFilePath = "EvoHtmlToImage." + getImageFileExtension(imageType);

					// write the buffer to a file
					writeBytesToFile(outImageBuffer, outFilePath);

					Desktop.getDesktop().open(new File(outFilePath));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frameHtmlToImage,
							String.format("Conversion failed: %1$s", ex.getMessage()));
				}
			}
		});
		btnConvertHtmlToImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConvertHtmlToImage.setBounds(10, 677, 185, 23);
		frameHtmlToImage.getContentPane().add(btnConvertHtmlToImage);

		JLabel lblImageSettings = new JLabel("Image Settings");
		lblImageSettings.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImageSettings.setBounds(10, 172, 204, 34);
		frameHtmlToImage.getContentPane().add(lblImageSettings);

		JLabel lblImageFormat = new JLabel("Image Format:");
		lblImageFormat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImageFormat.setBounds(10, 211, 87, 20);
		frameHtmlToImage.getContentPane().add(lblImageFormat);

		comboBoxImageFormat = new JComboBox();
		comboBoxImageFormat.setModel(new DefaultComboBoxModel(new String[] { "Png", "Jpg", "Bmp" }));
		comboBoxImageFormat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxImageFormat.setBounds(107, 211, 116, 20);
		frameHtmlToImage.getContentPane().add(comboBoxImageFormat);

		chckbxTransparentBackground = new JCheckBox("Transparent Background");
		chckbxTransparentBackground.setSelected(true);
		chckbxTransparentBackground.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTransparentBackground.setBounds(256, 208, 175, 23);
		frameHtmlToImage.getContentPane().add(chckbxTransparentBackground);

		comboBoxImageFormat.setSelectedItem("Png");

		JScrollPane scrollPaneTextHtml = new JScrollPane(textHtml);
		scrollPaneTextHtml.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTextHtml.setBounds(10, 489, 564, 108);
		frameHtmlToImage.getContentPane().add(scrollPaneTextHtml);
	}
}
