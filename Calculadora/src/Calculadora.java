/* Necesito:
* -botones del 0 al 9
* -botones para -, x, +, /, ., =
* -boton de borrar el numero actual, y boton de borrar todo
* -labels: numero actual (y resultado). numero anterior(acumulado)y la operacion que
 * se va a realizar.*/

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;


public class Calculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> View.crearVentana());
        Double test = Double.parseDouble("37.5");
        System.out.println(test);
    }
}


class View extends JPanel {
    static JTextField display = new JTextField("");

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
        String salida = Double.toString(Controller.num2);
        display.setText(Controller.input.toString());
        System.out.println("num2 "+Controller.num2);
        System.out.println("num1 "+Controller.num1);
    }
     View(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(66,66,66));
        gc.fill=GridBagConstraints.BOTH;
        this.gc.insets= new Insets(5,5,5,5);
        display.setFont(new Font("Tahoma",Font.PLAIN,30));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        gc.anchor=GridBagConstraints.EAST;
        gc.gridwidth=4;
        gc.gridheight=2;
        posicionCelda(0,0,1,1);
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
        this.add(allClear,gc);
        //
        JButton clear = new JButton("C");
        clear.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,2);
        clear.setBorderPainted(false);
        clear.setFocusPainted(false);
        clear.addActionListener(e-> Controller.clickClear());
        this.add(clear,gc);
        //
         JButton raiz = new JButton("√");
         raiz.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(2,2);
         raiz.addActionListener(e-> Controller.clickRaiz());
         this.add(raiz,gc);
        //
         JButton potencia = new JButton("X²");
         potencia.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(3,2);
         potencia.addActionListener(e-> Controller.clickPotencia());
         this.add(potencia,gc);


        //               Y=3
        //
        JButton num7 = new JButton("7");
        num7.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,3);
        num7.addActionListener(e->Controller.clickNum7());
        this.add(num7,gc);
        //
        JButton num8 = new JButton("8");
        num8.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,3);
        num8.addActionListener(e->Controller.clickNum8());
        this.add(num8,gc);
        //
        JButton num9 = new JButton("9");
        num9.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,3);
        num9.addActionListener(e->Controller.clickNum9());
        this.add(num9,gc);
         //
         JButton dividir = new JButton("/");
         dividir.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(3,3);
         dividir.addActionListener(e-> Controller.clickDividir());
         this.add(dividir,gc);

        //Y=4
        //
        JButton num4 = new JButton("4");
        num4.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,4);
        num4.addActionListener(e->Controller.clickNum4());
        this.add(num4,gc);
        //
        JButton num5 = new JButton("5");
        num5.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,4);
        num5.addActionListener(e->Controller.clickNum5());
        this.add(num5,gc);
        //
        JButton num6 = new JButton("6");
        num6.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,4);
        num6.addActionListener(e->Controller.clickNum6());
        this.add(num6,gc);
        //
         JButton multiplicar = new JButton("X");
         multiplicar.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(3,4);
         multiplicar.addActionListener(e->Controller.clickMultiplicar());
         this.add(multiplicar,gc);

        //Y=5
        //
        JButton num1 = new JButton("1");
        num1.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(0,5);
        num1.addActionListener(e->Controller.clickNum1());
        this.add(num1,gc);
        //
        JButton num2 = new JButton("2");
        num2.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,5);
        num2.addActionListener(e->Controller.clickNum2());
        this.add(num2,gc);
        //
        JButton num3 = new JButton("3");
        num3.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,5);
        num3.addActionListener(e->Controller.clickNum3());
        this.add(num3,gc);
        //
         JButton restar = new JButton("—");
         restar.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(3,5);
         restar.addActionListener(e->Controller.clickRestar());
         this.add(restar,gc);


        //Y=6
        //
         JButton coma = new JButton(".");
         coma.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(0,6);
         coma.addActionListener(e->Controller.clickComa());
         this.add(coma,gc);
        //
        JButton num0 = new JButton("0");
        num0.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(1,6);
        num0.addActionListener(e->Controller.clickNum0());
        this.add(num0,gc);
        //

        //
        JButton igual = new JButton("=");
        igual.setFont(new Font("Tahoma",Font.PLAIN,20));
        posicionCelda(2,6);
        igual.addActionListener(e-> {
            try {
                Controller.clickIgual();
            } catch (ScriptException e1) {
                e1.printStackTrace();
            }
        });
        this.add(igual,gc);
         JButton sumar = new JButton("+");
         sumar.setFont(new Font("Tahoma",Font.PLAIN,20));
         posicionCelda(3,6);
         sumar.addActionListener(e->Controller.clickSumar());
         this.add(sumar,gc);
    }
}


