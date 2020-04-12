public class CounterFeitCurreny {



    private static final int VALID_DENOMINATIONS[] = new int[]{10, 20, 50, 100, 200, 500, 1000};
    private static final int START_YEAR = 1900;
    private static final int END_YEAR = 2019;
    static int validValueOfCurrency(String serialNumber){
        int value = 0;
        int len = serialNumber.length();
        if(len < 10 || len > 12){
            return value;
        }

        // extract the parts from serial number
        String FIRST_PART = serialNumber.substring(0, 3);
        String SECOND_PART = serialNumber.substring(3,7);
        String THIRD_PART = serialNumber.substring(7,len-1);
        Character LAST_PART = serialNumber.charAt(len-1);

        // validate first part
        char[] chars = FIRST_PART.toCharArray();
        if(chars[0] == chars[1] || chars[0] == chars[2] || chars[1] == chars[2]){
            return value;
        }
        if(chars[0] < 'A' || chars[0] > 'Z' || chars[1] < 'A' || chars[1] > 'Z' || chars[2] < 'A' || chars[2] > 'Z'){
            return value;
        }

        // validate second part
        try{
            int year = Integer.parseInt(SECOND_PART);
            if(year < START_YEAR || year > END_YEAR){
                return value;
            }
        }catch (Exception e){
            return value;
        }

        // validate last char
        if(LAST_PART < 'A' || LAST_PART > 'Z'){
            return value;
        }

        // validate third part
        try{
            int denomination = Integer.parseInt(THIRD_PART);
            boolean valid = false;
            for(int i=0; i<VALID_DENOMINATIONS.length; i++){
                if(VALID_DENOMINATIONS[i] == denomination){
                    valid = true;
                    value = denomination;
                    break;
                }
            }
            if(!valid){
                return value;
            }
        }catch (Exception e){
            return value;
        }

        return value;
    }

    public static void main(String[] args) {
        //System.out.println(twoStrings("hello", "world"));
        //System.out.println(twoStrings("hi", "world"));

        System.out.println(validValueOfCurrency("AVG190420T"));
        System.out.println(validValueOfCurrency("RTF20001000Z"));
        System.out.println(validValueOfCurrency("ABC19992000Z"));
    }

}
