package lesson14_1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;


public class Application {

	public static void main(String[] args) {

		Set<Student> setofStudents = new HashSet<>();
		Consumer<Student> addStudent = student -> setofStudents.add(student);
		addStudent.accept(new Student("Oliver", 21));
		addStudent.accept(new Student("Daryna", 18));
		addStudent.accept(new Student("Fill", 19));
		addStudent.accept(new Student("Jonny", 30));
		addStudent.accept(new Student("Sashko", 22));
		addStudent.accept(new Student("Rita", 27));
		addStudent.accept(new Student("Elvira", 22));
		addStudent.accept(new Student("Pheophan", 21));
		addStudent.accept(new Student("Gerry", 19));

		setofStudents.forEach(System.out::println);
		System.out.println();
		System.out.println("================================");
		System.out.println();

		Set<Student> sortedStudents = new TreeSet<>();
		sortedStudents.addAll(setofStudents);
		sortedStudents.stream().sorted(new AllFieldsComparator()).forEach(System.out::println);;

	}

}

