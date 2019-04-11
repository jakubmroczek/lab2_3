package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test
    public void shouldReturnOne() {

        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {1, 2, 3, 4};
        boolean[] seqReturn = {true, true, true, true};

        SequenceSearcher sequenceSearcher = new SequenceSearcherImpl(seqReturn);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        double calculatedValue = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 1.0;
        assertThat(calculatedValue, is(expected));
    }

    @Test
    public void shouldReturnZero() {

        int[] seq1 = {1, 2, 3, 4};
        int[] seq2 = {5, 6, 7, 8};
        boolean[] seqReturn = {false, false, false, false};

        SequenceSearcher sequenceSearcher = new SequenceSearcherImpl(seqReturn);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        double calculatedValue = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        double expected = 0.0;
        assertThat(calculatedValue, is(expected));
    }
}
