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
}