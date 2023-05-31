package abhi1;
import java.util.*;

public class chatbot {
    public static void main(String[] args) {
        Map<String, List<String>> dataset = new HashMap<>();
        int r = 0, set = 0;
        Date now = new Date();
        dataset.put("hi", Arrays.asList("Hey", "Hey Buddy", "Hello"));
        dataset.put("do you know me ?", Arrays.asList("I know you", "NO", "Sorry But I can't"));
        dataset.put("what is your name ?", Arrays.asList("ChatBot 3.0", "My Self ChatBot 3.0", "My Name is ChatBot 3.0"));
        dataset.put("what is your age ?", Arrays.asList("My age is not defined","21", "My age is not Calculated yet", "Sorry I can't tell my age :("));
        dataset.put("exit", Arrays.asList("Visit Again !!!!", "Hope our site helpful for you !!!!!", "Thank U For Using Our ChatBot !!!!!"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to ChatBot 0.3 !!!!!!\n");
        System.out.println("Enter your question below or type 'Exit' to stop\n");
        while (true) {
            System.out.print("\n\nYou : ");
            String input = scanner.nextLine();
            input = input.toLowerCase();
            set = 0;

            for (Map.Entry<String, List<String>> entry : dataset.entrySet()) {
                String key = entry.getKey();
                List<String> responses = entry.getValue();

                if (key.contains(input)) {
                    Random rand = new Random();
                    r = rand.nextInt(responses.size());
                    System.out.println("Bot : " + responses.get(r));
                    set = 1;
                    break;
                }
            }

            if (set == 0 && input.equals("exit")) {
                break;
            }
        }

        scanner.close();
    }
}
