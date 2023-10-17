package calculator.objects;

import java.util.*;

public class NoDecimal extends Calculator implements Decimal{
    public ArrayList<String> decimalPressed(String a, String b){
        a += ".";
        b+=".";
        return new ArrayList<>(Arrays.asList(a,b));
    }
}
