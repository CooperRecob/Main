package frq;

public class WordScrambler {
    private String[] scrambledWords;
    
    public WordScrambler(String[] wordArr) {
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        return word1.substring(0, word1.length()) + word2.substring(0, word2.length());
    }

    public String[] mixedWords(String[] wordArr) {
        String[] array = {};

        for(int i = 2; i < wordArr.length + 2; i++) {
            if(i % 2 == 0) {
                array[i] = recombine(wordArr[i], wordArr[i+1]);
            } else {
                array[i] = wordArr[i].substring(0, wordArr[i].length() / 2) + wordArr[i-1].substring(wordArr[i-1].length() / 2, wordArr.length);
            }
        }
        return array;
    }
}
