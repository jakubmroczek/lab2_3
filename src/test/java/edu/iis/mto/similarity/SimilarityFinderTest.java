package edu.iis.mto.similarity;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimilarityFinderTest {

    @Test
    public void shouldReturn1ForEmptyArrays() {
        Iterable<Boolean> mockedResults = Collections.emptyList();
        SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler(mockedResults);
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);

        int[] seq1 = {};
        int[] seq2 = {};

        assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), is(1.0));
    }
}
