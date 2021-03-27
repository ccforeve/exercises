package com.examination.exercises;

import com.examination.exercises.service.NumeralMapLettersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;


@SpringBootTest
class ExercisesApplicationTests {

    @Autowired
    NumeralMapLettersService combination;

    @Test
    public void combinationTest1() {
        combination = new NumeralMapLettersService("3", "5", "6");
        String[] strings = combination.getAllLetters();
        for (String str : strings) {
            System.out.print(str + " ");
        }
        Assert.assertEquals(strings.length, 3 * 3 * 3);
    }

    @Test
    public void combinationTest2() {
        combination = new NumeralMapLettersService("0", "99");
        String[] strings = combination.getAllLetters();
        for (String str : strings) {
            System.out.print(str + " ");
        }
        Assert.assertEquals(strings.length, 4 * 4);
    }

    @Test
    public void combinationTest3() {
        combination = new NumeralMapLettersService("3", "a", "b");
        String[] strings = combination.getAllLetters();
        for (String str : strings) {
            System.out.print(str + " ");
        }
    }

    @Test
    public void combinationTest4() {
        for (int i = 2; i <= 99; i++) {
            combination = new NumeralMapLettersService(String.valueOf(i));
            String[] strings = combination.getAllLetters();
            String stri = i + " => ";
            for (String str : strings) {
                stri += str + " ";
            }
            System.out.println(stri);
        }
    }

}
