/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_java_lab03;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;

import se_java_lab02.Item2d;

/**
 * Выполняет тестирование разработанных классов.
 *
 * @author Twistzz
 * @version 2.0
 */
public class MainTest {

    /**
     * Проверка основной функциональности класса {@linkplain ViewResult}
     */
    @Test
    public void testCalc() {
        ViewResult view = new ViewResult(5);
        view.init(50);
        Item2d item = new Item2d();
        int ctr = 0;
        item.setXY(0, 0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setXY(50, 1);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setXY(100, 1);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setXY(150, 2);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
        ctr++;
        item.setXY(200, 2);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
    }

    /**
     * Проверка сериализации. Корректность восстановления данных.
     */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
// Вычислим количество тетрад со случайным шагом приращения числа
        view1.init((int) (Math.random() * 100));
// Сохраним коллекцию view1.items
        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
// Загрузим коллекцию view2.items
        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
// Должны загрузить столько же элементов, сколько сохранили
        assertEquals(view1.getItems().size(), view2.getItems().size());
// Причем эти элементы должны быть равны.
// Для этого нужно определить метод equals
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}
