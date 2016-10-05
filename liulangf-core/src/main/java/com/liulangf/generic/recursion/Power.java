package com.liulangf.recursion;

/**
 *
 */
public class Power {

    public int pow(int m, int n) {
        if (n == 0) {
            //base case
            return 1;
        }
        return m * pow(m, n - 1);
    }
    
    public void printBinary(int n) {
        if (n < 2) {
            System.out.println(n);
        } else {
            printBinary(n / 2);
            printBinary(n % 2);
        }
    }
}
