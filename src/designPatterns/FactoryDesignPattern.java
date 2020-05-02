package designPatterns;

interface Currency1 {
    String getSymbol();
}
// Concrete Rupee Class code
class Rupee1 implements Currency1 {
    @Override
    public String getSymbol() {
        return "Rs";
    }
}

// Concrete SGD class Code
class SGDDollar1 implements Currency1 {
    @Override
    public String getSymbol() {
        return "SGD";
    }
}

// Concrete US Dollar code
class USDollar1 implements Currency1 {
    @Override
    public String getSymbol() {
        return "USD";
    }
}

// Factroy Class code
class CurrencyFactory {

    public static Currency1 createCurrency (String country) {
        if (country. equalsIgnoreCase ("India")){
            return new Rupee1();
        }else if(country. equalsIgnoreCase ("Singapore")){
            return new SGDDollar1();
        }else if(country. equalsIgnoreCase ("US")){
            return new USDollar1();
        }
        throw new IllegalArgumentException("No such currency");
    }
}

// Factory client code
public class FactoryDesignPattern {
    public static void main(String args[]) {
        String country = "India";
        Currency1 curr = CurrencyFactory.createCurrency(country);
        System.out.println(curr.getSymbol());

        country = "US";
        curr = CurrencyFactory.createCurrency(country);
        System.out.println(curr.getSymbol());

        country = "singapore";
        curr = CurrencyFactory.createCurrency(country);
        System.out.println(curr.getSymbol());
    }
}

