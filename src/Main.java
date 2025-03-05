import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Major MagicHistory = new Major("MagicHistory", 20);
        Major Sorcery = new Major("Sorcery", 25);

        Person person1 = new Person("Harry", "1");
        Person person2 = new Person("Ron", "2");
        Person person3 = new Person("Hermione", "3");
        Person person4 = new Person("Snape", "4");
        Person person5 = new Person("McGonagall", "5");

        Student Harry = new Student(person1.id, 403, 12);
        Student Ron = new Student(person2.id, 403, 12);
        Student Hermione = new Student(person3.id, 403, 13);

        Professor Snape = new Professor(person4.id, 12);
        Professor McGonagall = new Professor(person5.id, 13);

        Course Potions = new Course("Potions", 4);
        Course Defence = new Course("Defence Against the Dark Arts", 2);
        Course Transfiguration = new Course("Transfiguration ", 3);

        PresentedCourse potions = new PresentedCourse(Potions.id, Snape.id, 10);
        PresentedCourse defence = new PresentedCourse(Defence.id, Snape.id, 8);
        PresentedCourse transfiguration = new PresentedCourse(Transfiguration.id, McGonagall.id, 12);

        potions.addStudent(Harry.id);
        potions.addStudent(Ron.id);
        defence.addStudent(Harry.id);
        defence.addStudent(Ron.id);
        defence.addStudent(Hermione.id);
        transfiguration.addStudent(Hermione.id);

        Transcript Harry_transcript = new Transcript(Harry.id);
        Transcript Ron_transcript = new Transcript(Ron.id);
        Transcript Hermione_transcript = new Transcript(Hermione.id);

        Harry_transcript.setGrade(potions.courseID, 18.5);
        Harry_transcript.setGrade(defence.courseID, 19);
        Ron_transcript.setGrade(defence.courseID, 17.5);
        Ron_transcript.setGrade(potions.courseID, 11.5);
        Hermione_transcript.setGrade(defence.courseID, 19.75);
        Hermione_transcript.setGrade(transfiguration.courseID, 20);

        Harry_transcript.printTranscript();
        Ron_transcript.printTranscript();
        Hermione_transcript.printTranscript();

        System.out.println("Harry's Transcript: " + Harry_transcript.transcript);
        System.out.println("Ron's Transcript: " + Ron_transcript.transcript);
        System.out.println("Hermione's Transcript: " + Hermione_transcript.transcript);

        System.out.println("Harry's GPA: " + Harry_transcript.getGPA());
        System.out.println("Ron's GPA: " + Ron_transcript.getGPA());
        System.out.println("Hermione's GPA: " + Hermione_transcript.getGPA());

    }
}