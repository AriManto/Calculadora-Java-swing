import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
/*
todo: refactoring code for readibility, limpiar los system out
*/

public class Calculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> View.crearVentana()); //Para que corra en el Event Dispatch Thread
    }
}