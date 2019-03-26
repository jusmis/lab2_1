import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTests {

    @Test
    public void valueIsInOneElementSequence() {
        int seq[] = {1};
        int value = 1;
        final int EXPECTED_VALUE = 0;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertTrue(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void valueIsNotInOneElementSequence() {
        int seq[] = {1};
        int value = 2;
        final int EXPECTED_VALUE = -1;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertFalse(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void valueIsFirstInMultiElementSequence() {
        int seq[] = {1, 2, 3};
        int value = 1;
        final int EXPECTED_VALUE = 0;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertTrue(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void valueIsLastInMultiElementSequence() {
        int seq[] = {1, 2, 3};
        int value = 3;
        final int EXPECTED_VALUE = seq.length - 1;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertTrue(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void valueIsCenterInMultiElementSequence() {
        int seq[] = {1, 2, 3};
        int value = 2;
        final int EXPECTED_VALUE = seq.length / 2;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertTrue(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test
    public void valueIsNotInMultiElementSequence() {
        int seq[] = {1, 2, 3};
        int value = 4;
        final int EXPECTED_VALUE = -1;

        SearchResult result = BinarySearch.search(value, seq);
        Assert.assertFalse(result.isFound());
        Assert.assertEquals(EXPECTED_VALUE, result.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrownWhenSequenceIsEmpty() {
        int[] seq = {};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrownWhenThereAreDuplicatesInSequence() {
        int[] seq = {2, 2};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isExceptionThrownWhenSequenceIsNotSorted() {
        int[] seq = {3, 2};
        int value = 1;

        SearchResult result = BinarySearch.search(value, seq);
    }

}
