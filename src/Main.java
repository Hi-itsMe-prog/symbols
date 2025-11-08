import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {

            String content = Files.readString(Paths.get("data.txt"));

            Pattern pattern = Pattern.compile("(?:QWERTY)+");
            Matcher matcher = pattern.matcher(content);

            int maxLength = 0;
            while (matcher.find()) {
                String found = matcher.group();
                int length = found.length();
                if (length > maxLength) {
                    maxLength = length;
                }
            }

            System.out.println("Длина самой длинной последовательности QWERTY: " + maxLength);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}