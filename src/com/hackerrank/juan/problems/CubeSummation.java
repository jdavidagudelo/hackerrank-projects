/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackerrank.juan.problems;

import java.util.Scanner;

/**
 *
 * @author ubidotsjd
 */
public class CubeSummation {
    private final long[][][] matrix = new long[101][101][101];
    private final int n;
    public CubeSummation(int n){
        this.n = n;
    }
    /**
    * (x, y, z) coordinates 1-based, w the value of the element (x, y, z)
    */
    public void update(int x, int y, int z, long w){
        for(int z1 = z; z1 <= n; z1 += z1 & (-z1)){
            for(int y1 = y; y1 <= n; y1 += y1 & (-y1)){
                for(int x1 = x; x1 <= n; x1 += x1 & (-x1)){
                    matrix[x1][y1][z1] += w;
                }
            }
        }
    }
    public long query(int x, int y, int z){
        long sum = 0l;
        for(int z1 = z; z1 > 0; z1 -= z1 & -z1){
            for(int y1 = y; y1 > 0; y1 -= y1 & -y1){
                for(int x1 = x; x1 >0; x1 -= x1 & -x1){
                    sum += matrix[x1][y1][z1];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            CubeSummation solution = new CubeSummation(n);
            int m = scanner.nextInt();
            for(int j = 0; j < m; j++){
                String operation = scanner.next();
                if(operation.equals("QUERY")){
                    int x1 = scanner.nextInt();
                    int y1 = scanner.nextInt();
                    int z1 = scanner.nextInt();
                    int x2 = scanner.nextInt();
                    int y2 = scanner.nextInt();
                    int z2 = scanner.nextInt();
                    
                    long value1 = solution.query(x2,y2,z2)- solution.query(x1-1,y2,z2) 
                    - solution.query(x2,y1-1,z2) + solution.query(x1-1,y1-1,z2);

            long value2 = solution.query(x2,y2,z1-1) - solution.query(x1-1,y2,z1-1)
                    - solution.query(x2,y1-1,z1-1)  + solution.query(x1-1,y1-1,z1-1);
                    System.out.println(value1-value2);
                }
                else if(operation.equals("UPDATE")){
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int z = scanner.nextInt();
                    int x1 = x;
                    int y1 = y;
                    int z1 = z;
                    long w = scanner.nextLong();
                    long value1 = solution.query(x,y,z)- solution.query(x1-1,y,z) 
                    - solution.query(x,y1-1,z) + solution.query(x1-1,y1-1,z);

            long value2 = solution.query(x,y,z1-1) - solution.query(x1-1,y,z1-1)
                    - solution.query(x,y1-1,z1-1)  + solution.query(x1-1,y1-1,z1-1);
                    solution.update(x, y, z, w-(value1-value2));
                }
            }
        }
    }
}
