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
    /*debuggers*/
    static void valores(){
        separador();
        System.out.println("Primer numero: "+ primerNumero+" | Operacion: " + operacion + " | num1: " + num1 +
                " | num2 : "+num2+"\nInput: "+input.toString()+" | exponenteFlag: " + exponenteFlag);
    }
    static void separador(){
        System.out.println("------------------------------------------------------------------");
    }
    /*debuggers*/
    static private String getDisplay(){
        return View.display.getText();
    }

    static private void ejecutarOperacion(){
        //Si es primer número, num2 (input) pasa al num1 (acumulador o resultado) directamente
        //Además saltea el switch de operación!
        if (primerNumero){
            num1=num2;
            try{num1 = Double.parseDouble(input.toString());}
            catch(NumberFormatException e){}
            primerNumero=false;
        }
        //Si no es primer número, num1 acumula la operacion entre num1 y num2
        else { //NO PRIMER NUMERO
            //Si no hay input no lo toma, no se cambia num2 xq puede ser potencia o raiz
            if (!(input.toString().equals(""))){
                num2=Double.parseDouble(input.toString());
            }
            //INPUT ASIGNADO
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
                case "=":  //Input es 0
                    if(exponenteFlag){exponenteFlag=false;num1=num2;}
                    num2=0;
                    break;
            }
        }
        View.display.setText(Double.toString(num1));
        View.displayOperador.setText(operacion);
        input.delete(0,input.length());
        exponenteFlag=false;
        valores();
        operacion="";
    }

    static private void clickNum(String num){
        if(!blockInput) {
            input.append(num);
            View.update();
            operacionFlag = false;
        }
    }
    static private void clickOperacion(String op) {
        /*La primera operacion que se aprieta es la que cuenta

        */
        if (!operacionFlag) {
            System.out.println(op);
            separador();
            valores();
            if (!blockInput || blockInput && primerNumero) {
                ejecutarOperacion();
            }
            operacionFlag = true;
            comaFlag = false;
            blockInput = false;
            operacion = op;
            View.displayOperador.setText(operacion);
        }
    }

    static void clickPotencia() {
        comaFlag=false;
        if (input.toString().equals("")){ //String null
            if ((num2 == 0)&& !(num1==0)) {//num1 == 0 cambiado por primernumero
                num2 = Math.pow(num1, 2);
            }
            else {
                num2 = Math.pow(num2, 2);
            }
            /*else if ((num2 == 0)&& (num1==0)) {//
                num2 = Math.pow(num2, 2);
            }
            else if (!(num2 == 0)&& !(num1==0)) {//
                num2 = Math.pow(num2, 2);
            }*/
        }
        else {  //Caso standard, toma el input y lo eleva al cuadrado, en num2
            num2 = Double.parseDouble(input.toString());
            num2 = Math.pow(num2, 2);
        }
        View.display.setText(Double.toString(num2));
        input.delete(0,input.length());
        exponenteFlag = true;
        blockInput=true;
        System.out.println("Potencia");
        valores();
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
        clickOperacion("/");
    }
    static void clickMultiplicar() {
        clickOperacion("x");
    }
    static void clickRestar() {
        //Número negativo
        if (input.toString().equals("")&&operacionFlag){
            input.append("-");
            signoFlag=true;
            View.update();
            blockInput=false;
        }
        //Operación de restar
        else clickOperacion("-");
    }
    static void clickSumar() {
        clickOperacion("+");
    }

    static void clickNum9() {clickNum("9");}
    static void clickNum8() {clickNum("8");}
    static void clickNum7() {clickNum("7");}
    static void clickNum6() {clickNum("6");}
    static void clickNum5() {clickNum("5");}
    static void clickNum4() {clickNum("4");}
    static void clickNum3() {clickNum("3");}
    static void clickNum2() {clickNum("2");}
    static void clickNum1() {clickNum("1");}
    //Necesita verificar si ya hay un 0 o null o error
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
        ejecutarOperacion();
        operacion="=";
        View.display.setText(Double.toString(num1));
        View.displayOperador.setText(Controller.operacion);
        operacionFlag=false;
        blockInput=true;
        System.out.println("Igual");
        valores();
    }
}