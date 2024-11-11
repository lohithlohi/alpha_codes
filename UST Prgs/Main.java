import java.io.*;
import java.util.*;

// Student class representing a student with id, name, and age
class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

// Custom exception class
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class Main {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        // 1. Demonstrating the use of ArrayList, LinkedList, HashMap, and HashSet
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> linkedList = new java.util.LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        arrayList.add("ArrayList");
        linkedList.add("LinkedList");
        hashMap.put("HashMap", 1);
        hashSet.add("HashSet");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("HashMap: " + hashMap);
        System.out.println("HashSet: " + hashSet);

        // 2. Performing CRUD operations on a collection of student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", 20));
        students.add(new Student(2, "Alice", 22));

        // Create
        students.add(new Student(3, "Bob", 21));

        // Read
        System.out.println("Students: " + students);

        // Update
        for (Student student : students) {
            if (student.getId() == 2) {
                student.setAge(23);
                break;
            }
        }
        System.out.println("Updated Students: " + students);

        // Delete
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == 1) {
                iterator.remove();
                break;
            }
        }
        System.out.println("Students after deletion: " + students);

        // 3. Handling runtime exceptions
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        try {
            int[] arr = new int[5];
            System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        try {
            int num = -5;
            if (num < 0) {
                throw new IllegalArgumentException("Number must be non-negative");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }

        // 4. Creating and using custom exception class
        try {
            throw new CustomException("Custom exception occurred");
        } catch (CustomException e) {
            System.out.println("CustomException caught: " + e.getMessage());
        }

        // 5. Reading data from a file, processing it, and handling file-related exceptions
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Read from file: " + line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}



/*
 * rub instructions:
 * javac Main.java   -> Compilation
 * java Main  -> Execution
 */