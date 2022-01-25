public class WordScrambler() {
    private String[] scrambledWords;

    public WordScrambler(String[] scrambledWords) {
        this.scrambledWords = scrambledWords;
    }

    private String recombine(String word1, String word2) {
        return word1.substring(0, (word1.length()/2) + word2.substring((word2.length()/2), word2.substring()))
    }

    // array {"apple", "pear", "this", "cat"} should return arrayResult {"apar", "peple", "that", "cis"}
    private String[] mixedWords(String words[]) {
        String[] result;
        for(int i = 2; i < words.size() + 2; i++) {
            if(i % 2 == 0) {
                result += words.substring(0, words[i].length() / 2) + words.substring()words[i+1].length() / 2, words[i+1].length());
            } else {
                result += words.substring()words[i-1].length() / 2, words[i-1].length()) + words.substring(0, words[i].length() / 2)
            }
        }
    }
}