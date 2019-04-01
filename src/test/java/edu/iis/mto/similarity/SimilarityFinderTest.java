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

    @Test
    public void shouldReturnOneIfSequencesAreTheSame() {
        int[] seq1 = {3, 1, 7};
        int[] seq2 = {3, 1, 7};

        assertEquals(1.0d, this.similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }

    @Test
    public void shouldReturnZeroIfSequencesAreDifferent() {
        int[] seq1 = {3, 1, 7};
        int[] seq2 = {4, 2, 8};

        assertEquals(0.0d, this.similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnNullPointerExceptionOnNotInitialisedSequence() {
        int[] seq1 = null;
        int[] seq2 = null;

        this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test
    public void shouldReturnProperJackardIndex() {
        int[] seq1 = {3, 1, 7};
        int[] seq2 = {4, 1, 7};

        assertEquals(0.5d, this.similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }
}
