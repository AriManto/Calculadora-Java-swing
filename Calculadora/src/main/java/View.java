import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

class View extends JPanel {
    static JTextField display = new JTextField("");
    static JTextField displayOperador = new JTextField("");


    static void crearVentana() {
        //Opciones básicas
        JFrame ventana = new JFrame();
        ventana.setLayout(new BorderLayout());
        ventana.setTitle("Calculadora");
        ventana.setSize(400, 500); //317,262
        ventana.setResizable(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null); //Centrar la ventana
        View panelExterno = new View();
        ventana.add(panelExterno);
        ventana.setVisible(true);
    }
    private GridBagConstraints gc = new GridBagConstraints();
    private void posicionCelda(int x, int y){ //
        gc.gridx=x;
        gc.gridy=y;
    }
    //Polimorfismo, para más opciones
    private void posicionCelda(int x, int y, double pesox, double pesoy){
        gc.gridx=x;
        gc.gridy=y;
        gc.weightx=pesox;
        gc.weighty=pesoy;
    }
    static void update(){
        display.setText(Controller.input.toString());
        displayOperador.setText(Controller.operacion);
        System.out.println("num1 (acumulado): "+Controller.num1
                +"   num2(nuevo): "+Controller.num2 + "   input:" + Controller.input.toString());
    }
    View(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(66,66,66));
        //Display de operador
        gc.fill=GridBagConstraints.BOTH;
        this.gc.insets= new Insets(5,5,5,0);
        displayOperador.setFont(new Font("Tahoma",Font.PLAIN,30));
        displayOperador.setEditable(false);
        displayOperador.setHorizontalAlignment(SwingConstants.CENTER);
        gc.gridwidth=1;
        gc.gridheight=2;
        posicionCelda(0,0,1,1);
        this.add(displayOperador,gc);

        //Display de numeros
        this.gc.insets= new Insets(5,0,5,5);
        display.setFont(new Font("Tahoma",Font.PLAIN,30));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.CENTER);
        gc.anchor=GridBagConstraints.EAST;
        gc.gridwidth=4;
        gc.gridheight=2;
        posicionCelda(1,0,1,1);
        this.add(display,gc);


        //     -----BOTONES-----
        gc.anchor=GridBagConstraints.CENTER;
        gc.gridwidth=1;
        gc.gridheight=1;
        this.gc.insets= new Insets(1,1,1,1);
        //             Y=2
        //
        JButton allClear = new JButton("AC");
        allClear.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,2);
        allClear.addActionListener(e-> Controller.clickAllClear());
        allClear.setUI(new StyledButtonUI());
        allClear.setBackground(new Color(246,81,29));
        allClear.setForeground(new Color(255,255,255));
        this.add(allClear,gc);
        //
        JButton clear = new JButton("C");
        clear.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,2);
        clear.setBorderPainted(false);
        clear.setFocusPainted(false);
        clear.addActionListener(e-> Controller.clickClear());
        clear.setUI(new StyledButtonUI());
        clear.setBackground(new Color(246,81,29));
        clear.setForeground(new Color(255,255,255));
        this.add(clear,gc);
        //
        JButton raiz = new JButton("√");
        raiz.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,2);
        raiz.addActionListener(e-> Controller.clickRaiz());
        raiz.setUI(new StyledButtonUI());
        raiz.setBackground(new Color(241,143,1));
        this.add(raiz,gc);
        //
        JButton potencia = new JButton("X²");
        potencia.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(3,2);
        potencia.addActionListener(e-> Controller.clickPotencia());
        potencia.setUI(new StyledButtonUI());
        potencia.setBackground(new Color(241,143,1));
        this.add(potencia,gc);


        //               Y=3
        //
        JButton num7 = new JButton("7");
        num7.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,3);
        num7.addActionListener(e->Controller.clickNum7());
        num7.setUI(new StyledButtonUI());
        this.add(num7,gc);
        //
        JButton num8 = new JButton("8");
        num8.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,3);
        num8.addActionListener(e->Controller.clickNum8());
        num8.setUI(new StyledButtonUI());
        this.add(num8,gc);
        //
        JButton num9 = new JButton("9");
        num9.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,3);
        num9.addActionListener(e->Controller.clickNum9());
        num9.setUI(new StyledButtonUI());
        this.add(num9,gc);
        //
        JButton dividir = new JButton("/");
        dividir.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(3,3);
        dividir.addActionListener(e-> Controller.clickDividir());
        dividir.setUI(new StyledButtonUI());
        dividir.setBackground(new Color(241,143,1));
        this.add(dividir,gc);

        //             Y=4
        //
        JButton num4 = new JButton("4");
        num4.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,4);
        num4.addActionListener(e->Controller.clickNum4());
        num4.setUI(new StyledButtonUI());
        this.add(num4,gc);
        //
        JButton num5 = new JButton("5");
        num5.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,4);
        num5.addActionListener(e->Controller.clickNum5());
        num5.setUI(new StyledButtonUI());
        this.add(num5,gc);
        //
        JButton num6 = new JButton("6");
        num6.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,4);
        num6.addActionListener(e->Controller.clickNum6());
        num6.setUI(new StyledButtonUI());
        this.add(num6,gc);
        //
        JButton multiplicar = new JButton("X");
        multiplicar.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(3,4);
        multiplicar.addActionListener(e->Controller.clickMultiplicar());
        multiplicar.setUI(new StyledButtonUI());
        multiplicar.setBackground(new Color(241,143,1));
        this.add(multiplicar,gc);

        //            Y=5
        //
        JButton num1 = new JButton("1");
        num1.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,5);
        num1.addActionListener(e->Controller.clickNum1());
        num1.setUI(new StyledButtonUI());
        this.add(num1,gc);
        //
        JButton num2 = new JButton("2");
        num2.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,5);
        num2.addActionListener(e->Controller.clickNum2());
        num2.setUI(new StyledButtonUI());
        this.add(num2,gc);
        //
        JButton num3 = new JButton("3");
        num3.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,5);
        num3.addActionListener(e->Controller.clickNum3());
        num3.setUI(new StyledButtonUI());
        this.add(num3,gc);
        //
        JButton restar = new JButton("—");
        restar.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(3,5);
        restar.addActionListener(e->Controller.clickRestar());
        restar.setUI(new StyledButtonUI());
        restar.setBackground(new Color(241,143,1));
        this.add(restar,gc);


        //              Y=6
        //
        JButton coma = new JButton(".");
        coma.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,6);
        coma.addActionListener(e->Controller.clickComa());
        coma.setUI(new StyledButtonUI());
        this.add(coma,gc);
        //
        JButton num0 = new JButton("0");
        num0.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,6);
        num0.addActionListener(e->Controller.clickNum0());
        num0.setUI(new StyledButtonUI());
        this.add(num0,gc);
        //
        JButton igual = new JButton("=");
        igual.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,6);
        igual.addActionListener(e-> Controller.clickIgual());
        igual.setUI(new StyledButtonUI());
        this.add(igual,gc);
        //
        JButton sumar = new JButton("+");
        sumar.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(3,6);
        sumar.addActionListener(e->Controller.clickSumar());
        sumar.setUI(new StyledButtonUI());
        sumar.setBackground(new Color(241,143,1));
        this.add(sumar,gc);
    }
}


class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground().darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
    }
}