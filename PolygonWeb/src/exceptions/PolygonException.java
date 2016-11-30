/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author Asger
 */
public class PolygonException extends Exception {

    public PolygonException() {
    }

    public PolygonException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
