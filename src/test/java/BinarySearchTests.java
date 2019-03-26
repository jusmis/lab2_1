import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTests {

    @Test
    public void valueIsInOneElementSequence() {
        int seq[] = {1};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertTrue(result.isFound());
    }

}
