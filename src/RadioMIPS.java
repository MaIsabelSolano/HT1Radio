/**
 * @author Pedro y Michy
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 */

import java.util.*;

public class RadioMIPS implements RadioGeneral {

    //Atributos
    private boolean ON; //true significa que está encendida, false que está apagada
    private boolean frecuencia; //true significa AM y false es FM
    private float emisoraFM = 100.5f; //Emisora FM que aparece al encender el radio.
    private float emisoraAM = 65.9f; //Emisora AM que aparece al encender el radio.

    /*Los atributos que aparecen abajo son las emisoras que estarán definidas para cada frecuencia y los botones para
    poder guardar nuestras emisoras favoritas. Los botones están representados como ArrayLists en este caso */

    private ArrayList<Float> emisorasFM = new ArrayList<Float>(Arrays.asList(100.5f, 99.3f, 86.3f, 96.7f, 100.6f, 85.5f, 88.9f, 92.7f, 91.2f, 95.0f, 104.3f, 110.5f, 87.8f, 94.2f));
    private ArrayList<Float> emisorasAM = new ArrayList<Float>(Arrays.asList(65.9f, 99.2f, 112.5f, 75.2f, 82.7f, 99.3f, 100.5f, 98.1f, 84.3f, 99.9f, 58.2f, 51.2f, 45.3f, 54.8f));
    private ArrayList<Float> emisorasFavoritasFM = new ArrayList<Float>(Arrays.asList(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,0.0f, 0.0f));
    private ArrayList<Float> emisorasFavoritasAM = new ArrayList<Float>(Arrays.asList(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,0.0f, 0.0f));

    Scanner scanner = new Scanner(System.in); //El scanner obtendrá un par de datos del usuario en los métodos.

    public RadioMIPS(){
        ON = false;
    }

    @Override
    public boolean isON() {
        return this.ON;
    }

    @Override
    public void encender() {
        this.ON = true;
        System.out.println("\nESTADO: ENCENDIDO\n");
    }

    @Override
    public void apagar() {
        this.ON = false;
        System.out.println("\nESTADO: APAGADO\n");
    }

    @Override
    public void incrementar() {

        if(frecuencia == true){ //Incrementa en la lista de emisoras en la frecuencia AM.
            int indice = emisorasAM.indexOf(emisoraAM);

            for(indice++;indice < emisorasAM.size();){ //Itera en la lista de emisoras AM.
                if(indice < emisorasAM.size()){
                    emisoraAM = emisorasAM.get(indice);
                    System.out.println("\nIncrementando...");
                    System.out.println("\nEMISORA ACTUAL: " + emisoraAM + " AM\n");
                    break;

                } else{ //Verifica que si el numero de emisoras es mayor al tamaño, regresa al inicio.
                    emisoraAM = emisorasAM.get(0);
                    System.out.println("\nIncrementando...");
                    System.out.println("\nEMISORA ACTUAL: " + emisoraAM + " AM\n");
                    break;
                }

            }
        } else if(frecuencia == false){ //Incrementa en la lista de emisoras en la frecuencia FM.
            int indice = emisorasFM.indexOf(emisoraFM);

            for(indice++;indice < emisorasFM.size();){ //Itera en la lista de emisoras FM.
                if(indice < emisorasFM.size()){
                    emisoraFM = emisorasFM.get(indice);
                    System.out.println("\nIncrementando...");
                    System.out.println("\nEMISORA ACTUAL: " + emisoraFM + "\n FM");
                    break;

                } else{ //Verifica que si el numero de emisoras es mayor al tamaño, regresa al inicio.
                    emisoraFM = emisorasFM.get(0);
                    System.out.println("\nIncrementando...");
                    System.out.println("\nEMISORA ACTUAL: " + emisoraFM + " FM\n");
                    break;
                }
            }
        }

    }

