package exceptions;

import javax.swing.JOptionPane;

/**
 * This class handles exceptions.
 */
public class PolygonException extends Exception {

    public PolygonException() {
    }

    public PolygonException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
