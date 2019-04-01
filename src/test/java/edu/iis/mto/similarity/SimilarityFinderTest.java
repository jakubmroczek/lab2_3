package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {
    private SequenceSearcher sequenceSearcher;
    private SimilarityFinder similarityFinder;

    @Before
    public void init() {
        this.sequenceSearcher = new SequenceSearcherDoubler();
        this.similarityFinder = new SimilarityFinder(sequenceSearcher);
    }

    @Test
    public void shouldReturnOneIfSequenceHasLengthZero() {
        int[] seq1 = new int[1];
        int[] seq2 = new int[1];

        assertEquals(1.0d, this.similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }
}
