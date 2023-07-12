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


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task {

    // функция заполнения базы данных Ноутбуков
    public static HashSet GenerateHashSet() {
        HashSet<Object> ObjSet = new HashSet<>();

        NoteBookClass NoteBook1 = new NoteBookClass("Dell", "Win11", "green", 4, 128, 1.63f, 21.632f);
        ObjSet.add(NoteBook1);
        NoteBookClass NoteBook2 = new NoteBookClass("MacBook", "MacOS", "blue", 8, 256, 1.67f, 126.425f);
        ObjSet.add(NoteBook2);
        NoteBookClass NoteBook3 = new NoteBookClass("Acer", "WinHome", "white", 4, 128, 1.65f, 30.130f);
        ObjSet.add(NoteBook3);
        NoteBookClass NoteBook4 = new NoteBookClass("Lenovo", "Windows8", "black", 32, 1024, 2.0f, 490.432f);
        ObjSet.add(NoteBook4);
        NoteBookClass NoteBook5 = new NoteBookClass("Hp", "FreeDos", "white", 8, 256, 1.75f, 90.058f);
        ObjSet.add(NoteBook5);
        NoteBookClass NoteBook6 = new NoteBookClass("Asus", "Windows8", "black", 8, 512, 1.7f, 41.171f);
        ObjSet.add(NoteBook6);
        NoteBookClass NoteBook7 = new NoteBookClass("Asus", "Win11", "black", 8, 512, 1.8f, 45.361f);
        ObjSet.add(NoteBook7);
        NoteBookClass NoteBook8 = new NoteBookClass("Hp", "WinHome", "white", 16, 512, 1.46f, 67.851f);
        ObjSet.add(NoteBook8);
        NoteBookClass NoteBook9 = new NoteBookClass("MacBook", "MacOS", "blue", 32, 1024, 1.6f, 311.250f);
        ObjSet.add(NoteBook9);
        NoteBookClass NoteBook10 = new NoteBookClass("Dell", "Linux", "green", 8, 512, 1.52f, 66.212f);
        ObjSet.add(NoteBook10);
        NoteBookClass NoteBook11 = new NoteBookClass("Lenovo", "Linux", "black", 8, 512, 1.4f, 84.228f);
        ObjSet.add(NoteBook11);

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

    // функция вывода на экран множества
    public static void print_set_of_note(HashSet ObjSet1) {
        for (Object str1 : ObjSet1) {
            System.out.println(str1.toString());
        }
    }

    // функция поиска по стринг (название ноутбука, название ОС, цвет)
    public static HashSet filter_of_name(HashSet ObjSet1, String FindStr) {
        HashSet<String> StrSetNote = new HashSet<>(); // множество только различных параметров
        HashSet<Object> FindStrSetNote = new HashSet<>();
        for (Object integer : ObjSet1) {
            String SmallStr = FindStr; // Искомый параметр 
            int StartID = FindFirstIndexOf(integer.toString(), SmallStr)+1; // ищу индекс начала слова
            int FinalID = StartID + SmallStr.length(); // ищу индекс конца слова 
            String Word = FindLastIndexOf(integer.toString(), FinalID); // нахожу значение, что соответствует параметру
            StrSetNote.add(Word); // генерирую множество различных значений параметров
        }

        print_set_of_note(StrSetNote); // вывожу на экран найденные все наименования (различные названия, ОС, цвета)
        String find = " ";
        System.out.print("Введите наименование? "); // Провожу выборку из тех вариантов что есть в HashSet
        Scanner scanner = new Scanner(System.in);
        find = scanner.nextLine();
        System.out.println("________________________");
        for (Object String1 : ObjSet1) // вывожу на экран все ноутбуки с определенным параметром
        {
            boolean contains = String1.toString().contains(find); // проверяю, есть или нет значение параметра в описании ноутбука
            if (contains == true) {
                System.out.println(String1);
                FindStrSetNote.add(String1);
            }
        }
        System.out.println("________________________");
        return FindStrSetNote;
        
    }

    public static void print_menu() {
        // Меню
        System.out.println("Меню фильтрации: \n1 - По названию ноутбука;\n2 - По ОС ноутбука;");
        System.out.println("3 - По цвету ноутбука; \n4 - Минимальным параметрам; \n5 - Очистить фильтр поиск;");
        System.out.println("6 - Выход.");
    }

    // Меню для параметров
    public static void print_menu_of_value() {
        System.out.println("Меню фильтрации по минимальным параметрам: \n1 - RAM;\n2 - Hd;");
        System.out.println("3 - weight; \n4 - price; \n5 - Вывести результат.");
    }

    // Функция фильтрации по минимальным параметрам (генерация hash запроса)
    public static void filter_of_value(HashSet ObjSet1) {
        HashMap<String, Double> Value1Hash = new HashMap<>();

        int num = 0;
        while (num != 5) {
            print_menu_of_value(); // функция вызова в консоль меню параметров
            System.out.println(Value1Hash); // выводит информацию какие параметры уже введены 
            double Value1 = 0f; // переменная для значений параметров
            System.out.print("Введите номер парметра: ");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num == 5) {
                break;
            }
            System.out.print("Введите значение парметра: ");
            Value1 = scanner.nextDouble();
            switch (num) {
                case 1:
                    Value1Hash.put("RAM", Value1);
                    continue;
                case 2:
                    Value1Hash.put("Hd", Value1);
                    continue;
                case 3:
                    Value1Hash.put("weight", Value1);
                    continue;
                case 4:
                    Value1Hash.put("price", Value1);
                    continue;
                case 5:
                    break;
            }
        }
        System.out.println("________________________");
        print_filter_result(Value1Hash, ObjSet1);
        System.out.println("________________________");

    }

    // Функция фильтрации по минимальным параметрам (печать в соответствии с hash)
    public static void print_filter_result(HashMap Value1Hash, HashSet ObjSet1) {
        Set<String> keys = Value1Hash.keySet(); // создаю множество всех ключей hash-апроса

        // Цикл в цикле: пробегаюсь по всем ключам hash-апроса и сравниваю результат запроса со значениями из БД
        for (Object integerKey : keys) {
            for (Object integerBig : ObjSet1) {
                int StartID = FindFirstIndexOf(integerBig.toString(), integerKey.toString());
                int FinalID = StartID + integerKey.toString().length();
                String Word = FindLastIndexOf(integerBig.toString(), FinalID); // значение параметра из БД по ноутбукам
                Double number = Double.parseDouble(Word); // перевожу str в double

                Double rez = Double.parseDouble(Value1Hash.get(integerKey).toString()); // значение параметра из hash-запроса
                // провожу сравнение значение hash-запроса с параметрами из БД
                if (rez < number) {
                    System.out.println(integerBig.toString().substring(13));
                }
            }
        }
    }

    // функция для остановки выполнения программы
    public static void Stop_program() {
        System.out.print("Для продолжения введите любую букву ");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
    }

    public static void main(String[] args) {
        HashSet<Object> ObjSet1 = new HashSet<>();
        ObjSet1 = GenerateHashSet();

        // вывожу в консоль всю БД по ноутбукам без первых 13 символом (т.е. без названия класса NoteBookClass)
        for (Object integer : ObjSet1) {
            System.out.println(integer.toString().substring(13));
        }

        int num = 0;
        while (true) {
            print_menu();
            System.out.print("Введите число: ");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num == 6){break;}
        
            switch (num) {
                case 1:
                    ObjSet1 = filter_of_name(ObjSet1, "Name");
                    Stop_program();
                    continue;
                case 2:
                    ObjSet1 = filter_of_name(ObjSet1, "OpSys");
                    Stop_program();
                    continue;
                case 3:
                    ObjSet1 = filter_of_name(ObjSet1, "color");
                    Stop_program();
                    continue;
                case 4:
                    filter_of_value(ObjSet1);
                    Stop_program();
                    continue;
                case 5:
                    ObjSet1 = GenerateHashSet();
                    System.out.println("Фильтр очищен!");
                    Stop_program();
                    continue;
            }
        }
    }
}
