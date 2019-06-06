/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_java_lab02;

/**
 *
 * @author Twistzz
 */
import java.io.Serializable;

/**
 * Хранит исходные данные и результат вычислений.
 *
 * @author Twistzz
 *
 */
public class Item2d implements Serializable {

    /**
     * Сгенерированное число.
     */
// transient
    private int x;
    /**
     * Результат вычисления тетрад.
     */
    private int y;
    /**
     * Автоматически сгенерированная константа
     */
    private static final long serialVersionUID = 1L;

    /**
     * Инициализирует поля {@linkplain Item2d#x}, {@linkplain Item2d#y}
     */
    public Item2d() {
        x = 0;
        y = 0;
    }

    /**
     * Устанавливает значения полей: аргумента и результата вычисления тетрад.
     *
     * @param x - значение для инициализации поля {@linkplain Item2d#x}
     * @param y - значение для инициализации поля {@linkplain Item2d#y}
     */
    public Item2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Установка значения поля {@linkplain Item2d#x}
     *
     * @param x - значение для {@linkplain Item2d#x}
     * @return Значение {@linkplain Item2d#x}
     */
    public int setX(int x) {
        return this.x = x;
    }

    /**
     * Получение значения поля {@linkplain Item2d#x}
     *
     * @return Значение {@linkplain Item2d#x}
     */
    public int getX() {
        return x;
    }

    /**
     * Установка значения поля {@linkplain Item2d#y}
     *
     * @param y - значение для {@linkplain Item2d#y}
     * @return Значение {@linkplain Item2d#y}
     */
    public int setY(int y) {
        return this.y = y;
    }

    /**
     * Получение значения поля {@linkplain Item2d#y}
     *
     * @return значение {@linkplain Item2d#y}
     */
    public int getY() {
        return y;
    }

    /**
     * Установка значений {@linkplain Item2d#x} и {@linkplain Item2d#y}
     *
     * @param x - значение для {@linkplain Item2d#x}
     * @param y - значение для {@linkplain Item2d#y}
     * @return this
     */
    public Item2d setXY(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Представляет результат вычислений в виде строки.<br>{@inheritDoc}
     */
    @Override
    public String toString() {
        return "Сгенерированное число = " + x + "\nКоличество целых тетрад = " + y;
    }

    /**
     * Автоматически сгенерированный метод.<br>{@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item2d other = (Item2d) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
// изменено сравнение результата вычисления функции
        if (Math.abs(Math.abs(y) - Math.abs(other.y)) > .1e-10) {
            return false;
        }
        return true;
    }
}
