/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_java_lab03;

/** Creator
* (шаблон проектирования
* Factory Method)<br>
* Объявляет метод,
* "фабрикующий" объекты
* @author Twistzz
* @version 1.0
* @see Viewable#getView()
*/
public interface Viewable {

    /**
     * Создаёт объект, реализующий {@linkplain View}
     * @return 
     */
    public View getView();
}
