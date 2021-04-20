package com.jaen.pedro.springmaven;

import java.util.ArrayList;

public class Comun {
    private ArrayList<String> lista;

    public Comun() {
        lista=new ArrayList<String>();
    }

    public void addElement(String s){
        lista.add(s);
    }

    public void imprimir(){
        for (String s : lista) {
            System.out.println(s);
        }
    }

}
