package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.function.Supplier;

public class SequenceSearchMock implements SequenceSearcher {

    private Supplier<Boolean> searchFoundSupplier = () -> {throw new IllegalArgumentException("SequenceSearchMock SearchFoundSupplier had not been provided");};

    @Override
    public SearchResult search(int key, int[] seq) {
        return SearchResult.builder().withFound(searchFoundSupplier.get()).build();
    }

    public void setSearchFoundSupplier(Supplier<Boolean> searchFoundSupplier) {
        this.searchFoundSupplier = searchFoundSupplier;
    }
}
