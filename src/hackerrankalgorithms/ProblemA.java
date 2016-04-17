/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrankalgorithms;

import java.util.Scanner;
import java.math.*;

/**
 *
 * @author ubidotsjd
 */
public class ProblemA {
    public BigInteger gcd(BigInteger a, BigInteger b){
        if(b.equals(BigInteger.ZERO)){
            return a;
        }
        return gcd(b, a.mod(b));
    }
    public static void main(String args[]){
        ProblemA pa = new ProblemA();
        Scanner scanner = new Scanner(System.in);
        BigInteger a = new BigInteger(scanner.next());
        BigInteger b = new BigInteger(scanner.next());
        BigInteger x = pa.gcd(a, b);
        for(BigInteger y = a.add(BigInteger.ONE); y.compareTo(b) < 0 && !x.equals(BigInteger.ONE); y = y.add(BigInteger.ONE)){
            x = pa.gcd(x, y);
        }
        System.out.println(x);
    }
}
