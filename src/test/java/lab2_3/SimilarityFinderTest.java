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
	
	@Test
	public void shouldReturnZeroWhenSequencesAreNotEqual() {
		int[] seq1 = {1,2,3,4,5,6,7};
		int[] seq2 = {12,23,42,46,56,57,88,91};
		
		for(int i = 0 ; i < seq1.length ; i++) {
			stub.getIsFound().add(false);
		}
		
		double expectedResult = finder.calculateJackardSimilarity(seq1, seq2);
		
		assertThat(expectedResult, is(0.0));
	}
	
	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionWhenSequencesAreNotInitialized() {
		int[] seq1 = null;
		int[] seq2 = null;
		
		double expectedResult = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(expectedResult, is(1.0));
	}
	
	@Test
	public void shouldReturnZeroWhenOneSequenceIsEmpty() {
		int[] seq1 = {3,4,5};
		int[] seq2 = {};
		
		for(int i = 0 ; i < seq1.length ; i++) {
			stub.getIsFound().add(false);
		}
		
		double expectedResult = finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(expectedResult, is(0.0));
	}
	
	@Test
	public void searchMethodShouldBeCalledOncePerElementInSequence() {
		int seq1[] = {4,5,6,7};
		int seq2[] = {4,5};
		
		stub.getIsFound().add(true);
		stub.getIsFound().add(true);
		stub.getIsFound().add(false);
		stub.getIsFound().add(false);
		
		finder.calculateJackardSimilarity(seq1, seq2);
		assertThat(stub.getInvocationCount(), is(4));
	}
}
