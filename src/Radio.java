import java.util.*;

public class Radio implements RadioGeneral{

    //Atributos
    private boolean ON; //true significa que está encendida, false que está apagada
    private boolean Frecuencia; //true significa AM y false es FM


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

    }

    @Override
    public void disminuir() {

    }

    @Override
    public void asignar() {

    }

    @Override
    public void emisoras() {

    }

    @Override
    public void frecuencia() {
        if (Frecuencia == true){
            Frecuencia = false;
            //Cambiar de AM a FM
        }
        else {
            Frecuencia = true;
            //Cambiar de FM a AM
        }
    }
}
