import java.util.*;

public class WordFrequencyGame {

    private static final String NEW_LINE_DELIMITER = "\n";
    public static final String SPACE_DELIMITER = " ";
    private static final String SPACE_PATTERN = "\\s+";

    public String getResult(String sentence) {
        try {
            List<WordInfo> wordInfoList = calculateWordCount(sentence);
            return getOutputResult(wordInfoList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private List<WordInfo> calculateWordCount(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfoList = new ArrayList<>();

        for (String word : new HashSet<>(words)) {
            int wordCount = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, wordCount));
        }
        wordInfoList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());
        return wordInfoList;
    }

    private String getOutputResult(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEW_LINE_DELIMITER);
        for (WordInfo word : wordInfoList) {
            String formattedWordCountResult = word.getWord() + SPACE_DELIMITER + word.getWordCount();
            joiner.add(formattedWordCountResult);
        }
        return joiner.toString();
    }
}
