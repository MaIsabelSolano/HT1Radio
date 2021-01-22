/**
 * @author Pedro y Michy
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 */

import java.util.*; //Para utilizar scanner y progra defensiva

public class Driver {
    public static void main (String [] args){

        //Instanciar la clase Scanner
        Scanner scan = new Scanner(System.in);
        Radio radio = new Radio();

        //inicio del menú
        boolean verificador = false;

        while (verificador != true){
            try {

                if(radio.isON() == true){
                    if(radio.frecuencia == true){
                        System.out.println("\nEMISORA ACTUAL: " + radio.emisoraAM + " AM\n");
                    } else if(radio.frecuencia == false){
                        System.out.println("\nEMISORA ACTUAL: " + radio.emisoraFM + " FM\n");
                    }
                } else {
                    System.out.println("\nNO SIGNAL\n");
                }

                System.out.println("Escriba el numero de la opcion que desea utilizar");
                System.out.println("1. Encender");
                System.out.println("2. Incrementar emisora");
                System.out.println("3. Cambiar de emisora (AM/FM)");
                System.out.println("4. Elegir Emisora de favoritas");
                System.out.println("5. Asignar Emisora a favoritas");
                System.out.println("6. Apagar");

                int opcion = scan.nextInt();

                if (opcion == 1){
                    //Encender la radio
                    if (!radio.isON()) {
                        radio.encender();
                        System.out.println("\nSe ha encendido la radio");
                    }
                    else {
                        System.out.println("La radio ya estaba encendida...");
                    }
                }
                else if (opcion == 2){
					//Incrementar de emisión
                    radio.incrementar();
                }
                else if (opcion == 3){
                    //Cambiar de frecuencia
                    if (radio.isON()) {
                        radio.frecuencia();
                        System.out.println("Se ha cambiado de frecuencia\n");
                    }
                    else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }
                }
                else if (opcion == 4){
                    //elegir emisora de favoritas

                    if(radio.isON()){
                        int boton = 0;
                        System.out.println("\nEscoge un boton del 1 al 12\n");

                        boolean correcto = false;

                        while(!correcto){ //Seguirá funcionando hasta que se escoja una opción válida.
                            try{
                                boton = scan.nextInt();

                                if (boton > 12 || boton < 1){ //Verifica que la opción sea válida.
                                    System.out.println("\nOPCION INVALIDA.\n");
                                }  else {
                                    radio.emisora(boton - 1);
                                    correcto = true;
                                }

                            } catch (InputMismatchException e){ //Si el usuario ingresa un valor no numerico, se ejecutará esto.
                                System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                                scan.next();
                            }
                        }
                    } else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }

                }
                else if (opcion == 5){
                    //Agregar estación a favoritas

                    if(radio.isON()){
                        int boton = 0;
                        System.out.println("\nEscoge un boton del 1 al 12\n");

                        boolean correcto = false;

                        while(!correcto){ //Seguirá funcionando hasta que se escoja una opción válida.
                            try{
                                boton = scan.nextInt();

                                if (boton > 12 || boton < 1){ //Verifica que la opción sea válida.
                                    System.out.println("\nOPCION INVALIDA.\n");
                                }  else {
                                    radio.asignar((boton-1));
                                    correcto = true;
                                }

                            } catch (InputMismatchException e){ //Si el usuario ingresa un valor no numerico, se ejecutará esto.
                                System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                                scan.next();
                            }
                        }

                    } else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }


                }
                else if (opcion == 6){
                    //Apagar la radio
                    if (radio.isON()) {
                        radio.apagar();
                        System.out.println("Se ha apagado la radio");
                    }
                    else {
                        System.out.println("La radio ya estaba apagada...");
                    }
                }

                else if (opcion == 100){
                    //opción oculta para cerrar el programa
                    verificador = true;
                }

                else {
                    //opción equivocada
                    System.out.println("La opcion ingresada no es valida \n");
                }
            }
            catch (InputMismatchException e){
                System.out.println("La opcion ingresada no es valida \n");
                scan.nextLine(); //Para que el programa continue funcionando
            }
        }
       

    }
}

