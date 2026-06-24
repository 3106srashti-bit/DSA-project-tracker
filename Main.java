import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        HashMap<String, Integer> topicCount = new HashMap<>();

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

                topicCount.put(q.topic,
                        topicCount.getOrDefault(q.topic, 0) + 1);

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

                System.out.print("Enter topic to search: ");
                String searchTopic = sc.nextLine();

                boolean found = false;

                System.out.println("\n===== Search Results =====");

                for (Question question : questions) {

                    if (question.topic.equalsIgnoreCase(searchTopic)) {

                        System.out.println(
                                question.name + " | " +
                                question.topic + " | " +
                                question.difficulty + " | " +
                                question.platform);

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No questions found for this topic.");
                }

            } else if (choice == 4) {

                System.out.println("\n===== Statistics =====");

                System.out.println("Total Questions: "
                        + questions.size());

                for (String topic : topicCount.keySet()) {
                    System.out.println(
                            topic + " : " +
                            topicCount.get(topic));
                }

            } else if (choice == 5) {

                System.out.print("Enter difficulty: ");
                String searchDifficulty = sc.nextLine();

                boolean found = false;

                System.out.println("\n===== Search Results =====");

                for (Question question : questions) {

                    if (question.difficulty.equalsIgnoreCase(
                            searchDifficulty)) {

                        System.out.println(
                                question.name + " | " +
                                question.topic + " | " +
                                question.difficulty + " | " +
                                question.platform);

                        found = true;
                    }
                }

                if (!found) {
                    System.out.println(
                            "No questions found for this difficulty.");
                }

            } else if (choice == 6) {
                questions.sort((q1, q2) -> q1.topic.compareToIgnoreCase(q2.topic));
                System.out.println("\n===== Questions Sorted by Topic =====");
                for (Question question : questions) {
                    System.out.println(
                            question.name + " | " +
                            question.topic + " | " +
                            question.difficulty + " | " +
                            question.platform);
                }

            } else if (choice == 7) {
                questions.sort((q1, q2) -> q1.difficulty.compareToIgnoreCase(q2.difficulty));
                System.out.println("\n===== Questions Sorted by Difficulty =====");
                for (Question question : questions) {
                    System.out.println(
                            question.name + " | " +
                            question.topic + " | " +
                            question.difficulty + " | " +
                            question.platform);
                }


            } else if (choice == 8) {

                System.out.println(
                        "Exiting DSA Progress Tracker...");
                break;

            } else {

                System.out.println(
                        "Invalid choice! Please enter 1-8.");
            }
        }



        sc.close();
    }
}