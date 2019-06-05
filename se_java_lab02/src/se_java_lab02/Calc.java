/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_java_lab02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Twistzz
 */
public class Calc {

    /**
     * Имя файла, используемое при сериализации.
     */
    private static final String FNAME = "Item2d.bin";
    /**
     * Сохраняет результат вычислений. Объект класса {@linkplain Item2d}
     */
    private Item2d result;

    /**
     * Инициализирует {@linkplain Calc#result}
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * Установить значение {@linkplain Calc#result}
     *
     * @param result - новое значение ссылки на объект {@linkplain Item2d}
     */
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * Получить значение {@linkplain Calc#result}
     *
     * @return текущее значение ссылки на объект {@linkplain Item2d}
     */
    public Item2d getResult() {
        return result;
    }

    /**
     * Вычисляет значение функции.
     *
     * @param x - Сгенерированное число.
     * @return Результат вычисления тетрад.
     */
    public int calc(int x) {
        String s = Integer.toBinaryString(x);
        int amount = s.length();
        return amount / 4;
    }

    /**
     * Вычисляет количество тетрад и сохраняет результат в объекте
     * {@linkplain Calc#result}
     *
     * @param x - Сгенерированное число.
     */
    public double init(int x) {
        result.setX(x);
        return result.setY(calc(x));
    }

    /**
     * Выводит результат вычислений.
     */
    public void show() {
        System.out.println(result);
    }

    /**
     * Сохраняет {@linkplain Calc#result} в файле {@linkplain Calc#FNAME}
     *
     * @throws IOException
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Восстанавливает {@linkplain Calc#result} из файла {@linkplain Calc#FNAME}
     *
     * @throws Exception
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
        result = (Item2d) is.readObject();
        is.close();
    }

}
