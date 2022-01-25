public class Main() {
    public static void Main(String[] args) {
        String[] scrambledArray = {"apar", "peple", "that", "cis"};
        String[] nonScrambledArray = {"apple", "pear", "this", "cat"};
        WordScrambler word1 = new WordScrambler(scrambledArray);

        word1.recombine("apple", "pear");
        word1.mixedWords(nonScrambledArray);
    }
}