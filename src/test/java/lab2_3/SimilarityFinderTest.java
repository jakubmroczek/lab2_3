package lab2_3;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import edu.iis.mto.similarity.SequenceSearcherStub;
import edu.iis.mto.similarity.SimilarityFinder;

public class SimilarityFinderTest {
	
	SequenceSearcherStub stub;
	SimilarityFinder finder;
	
	@Before
	public void initialize() {
		stub = new SequenceSearcherStub();
		finder = new SimilarityFinder(stub);
	}
	
	@Test
	public void shouldReturnOneWhenSequencesAreEqual() {
		int[] seq1 = {1,2,3,4,5,6,7};
		int[] seq2 = {1,2,3,4,5,6,7};
		
		for(int i = 0 ; i < seq1.length ; i++) {
			stub.getIsFound().add(true);
		}
		
		double expectedResult = finder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(expectedResult, is(1.0));
	}
}
