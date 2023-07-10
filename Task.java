/******************************************************************************
Формат сдачи: ссылка на подписанный git-проект.
Задание
1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
Реализовать в java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и 
выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
*******************************************************************************/

public class Task {

    public static void main(String[] args) {

        NoteBookClass NoteBook1 = new NoteBookClass("B","a", "Q", 4,5,6f,7f);
        NoteBookClass NoteBook2 = new NoteBookClass();
        System.out.println(NoteBook1.getColor());
        NoteBook1.setColor("red");
        System.out.println(NoteBook1.getColor());
        System.out.println(NoteBook1.toString());
    }
}
