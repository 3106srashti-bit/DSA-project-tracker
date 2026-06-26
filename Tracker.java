import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tracker {

    private ArrayList<Question> questions = new ArrayList<>();
    private HashMap<String, Integer> topicCount = new HashMap<>();

    public void addQuestion(Scanner sc) {

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

        System.out.println(" Question added successfully!");

        }
        public void viewQuestions() {
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

    }
    public void searchByTopic(Scanner sc){
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
    }

    public void viewStatistics(){
        System.out.println("\n===== Statistics =====");

                System.out.println("Total Questions: "
                        + questions.size());

                for (String topic : topicCount.keySet()) {
                    System.out.println(
                            topic + " : " +
                            topicCount.get(topic));
                }  
    }

    public void searchByDifficulty(Scanner sc){
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
    }
    public void sortQuestionsByTopic(){
 questions.sort((q1, q2) -> q1.topic.compareToIgnoreCase(q2.topic));
                System.out.println("\n===== Questions Sorted by Topic =====");
                for (Question question : questions) {
                    System.out.println(
                            question.name + " | " +
                            question.topic + " | " +
                            question.difficulty + " | " +
                            question.platform);
                }

    }

    public void sortQuestionsByDifficulty(){
        questions.sort((q1, q2) -> q1.difficulty.compareToIgnoreCase(q2.difficulty));
                System.out.println("\n===== Questions Sorted by Difficulty =====");
                for (Question question : questions) {
                    System.out.println(
                            question.name + " | " +
                            question.topic + " | " +
                            question.difficulty + " | " +
                            question.platform);
                }
    }

    public void loadQuestionsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("questions.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    Question q = new Question();
                    q.name = parts[0];
                    q.topic = parts[1];
                    q.difficulty = parts[2];
                    q.platform = parts[3];
                    questions.add(q);
                    topicCount.put(q.topic,
                            topicCount.getOrDefault(q.topic, 0) + 1);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No saved questions found. Starting fresh.");
        }
    }

    public void saveQuestionsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("questions.txt"));
            for (Question question : questions) {
                writer.write(question.name + "|" + question.topic + "|" +
                        question.difficulty + "|" + question.platform);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving questions to file.");
        }
    }

    

}