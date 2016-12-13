package com.bvan.jc.employee.generator;

import com.bvan.jc.employee.OtherEmployee;
import com.bvan.jc.employee.Position;
import static com.bvan.jc.employee.util.DateUtils.getTimestamp;
import com.thedeanda.lorem.LoremIpsum;
import java.util.Random;

/**
 * @author bvanchuhov
 */
public final class EmployeeGenerator {

    private static LoremIpsum loremIpsum = LoremIpsum.getInstance();
    private static Random random = new Random();

    private EmployeeGenerator() {}

    public static int randomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min greater than max: " + min + " > " + max);
        }
        return min + random.nextInt(max - min + 1);
    }

    public static String randomName() {
        return loremIpsum.getFirstName();
    }

    public static String randomSurname() {
        return loremIpsum.getLastName();
    }

    public static long randomBirthDate() {
        return getTimestamp(randomInt(1960, 1999), randomMonth(), randomDayOfMonth());
    }

    public static long randomHireDate() {
        return getTimestamp(randomInt(2000, 2010), randomMonth(), randomDayOfMonth());
    }

    public static int randomDayOfMonth() {
        return randomInt(1, 28);
    }

    public static int randomMonth() {
        return randomInt(1, 12);
    }

    public static Position randomPosition() {
        Position[] positions = Position.values();
        int randomIndex = randomInt(0, positions.length - 1);
        return positions[randomIndex];
    }

    public static OtherEmployee randomOtherEmployee() {
        OtherEmployee otherEmployee = new OtherEmployee();
        otherEmployee.setName(randomName());
        otherEmployee.setSurname(randomSurname());
        otherEmployee.setBirthDate(randomBirthDate());
        otherEmployee.setHireDate(randomBirthDate());
        otherEmployee.setDescription(loremIpsum.getWords(20));
        otherEmployee.setPosition(randomPosition());
        return otherEmployee;
    }
}

class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(EmployeeGenerator.randomOtherEmployee());
        }
    }
}
