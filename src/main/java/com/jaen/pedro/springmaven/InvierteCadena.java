package com.jaen.pedro.springmaven;

import java.util.Scanner;

public class InvierteCadena {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String frase=sc.nextLine();
        String resultado="";
        for(int x=frase.length()-1;x>=0;x--){
            resultado+=frase.charAt(x);
        }

        System.out.println(resultado);
    }
}
