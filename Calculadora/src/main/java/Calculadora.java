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


class Controller{
    static private String error = "No se puede dividir por 0";
    static private boolean comaFlag=false;
    static String operacion;
    static private boolean operacionFlag=true;
    static private boolean primerNumero=true;
    static boolean exponenteFlag=false;
    static private boolean blockInput=false;
    static boolean signoFlag=false;
    static double num1=0;
    static double num2=0;
    static StringBuffer input= new StringBuffer();


    static private String getDisplay(){
        return View.display.getText();
    }
    static private void operar(){
        if (primerNumero){
            num1=num2;
            try{num1 = Double.parseDouble(input.toString());}
            catch(NumberFormatException e){}
            primerNumero=false;
        }
        else { //NO PRIMER NUMERO
            if (input.toString().equals("")){
            exponenteFlag=false;
            }
            else {num2=Double.parseDouble(input.toString());}//INPUT ASIGNADO
            switch (operacion) {
                case "x":
                    num1 = num1 * num2;
                    break;
                case "+":
                    num1 = num1 + num2;
                    break;
                case "-":
                    num1 = num1 - num2;
                    break;
                case "/":
                    num1 = num1 / num2;
                    break;
                case "=": num2=0;
                        //if(exponenteFlag){exponenteFlag=false;num1=num2;}
                        //else{num2=0;input.delete(0,input.length());}
                    break;
            }
        }
        View.display.setText(Double.toString(num1));
        View.displayOperador.setText(operacion);
        input.delete(0,input.length());
        System.out.printf("Primer numero %b , operacion %s, num1 %f num2 %f, input %s\n",primerNumero,operacion, num1,num2,input.toString());
    }

    static void clickPotencia() {
            comaFlag=false;
            if (input.toString().equals("")){ //String null
                if ((num2 == 0)&& !(num1==0)) {//
                    num2 = Math.pow(num1, 2);
                } else if ((num2 == 0)&& (num1==0)) {//
                num2 = Math.pow(num2, 2);
                }
                else if (!(num2 == 0)&& !(num1==0)) {//
                num2 = Math.pow(num2, 2);
                }
            }
            else {  //Caso standard
                num2 = Double.parseDouble(input.toString());
                num2 = Math.pow(num2, 2);
            }
            View.display.setText(Double.toString(num2));
            input.delete(0,input.length());
            exponenteFlag = true;
            blockInput=true;
            System.out.println("Potencia");
    }

    static void clickRaiz() {
        comaFlag=false;
        if (input.toString().equals("")){ //String null
            if ((num2 == 0)&& !(num1==0)) {//
                num2 = Math.sqrt(num1);
            } else if ((num2 == 0)&& (num1==0)) {//
                num2 = Math.sqrt(num2);
            }
            else if (!(num2 == 0)&& !(num1==0)) {//
                num2 = Math.sqrt(num2);
            }
        }
        else {  //Caso standard
            num2 = Double.parseDouble(input.toString());
            num2 = Math.sqrt(num2);
        }
        View.display.setText(Double.toString(num2));
        input.delete(0,input.length());
        exponenteFlag = true;
        blockInput=true;
        System.out.println("Raiz");
    }

    static void clickAllClear() {
        System.out.println("AllClear");
        input.delete(0,input.length());
        num1=0;
        num2=0;
        operacion="";
        View.update();
        exponenteFlag=false;
        comaFlag=false;
        operacionFlag=false;
        blockInput=false;
        primerNumero=true;
    }

    static void clickClear() {
        System.out.println("Clear");
        input.delete(0,input.length());
        num2=0;
        blockInput=true;
        if (num1==0){View.display.setText(""); blockInput=false;}//
        else {View.display.setText(Double.toString(num1));}
        View.displayOperador.setText("");
        comaFlag=false;
        operacionFlag=false;
        operacion="";
        exponenteFlag=false;

    }

    static void clickDividir() {
        if (!operacionFlag){
            if(!blockInput||blockInput&&primerNumero){operar();}
            blockInput=false;
            operacion = "/";
            View.displayOperador.setText(operacion);
            operacionFlag = true;
            comaFlag=false;
            System.out.println("Dividir");
        }
    }

    static void clickMultiplicar() {
        if (!operacionFlag){
            operacionFlag = true;
            comaFlag=false;
            if(!blockInput||blockInput&&primerNumero){operar();}
            blockInput=false;
            operacion = "x";
            View.displayOperador.setText(operacion);
            //input.append("*");
            System.out.println("X");
        }
    }

    static void clickRestar() {
        if (input.toString().equals("")&&operacionFlag){
            input.append("-");
            signoFlag=true;
            View.update();
            blockInput=false;
        }
        else if (!operacionFlag){
            operacionFlag = true;
            comaFlag=false;
            System.out.println("-");
            if(!blockInput){operar();}
            operacion = "-";
            View.displayOperador.setText(operacion);
            blockInput=false;
        }
    }

    static void clickSumar() {
        if (!operacionFlag) {
            operacionFlag = true;
            comaFlag=false;
            System.out.println("+");
            if(!blockInput||blockInput&&primerNumero){operar();}
            operacion = "+";
            View.displayOperador.setText(operacion);
            blockInput=false;
        }
    }

    static void clickNum9() {
        if(!blockInput) {
            input.append("9");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum8() {
        if(!blockInput) {
            input.append("8");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum7() {
        if(!blockInput){
            input.append("7");
            View.update();
            operacionFlag=false;
        }
    }

    static void clickNum6() {
        if(!blockInput) {
            input.append("6");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum5() {
        if(!blockInput) {
            input.append("5");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum4() {
        if(!blockInput) {
            input.append("4");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum3() {
        if(!blockInput) {
            input.append("3");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum2() {
        if(!blockInput) {
            input.append("2");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum1() {
        if(!blockInput) {
            input.append("1");
            View.update();
            operacionFlag = false;
        }
    }

    static void clickNum0() {
        if(!blockInput) {
            if (!(getDisplay().equals("0") || getDisplay().equals("") || getDisplay().equals(error))) {
                System.out.println("0");
                input.append("0");
                View.update();
                operacionFlag = false;
            }
        }
    }

    static void clickComa() {
        if (!comaFlag&&!blockInput) {
            if (getDisplay().equals("")||getDisplay().equals(error)) {
                input.delete(0,input.length());
                input.append("0.");
                View.update();
                comaFlag = true;
            } else {
                input.append(".");
                View.update();
                comaFlag = true;
            }
            System.out.println(".");
        }
    }

    static void clickIgual(){

        operar();
        operacion="=";
        View.display.setText(Double.toString(num1));
        View.displayOperador.setText(Controller.operacion);
        blockInput=true;
        System.out.println("input "+ input);
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