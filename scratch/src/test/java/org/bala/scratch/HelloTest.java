package org.bala.scratch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Demonstrates the use of Mockito.spy. to use when you need to mock a 'static' method of a 3rd party library
 *
 * User: murali
 * Time: 7/1/12 5:40 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloTest {

    @Mock
    Pair pair;

    private Hello hello;

    @Before
    public void setup() {
        //System-under-Test
        hello = spy( new Hello(pair) );
    }

    @Test
    public void test2() {

        // this bypasses calling Pair.getRandomNumber(),
        // so, while stepping through, you may go through Mockito code.
        // To avoid, you may setup Debug->Filtering (Eclipse) / Debugger->Stepping (IntelliJ)
        doReturn( 13L ).when( hello ).getRandomNumber();

        when(pair.first()).thenReturn("Father");
        when(pair.second()).thenReturn("Mother");

        hello.sayHelloToThePair();

        verify(pair,atMost(1)).first();
        verify(pair,atMost(1)).second();


    }

}
