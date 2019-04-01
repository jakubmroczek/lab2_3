package edu.iis.mto.similarity;

import edu.iis.mto.search.SequenceSearcher;
import org.junit.Before;

import static org.junit.Assert.*;

public class SimilarityFinderTest {
    private SequenceSearcher sequenceSearcher;
    private SimilarityFinder similarityFinder;

    @Before
    public void init() {
        this.sequenceSearcher = new SequenceSearcherDoubler();
        this.similarityFinder = new SimilarityFinder(sequenceSearcher);
    }
}
