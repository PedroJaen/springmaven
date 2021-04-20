package com.jaen.pedro.springmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringmavenApplication {
    double distancia;
    Hilo[] hilos;
    Comun comun;

	public static void main(String[] args) {
		//SpringApplication.run(SpringmavenApplication.class, args);
		SpringmavenApplication sp=new SpringmavenApplication();

		sp.pideDatos();
        sp.iniciaHilos();
        sp.controlaHilos();
	}

	private void pideDatos() {
        Scanner sc = new Scanner(System.in);
        comun = new Comun();

        System.out.println("Indica la distancia a correr");
        distancia = sc.nextDouble();

        System.out.println("Indica el número de corredores");
        int n = sc.nextInt();
        sc.nextLine();

        hilos = new Hilo[n];
        for (int x = 0; x < n; x++) {
            System.out.println("Indica el nombre del corredor");
            String nombre = sc.nextLine();

            hilos[x] = new Hilo(comun, nombre, distancia);
        }

    }

    private void iniciaHilos() {
        for (Hilo hilo : hilos) {
            hilo.start();
        }
    }

    private void controlaHilos() {
        Scanner sc=new Scanner(System.in);

        boolean continuar=true;
        while(continuar){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            boolean vivos=false;
            for (Hilo hilo : hilos) {
                if(hilo.isAlive()){
                    vivos=true;
                    break;
                }
            }

            if(vivos){
                System.out.println("Desea continuar?");
                String respuesta=sc.nextLine();

                if(respuesta.equals("no")){
                    for (Hilo hilo : hilos) {
                        if(hilo.isAlive()){
                            hilo.interrupt();
                        }
                    }
                    continuar=false;
                }
            }else{
                comun.imprimir();
                continuar=false;
            }

        }
    }
}
