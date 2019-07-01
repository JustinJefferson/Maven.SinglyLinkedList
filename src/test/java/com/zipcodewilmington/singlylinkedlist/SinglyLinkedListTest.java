package com.zipcodewilmington.singlylinkedlist;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 1;

        //When
        list.add(expected);
        Integer actual = list.get(0);

        //Then
        assertEquals(expected, actual);

    }

    @Test
    public void addTest2() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 1;

        //When
        list.add(expected);
        list.add(3);
        list.add(5);


        //Then
        assertTrue(list.contains(expected));

    }

    @Test
    public void removeTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 1;
        list.add(5);
        list.add(3);
        list.add(expected);

        assertTrue(list.contains(expected));

        //When
        list.remove(1);
        Integer actual = list.get(1);

        //Then
        assertEquals(expected, actual);


    }

    @Test
    public void sizeTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 3;
        list.add(4);
        list.add(3);
        list.add(5);


        //Then
        Integer actual = list.size();

        assertEquals(expected, actual);

    }

    @Test
    public void findTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 1;
        list.add(4);
        list.add(3);
        list.add(5);


        //Then
        Integer actual = list.find(3);

        assertEquals(expected, actual);

    }

    @Test
    public void sortTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedFirst = 3;
        Integer expectedSecond = 4;
        Integer expectedLast = 5;
        list.add(expectedLast);
        list.add(expectedFirst);
        list.add(expectedSecond);

        //When
        list.sort();

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        //Then
        assertEquals(expectedFirst, list.get(0));
        assertEquals(expectedSecond, list.get(1));
        assertEquals(expectedLast, list.get(2));

    }

    @Test
    public void reverseTest1() {

        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedFirst = 3;
        Integer expectedSecond = 4;
        Integer expectedLast = 5;
        list.add(expectedLast);
        list.add(expectedSecond);
        list.add(expectedFirst);

        //When
        list.reverse();

        //Then
        assertEquals(expectedFirst, list.get(0));
        assertEquals(expectedSecond, list.get(1));
        assertEquals(expectedLast, list.get(2));

    }

    @Test
    public void copyTest1() {
        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedFirst = 3;
        Integer expectedSecond = 4;
        Integer expectedLast = 5;
        list.add(expectedFirst);
        list.add(expectedSecond);
        list.add(expectedLast);

        //When
        SinglyLinkedList<Integer> actual = list.copy();

        //Then
        assertEquals(expectedFirst, actual.get(0));
        assertEquals(expectedSecond, actual.get(1));
        assertEquals(expectedLast, actual.get(2));
    }

    @Test
    public void sliceTest1() {
        //Given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedFirst = 3;
        Integer expectedSecond = 4;
        Integer expectedLast = 5;
        list.add(expectedFirst);
        list.add(expectedSecond);
        list.add(expectedLast);
        list.add(6);
        list.add(7);

        //When
        SinglyLinkedList<Integer> actual = list.slice(1, 3);

        //Then
        assertEquals(expectedSecond, actual.get(0));
        assertEquals(expectedLast, actual.get(1));
    }
}
