package toyshop_draw;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * toyshop_draw
 */
public class toyshop_draw {

    public static void createToy(){
        // создаем доп. игрушку (toy), запрашиваем все поля, 
        // проверяем несовпадение названия, присваиваем ИД
    }

    public static void changeToy(){
        // изменяем имеющуюся игрушку (toy), 
        // запрашиваем, что изменить (вес, название, кол-во НЕ ИД) 
    
    }

    public static PriorityQueue addToyToQueue(PriorityQueue tmpQueue, singleToy Toy){
        // проверяем, есть ли еще игрушки такого типа (ID есть, qty > 0)
        // добавлем в очередь
        // уменьшаем кол-во в классе Toy
        // возвраащем обновленную очередь
    }

    public static void drawTime(PriorityQueue tmpQueue){
        // берем самую старую в очереди
        // генерируем случайное число 1-100
        // если <= весу, выписываем "Вы выигради" и поля игрушки в консоль и файл, игрушка удаляется из очереди
        // если больше веса, то выписываем в консоль "увы" и ничего не меняем

    }

    public static void main(String[] args) {
        
    }
}