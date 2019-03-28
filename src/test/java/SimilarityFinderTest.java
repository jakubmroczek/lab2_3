import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimilarityFinderTest {

    @Test
    public void SimilarityFinderTestGoodValue(){
        SimilarityFinder finder=new SimilarityFinder();
        int tab1[]={1,2,3,4,5,6};
        int tab2[]={5,4,6,7,8,9};
        Assertions.assertEquals(0.5,finder.calculateJackardSimilarity(tab1,tab2));
    }

    @Test
    public void SimilarityFinderTestSeqOfZeroSize(){
        SimilarityFinder finder=new SimilarityFinder();
        int tab1[]={};
        int tab2[]={};
        Assertions.assertEquals(1.0,finder.calculateJackardSimilarity(tab1,tab2));
    }
}
