package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    private SimilarityFinder sut;
    private SequenceSearchMock sequenceSearchMock;

    private static final double EPSILON = 0.0000000001;

    @Before
    public void setUp() {
        sequenceSearchMock = new SequenceSearchMock();
        sut = new SimilarityFinder(sequenceSearchMock);
    }

    @Test
    public void shouldJackardIndexBeOneForEqualArrays() {
        int[] first = {1, 2, 3, 4};
        int[] second = {1, 2, 3, 4};

        sequenceSearchMock.setSearchFoundSupplier(() -> true);

        assertEquals(sut.calculateJackardSimilarity(first, second), 1.0, EPSILON);
    }
}