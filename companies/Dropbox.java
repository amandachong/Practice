import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Dropbox {

	public double sqrt(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		double high = n;
		double low = 0;

		while (high - low > 1) {
			double mid = low + (high - low) / 2;
			if (mid * mid <= n) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return low;
	}
}

/**
 * Class registration system. You have to implement 9 functions like
 * create/delete classes, students, enroll/deenroll student to class, remove
 * class (deregister all students).
 */
class ClassRegistrationSystem {

	private HashSet<Course> courses = new HashSet<Course>();
	private HashSet<Student> students = new HashSet<Student>();
	private HashMap<Course, HashSet<Student>> courseEnrollment;
	private HashMap<Student, HashSet<Course>> studentEnrollment;

	public ClassRegistrationSystem() {
		courses = new HashSet<Course>();
		students = new HashSet<Student>();
		courseEnrollment = new HashMap<Course, HashSet<Student>>();
		studentEnrollment = new HashMap<Student, HashSet<Course>>();
	}

	public Course createCourse(String courseName) {
		Course course = new Course(courseName);

		courses.add(course);

		HashSet<Student> students = new HashSet<Student>();
		courseEnrollment.put(course, students);

		return course;
	}

	/**
	 * Delete the course and all student enrolled.
	 */
	public void deleteCourse(Course course) {
		courses.remove(course);

		HashSet<Student> students = courseEnrollment.get(course);
		for (Student student : students) {
			studentEnrollment.get(student).remove(course);
		}
		courseEnrollment.remove(course);
	}

	public Student createStudent(String studentName) {
		Student student = new Student(studentName);

		students.add(student);

		HashSet<Course> courses = new HashSet<Course>();
		studentEnrollment.put(student, courses);

		return student;
	}

	public void deleteStudent(Student student) {
		students.remove(student);

		HashSet<Course> courses = studentEnrollment.get(student);
		for (Course course : courses) {
			courseEnrollment.get(course).remove(student);
		}
		studentEnrollment.remove(student);
	}

	/**
	 * Enroll a student in a course.
	 */
	public void enroll(Student student, Course course) {
		if (!courses.contains(course)) {
			createCourse(course.getCourseName());
		}
		courseEnrollment.get(course).add(student);
		studentEnrollment.get(student).add(course);
	}

	public void unenroll(Student student, Course course) {
		if (!courses.contains(course) || !students.contains(student)) {
			if (!courses.contains(course)) {
				createCourse(course.getCourseName());
			}
			if (!students.contains(student)) {
				createStudent(student.getStudentName());
			}
		} else {
			courseEnrollment.get(course).remove(student);
			studentEnrollment.get(student).remove(course);
		}
	}
}

class Course {

	private String courseName;

	public Course() {

	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}
}

class Student {
	private String studentName;

	public Student() {

	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}
}

class DictionaryTree<K, V> {

	private TreeMap<K, V> treeMap;

	public DictionaryTree() {
		treeMap = new TreeMap<K, V>();
	}

	public V get(K key) {
		return treeMap.get(key);
	}

	public V put(K key, V value) {
		return treeMap.put(key, value);
	}
}

class IntegerAllocator {
	HashSet<Integer> unallocated;
	HashSet<Integer> allocated;

	public IntegerAllocator(int initialCapacity) {
		unallocated = new HashSet<Integer>();
		allocated = new HashSet<Integer>();

		// Allocate some numbers to the pool with size of initial capacity
		while (unallocated.size() < initialCapacity) {
			unallocated.add((int) Math.random());
		}
	}

	public Integer allocate() {
		ArrayList<Integer> array = new ArrayList<Integer>(
				Arrays.asList((Integer[]) unallocated.toArray()));
		Integer id = array.get((int) Math.random() % array.size());
		unallocated.remove(id);
		allocated.add(id);
		return id;
	}

	public void deallocate(Integer id) {
		allocated.remove(id);
		unallocated.add(id);
	}
}

/**
 * Design a web counter that returns the number of visitors in last 5 minutes.
 */
class WebCounter {

	TreeMap<Integer, Integer> treeMap;

	public WebCounter() {
		treeMap = new TreeMap<Integer, Integer>();
	}

	public void increment(Integer time) {
		treeMap.put(time, treeMap.get(time) + 1);
	}

	public Integer recentVisitors(Integer currentTime, Integer minutes) {
		Integer visitors = 0;
		for (int i = 0; i < minutes; i++) {
			visitors += treeMap.get(currentTime - i);
		}
		return visitors;
	}
}

/**
 * Get all duplicate files by content in your file system.
 * 
 * - Get list of all files in file system via DFS
 * 
 * - Bin into possible matches
 * 
 * - Repeat via swap-able heuristics (size, md5, byte stream)
 * 
 * Get all files via DFS. group files by file size. Then compare each file to
 * other files in its group, reading one byte at a time. If one byte is
 * different from rest, remove it from group. Files with same byte are in
 * subgroups. Read next byte until EOF. Remove subgroups of size 1 - these files
 * are not duplicates. Remaining subgroups consist of duplicate files. Doing MD5
 * or SHA1 would involve reading large files which is slow, and collisions if
 * file sizes are > 2^256 size. For example, if using SHA 256-bit.
 */

/**
 * Online: OOP-based class management system. Phone 1: Forming words from mobile
 * keypad Phone 2: Game of life.
 */
