package com.evopdf.htmltopdfdemo;

import com.evopdf.HtmlToPdfConverter;
import com.evopdf.PdfPageOrientation;
import com.evopdf.PdfPageSize;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLWriter;
import javax.xml.ws.spi.http.HttpContext;

public class htmlToPdf {
   
    
    public byte[] convertHtmlToPdf(boolean convertURL) throws Exception {
		String serverIP = "127.0.0.1";
		int port = 40001;

		// create the HTML to PDF converter
		HtmlToPdfConverter htmlToPdfConverter = new HtmlToPdfConverter(serverIP, port);

		// set license key
		htmlToPdfConverter.setLicenseKey("B4mYiJubiJiInoaYiJuZhpmahpGRkZGImg==");

		// set service password if necessary
//                if (textServicePassword.getText().length() > 0)
//                    htmlToPdfConverter.setServicePassword(textServicePassword.getText());

		// set HTML viewer width
		int viewerWidth = 1024;
		htmlToPdfConverter.setHtmlViewerWidth(viewerWidth);

		// set HTML viewer height if necessary
//		if (textHtmlViewerHeight.getText().length() > 0) {
//			int viewerHeight = Integer.parseInt(textHtmlViewerHeight.getText());
//			htmlToPdfConverter.setHtmlViewerHeight(viewerHeight);
//		}

		// set navigation timeout
		int navigationTimeout = 60;
		htmlToPdfConverter.setNavigationTimeout(navigationTimeout);

		// set conversion delay if necessary
//		if (textConversionDelay.getText().length() > 0) {
			int conversionDelay = 2;
			htmlToPdfConverter.setConversionDelay(conversionDelay);
//		}

		// set PDF page size
		htmlToPdfConverter.pdfDocumentOptions().setPdfPageSize(PdfPageSize.A4);

		// set PDF page orientation
		htmlToPdfConverter.pdfDocumentOptions().setPdfPageOrientation(PdfPageOrientation.Portrait);

		// set margins
		int leftMargin = 0;
		htmlToPdfConverter.pdfDocumentOptions().setLeftMargin(leftMargin);

		int rightMargin = 0;
		htmlToPdfConverter.pdfDocumentOptions().setRightMargin(rightMargin);

		int topMargin = 0;
		htmlToPdfConverter.pdfDocumentOptions().setTopMargin(topMargin);

		int bottomMargin = 0;
		htmlToPdfConverter.pdfDocumentOptions().setBottomMargin(bottomMargin);

		byte[] outPdfBuffer = null;

//		if (convertURL) {
//			// convert URL to PDF
//
//			String urlToConvert = textUrl.getText();
//
//			outPdfBuffer = htmlToPdfConverter.convertUrl(urlToConvert);
//		} else {
			// convert HTML to PDF

			String html = getUrlSource("http://localhost:8084/PolygonWeb/rapport.html");
			String baseUrl = "rapport.html";

			outPdfBuffer = htmlToPdfConverter.convertHtml(html, baseUrl);
//		}

		return outPdfBuffer;
	}
    
     private static String getUrlSource(String url) throws IOException {
            URL urlpath = new URL(url);
            URLConnection u = urlpath.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    u.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder a = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                a.append(inputLine);
            in.close();

            return a.toString();
        }
     
    public void writeBytesToFile(byte[] bytes, String outFilePath) throws Exception {
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
}