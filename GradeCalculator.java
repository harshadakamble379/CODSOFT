import java.util.Scanner;

class GradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            total += sc.nextInt();
        }

        double percentage = (double) total / subjects;
        char grade;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n----- RESULT -----");
        System.out.println("Total Marks: " + total);
        System.out.printf("Percentage : %.2f%%\n", percentage);
        System.out.println("Grade      : " + grade);

        sc.close();
    }
}
