package org.example.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenericsApp {

    public static void main(String[] args) {

        //Generic tipu var norādīt gan klasei gan metodei
        //To mēs izmantojam tad, ja klase vai metode var saturēt/apstrādāt dažādus objektus

        //Klasēs:
        //Vispopulārkais piemērs ir container tipa klases, kuras satur vienu vai vairākus generic tipa objektus

        //Metodēm:
        //Vispopulārākais piemērs ir tad, ja metode izmanto citu klasi ar generic tipu (piem. List, Queue, LazyBox, MyLinkedList)

        LazyBox<String> myBox = new LazyBox<>(GenericsApp::createContents);
        System.out.println(myBox.getContents());

        MyLinkedList<String> myList = new MyLinkedList<>("John");
        myList.addElement("Peter");
        myList.addElement("Lisa");
        myList.addElement("Bob");
        System.out.println(myList);

        MyLinkedList<Integer> numbers = new MyLinkedList<>(10);
        numbers.addElement(12);
        numbers.addElement(14);
        numbers.addElement(16);
        System.out.println(numbers);

        List<String> myList2 = singleValueToList("John");
        List<Integer> myList3 = singleValueToList(123);

        LazyBox<Integer> myBox2 = createLazyBox(() -> 3 + 5);

        Integer myNumber = convert("12", Integer::parseInt);
        String myText = convert(123, (number) -> "[" + number + "]");
        System.out.println("End");

        MyNumber myNewNumber = new MyNumber(10);
        MyNumber x = printOutNumberAndReturn(myNewNumber);


        System.out.println(combine(10, 12, (f, s) -> String.valueOf(f + s)));
        System.out.println(combine(10, 12, GenericsApp::combineF));
    }

    public static String combineF(Integer a, Integer b) {
        return String.valueOf(a + b);
    }

    public static String createContents() {
        return "My box contents";
    }

    public static <V> List<V> singleValueToList(V value) {
        List<V> newList = new ArrayList<>();
        newList.add(value);
        return newList;
    }

    public static <T> LazyBox<T> createLazyBox(Supplier<T> contentCreator) {
        return new LazyBox<>(contentCreator);
    }

    //Nav vērts lietot generic tipu, jo metodes ķermenī un return tipā nav atsauces uz T. Labāk izmantot Object
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }

    //Ir vērts lietot generic tipus, jo tiek pārbaudīts vai From tips sakrīt ar Funkcijas parametru kā arī citas lietas, kā arī
    //tips T tiek pielietots kā return tips
    public static <F, T> T convert(F from, Function<F, T> converter) {
        return converter.apply(from);
    }

    //Ir vērts lietot generic tipu T, jo tādā veidā tiks atgriezts tas pats tips. Ja lietotu BigDecimal, tad metodei
    //var padot MyNumber, bet return tips būs BigDecimal
    public static <T extends BigDecimal> T printOutNumberAndReturn(T number) {
        System.out.println(number.getClass() + "[" + number + "]");
        return number;
    }

    public static <E, V> String combine(E first, V second, BiFunction<E, V, String> combiner) {
        return combiner.apply(first, second);
    }

    /* Izveidot klasi Combiner, kura konstruktorā saņem divus objektus ar
    * dažādiem generic tipiem un saņem funkciju, kura
    * šos abus objektus var pārveidot par String
    * Piemērs funkcionalitātei:
    * Combiner combiner = new Combiner(10, "Teksts", (a, b) -> ???);
    * String result = combiner.combine();
    * System.out.println(result); //Expected result "10-Teksts"
    * */


}
