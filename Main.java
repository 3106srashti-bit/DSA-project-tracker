import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Tracker tracker = new Tracker();

        tracker.loadQuestions();

        while (true) {

            System.out.println("\n===== DSA Progress Tracker =====");
            System.out.println("1. Add a new question");
            System.out.println("2. View all questions");
            System.out.println("3. Search by topic");
            System.out.println("4. Show statistics");
            System.out.println("5. Search by difficulty");
            System.out.println("6. Sort by topic");
            System.out.println("7. Sort by difficulty");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                tracker.addQuestion(sc);

            } else if (choice == 2) {

                tracker.viewQuestions();

            } else if (choice == 3) {

                tracker.searchByTopic(sc);

            } else if (choice == 4) {

                tracker.viewStatistics();

            } else if (choice == 5) {

                tracker.searchByDifficulty(sc);

            } else if (choice == 6) {

                tracker.sortQuestionsByTopic();

            } else if (choice == 7) {

                tracker.sortQuestionsByDifficulty();

            } else if (choice == 8) {

                tracker.saveQuestions();
                System.out.println("Exiting DSA Progress Tracker...");
                break;

            } else {

                System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }
}