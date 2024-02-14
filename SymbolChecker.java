import java.io.*;
import java.util.Stack;

public class SymbolChecker {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SymbolChecker <source-code-file>");
            return;
        }

        String fileName = args[0];
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stack<Character> stack = new Stack<>();

            int c;
            while ((c = bufferedReader.read()) != -1) {
                char character = (char) c;
                switch (character) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(character);
                        break;
                    case ')':
                        if (stack.isEmpty() || stack.pop() != '(') {
                            System.out.println("Incorrect pairing of symbols found.");
                            return;
                        }
                        break;
                    case '}':
                        if (stack.isEmpty() || stack.pop() != '{') {
                            System.out.println("Incorrect pairing of symbols found.");
                            return;
                        }
                        break;
                    case ']':
                        if (stack.isEmpty() || stack.pop() != '[') {
                            System.out.println("Incorrect pairing of symbols found.");
                            return;
                        }
                        break;
                    default:
                        // Ignore other characters
                        break;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("All symbols are correctly paired.");
            } else {
                System.out.println("Incorrect pairing of symbols found.");
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
        }
    }
}
