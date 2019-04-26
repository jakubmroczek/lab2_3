package edu.iis.mto.similarity;

import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherStub implements SequenceSearcher {

	private int invocationCount = 0;
	private List<Boolean> isFound = new ArrayList<>();
	
	@Override
	public SearchResult search(int key, int[] seq) {
		this.invocationCount++;
		SearchResult.Builder builder = SearchResult.builder();
		builder.withFound(isFound.get(isFound.size()-1));
		builder.withFound(isFound.remove(isFound.size()-1));
		return builder.build();
	}
	
	public List<Boolean> getIsFound(){
		return this.isFound;
	}
	
	public int getInvocationCount() {
		return this.invocationCount;
	}
	
}
