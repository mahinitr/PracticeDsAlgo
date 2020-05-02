package bits;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int setBits = 0;
        while(z > 0){
            setBits += z & 1;
            z = z >> 1;
        }
        return setBits;
    }

    public static void main(String[] args){
        HammingDistance obj = new HammingDistance();
        System.out.println(obj.hammingDistance(5,6));
    }

}
