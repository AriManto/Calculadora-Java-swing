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