
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Converter {

    private final NavigableMap<Integer, String> arabRim = new TreeMap<>();
    private final HashMap<String, Integer> rimArab = new HashMap<>();

    public  Converter() {
        arabRim.put(100, "C");
        arabRim.put(90,"XC");
        arabRim.put(50,"L");
        arabRim.put(40,"XL");
        arabRim.put(10,"X");
        arabRim.put(9,"IX");
        arabRim.put(5,"V");
        arabRim.put(4,"IV");
        arabRim.put(1,"I");

        rimArab.put("I",1);
        rimArab.put("II",2);
        rimArab.put("III",3);
        rimArab.put("IV",4);
        rimArab.put("V",5);
        rimArab.put("VI",6);
        rimArab.put("VII",7);
        rimArab.put("VIII",8);
        rimArab.put("IX",9);
        rimArab.put("X",10);
    }
    public  String arabToRim(int number) {
        if (number<= 0){
            throw  new NumberFormatException("Римские числа не могут быть отрицательными");
        }

        StringBuilder result = new StringBuilder();
        for (Integer key : arabRim.descendingKeySet()) {
            while (number >= key){
                number -= key;
                result.append(arabRim.get(key));
            }
        }
        return result.toString();
    }

    public int rimToArab(String number) throws ConvertException {
        Integer result = rimArab.get(number);
        if (result == null) {
            throw new ConvertException("Некорректное римское число, или оне не соотвецтвует диапазону [I. X]");
        }
        return result;
    }
}
