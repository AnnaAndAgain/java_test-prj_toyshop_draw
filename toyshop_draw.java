package toyshop_draw;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * toyshop_draw
 */
public class toyshop_draw {

    public static void changeToy(toy toyToChange, String newName, int newWeight){
        // изменяем имеющуюся игрушку (toy), 
        // запрашиваем (принимаем), что изменить (вес, название, кол-во, но НЕ ИД, они должны оставаться фиксированными) 
        if (newName != null) {
            toyToChange.setName(newName);
        }
        
        if (newWeight > 0 && newWeight <=100) {
            toyToChange.setWeight(newWeight);
        } else {
            System.out.println("Некорректное значение веса, должно быть от 0 до 100");
        }
    }

    public static void addToyToQueue(Queue<singleToy> tmpQueue, toy tmpToy){
        // проверяем, есть ли еще игрушки такого типа (ID есть, qty > 0) - вынесла наружу
        // добавлем в очередь
        // уменьшаем кол-во в классе Toy
        // возвраащем обновленную очередь - лучше не надо
        //return tmpQueue;
        singleToy tmpSingleToy = new singleToy(tmpToy.getName(), tmpToy.getId(),tmpToy.getWeight());
        tmpQueue.add(tmpSingleToy);
        tmpToy.setQuantity(tmpToy.getQuantity()-1);
        
        //для промежуточной проверки
        System.out.print("Осталось: " + tmpToy.toString());
    }

    public static void drawTime(Queue<singleToy> tmpQueue){
        // берем самую старую в очереди
        // генерируем случайное число 1-100
        // если <= весу, выписываем "Вы выигради" и поля игрушки в консоль и файл, игрушка удаляется из очереди
        // если больше веса, то выписываем в консоль "увы" и ничего не меняем
        try {
            // в ТЗ кросс-платформенность, поэтому путь к файлу в текущей папке добываем у системы
            String pathToPrj = System.getProperty("user.dir");
            String pathToFile = pathToPrj.concat("/draw-result.txt");
            FileWriter fw = new FileWriter(pathToFile, StandardCharsets.UTF_8);
            
            // разыгрываем игрушки по очереди, пока они не кончатся
            // каждый участник может выиграть ничего или текущую игрушку
            // все участники с результатами пишутся в файл
            int countPpl = 1; // счетчик для ID (порядковые номера) участников
            Random rnd1 = new Random();
            String toWrite = "";
            singleToy tmpSingleToy; // сюда будем писать текущую призовую игрушку

            while (tmpQueue.iterator().hasNext()) {
                tmpSingleToy = tmpQueue.peek();
                int rndVal = rnd1.nextInt(100);
                if (rndVal <= tmpSingleToy.getWeight()){
                    toWrite = "Участник " + countPpl + " выиграл приз: " + tmpSingleToy.toString();
                    fw.write(toWrite);
                    tmpQueue.remove(); //удаляем выигранную игрушку из очереди
                } else {
                    toWrite = "Участник " + countPpl + " ничего не выиграл\n";
                    fw.write(toWrite);
                }
                countPpl++;
            }

            fw.write("Розыгрыш окончен, всем спасибо!\n");

            fw.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // создаем очередь
        Queue<singleToy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());
        Random rnd = new Random();

        // создаем "склад" с игрушками разных типов
        // здесь игрушки заданы жестко, а кол-во и вес — случайным образом (от 1 до 10 и от 1 до 100, соответсвенно)
        // в "полной версии" запрашивали бы название, кол-во и вес у пользователя или брали из БД
        toy toy0 = new toy(0, "мячик", rnd.nextInt(10), rnd.nextInt(100));
        toy toy1 = new toy(1, "кукла", rnd.nextInt(10), rnd.nextInt(100));
        toy toy2 = new toy(2, "машинка", rnd.nextInt(10), rnd.nextInt(100));
        toy toy3 = new toy(3, "мишка", rnd.nextInt(10), rnd.nextInt(100));

        //для промежуточной проверки
        System.out.println("На складе:\n" + toy0.toString() + toy1.toString() + toy2.toString() + toy3.toString());

        // наполняем очередь случайными игрушками со склада
        // допустим, призов будет 10
        for (int i = 0; i < 10; i++){
            int rndVal = rnd.nextInt(4);
            switch (rndVal) {
                case 0:
                    if (toy0.getQuantity() > 0) {
                        addToyToQueue(toyQueue, toy0);
                    } else {
                        i -= 1; //если такие игрушки на складе уже кончились, инициируем доп. прогон цикла
                    }
                    break;
                case 1:
                    if (toy1.getQuantity() > 0) {addToyToQueue(toyQueue, toy1);}
                    else {i -= 1;}
                    break;
                case 2:
                    if (toy2.getQuantity() > 0) {addToyToQueue(toyQueue, toy2);} 
                    else {i -= 1;}
                    break;
                default:
                    if (toy3.getQuantity() > 0) {addToyToQueue(toyQueue, toy3);} 
                    else {i -= 1;}
                    break;
            }
        }

        // и проводим розыгрыш
        drawTime(toyQueue);
        System.out.println("Розыгрыш окончен. До новых встреч!");
    }
}