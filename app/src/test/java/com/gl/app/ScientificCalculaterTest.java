package com.gl.app;

import com.gl.app.Iservice.IScintificCalculater;
import com.gl.app.Iservice.service.BasicCalculaterImpl;
import com.gl.app.Iservice.service.ScintificCalculaterImpl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScientificCalculaterTest {
    private IScintificCalculater scintificCalculater = null;

    @Before
    public void init() {
        scintificCalculater = new ScintificCalculaterImpl();
    }

    @Test
    public void log_test_Correction(){
      double result=  scintificCalculater.log(12);
        assertEquals(result,2.4849,4);
    }


    @Test
    public void logn_test_Correction(){
        double result=  scintificCalculater.logn(12);
        assertEquals(result,1.079,3);
    }


    @Test
    public void log_test_NoCorrection(){
        double result=  scintificCalculater.log(1);
        assertNotEquals(result,3.123);
    }

}
