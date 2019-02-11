/**
 *
 * @author: Ariel Manto
 * @date: 11/02/2019
 * @version: 1.2.0
 *
 * TODO: Mejorar legibilidad, reusabilidad de codigo
 *
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;


public class Calculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> View.crearVentana()); //Para que corra en el Event Dispatch Thread
    }
}