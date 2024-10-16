package org.learn.regsystem;

import java.util.Random;

public class RandomDataGenerator {
    private static final Random random = new Random();
    private static final String[] names = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Hannah"};
    private static final String[] departments = {"Computer Science", "Mathematics", "Physics", "Biology", "Chemistry", "English", "History", "Art", "Music", "Philosophy"};

    public static String getRandomName() {
        return names[random.nextInt(names.length)];
    }

    public static String getRandomDepartment() {
        return departments[random.nextInt(departments.length)];
    }

    public static String getRandomEmail() {
        return getRandomName().toLowerCase() + "@university.edu";
    }

    public static String getRandomPhoneNumber() {
        return String.format("555-01%02d", random.nextInt(100)); // Generates a number like 555-0101, 555-0102, etc.
    }

    public static int getRandomYear() {
        return random.nextInt(4) + 1; // Generates a year between 1 and 4
    }

    public static int getRandomCredits() {
        return random.nextInt(6) + 1; // Generates credits between 1 and 6
    }

    public static int getRandomMinimumGrade() {
        return random.nextInt(41) + 60; // Generates a grade between 60 and 100
    }

    public static String getRandomCourse() {
        return "Course " + (random.nextInt(10) + 1); // Random course name
    }
}
