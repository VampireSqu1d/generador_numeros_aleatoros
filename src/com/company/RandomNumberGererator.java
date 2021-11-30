package com.company;

public class RandomNumberGererator {
    int[] a = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 };
    public int GenerarNumeros(int seed,int digito){
        int square = seed * seed, next = 0;
        int t = (digito / 2);
        square = square / a[t];
        for (int i = 0; i < digito; i++) {
            next += (square % (a[t])) * a[i];
            square = square / 10;
        }
        return  next;
    }

}
