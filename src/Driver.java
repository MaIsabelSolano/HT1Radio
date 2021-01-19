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
                System.out.println("Escriba el numero de la opcion que desea utilizar");
                System.out.println("1. Encender");
                System.out.println("2. Incrementar emisora");
                System.out.println("3. Disminuir emisora");
                System.out.println("4. Cambiar de emisora (AM/FM)");
                System.out.println("5. Elegir Emisora de favoritas");
                System.out.println("6. Asignar Emisora a favoritas");
                System.out.println("7. Apagar");

                int opcion = scan.nextInt();

                if (opcion == 1){
                    //Encender la radio
                    if (radio.isON() == false) {
                        radio.encender();
                        System.out.println("Se ha encendido la radio");
                    }
                    else {
                        System.out.println("La radio ya estaba encendida...");
                    }
                }
                else if (opcion == 2){
                    //Incrementar el número de la emisora
                }
                else if (opcion == 3){
                    //Disminuir el número de la emisora
                }
                else if (opcion == 4){
                    //Cambiar de emisora
                    if (radio.isON()) {
                        radio.frecuencia();
                        System.out.println("Se ha cambiado de frecuencia\n");
                    }
                    else {
                        System.out.println("Necesita encender la radio primero para realizar esta accion");
                    }
                }
                else if (opcion == 5){
                    //elegir emisora de favoritas
                }
                else if (opcion == 6){
                    //Agregar estación a favoritas
                }
                else if (opcion == 7){
                    //Apagar la radio
                    if (radio.isON() == true) {
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

