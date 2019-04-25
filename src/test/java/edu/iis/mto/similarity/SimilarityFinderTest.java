package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test
    public void shouldReturnOneIfSequenceHasLengthZero() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherDoubler(new boolean[] {});
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {};
        int[] seq2 = {};

        assertEquals(1.0d, similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }

    @Test
    public void shouldReturnOneIfSequencesAreTheSame() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherDoubler(new boolean[] {true, true, true});
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {3, 1, 7};
        int[] seq2 = {3, 1, 7};

        assertEquals(1.0d, similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }

    @Test
    public void shouldReturnZeroIfSequencesAreDifferent() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherDoubler(new boolean[] {false, false, false});
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {3, 1, 7};
        int[] seq2 = {4, 2, 8};

        assertEquals(0.0d, similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnNullPointerExceptionOnNotInitialisedSequence() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherDoubler(new boolean[] {});
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        int[] seq1 = null;
        int[] seq2 = null;

        similarityFinder.calculateJackardSimilarity(seq1, seq2);
    }

    @Test
    public void shouldReturnProperJackardIndex() {
        SequenceSearcher sequenceSearcher = new SequenceSearcherDoubler(new boolean[] {false, true, true});
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int[] seq1 = {3, 1, 7};
        int[] seq2 = {4, 1, 7};

        assertEquals(0.5d, similarityFinder.calculateJackardSimilarity(seq1, seq2), 0);
    }
}
