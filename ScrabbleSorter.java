package CS210;
import java.util.Scanner;
import java.util.*;

class ScrabbleWord {
    String word;
    int score;

    public ScrabbleWord(String word, int score) {
        this.word = word;
        this.score = score;
    }
}

public class ScrabbleSorter {
    public static int calculateScore(String word) {
        int[] letterScores = {
            1, 1, 1, 1, 1, 1, 1, 1, 1, 1, // A:1, B:1, C:1, ...
            2, 2, // D:2, E:2, ...
            3, 3, 3, 3, // F:3, G:3, ...
            4, 4, 4, 4, 4, 4, // H:4, I:4, ...
            1, // J:8
            1, 1, 1, 1, 1, // K:5, L:1, M:3, N:1, O:1
            3, 3, // P:3, Q:10
            1, 1, 1, 1, 1, 1, // R:1, S:1, T:1, U:1, V:4, ...
            4, 4, // W:4, X:8
            10, 10 // Y:4, Z:10
        };

        int score = 0;
        for (char c : word.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                score += letterScores[c - 'A'];
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<ScrabbleWord> words = new ArrayList<>();

        // Read input and calculate scores
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            int score = calculateScore(word);
            words.add(new ScrabbleWord(word, score));
        }

        // Sort words based on scores and then alphabetically
        Collections.sort(words, Comparator
                .comparingInt((ScrabbleWord sw) -> sw.score)
                .thenComparing(sw -> sw.word));

        // Output the sorted words
        for (ScrabbleWord sw : words) {
            System.out.println(sw.word);
        }
    }
}