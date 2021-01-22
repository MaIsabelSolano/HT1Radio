/**
 * @author Pedro y Michy
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 */

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Radio implements RadioGeneral{

    //Atributos
    private boolean ON; //true significa que está encendida, false que está apagada
    public boolean frecuencia; //true significa AM y false es FM
    public float emisoraFM = 100.5f; //Emisora FM que aparece al encender el radio.
    public float emisoraAM = 65.9f; //Emisora AM que aparece al encender el radio.

    /*Los atributos que aparecen abajo son las emisoras que estarán definidas para cada frecuencia y los botones para
    poder guardar nuestras emisoras favoritas. Los botones están representados como ArrayLists en este caso */

    private ArrayList<Float> emisorasFM = new ArrayList<Float>(Arrays.asList(100.5f, 99.3f, 86.3f, 96.7f, 100.6f, 85.5f, 88.9f, 92.7f, 91.2f, 95.0f, 104.3f, 110.5f, 87.8f, 94.2f));
    private ArrayList<Float> emisorasAM = new ArrayList<Float>(Arrays.asList(65.9f, 99.2f, 112.5f, 75.2f, 82.7f, 99.3f, 100.5f, 98.1f, 84.3f, 99.9f, 58.2f, 51.2f, 45.3f, 54.8f));
    private ArrayList<Float> emisorasFavoritasFM = new ArrayList<Float>(Arrays.asList(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,0.0f, 0.0f));
    private ArrayList<Float> emisorasFavoritasAM = new ArrayList<Float>(Arrays.asList(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,0.0f, 0.0f));

    Scanner scanner = new Scanner(System.in); //El scanner obtendrá un par de datos del usuario en los métodos.

    public Radio(){
        ON = false;
    }

    @Override
    public boolean isON() {
        return this.ON;
    }

    @Override
    public void encender() {
        this.ON = true;
    }

    @Override
    public void apagar() {
        this.ON = false;
    }

    @Override
    public void incrementar() {

        if(frecuencia == true){ //Incrementa en la lista de emisoras en la frecuencia AM.
            int indice = emisorasAM.indexOf(emisoraAM);

            for(indice++;indice < emisorasAM.size();){ //Itera en la lista de emisoras AM.
                if(indice < emisorasAM.size()){
                    emisoraAM = emisorasAM.get(indice);
                    break;

                } else{ //Verifica que si el numero de emisoras es mayor al tamaño, regresa al inicio.
                    emisoraAM = emisorasAM.get(0);
                    break;
                }

            }
        } else if(frecuencia == false){ //Incrementa en la lista de emisoras en la frecuencia FM.
            int indice = emisorasFM.indexOf(emisoraFM);

            for(indice++;indice < emisorasFM.size();){ //Itera en la lista de emisoras FM.
                if(indice < emisorasFM.size()){
                    emisoraFM = emisorasFM.get(indice);
                    break;

                } else{ //Verifica que si el numero de emisoras es mayor al tamaño, regresa al inicio.
                    emisoraFM = emisorasFM.get(0);
                    break;
                }
            }
        }

    }

    @Override
    public boolean asignar(int pos) {
        // TODO Auto-generated method stub

        if(frecuencia == true){ //Para la frecuencia AM.
            System.out.println("\nSelecciona la emisora que deseas guardar en tus favoritos\n");
            for(int i = 0; i < emisorasAM.size(); i++){
                System.out.println((i+1) + ") " + emisorasAM.get(i) + "AM\n");
            }

            boolean correcto = false;

            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    int seleccion = scanner.nextInt();
                    if(seleccion > emisorasAM.size() || seleccion < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        float emisoraFav = emisorasAM.get(seleccion - 1);
                        emisorasFavoritasAM.set(pos, emisoraFav);
                        System.out.println("\nSe ha agregado con exito a tus favoritos\n");
                        System.out.println(emisorasFavoritasAM);
                        correcto = true;
                    }
                } catch (InputMismatchException e) { //Atrapa el tipo de dato incorrecto y pide que se ingrese el tipo correcto.
                    System.out.println("\nPor favor ingrese una cantidad numerica.\n");
                    scanner.next();
                }

            }

        } else if(frecuencia == false){ //Para la frecuencia FM.

            System.out.println("\nSelecciona la emisora que deseas guardar en tus favoritos\n");
            for(int i = 0; i < emisorasFM.size(); i++){
                System.out.println((i+1) + ") " + emisorasFM.get(i) + "FM\n");
            }

            boolean correcto = false;

            while(!correcto){
                System.out.println("Input:");
                try { //Verifica que los datos sean del tipo correcto.
                    int seleccion = scanner.nextInt();
                    if(seleccion > emisorasFM.size() || seleccion < 1){
                        System.out.println("\nOPCION INVALIDA\n");
                    } else{
                        float emisoraFav = emisorasFM.get(seleccion - 1);
                        emisorasFavoritasFM.set(pos, emisoraFav);
                        System.out.println("\nSe ha agregado con exito a tus favoritos\n");
                        System.out.println(emisorasFavoritasFM);
                        correcto = true;
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
    public boolean emisora(int pos) { //Accede a la lista de emisoras favoritas

        if(frecuencia == true){
            float emisoraSeleccionada = emisorasFavoritasAM.get(pos);
            emisoraAM = emisoraSeleccionada;

        } else if(frecuencia == false){
            float emisoraSeleccionada = emisorasFavoritasFM.get(pos);
            emisoraFM = emisoraSeleccionada;
        }

        return true;
    }

    @Override
    public void frecuencia() { //Cambia la frecuencia del radio.
        if (frecuencia == true){
            frecuencia = false;
            //Cambiar de AM a FM
        }
        else {
            frecuencia = true;
            //Cambiar de FM a AM
        }
    }


    /**
     * Esta sección se realizó para poder hacer las pruebas unitarias con JUnit.
     */

    @Test
    public void pruebaIsOn(){
        Radio radio = new Radio();

        /**Prueba unitaria realizada en el método isON() de la clase Radio */
        assertEquals(false, radio.isON());

    }

    @Test
    public void pruebaEmisora(){

        /**Prueba unitaria realizada en el método emisora() de la clase Radio */
        Radio radio = new Radio();
        assertEquals(true, radio.emisora(2));
    }


    @Test
    public void pruebaAsignar(){

        /**Prueba unitaria realizada en el método asignar() de la clase Radio */
        Radio radio = new Radio();
        assertEquals(true, radio.asignar(2));
    }

    
}

