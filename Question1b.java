import java.util.*;

public class Question1b {

    public static List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();

        return backtrack(s, 0, dictionary, memo);
    }

    private static List<String> backtrack(String s, int start,
                                          Set<String> dictionary,
                                          Map<Integer, List<String>> memo) {

        if (memo.containsKey(start))
            return memo.get(start);

        List<String> result = new ArrayList<>();

        if (start == s.length()) {
            result.add("");
            return result;
        }

        for (int end = start + 1; end <= s.length(); end++) {

            String word = s.substring(start, end);

            if (dictionary.contains(word)) {

                List<String> subList = backtrack(s, end, dictionary, memo);

                for (String sub : subList) {

                    if (sub.isEmpty())
                        result.add(word);
                    else
                        result.add(word + " " + sub);
                }
            }
        }

        memo.put(start, result);

        return result;
    }

    public static void main(String[] args) {

        String user_query = "nepaltrekkingguide";

        List<String> dictionary = Arrays.asList(
                "nepal", "trekking", "guide", "nepaltrekking"
        );

        List<String> result = wordBreak(user_query, dictionary);

        System.out.println("Possible Sentences:");

        for (String sentence : result) {
            System.out.println(sentence);
        }
    }
}