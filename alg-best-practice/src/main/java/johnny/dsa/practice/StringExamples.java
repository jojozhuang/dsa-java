package johnny.dsa.practice;

public class StringExamples {
    public static void main(String[] args) {
        StringExample();
        StringSplit();
        StringBuilderExmaple();
        CharacterExample();
    }

    private static void StringExample() {
        // convert string to char array
        String str = "Hello";
        char[] array = str.toCharArray();  // array = ['H','e','l','l','o']

        // convert int to string
        String str2 = String.valueOf(123); // str2 = "123"

        // concatenate strings
        String sub1 = "hello";
        String sub2 = "123";
        String str3 = sub1 + sub2;         // str3 = "hello123";

        // string comparison
        String s1 = "abc";
        String s2 = "abc";
        if (s1 == s2) {      // return false

        }

        if (s1.equals(s2)) { // return true;

        }
    }

    private static void StringSplit() {
        // Split string to string array
        String sentence = "I am a software engineer";
        String[] words = sentence.split(" "); // words = {"I", "am", "a", "software", "engineer"}

        //Split string with regex.
        String complex1 = "1+2i";
        String[] x = complex1.split("\\+|i"); // x = {1, 2};

        String complex2 = "1+2i3";
        String[] y = complex2.split("\\+|i"); // y = {1, 2, 3};

        String complex3 = "1+2i3";
        String[] z = complex3.split("[+i]+"); // z = {1, 2, 3};

        String str4 = "word1, word2 word3@word4?word5.word6";
        String[] arrWords = str4.split("[, ?.@]+"); // arrWords = {"word1", "word2", "word3", "word4", "word5", "word6"}

        String str5 = "Elmo will be on every kid's wishlist!";
        String[] words3 = str5.split("\\W"); // words3 = {"Elmo", "will", "be", "on", "every", "kid", "s", "wishlist"}

        String[] words4 = str5.split("[^\\w]"); // words4 = {"Elmo", "will", "be", "on", "every", "kid", "s", "wishlist"}

        String[] words5 = str5.split("[^\\w']"); // words5 = {"Elmo", "will", "be", "on", "every", "kid's", "wishlist"}

        String[] words6 = str5.split("[ '!]+"); // words6 = {"Elmo", "will", "be", "on", "every", "kid", "s", "wishlist"}

        // The W metacharacter is used to find a word character.
        // A word character is a character from a-z, A-Z, 0-9, including the _ (underscore) character.
        String str6 = "Could you update -my age to variable _count? I'm 18.";
        String[] words7 = str6.split("\\W");
        // words7 = {"Could", "you", "update", "", "my", "age", "to", "variable", "_count", "", "I","m","18"}

        String[] words8 = str6.split("[^\\w]");
        // words8 = {"Could", "you", "update", "", "my", "age", "to", "variable", "_count", "", "I","m","18"}

        String[] words9 = str6.replaceAll("[^a-zA-Z0-9_ ]", "").split("\\s+");
        // words9 = {"Could", "you", "update", "my", "age", "to", "variable", "_count", "Im","18"}

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] words10 = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        // words10 = ["bob", "hit", "a", "ball", "the", "hit", "ball", "flew", "far", "after", "it", "was", "hit"];
    }

    private static void StringBuilderExmaple() {
        // concatenate strings
        String s1 = "hello";
        String s2 = "123";
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        // stringbuilder to string
        sb.toString(); // return "hello123";
        // delete last character of a StringBuilder
        sb.setLength(sb.length() - 1);
        sb.toString(); // return "hello12";

        // reverse
        sb.reverse();
        sb.toString(); // return "21olleh";
    }

    private static void CharacterExample() {
        // get integer value from char
        String s = "ab5d";
        int x = Character.getNumericValue(s.charAt(2)); // x = 5

        // check if character is number(one single character)
        char c = '5';
        Character.isDigit(c);
        // same as
        if (c >= '0' && c <= '9') {

        }

        // check if character is number or letter
        Character.isLetterOrDigit(c);
        // same as
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {

        }
    }
}