class Controller{
    static String error = "No se puede dividir por 0";
    static boolean comaFlag=false;
    static String operacion;
    static boolean operacionFlag=false;
    static double num1=0;
    static double num2=0;
    static StringBuffer input= new StringBuffer();


    static String getDisplay(){
        return View.display.getText();
    }
    static void operar(){
        num1 = Double.parseDouble(input.delete(input.length()-1,input.length()).toString());
        input.delete(0,input.length());
        switch(operacion){
            case "*":num2=num1*num2;
            break;
            case "+":num1=num1+num2;
            break;
            case "-":num1=num1-num2;
            break;
            case "/":num1=num1/num2;
            break;
            case "raiz": num2=Math.sqrt(num2);
            break;
            case "potencia": num2=Math.pow(num2,2);
            break;
        }
        operacionFlag=false;
        operacion="";
        View.update();
    }

    static void clickPotencia() {
        System.out.println("Potencia");
        if (!operacionFlag){
            operacion = "potencia";
            operacionFlag = true;
            comaFlag=false;
            //input.append("");
            operar();
        }
    }

    static void clickAllClear() {
        System.out.println("AllClear");
        input.delete(0,input.length());
        num1=0;
        num2=0;
        View.update();
        comaFlag=false;
        operacionFlag=false;
        operacion="";
    }

    static void clickClear() {
        System.out.println("Clear");
        input.delete(0,input.length());
        View.update();
        comaFlag=false;
        operacionFlag=false;
        operacion="";
    }


    static void clickDividir() {
        System.out.println("Dividir");
        if (!operacionFlag){
            operacion = "/";
            operacionFlag = true;
            comaFlag=false;
            input.append("/");
            operar();
        }
    }

    static void clickRaiz() {
        System.out.println("Raiz");
        if (!operacionFlag){
            operacion = "raiz";
            operacionFlag = true;
            comaFlag=false;
            //input.append("");
            operar();
        }
    }

    static void clickNum7() {
        System.out.println("7");
        input.append("7");
        View.update();
        operacionFlag=false;
    }

    static void clickNum8() {
        System.out.println("8");
        input.append("8");
        View.update();
        operacionFlag=false;
    }

    static void clickNum9() {
        System.out.println("9");
        input.append("9");
        View.update();
        operacionFlag=false;
    }

    static void clickMultiplicar() {
        System.out.println("X");
        if (!operacionFlag){
            operacion = "x";
            operacionFlag = true;
            comaFlag=false;
            input.append("*");
            operar();
        }
    }

    static void clickNum4() {
        System.out.println("4");
        input.append("4");
        View.update();
        operacionFlag=false;
    }

    static void clickNum5() {
        System.out.println("5");
        input.append("5");
        View.update();

        operacionFlag=false;
    }

    static void clickNum6() {
        System.out.println("6");
        input.append("6");
        View.update();
        operacionFlag=false;
    }

    static void clickRestar() {
        if (!(operacionFlag||getDisplay().equals("-")||getDisplay().equals(error))){
            operacion = "-";
            operacionFlag = true;
            comaFlag=false;
            System.out.println("-");
            input.append("-");
            operar();
        }
    }

    static void clickNum1() {
        System.out.println("1");
        input.append("1");
        View.update();
        operacionFlag=false;
    }

    static void clickNum2() {
        input.append("2");
        View.update();
        operacionFlag=false;
    }

    static void clickNum3() {
        System.out.println("3");
        input.append("3");
        View.update();
        operacionFlag=false;
    }

    static void clickSumar() {
        if (!(operacionFlag||getDisplay().equals("")||getDisplay().equals(error))) {
            operacion = "+";
            operacionFlag = true;
            comaFlag=false;
            System.out.println("+");
            input.append("+");
            operar();
        }

    }

    static void clickNum0() {

        if(!(getDisplay().equals("0")||getDisplay().equals("")||getDisplay().equals(error))){
            System.out.println("0");
            input.append("0");
            View.update();
            operacionFlag=false;
        }
    }

    static void clickComa() {
        if (!comaFlag) {
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

    static void clickIgual() throws ScriptException {
        System.out.println("=");
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object parcial = engine.eval(getDisplay());

        View.display.setText(parcial.toString());
    }
}