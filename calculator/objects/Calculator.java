package calculator.objects;

import java.util.*;

public class Calculator{
    protected String display;
    protected Double equationDouble;
    protected String equation;
    protected String lastOperation;

    protected Operators operation;
    private Decimal decimalState = new Decimal() { //Whether or not there is a decimal
        @Override
        public ArrayList<String> decimalPressed(String a, String b) { //Seperated by 2 strings into an arraylist
            a += ".";
            b+=".";
            return new ArrayList<>(Arrays.asList(a,b));
        }
    };
    
    
    public Calculator(){
        this.display = "0";
        this.equation = "";
        this.equationDouble = 0.0;
    }

    public double displayNumber() {
        return Double.parseDouble(display); //Just changes display
    }

    //Buttons Pressed
    public void clearPressed() { //Resets everything
        this.display = "0"; 
        this.equation = "";
        this.equationDouble = 0.0;
        this.decimalState = new NoDecimal();
    }

    public void numberPressed(int number) { //Adds numbers to the display
        display += number;
        equation+=number;
    }
    public void dividePressed() { //creates a new Division object to be computed
        lastOperation = ""; //Previous operation incase you wanted to spam equals
        this.operation = new Division(); //created object
        equation = display.toString(); //updates the equation in the calculator
        equation += "/"; //adds operator symbol
        display = "0"; //sets display at 0 to await new number
        decimalState = new NoDecimal(); //sets the state as no decimal
    }
    public void multiplyPressed() { //creates a new multiplcation object to be computed
        lastOperation = "";
        this.operation = new Multiplication();
        equation = display.toString();
        equation += "*";
        display = "0";
        decimalState=new NoDecimal();
    }
    public void subtractPressed() { //creates a new subtraction object to be computed
        lastOperation = "";
        this.operation = new Subtraction();
        equation = display.toString();
        equation += "-";
        display = "0";
        decimalState=new NoDecimal();
    }
    public void addPressed() { //creates a new addition object to be computed
        lastOperation = "";
        this.operation = new Addition();
        equation = display.toString();
        equation += "+";
        display = "0";
        decimalState=new NoDecimal();
    }

    public void equalsPressed() {
        this.equation += lastOperation;
        ArrayList<String> out = this.operation.compute(this.equation);
        lastOperation = out.get(1);
        display = out.get(0).toString();
        equation = out.get(0).toString();
        decimalState=new NoDecimal();

    }

    public void decimalPressed() {
        ArrayList<String> decimalOut = decimalState.decimalPressed(display.toString(),equation.toString());
        display = decimalOut.get(0);
        equation = decimalOut.get(1);
        decimalState = new Decimal() {
            @Override
            public ArrayList<String> decimalPressed(String a, String b) {
                return new ArrayList<>(Arrays.asList(a,b));
            }
        };
    }

}
