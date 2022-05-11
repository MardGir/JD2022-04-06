package by.it.marchenko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static final String FIRST_ELEMENT = "one";
    public static final String SECOND_ELEMENT = "two";
    public static final String THIRD_ELEMENT = "three";
    public static final String FORTH_ELEMENT = "four";
    public static final String FIFTH_ELEMENT = "five";

    public static void main(String[] args) {
        List<String> stdList = new ArrayList<>();
        stdList.add(FIRST_ELEMENT);
        stdList.add(SECOND_ELEMENT);
        stdList.add(THIRD_ELEMENT);
        stdList.add(FORTH_ELEMENT);
        stdList.add(FIFTH_ELEMENT);
        System.out.println(stdList);
        stdList.remove(2);
        System.out.println(stdList);
        System.out.println(stdList.get(0));
        System.out.println(stdList.get(stdList.size()-1));

        List<String> myList = new ListA<>();
        myList.add(FIRST_ELEMENT);
        myList.add(SECOND_ELEMENT);
        myList.add(THIRD_ELEMENT);
        myList.add(FORTH_ELEMENT);
        myList.add(FIFTH_ELEMENT);
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        System.out.println(myList.get(0));
        System.out.println(myList.get(myList.size()-1));



    }
}
