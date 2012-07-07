package org.bala.scratch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * User: murali
 * Time: 6/30/12 12:49 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class MockingBird {

    @Mock
    ArrayList mockedList;

    @Before
    public void setup() {
    }

    @After
    public void tearOff() {
    }

    @Test
    public void verifyInteractionsSelectively() {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - does not throw any 'unexpected interaction' exception
        mockedList.add("nest");
        mockedList.add("bird");
        mockedList.clear();

        // selective & explicit verification i.e., at least the following interactions should have taken place
        verify(mockedList).add("bird");
        verify(mockedList).clear();
    }

    @Test(expected=RuntimeException.class)
    public void stubMethodCalls() {
        //  apart from interfaces, can mock concrete classes too
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing - before call
        when(mockedList.get(0)).thenReturn("zeroth");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        //when(mockedList.get(anyInt())).thenReturn("someNumber!");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }

    @Test
    public void argumentMatcher() {
        ArrayList mockedList = mock(ArrayList.class);

        when(mockedList.get(anyInt())).thenReturn("element");

        //when(mockedList.get(argThat(isValid()))).thenReturn("element");

        System.out.println(mockedList.get(999));

        verify(mockedList).get(anyInt());
    }


    @Test
    public void verifyNumberOfInvocations() {
         //= mock(ArrayList.class);

        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("thrice");
        mockedList.add("thrice");
        mockedList.add("thrice");

        // both of the following are the same
        verify(mockedList).add("once");
        verify(mockedList,times(1)).add("once");

        verify(mockedList,times(2)).add("twice");

        // both of the following are the same
        verify(mockedList,never()).add("never happened");
        verify(mockedList,times(0)).add("never happened");

        // at least / at most
        verify(mockedList,atLeast(1)).add("thrice");
        verify(mockedList,atMost(2)).add("twice");
    }

    @Test(expected = RuntimeException.class)
    public void stubbingVoidMethodsWithExceptions() {
        ArrayList mockedList = mock(ArrayList.class);

        doThrow(RuntimeException.class).when(mockedList).clear();

        mockedList.clear();

    }


}
