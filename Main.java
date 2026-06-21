import java.util.ArrayList;
import java.util.Scanner;

 class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Question> questions = new ArrayList<>();

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

        System.out.println("\nStored Questions:");

        for (Question question : questions) {
            System.out.println(
                question.name + " | " +
                question.topic + " | " +
                question.difficulty + " | " +
                question.platform
            );
        }

        sc.close();
    }
}

