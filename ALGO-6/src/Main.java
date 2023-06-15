import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(search("Alibaba or Alibubab? I do not know!", "b*b"));
    }

    public static ArrayList<Integer> search(String source, String pattern) {
        if (source.length() < pattern.length()) {
            System.out.println("Нет такой подстроки!");
            return null;
        }
        ArrayList<Integer> found = new ArrayList<>();
        int patternHash = 0;
        int asterikPosition = 0;
        int windowHash = 0;
        char[] patCharArray = pattern.toCharArray();
        char[] sourCharArray = source.toCharArray();
        for (int i = 0; i < patCharArray.length; i++) {
            if (patCharArray[i] == '*') {
                asterikPosition = i;
            } else {
                patternHash += patCharArray[i];
            }
        }
        for (int k = 0; k < sourCharArray.length - patCharArray.length + 1; k++) {
            if (k == 0) {
                for (int j = 0; j < pattern.length(); j++) {
                    windowHash += sourCharArray[j];
                }
                windowHash -= sourCharArray[asterikPosition];
            } else {
                windowHash -= sourCharArray[k - 1];
                windowHash += sourCharArray[k + pattern.length() - 1];
                windowHash += sourCharArray[k + asterikPosition - 1];
                windowHash -= sourCharArray[k + asterikPosition];
            }
            if (windowHash == patternHash) {
                boolean flag = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (patCharArray[j] != '*' && sourCharArray[k + j] != patCharArray[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) found.add(k);
            }
        }
        if (found.size() > 0) {
            return found;
        } else {
            System.out.println("Подстрока не найдена.");
            return null;
        }
    }
}