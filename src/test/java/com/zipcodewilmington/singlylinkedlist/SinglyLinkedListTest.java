package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList<String> stringList;
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;

    @Before
    public void setUp(){
        first = "first";
        second = "second";
        third = "third";
        fourth = "fourth";
        fifth = "fifth";

        stringList = new SinglyLinkedList<String>();

        stringList.add(first);
        stringList.add(second);
        stringList.add(third);
        stringList.add(fourth);
        stringList.add(fifth);
    }

    @Test
    public void addTest1(){
        String expected = first;
        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){

        String expected = second;
        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest3(){
        String expected = third;
        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest(){
        String expected = third;
        stringList.swap(second, third);

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest1(){
        String expected = second;
        stringList.swap(second, third);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest2(){
        String expected = first;
        stringList.swap(second, third);

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void swapTest3(){
        String expected = fourth;
        stringList.swap(second, third);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest(){
        String expected = third;
        stringList.set(1, third);

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest1(){
        String expected = first;
        stringList.set(1, third);

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest2(){
        String expected = third;
        stringList.set(1, third);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFirstIndex(){
        String expected = second;

        stringList.removeFirstIndex();

        String actual = stringList.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFirstIndex1(){
        String expected = third;

        stringList.removeFirstIndex();

        String actual = stringList.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeSecondIndex(){
        String expected = third;

        stringList.removeSecondIndex();

        String actual = stringList.get(1);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeSecondIndex1(){
        String expected = first;

        stringList.removeSecondIndex();

        String actual = stringList.get(0);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeSecondIndex2(){
        String expected = fourth;

        stringList.removeSecondIndex();

        String actual = stringList.get(2);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeOtherIndexes(){
        String expected = fifth;

        stringList.removeOtherIndex(3);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOtherIndexes1(){
        String expected = third;

        stringList.removeOtherIndex(3);

        String actual = stringList.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastIndex(){
        String expected = third;
        stringList.remove(4);

        String actual = stringList.get(3);

        Assert.assertEquals(expected, actual);
    }

}
