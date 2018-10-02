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
         //String salida = Double.toString(Controller.num2);
        display.setText(Controller.input.toString());
        System.out.println("num2 (input): "+Controller.num2
                +"   num1(acumulado): "+Controller.num1 + "   pantalla:" + Controller.input.toString());
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
    static boolean primerNumero=true;
    static boolean signoFlag=false;
    static double num1=0;
    static double num2=0;
    static StringBuffer input= new StringBuffer();


    static String getDisplay(){
        return View.display.getText();
    }
    static void operar(){
        if (primerNumero){
            num1 = Double.parseDouble(input.toString());
            primerNumero=false;
        }
        else {
            if (operacion.equals("=")){
                num2=0;
            }
            else try {
                num2 = Double.parseDouble(input.toString());
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
                        if (num2==0){View.display.setText("BIJA");return;}
                        else {num1 = num1 / num2;}
                        break;
                    case "raiz":
                        num2 = Math.sqrt(num2);
                        break;
                    //case "potencia":
                        //num2 = Math.pow(num2, 2);
                        //break;
                    case "=": num2=0; input.delete(0,input.length());
                        break;
                }
            } catch (NumberFormatException e){}
        }
        //operacionFlag=false;
        //View.update();
        //View.display.setText(Double.toString(num1));
        input.delete(0,input.length());
        System.out.printf("Primer numero %b , operacion %s, num1 %f num2 %f\n",primerNumero,operacion, num1,num2);
    }

    static void clickPotencia() {
        //if (!operacionFlag){
            //operacion = "potencia";
            //operacionFlag = true;
            comaFlag=false;
            if (input.toString().equals("")||num2==0){num2=num1;}
            num2 = Double.parseDouble(input.toString());
            num2 = Math.pow(num2, 2);
            input.delete(0,input.length());
            input.append(num2);
            View.display.setText(Double.toString(num2));
            System.out.println("Potencia");
            //operar();
        //}
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
        primerNumero=true;

    }

    static void clickClear() {
        System.out.println("Clear");
        input.delete(0,input.length());
        num2=0;
        View.display.setText(Double.toString(num1));
        comaFlag=false;
        operacionFlag=false;
        operacion="";

    }


    static void clickDividir() {
        if (!operacionFlag){
            operar();
            operacion = "/";
            operacionFlag = true;
            comaFlag=false;
            //input.append("/");
            System.out.println("Dividir");
        }
    }

    static void clickRaiz() {
        comaFlag=false;
        if (input.toString().equals("")||num2==0){num2=num1;}
        num2 = Double.parseDouble(input.toString());
        num2 = Math.sqrt(num2);
        input.delete(0,input.length());
        input.append(num2);
        View.display.setText(Double.toString(num2));
        System.out.println("Potencia");
        /*if (!operacionFlag){
            operar();
            operacion = "raiz";
            operacionFlag = true;
            comaFlag=false;
            //input.append("");
            System.out.println("Raiz");
        }*/
    }

    static void clickNum7() {
        input.append("7");
        View.update();
        operacionFlag=false;
    }

    static void clickNum8() {
        input.append("8");
        View.update();
        operacionFlag=false;
    }

    static void clickNum9() {
        input.append("9");
        View.update();
        operacionFlag=false;
    }

    static void clickMultiplicar() {
        if (!operacionFlag){
            operacionFlag = true;
            comaFlag=false;
            operar();
            operacion = "x";
            //input.append("*");
            System.out.println("X");
        }
    }

    static void clickNum4() {
        input.append("4");
        View.update();
        operacionFlag=false;
    }

    static void clickNum5() {
        input.append("5");
        View.update();
        operacionFlag=false;
    }

    static void clickNum6() {
        input.append("6");
        View.update();
        operacionFlag=false;
    }

    static void clickRestar() {
        /*if (primerNumero||!signoFlag){
            input.append("-");
            signoFlag=false;
        }else*/
        if (!(operacionFlag||input.toString().equals("-")||input.toString().equals(error))){
            operacionFlag = true;
            comaFlag=false;
            System.out.println("-");
            operar();
            operacion = "-";
            //input.append("-");
        }
    }

    static void clickNum1() {
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
        input.append("3");
        View.update();
        operacionFlag=false;
    }

    static void clickSumar() {
        if (!(operacionFlag||input.equals("")||input.equals(error))) {
            operacionFlag = true;
            comaFlag=false;
            System.out.println("+");
            operar();
            operacion = "+";
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
        operar();
        operacion="=";
        View.display.setText(Double.toString(num1));
    }
}