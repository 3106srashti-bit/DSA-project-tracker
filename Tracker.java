import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tracker {

    private ArrayList<Question> questions = new ArrayList<>();
    private HashMap<String, Integer> topicCount = new HashMap<>();

    public void addQuestion(Scanner sc) {

        System.out.print("Enter Question Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Topic: ");
        String topic = sc.nextLine();

        System.out.print("Enter Difficulty: ");
        String difficulty = sc.nextLine();

        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();

        Question q = new Question(name, topic, difficulty, platform);

        questions.add(q);

        topicCount.put(q.getTopic(),
                topicCount.getOrDefault(q.getTopic(), 0) + 1);

        System.out.println("Question added successfully!");
    }

    public void viewQuestions() {

        if (questions.isEmpty()) {
            System.out.println("No questions added yet.");
            return;
        }

        System.out.println("\n===== Stored Questions =====");

        for (Question question : questions) {
            System.out.println(
                    question.getName() + " | " +
                    question.getTopic() + " | " +
                    question.getDifficulty() + " | " +
                    question.getPlatform());
        }
    }

    public void searchByTopic(Scanner sc) {

        System.out.print("Enter topic to search: ");
        String searchTopic = sc.nextLine();

        boolean found = false;

        for (Question question : questions) {

            if (question.getTopic().equalsIgnoreCase(searchTopic)) {

                System.out.println(
                        question.getName() + " | " +
                        question.getTopic() + " | " +
                        question.getDifficulty() + " | " +
                        question.getPlatform());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No questions found.");
        }
    }

    public void viewStatistics() {

        System.out.println("\n===== Statistics =====");

        System.out.println("Total Questions : " + questions.size());

        for (String topic : topicCount.keySet()) {

            System.out.println(topic + " : " + topicCount.get(topic));

        }
    }

    public void searchByDifficulty(Scanner sc) {

        System.out.print("Enter Difficulty: ");
        String searchDifficulty = sc.nextLine();

        boolean found = false;

        for (Question question : questions) {

            if (question.getDifficulty().equalsIgnoreCase(searchDifficulty)) {

                System.out.println(
                        question.getName() + " | " +
                        question.getTopic() + " | " +
                        question.getDifficulty() + " | " +
                        question.getPlatform());

                found = true;
            }
        }

        if (!found) {

            System.out.println("No questions found.");

        }
    }

    public void sortQuestionsByTopic() {

        questions.sort((q1, q2) ->
                q1.getTopic().compareToIgnoreCase(q2.getTopic()));

        System.out.println("Questions sorted by topic.");

        viewQuestions();
    }

    public void sortQuestionsByDifficulty() {

        questions.sort((q1, q2) ->
                q1.getDifficulty().compareToIgnoreCase(q2.getDifficulty()));

        System.out.println("Questions sorted by difficulty.");

        viewQuestions();
    }

    public void loadQuestions() {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("questions.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 4) {

                    Question q = new Question(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim());

                    questions.add(q);

                    topicCount.put(q.getTopic(),
                            topicCount.getOrDefault(q.getTopic(), 0) + 1);
                }
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("No saved questions found. Starting fresh.");

        }
    }

    public void saveQuestions() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter("questions.txt"));

            for (Question question : questions) {

                writer.write(
                        question.getName() + "|" +
                        question.getTopic() + "|" +
                        question.getDifficulty() + "|" +
                        question.getPlatform());

                writer.newLine();
            }

            writer.close();

            System.out.println("Questions saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving questions.");

        }
    }
      public void editQuestion(Scanner sc) {

    System.out.print("Enter the name of the question you want to edit: ");
    String questionName = sc.nextLine();

    Question questionToEdit = null;

    // Search for the question
    for (Question q : questions) {
        if (q.getName().equalsIgnoreCase(questionName)) {
            questionToEdit = q;
            break;
        }
    }

    if (questionToEdit != null) {

        System.out.println("Editing question: " + questionToEdit.getName());

        int choice;
        boolean updated = false;

        do {
            System.out.println("\n===== Edit Menu =====");
            System.out.println("1. Edit  Question Name");
            System.out.println("2. Edit Topic");
            System.out.println("3. Edit Difficulty");
            System.out.println("4. Edit Platform");
            System.out.println("5. Exit Editing");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter new question name: ");
                    String newQuestionName = sc.nextLine();
                    questionToEdit.setName(newQuestionName);
                    updated = true;
                    System.out.println("Question name updated successfully!");
                    break;

                case 2:
                    System.out.print("Enter new topic: ");
                    String newTopic = sc.nextLine();
                    questionToEdit.setTopic(newTopic);
                    updated = true;
                    System.out.println("Topic updated successfully!");
                    break;    

                case 3:
                    System.out.print("Enter new difficulty: ");
                    String newDifficulty = sc.nextLine();
                    questionToEdit.setDifficulty(newDifficulty);
                    updated = true;
                    System.out.println("Difficulty updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter new platform: ");
                    String newPlatform = sc.nextLine();
                    questionToEdit.setPlatform(newPlatform);
                    updated = true;
                    System.out.println("Platform updated successfully!");
                    break;

                case 5:
                    System.out.println("Exiting editing mode...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        if (updated) {
            System.out.println("Question updated successfully!");
        }

    } else {

        System.out.println("Question not found.");

    }
}
public void deleteQuestion(Scanner sc) {

    System.out.print("Enter question name to delete: ");
    String name = sc.nextLine();

    boolean found = false;

    for (int i = 0; i < questions.size(); i++) {

        if (questions.get(i).getName().equalsIgnoreCase(name)) {

            questions.remove(i);
            found = true;

            System.out.println("Question deleted successfully!");
            break;
        }
    }

    if (!found) {
        System.out.println("Question not found.");
    }
}
}