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

// https://developer.alexanderklimov.ru/android/java/set.php
import java.util.HashSet;

public class Task {

    // функция заполнения базы данных Ноутбуков
    public static HashSet GenerateHashSet() {
        HashSet<Object> ObjSet = new HashSet<>();

        NoteBookClass NoteBook1 = new NoteBookClass("Dell", "Windows10", "green", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook1);
        NoteBookClass NoteBook2 = new NoteBookClass("Mac", "MacOS", "blue", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook2);
        NoteBookClass NoteBook3 = new NoteBookClass("Accer", "Windows8", "white", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook3);

        return ObjSet;
    }

    // Функция поиска первого индекса подстроки в строке
    public static int FindFirstIndexOf(String BigStr, String SmallStr) {
        int index = BigStr.lastIndexOf(SmallStr);
        return index;
    }


    // Определение значения того или иного параметра в строке по индексам
    public static String FindLastIndexOf(String BigStr, int StartIndex) {
        String word = "";
        for (int i = StartIndex + 1; i < BigStr.length(); i++) {

            char char1 = BigStr.charAt(i);
            if (char1 != ',') {

                word += char1;
            } else {
                break;
            }
        }

        System.out.println(word);
        return word;
    }


    public static void main(String[] args) {
        HashSet<Object> ObjSet1 = new HashSet<>();
        ObjSet1 = GenerateHashSet();
        //System.out.println(ObjSet1);
        for (Object integer : ObjSet1) {
            String str1 = integer.toString();
            char c = str1.charAt(2);
            System.out.println(c);
        }

        for (Object integer : ObjSet1) {
            System.out.println(integer.toString());
        }

        for (Object integer : ObjSet1) {
            String SmallStr = "OpSys"; // тип параметра
            int StartID = FindFirstIndexOf(integer.toString(), SmallStr); // ищу индекс начала слова
            System.out.println(StartID + " " + SmallStr.length());
            int FinalID = StartID + SmallStr.length(); // ищу индекс конца слова
            String Word = FindLastIndexOf(integer.toString(), FinalID);
        }
    }
}
