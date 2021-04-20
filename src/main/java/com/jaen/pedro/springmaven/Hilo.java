package com.jaen.pedro.springmaven;

import java.util.Random;

public class Hilo extends Thread{
    private Comun comun;
    private String nombre;
    private double distancia;

    public Hilo(Comun comun, String nombre, double distancia) {
        this.comun = comun;
        this.nombre = nombre;
        this.distancia = distancia;
    }

    @Override
    public void run() {
        try {
            Random rm=new Random();
            double distActual=0;
            while(distancia>distActual){
                distActual+=rm.nextDouble()*10;
                sleep(1000);
            }
            comun.addElement(nombre+" ha llegado a la meta");
        } catch (InterruptedException e) {
            System.out.println(nombre+" aun no llego a la meta");
            return;
        }
    }
}
