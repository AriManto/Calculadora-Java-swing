import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
//todo: apariencia de botones
//todo: bug de "si num1 !=0 y num2 !=0 e input "", potencia agarra y guarda num2"
//todo: refactoring code for readibility, limpiar los system out

public class Calculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> View.crearVentana()); //Para que corra en el Event Dispatch Thread
    }
}


