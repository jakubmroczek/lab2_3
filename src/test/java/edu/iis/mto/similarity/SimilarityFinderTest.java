package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SimilarityFinder sut;
    private SequenceSearchMock sequenceSearchMock;

    private static final double EPSILON = 0.1;

    @Before
    public void setUp() {
        sequenceSearchMock = new SequenceSearchMock();
        sut = new SimilarityFinder(sequenceSearchMock);
    }

    @Test
    public void shouldJaccardIndexBeOneForEqualArrays() {
        int[] first = {1, 2, 3, 4};
        int[] second = {1, 2, 3, 4};

        sequenceSearchMock.setResults(Arrays.asList(true, true, true, true));

        assertEquals(sut.calculateJackardSimilarity(first, second), 1.0, EPSILON);
    }

    @Test
    public void shouldJaccardIndexBeOneForBothEmptyArrays() {
        int[] first = {};
        int[] second = {};

        sequenceSearchMock.setResults(Arrays.asList(true));

        assertEquals(sut.calculateJackardSimilarity(first, second), 1.0, EPSILON);
    }

    @Test
    public void shouldReturnProperJaccardIndex() {
        int[] first = {1, 2, 3, 4, 5, 8, 9};
        int[] second = {5, 8, 9};

        sequenceSearchMock.setResults(Arrays.asList(false, false, false, false, true, true, true));

        assertEquals(sut.calculateJackardSimilarity(first, second), 0.43, EPSILON);
    }

    @Test
    public void shouldSequenceSearchMockBeCalledSevenTimes() {
        int[] first = {1, 2, 3, 4, 5, 8, 9};
        int[] second = {5, 8, 9};

        sequenceSearchMock.setResults(Arrays.asList(false, false, false, false, true, true, true));
        sut.calculateJackardSimilarity(first, second);

        assertEquals(sequenceSearchMock.getCalls(), 7);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowAnExcepetionOnNulls() {
        sut.calculateJackardSimilarity(null, null);
    }

    @Test
    public void shouldJaccardIndexBe0() {
        int[] first = {};
        int[] second = {1};

        assertEquals(sut.calculateJackardSimilarity(first, second), 0.0, EPSILON);
    }
}