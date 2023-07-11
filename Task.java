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
import java.util.Scanner;

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


    // Определение значения того или иного параметра ноутбука в строке по индексам
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

        
        return word;
    }
    ////
    // функция вывода на экран множества
    public static void print_set_of_note(HashSet ObjSet1){
        for (Object str1 : ObjSet1){
            System.out.println(str1);
        }
    }
    
    ////
    public static void filter_of_name(HashSet ObjSet1) {
        HashSet<String> StrSetNote = new HashSet<>(); // множество только для названий ноутбуков
        HashSet<String> StrSetFindNote = new HashSet<>(); // множество с искомыми ноутбуками
        for (Object integer : ObjSet1) {
            String SmallStr = "AllName"; // тип параметра
            int StartID = FindFirstIndexOf(integer.toString(), SmallStr); // ищу индекс начала слова
            int FinalID = StartID + SmallStr.length(); // ищу индекс конца слова
            String Word = FindLastIndexOf(integer.toString(), FinalID);
            StrSetNote.add(Word);
    }
    print_set_of_note(StrSetNote);
    String find = " ";
    System.out.print("Какая модель ноутбука вас интересует? ");
            Scanner scanner = new Scanner(System.in);
            find = scanner.nextLine();
    for (Object String1 : ObjSet1) 
    {
        boolean contains = String1.toString().contains(find);
        if (contains == true){
            System.out.println(String1);
        }
    }
    
    }
    
    


    public static void main(String[] args) {
        HashSet<Object> ObjSet1 = new HashSet<>();
        ObjSet1 = GenerateHashSet();
        //System.out.println(ObjSet1);
        
        // Меню
        System.out.println("Меню фильтрации: \n1 - По названию ноутбука;\n2 - По ОС ноутбука;");
        System.out.println("3 - По цвету ноутбука; \n4 - По обьему RAM; \n5 - По обьему HD;");
        System.out.println("6 - По весу ноутбука; \n7 - По цене ноутбука; \n8 - Выход.");
        

        for (Object integer : ObjSet1) {
            System.out.println(integer.toString());
        }

        
            
        int num = 0;
        while (num != 5) {
            System.out.print("Введите число: ");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            switch (num){
                case 1: filter_of_name(ObjSet1);
                continue;
                case 8:
                break;
                
            }
        }  
            
        }
    }
