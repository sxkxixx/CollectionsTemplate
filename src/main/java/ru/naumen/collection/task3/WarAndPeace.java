package ru.naumen.collection.task3;
import java.nio.file.Path;
import java.util.*;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources",
            "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");

    /**
     * <p>
     *     Для подсчёта каждого слова в тексте используется HashMap, так как операции вставки и чтения имеют сложность O(1).
     *     Операция подсчёта слов имеет сложность O(N), где N - кол-во слов в документе.
     * </p><br/>
     * <p>
     *     Чтобы вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов, необходимо
     *     сортировать Map.Entry. Операция сортировки имеет сложность O(M*log(M)), где M - HashMap.size().
     * </p><br/>
     * <p>
     *     Итоговая сложность: O(N) + O(M*log(M))
     * </p>
     * @since 24.10.2023
     */
    public static void main(String[] args) {
        WordParser parser = new WordParser(WAR_AND_PEACE_FILE_PATH);
        Map<String, Integer> map = new HashMap<>();

        parser.forEachWord(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        List<Map.Entry<String, Integer>> sortedEntries = getSortedEntries(map);
        printMostUsed(sortedEntries);
        System.out.println();
        printLeastUsed(sortedEntries);
    }

    private static List<Map.Entry<String, Integer>> getSortedEntries(Map<String, Integer> map){
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
    }

    private static void printMostUsed(List<Map.Entry<String, Integer>> map) {
        System.out.println("Самые используемые слова");
        for (int i = map.size() - 1; i >= map.size() - 10; i--)
            printEntry(map.get(i));
    }

    private static void printLeastUsed(List<Map.Entry<String, Integer>> map) {
        System.out.println("Самые неиспользуемые слова");
        for (int i = 0; i < 10; i++)
            printEntry(map.get(i));
    }

    private static void printEntry(Map.Entry<String, Integer> entry){
        System.out.println(entry.getKey() + " == " + entry.getValue());
    }
}
