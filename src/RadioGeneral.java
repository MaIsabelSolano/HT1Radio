/**
 * @author Pedro y Michy
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * Seccion 10
 */
public interface RadioGeneral {

    //métodos que debe contener el radio desarrollado para este ejercicio.
    /**
     *Verifica que el radio esté encendido para evitar que se usen funciones cuando está apagado.
     * @return valor booleano
     */
    public abstract boolean isON();


    /**
     *Enciende la radio.
     */
    public abstract void encender();


    /**
     *Apaga la radio.
     */
    public abstract void apagar();


    /**
     *Incrementa la emisora al escuchar la radio.
     */
    public abstract void incrementar();

    /**
     *Asigna la radio preferida a uno de los 12 botones del radio.
     * @param num
     * @return valor booleano
     */
    public abstract boolean asignar(int num);

    /**
     *Selecciona una emisora marcada como favorita.
     * @param num
     * @return
     */
    public abstract boolean emisora(int num);


    /**
     * Cambia la frecuencia de la radio.
     */
    public abstract void frecuencia();

}
