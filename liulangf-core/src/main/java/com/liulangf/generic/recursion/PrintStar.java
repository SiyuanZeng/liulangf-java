package com.liulangf.recursion;

/**
 *
 */
public class PrintStar {
    
    public void printStar(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public void printStars(int n) {
        if (n == 0) {
            System.out.println();
        } else {
            System.out.print("*");
            printStars(n - 1);
        }
    }
    
    public void printStars3(int n) {
        if (n == 1) {
            System.out.println("*");
        } else {
            System.out.print("*");
            printStars3(n - 1);
        }
    }
    
    public void printStars4(int n) {
        if (n == 1) {
            System.out.println("*");
        } else if (n == 2) {
            System.out.print("*");
            System.out.println("*");
        } else if (n == 3) {
            System.out.print("*");
            System.out.print("*");
            System.out.println("*");
        } else if (n == 4) {
            System.out.print("*");
            System.out.print("*");
            System.out.print("*");
            System.out.println("*");
        }
    }
    
    public void printStars5(int n) {
        if (n == 1) {
            System.out.println("*");
        } else if (n == 2) {
            System.out.print("*");
            printStars5(1);
        } else if (n == 3) {
            System.out.print("*");
            printStars5(2);
        } else if (n == 4) {
            System.out.print("*");
            printStars5(3);
        }
    }
    
    public static void main(String...args) {
        PrintStar ps = new PrintStar();
        ps.printStar(6);
        ps.printStars(6);
    }

}
