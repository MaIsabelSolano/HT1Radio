import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    //@org.junit.jupiter.api.Test
    @Test
    void isON(){
        Radio radio = new Radio();
        Assertions.assertEquals(false,radio.isON());
    }

    @org.junit.jupiter.api.Test
    void asignar() throws Exception{
        Radio radio = new Radio();
        radio.encender();
        Assertions.assertTrue(radio.asignar(-1));
    }


    @org.junit.jupiter.api.Test
    void emisora() throws Exception{
        Radio radio = new Radio();
        Assertions.assertTrue(radio.emisora(10));
    }

}