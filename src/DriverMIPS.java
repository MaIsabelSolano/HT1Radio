/**
 * @author Pedro y Michy
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 */

import java.util.*; //Para utilizar scanner y progra defensiva

public class DriverMIPS {
    public static void main (String [] args){

        //Instanciar la clase Scanner
        Scanner scan = new Scanner(System.in);
        RadioMIPS radio = new RadioMIPS();

        //inicio del menú
        boolean verificador = false;

        while (verificador != true){
            try {

                System.out.println("Escriba el numero de la opcion que desea utilizar");
                System.out.println("1. Encender");
                System.out.println("2. Incrementar emisora");
                System.out.println("3. Cambiar de frecuencia (AM/FM)");
                System.out.println("4. Elegir Emisora de favoritas");
                System.out.println("5. Asignar Emisora a favoritas");
                System.out.println("6. Apagar");

                int opcion = scan.nextInt();

                if (opcion == 1){
                    //Encender la radio
                    if (!radio.isON()) {
                        radio.encender();
                    }
                    else {
                        System.out.println("La radio ya estaba encendida...");
                    }
                }
                else if (opcion == 2){
					//Incrementar de emisora
                    radio.incrementar();
                }
                else if (opcion == 3){
                    //Cambiar de frecuencia
                    if (radio.isON()) {
                        radio.frecuencia();
                    }
                    else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }
                }
                else if (opcion == 4){
                    //elegir emisora de favoritas

                    if(radio.isON()){
                        radio.emisora(0);
                    } else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }

                }
                else if (opcion == 5){
                    //Agregar emisora a la lista de favoritas

                    if(radio.isON()){
                        radio.asignar(0);

                    } else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }

                }
                else if (opcion == 6){
                    //Apagar la radio
                    if (radio.isON()) {
                        radio.apagar();
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
