/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_java_lab02;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import se_java_lab02.Calc;

/**
 *
 * @author Twistzz
 */
public class MainTest {

    /**
     * Проверка основной функциональности класса {@linkplain Calc}
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        calc.init(0);
        assertEquals(0.0, calc.getResult().getY(), .1e-10);
        calc.init(12);
        assertEquals(1.0, calc.getResult().getY(), .1e-10);
        calc.init(156);
        assertEquals(2.0, calc.getResult().getY(), .1e-10);
        calc.init(8);
        assertEquals(1.0, calc.getResult().getY(), .1e-10);
        calc.init(999);
        assertEquals(2.0, calc.getResult().getY(), .1e-10);
    }

    /**
     * Проверка сериализации. Корректность восстановления данных.
     */
    @Test
    public void testRestore() {
        Calc calc = new Calc();
        double x, y;
        for (int ctr = 0; ctr < 1000; ctr++) {
            x = (int) (Math.random() * 1000);
            y = calc.init((int) x);
            try {
                calc.save();
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
            calc.init((int) (Math.random() * 360));
            try {
                calc.restore();
            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
            assertEquals(y, calc.getResult().getY(), .1e-10);
            assertEquals(x, calc.getResult().getX(), .1e-10);
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