    @Override
    public boolean asignar(int num) {
        // TODO Auto-generated method stub

        if(frecuencia == true){ //Para la frecuencia AM.
            int boton = 0;

            System.out.println("\nSeleccione el boton donde desea guardar su emisora:\n");
            for(int i = 0; i < emisorasFavoritasAM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFavoritasAM.get(i) + " AM\n");
            }
            boolean correcto = false;
            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    boton = scanner.nextInt();
                    if(boton > emisorasFavoritasAM.size() || boton < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        boton -= 1;
;                        correcto = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }


            System.out.println("\nSelecciona la emisora que deseas guardar en tus favoritos\n");
            for(int i = 0; i < emisorasAM.size(); i++){
                System.out.println((i+1) + ") " + emisorasAM.get(i) + " AM\n");
            }

            boolean correctoDos = false;

            while(!correctoDos){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    int seleccion = scanner.nextInt();
                    if(seleccion > emisorasAM.size() || seleccion < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        float emisoraFav = emisorasAM.get(seleccion - 1);
                        emisorasFavoritasAM.set(boton, emisoraFav); //Arreglar esto
                        System.out.println("\nSe ha agregado con exito la emisora" + emisoraFav +"a tus favoritos\n");
                        System.out.println(emisorasFavoritasAM);
                        correctoDos = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }

        } else if(frecuencia == false){ //Para la frecuencia FM.

            int boton = 0;

            System.out.println("\nSeleccione el boton donde desea guardar su emisora:\n");
            for(int i = 0; i < emisorasFavoritasFM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFavoritasFM.get(i) + " AM\n");
            }
            boolean correcto = false;
            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    boton = scanner.nextInt();
                    if(boton > emisorasFavoritasFM.size() || boton < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        boton -= 1;
;                        correcto = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }

            System.out.println("\nSelecciona la emisora que deseas guardar en tus favoritos\n");
            for(int i = 0; i < emisorasFM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFM.get(i) + " FM\n");
            }

            boolean correctoDos = false;

            while(!correctoDos){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    int seleccion = scanner.nextInt();
                    if(seleccion > emisorasFM.size() || seleccion < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        float emisoraFav = emisorasFM.get(seleccion - 1);
                        emisorasFavoritasFM.set(boton, emisoraFav); //Arreglar esto
                        System.out.println("\nSe ha agregado con exito la emisora" + emisoraFav +"a tus favoritos\n");
                        System.out.println(emisorasFavoritasFM);
                        correctoDos = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }

        }
        return true;
    }

    @Override
    public boolean emisora(int num) { //Accede a la lista de emisoras favoritas

        if(frecuencia == true){
            int boton = 0;

            System.out.println("\nSeleccione su emisora favorita de la lista:\n");
            for(int i = 0; i < emisorasFavoritasFM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFavoritasFM.get(i) + " AM\n");
            }
            boolean correcto = false;
            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    boton = scanner.nextInt();
                    if(boton > emisorasFavoritasFM.size() || boton < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        boton -= 1;
                        float emisoraSeleccionada = emisorasFavoritasAM.get(boton); //Arreglar esto
                        emisoraAM = emisoraSeleccionada;
                        System.out.println("\nEMISORA ACTUAL: " + emisoraAM + " AM\n");
;                        correcto = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }


        } else if(frecuencia == false){
            int boton = 0;

            System.out.println("\nSeleccione su emisora favorita de la lista:\n");
            for(int i = 0; i < emisorasFavoritasFM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFavoritasFM.get(i) + " AM\n");
            }
            boolean correcto = false;
            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    boton = scanner.nextInt();
                    if(boton > emisorasFavoritasFM.size() || boton < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        boton -= 1;
                        float emisoraSeleccionada = emisorasFavoritasFM.get(boton); //Arreglar esto
                        emisoraFM = emisoraSeleccionada;
                        System.out.println("\nEMISORA ACTUAL: " + emisoraFM + " FM\n");
;                       correcto = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }
            }
        }
        return ON;
    }

    @Override
    public void frecuencia() { //Cambia la frecuencia del radio.
        if (frecuencia == true){
            frecuencia = false;
            System.out.println("\nFRECUENCIA ACTUAL: FM\n");
            //Cambiar de AM a FM
        }
        else {
            frecuencia = true;
            System.out.println("\nFRECUENCIA ACTUAL: AM\n");
            //Cambiar de FM a AM
        }
    }
}


