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
import java.util.HashMap;

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
        NoteBookClass NoteBook4 = new NoteBookClass("Lenovo", "Windows8", "black", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook4);
        NoteBookClass NoteBook5 = new NoteBookClass("Hp", "Windows8", "white", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook5);
        NoteBookClass NoteBook6 = new NoteBookClass("Asus", "Windows8", "black", 4, 5, 6f, 7f);
        ObjSet.add(NoteBook6);

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
    // функция поиска по стринг (название ноутбука и название ОС)
    public static void filter_of_name(HashSet ObjSet1, String FindStr) {
        HashSet<String> StrSetNote = new HashSet<>(); // множество только различных параметров
       
        for (Object integer : ObjSet1) {
            String SmallStr = FindStr; // Искомый параметр 
            int StartID = FindFirstIndexOf(integer.toString(), SmallStr); // ищу индекс начала слова
            int FinalID = StartID + SmallStr.length(); // ищу индекс конца слова 
            String Word = FindLastIndexOf(integer.toString(), FinalID); // нахожу значение, что соответствует параметру
            StrSetNote.add(Word); // генерирую множество различных параметров
    }
    print_set_of_note(StrSetNote); // вывожу на экран найденные все наименования
    String find = " ";
    System.out.print("Введите наименование? ");
            Scanner scanner = new Scanner(System.in);
            find = scanner.nextLine();
    for (Object String1 : ObjSet1) // вывожу на экран все ноутбуки с определенным имененм
    {
        boolean contains = String1.toString().contains(find);
        if (contains == true){
            System.out.println(String1);
        }
    }
    
    }
    ////
    public static void print_menu(){
         // Меню
        System.out.println("Меню фильтрации: \n1 - По названию ноутбука;\n2 - По ОС ноутбука;");
        System.out.println("3 - По цвету ноутбука; \n4 - Минимальным параметрам; \n5 - Выход.");
    }
    
    ////
    // Меню для параметров
    public static void print_menu_of_value()
    {
    System.out.println("Меню фильтрации по минимальным параметрам: \n1 - RAM;\n2 - Hd;");
    System.out.println("3 - weight; \n4 - price; \n5 - Выход.");    
    }
    ////
    // Функция фильтрации по минимальным параметрам (генерация hash запроса)
    public static void filter_of_value(HashSet ObjSet1){
        HashMap<String, Double> Value1Hash = new HashMap<>();
        
        int num = 0;
        while (num != 5) {
            print_menu_of_value();
            System.out.println(Value1Hash);
            double Value1 = 0f;
            System.out.print("Введите номер парметра: ");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num == 5){break;}
            System.out.print("Введите значение парметра: ");
            Value1 = scanner.nextDouble();
            switch (num){
                case 1:  Value1Hash.put("RAM", Value1);
                continue;
                case 2:  Value1Hash.put("Hd", Value1);
                continue;
                case 3:  Value1Hash.put("weight", Value1);
                continue;
                case 4:  Value1Hash.put("price", Value1);
                continue;
                case 5:
                break;
            }
        }
        print_filter_result(Value1Hash, ObjSet1);
        
    }
    // Функция фильтрации по минимальным параметрам (печать в соответствии с hash)
    public static void print_filter_result(HashMap Value1Hash, HashSet ObjSet1){
        System.out.println("!!!!!!");
    }
    
    
    


    public static void main(String[] args) {
        HashSet<Object> ObjSet1 = new HashSet<>();
        ObjSet1 = GenerateHashSet();
        //System.out.println(ObjSet1);
        
        for (Object integer : ObjSet1) {
            System.out.println(integer.toString());
        }
            
        int num = 0;
        while (num != 5) {
            print_menu();
            System.out.print("Введите число: ");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            switch (num){
                case 1: filter_of_name(ObjSet1, "AllName");
                continue;
                case 2: filter_of_name(ObjSet1, "OpSys");
                continue;
                case 3: filter_of_name(ObjSet1, "color");
                continue;
                case 4: filter_of_value(ObjSet1);
                continue;
                case 5:
                break;
            }
        }  
            
        }
    }
