import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();

        while (true) {

            System.out.println("\n===== DSA Progress Tracker =====");
            System.out.println("1. Add a new question");
            System.out.println("2. View all questions");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                Question q = new Question();

                System.out.print("Enter Question Name: ");
                q.name = sc.nextLine();

                System.out.print("Enter Topic: ");
                q.topic = sc.nextLine();

                System.out.print("Enter Difficulty: ");
                q.difficulty = sc.nextLine();

                System.out.print("Enter Platform: ");
                q.platform = sc.nextLine();

                questions.add(q);

                System.out.println("✅ Question added successfully!");

            } else if (choice == 2) {

                if (questions.isEmpty()) {
                    System.out.println("No questions added yet.");
                } else {

                    System.out.println("\n===== Stored Questions =====");

                    for (Question question : questions) {
                        System.out.println(
                                question.name + " | " +
                                question.topic + " | " +
                                question.difficulty + " | " +
                                question.platform);
                    }
                }

            } else if (choice == 3) {

                System.out.println("Exiting DSA Progress Tracker...");
                break;

            } else {

                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        sc.close();
    }
}