import java.io.*;
import java.util.*;

public class ReadFile {

    private StringTokenizer stringParsing;
    private Map<String, Integer> wordList = new HashMap<>();
    private static final Integer WORD_NUMBER = 1;

    public ReadFile() {

    }

    public void readFile(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                stringParsing = new StringTokenizer(word);

                while (stringParsing.hasMoreTokens()) {
                    addWordInList(stringParsing.nextToken());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addWordInList(String word) {

        if (wordList.isEmpty()) {
            wordList.put(word, WORD_NUMBER);
        } else {
            if (wordList.containsKey(word)) {
                wordList.put(word, wordList.get(word) + WORD_NUMBER);
            } else {
                wordList.put(word, WORD_NUMBER);
            }
        }
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    public void printMap() {
        Map<String, Integer> sortedMap = sortMapByValue(wordList);
        for (Map.Entry<String, Integer> element : sortedMap.entrySet()) {
            System.out.println(element.getKey() + ":" + element.getValue());
        }
    }
}
