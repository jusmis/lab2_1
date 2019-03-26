/**
 *
 */
package edu.iis.mto.bsearch;

/**
 * Utility Class dla wyszukiwania binarnego
 *
 */
public class BinarySearch {

    private BinarySearch() {}

    /**
     * Metoda realizujaca wyszukiwanie binarne
     *
     * @param key
     *            - szukany obiekt
     * @param seq
     *            - rosnaco uporzadkowana niepusta sekwencja
     * @return obiekt rezultatu o polach: - found (true jezeli znaleziony) - position (jezeli znaleziony - pozycja w
     *         sekwencji, jezeli nie znaleziony -1)
     */
    public static SearchResult search(int key, int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException();
        }
        if (checkForDuplicates(seq)) {
            throw new IllegalArgumentException();
        }
        if (isNotSorted(seq)) {
            throw new IllegalArgumentException();
        }
        int start = 0;
        int end = seq.length - 1;
        int center;
        SearchResult result = new SearchResult();

        while (start <= end) {
            center = (start + end) / 2;
            if (seq[center] == key) {
                result.setPosition(center);
                break;
            } else {
                if (seq[center] < key) {
                    start = center + 1;
                } else {
                    end = center - 1;
                }
            }

        }
        return result;
    }

    private static boolean checkForDuplicates(int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            for (int j = 0; j < seq.length; j++) {
                if ( i != j && seq[j] == seq[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isNotSorted(int[] seq) {
        for (int i = 0; i < seq.length - 1; i++){
            if (seq[i] > seq[i+1]){
                return true;
            }
        }
        return false;
    }

}
