package com.gl.app;

import com.gl.app.Iservice.IBasicCalculater;
import com.gl.app.Iservice.service.BasicCalculaterImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private IBasicCalculater basicCalculater = null;

    @Before
    public void init() {
        basicCalculater = new BasicCalculaterImpl();

    }

   /* @Test
    public void addition_isCorrect() {
        Double result = basicCalculater.add(10, 20);
        assertEquals(30, result, 0);
    }
*/


    /* @Test
     public void substration_isCorrect() {
         Double result = basicCalculater.substraction(30,10);
         assertEquals(20, result, 0);
     }
 */
   /* @Test
    public void multipcation_isCorrect() {
        Double result = basicCalculater.multipication(30, 10);
        assertEquals(300, result, 0);
    }*/


    @Test
    public void divsion_isCorrect() {
        Double result = basicCalculater.divsion(30.30, 5);
        assertEquals(6.6, result, 1);
    }


}