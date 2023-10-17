package calculator.objects;

import java.util.*;

public class Division implements Operators{
    public ArrayList<String> calculate(String equation){
        ArrayList<String> equationSplit = new ArrayList<>(Arrays.asList(equation.split("/")));
        ArrayList<String> out = new ArrayList<>();

        double total = 0.0;

        total += Double.parseDouble(equationSplit.get(0));
        total /= Double.parseDouble(equationSplit.get(1));

        out.add(String.valueOf(total));

        out.add("/" + Double.parseDouble(equationSplit.get(1)));

        return out;
    }
}