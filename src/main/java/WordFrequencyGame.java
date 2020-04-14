import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String NEW_LINE_DELIMITER = "\n";
    public static final String SPACE_DELIMITER = " ";
    private static final String SPACE_PATTERN = "\\s+";

    public String getResult(String sentence) {
        List<WordInfo> wordInfoList = calculateWordCount(sentence);
        return getOutputResult(wordInfoList);
    }

    private List<WordInfo> calculateWordCount(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfoList = new ArrayList<>();

        for (String word : new HashSet<>(words)) {
            int wordCount = Collections.frequency(words, word);
            wordInfoList.add(new WordInfo(word, wordCount));
        }
        return wordInfoList;
    }

    private String getOutputResult(List<WordInfo> wordInfoList) {
        return wordInfoList
                .stream()
                .sorted(Comparator.comparingInt(WordInfo::getWordCount).reversed())
                .map(wordInfo -> wordInfo.getWord() + SPACE_DELIMITER + wordInfo.getWordCount())
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }
}
