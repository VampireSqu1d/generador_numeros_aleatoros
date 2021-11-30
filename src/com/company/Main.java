package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int repeticiones = 1, digitos = 0, numero = (int) System.nanoTime()/100000;
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        RandomNumberGererator gererator = new RandomNumberGererator();
        String nombreArchivo = "";
        while(seguir){
            System.out.println("dame la cantidad de  números que quieres generar:");
            repeticiones = scanner.nextInt();
            System.out.println("dame el número de digitos que quieres en los números aleatorios");
            digitos = scanner.nextInt();

            if (repeticiones >= 1) {
                System.out.println("dame el nombre del archivo al que se van a guardar los numeros:");
                nombreArchivo = scanner.next();

                try {
                    nombreArchivo = nombreArchivo + ".txt";
                    File archivo = new File(nombreArchivo);
                    FileWriter fileWriter = new FileWriter(archivo);
                    fileWriter.write("Numeros aleatorios generados \n");
                    for (int i = 0; i < repeticiones; i++) {
                        numero = gererator.GenerarNumeros(numero, digitos);
                        fileWriter.write(numero + "\n");
                    }

                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("generar más números?[y/n]");
            if (scanner.next().equalsIgnoreCase("n"))  seguir = false;
        }

        System.out.println("Okay bye");
    }

}
