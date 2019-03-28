import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimilarityFinderTest {

    @Test
    public static void calculateJackardSimilarityTest(){

        SequenceSercher sequenceSercher = new SequenceSercher();

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSercher);

        int[] seq1 = {1,2,3,4};
        int[] seq2 = {1,2,3,4};

        Assertions.assertEquals(1,similarityFinder.calculateJackardSimilarity(seq1,seq2));

        int[] seq3 = {1,2,5,6};
        int[] seq4 = {1,2,7,8};

        Assertions.assertEquals(0.5,similarityFinder.calculateJackardSimilarity(seq3,seq4));


    }


}
