package com.ou1box.metrojourney;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {
    DoubleLinkedList testList;
    ArrayList<String> first;
    ArrayList<String> middle;
    ArrayList<String> last;
    
    @BeforeEach void beforeEach() {
        testList = new DoubleLinkedList();

        first = new ArrayList<String>();
        first.add("f");
        first.add("i");
        first.add("r");
        first.add("s");
        first.add("t");

        middle = new ArrayList<String>();
        middle.add("m");
        middle.add("i");
        middle.add("d");
        middle.add("d");
        middle.add("l");
        middle.add("e");

        last = new ArrayList<String>();
        last.add("l");
        last.add("a");
        last.add("s");
        last.add("t");
    }

    @Test void addTest() {
        testList.add(last);
        testList.add(middle);
        testList.add(first);
        assertEquals(first, testList.getFirst().value);
    }

    @Test void appendTest() {
        testList.append(first);
        testList.append(middle);
        testList.append(last);
        assertEquals(last, testList.getLast().value);
    }

    @Test void insertTest() throws Exception{
        testList.add(first);
        testList.append(last);
        testList.insert(middle, 1);
        assertEquals(middle, testList.getMiddle(1).value);
    }
}
