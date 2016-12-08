package data;

import com.evopdf.HtmlToPdfConverter;
import com.evopdf.PdfPageOrientation;
import com.evopdf.PdfPageSize;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class CreateRapport {

    private byte[] convertHtmlToPdf(int buildingID) throws Exception {
        String serverIP = "127.0.0.1";
        int port = 40001;

        // create the HTML to PDF converter
        HtmlToPdfConverter htmlToPdfConverter = new HtmlToPdfConverter(serverIP, port);

        // set license key
        htmlToPdfConverter.setLicenseKey("B4mYiJubiJiInoaYiJuZhpmahpGRkZGImg==");

        // set HTML viewer height if necessary
        int viewerHeight = 4600;
        htmlToPdfConverter.setHtmlViewerHeight(viewerHeight);

        // set navigation timeout
        int navigationTimeout = 60;
        htmlToPdfConverter.setNavigationTimeout(navigationTimeout);

        // set conversion delay if necessary
        int conversionDelay = 1;
        htmlToPdfConverter.setConversionDelay(conversionDelay);

        // set PDF page size
        htmlToPdfConverter.pdfDocumentOptions().setPdfPageSize(PdfPageSize.A3);

        // set PDF page orientation
        htmlToPdfConverter.pdfDocumentOptions().setPdfPageOrientation(PdfPageOrientation.Portrait);

        // set margins
        int leftMargin = 15;
        htmlToPdfConverter.pdfDocumentOptions().setLeftMargin(leftMargin);

        int rightMargin = 0;
        htmlToPdfConverter.pdfDocumentOptions().setRightMargin(rightMargin);

        int topMargin = 40;
        htmlToPdfConverter.pdfDocumentOptions().setTopMargin(topMargin);

        int bottomMargin = 0;
        htmlToPdfConverter.pdfDocumentOptions().setBottomMargin(bottomMargin);

        byte[] outPdfBuffer = null;

        // convert URL to PDF
        String urlToConvert = "http://vetterlain.dk/PolygonWeb/FrontController?ID=LinkServlet&page=rapport.jsp&buildingID=" + buildingID + "&newRapport&pdf";

        outPdfBuffer = htmlToPdfConverter.convertUrl(urlToConvert);

        return outPdfBuffer;
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
            if (fs != null) {
                fs.close();
            }
        }
    }

    /**
     * Create PDF file of rapport
     *
     * @param buildingID
     * @param buildingName
     * @throws Exception
     */
    public void createPDF(int buildingID, String buildingName) throws Exception {
        try {
            // convert the URL to a PDF document in a buffer
            byte[] outPdfBuffer = convertHtmlToPdf(buildingID);
            String outFilePath = "C:\\Users\\Asger\\Desktop\\Datamatiker\\Polygon\\PolygonWeb\\web\\files\\pdf\\buildingRapport_" + buildingName + buildingID + ".pdf";
            //String outFilePath = "C:\\temp\\buildingRapport_" + buildingName + buildingID + ".pdf";
            // write the buffer to a file
            writeBytesToFile(outPdfBuffer, outFilePath);
            Desktop.getDesktop().open(new File(outFilePath));
        } catch (Exception ex) {
            System.out.println(String.format("Conversion failed: %1$s", ex.getMessage()));
            throw new Exception("Could not create pdf file: " + ex.getMessage());
        }
    }
}
