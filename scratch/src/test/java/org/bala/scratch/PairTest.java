package org.bala.scratch;

import org.junit.Test;

import static org.hamcrest.core.Is.is; // ok
import static org.junit.Assert.assertThat; // ok

//import static org.hamcrest.CoreMatchers.is; // notok
//import static org.hamcrest.MatcherAssert.assertThat; // notok
import static org.mockito.Mockito.*;

import java.util.List;

/**
 * User: murali
 * Time: 6/30/12 11:00 AM
 */
public class PairTest {

    @Test
    public void testPair1() {
        Pair<String,Integer> pair = new Pair<String, Integer>("Bala",1000000);
        assertThat(pair.first(),is("Bala"));
        assertThat(pair.second(),is(1000000));
    }

    @Test
    public void testPair2() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

}
