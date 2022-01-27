package frq;

public class WordScrambler() {
    private String[] scrambledWords;
    
    public WordScrambler(String[] wordArr) {
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        return word1.substiring(0, word1.length / 2) + word2.substring(word2.length / 2, word2.length);
    }

    private String[] WordScrambler(String[] words) {
        String[] result;

        for(int i = 0; i < words.length; i++) {
            if(i % 2 = 0) {
                result += recombine(words[i], words[i+1]);
            } else {
                result += word[i].substring(0,word[i].length) + word[i-1].substring(word[i-1].length / 2, word[i-1].length);
            }
        }
        return result;
    }
}