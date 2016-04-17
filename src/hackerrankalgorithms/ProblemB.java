/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrankalgorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ubidotsjd
 */
public class ProblemB {

    public boolean getResult(String[] s, int cn, int n, int nn, int i, int o, int[] v) {
        if (cn == n && i >= s.length) {
            return true;
        }
        System.out.println(cn+", "+nn*v.length+", "+n+", "+nn+", "+i);
        if(nn*v.length < n){
            return false;
        }
        if(cn > n){
            return false;
        }
        if (i >= s.length) {
            return false;
        }
        if (i == 0) {
            for (int k = 1; k <= nn; k++) {
                int aux = v[o];
                v[o] = k;
                if (getResult(s, cn + k, n,nn, i + 2, o + 1, v)) {
                    return true;
                }
                v[o] = aux;
            }
            return false;
        }
        if (s[i].equals("?")) {
            if (s[i - 1].equals("+")) {
                for (int k = 1; k <= nn; k++) {
                    int aux = v[o];
                    v[o] = k;
                    if (s[i - 1].equals("+")) {
                        
                        if (getResult(s, cn + k, n,nn, i + 2, o + 1, v)) {
                            return true;
                        }
                    }
                    v[o] = aux;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        ProblemB pb = new ProblemB();
        int n = Integer.parseInt(s[s.length - 1]);
        int nn = n;
        int q = 0;
        String ss = "";
        int qq = 0;
        for (int i = 0; i < s.length; i++) {

            if (s[i].equals("?")) {
                qq++;
            }
            if (i < s.length - 2 && (i == 0 || s[i].equals("?") && s[i - 1].equals("+") || s[i].equals("+"))) {
                ss += s[i];
                if (s[i].equals("?")) {
                    q++;
                }
            } else if (i < s.length - 2 && s[i].equals("?")) {
                n++;
            }
        }
        int[] v = new int[q];
        char signs[] = new char[qq - 1];
        int k = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("+") || s[i].equals("-")) {
                signs[k] = s[i].charAt(0);
                k++;
            }
        }
        String[] sr = new String[ss.length()];
        int kk = 0;
        for (char c : ss.toCharArray()) {
            sr[kk] = c + "";
            kk++;
        }
        if (pb.getResult(sr, 0, n,nn, 0, 0, v)) {
            if(v[0] > nn){
                System.out.println("Impossible");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Possible\n");
            k = 0;
            for (int i = 0; i < signs.length; i++) {
                if (signs[i] == '+') {
                    if (k == 0) {
                        sb.append(v[k]).append(" + ").append(v[k + 1]);
                        k += 2;
                    } else {
                        sb.append(" + ").append(v[k]);
                        k++;
                    }
                } else {
                    if(k == 0){
                        sb.append(v[k]).append(" - ").append(1);
                        k++;
                    }
                    else{
                        sb.append(" - ").append(1);
                    }
                }
            }
            if(signs.length == 0){
                System.out.println("Possible");
                System.out.println(nn + " = "+nn);
            }else{
            System.out.println(sb.append(" = ").append(nn).toString());}
        } else {
            System.out.println("Impossible");
        }

    }
}
