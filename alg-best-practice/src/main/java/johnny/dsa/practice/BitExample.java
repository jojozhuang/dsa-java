package johnny.dsa.practice;

public class BitExample {
    public static void main(String[] args) {
        // flip bit with XOR, change 1 to 0 and change 0 to 1.
        int bit = 0;
        bit = bit ^ 1; // bit = 1
        bit = bit ^ 1; // bit = 0

        // find the complement of the give number
        int num = 10;  // 1010
        int mask = 15; // 1111
        int result = num ^ mask;  // result = 5, 0101

        // power
        int left = 3;
        int pow = 1 << left; // pow = 8, 1000

        // get the value of last bit
        int num2 = 5;        // num2 = 101
        int last = num2 & 1; // last = 1

        // right shift
        int num3 = 5;     // num3 = 101
        num3 = num3 >> 1; // num3 = 2, 101 -> 10

        // left shift
        int num4 = 5;     // num4 = 101
        num4 = num4 << 1; // num4 = 10, 101 -> 1010

        // number of one-bits
        int n = 177;   // in binary format: 10110001
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count); // print 4;

        // or use built-in method
        count = Integer.bitCount(177);  // count = 4;
    }
}
