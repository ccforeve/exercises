package com.examination.exercises.service;

import com.examination.exercises.enums.NumeralControlLetterEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * phone keyboard
 * @Author ZhongJinChun
 * @Date 2021.3.27
 */
@Service
public class NumeralMapLettersService {
    // numeral list
    private List<String> numeralList = new ArrayList<>();

    // letter list
    private List<String[]> lettersList = new ArrayList<>();

    public NumeralMapLettersService(){}

    /**
     * Initialize the submitted parameters and determine.
     * If it exists, add the enumeration value to the member variables numeralList and lettersList.
     * If it does not exist, determine if it's a number.
     * If it is a number, disassemble it into a single number and then start the enumeration.
     * Get enumerated data from the class and add it to the member variables numeralList and lettersList
     * @param numerals String...
     */
    public NumeralMapLettersService(String... numerals) {
        for (String numeral : numerals) {
            NumeralControlLetterEnum numControlLetter = NumeralControlLetterService.getMap(numeral);
            if (numControlLetter != null) {
                setMapRelation(numControlLetter);
            } else {
                if (isNumber(numeral)) {
                    char[] numeralCharArray = numeral.toCharArray();
                    for (char numeralChar : numeralCharArray) {
                        NumeralControlLetterEnum controlLetterEnum = NumeralControlLetterService.getMap(String.valueOf(numeralChar));
                        if (controlLetterEnum != null) {
                            setMapRelation(controlLetterEnum);
                        }
                    }
                }
            }
        }
    }

    /**
     * Determine whether the current character is a number.
     * @param str String
     * @return boolean
     */
    public static boolean isNumber(String str) {
        Pattern pattern = compile("[0-9]*");

        return pattern.matcher(str).matches();

    }

    /**
     * Add the numbers of the enumeration class and the letters it represents.
     * to the member variables numericalList and lettersList.
     * @param numControlLetter NumeralControlLetter
     */
    private void setMapRelation(NumeralControlLetterEnum numControlLetter) {
        numeralList.add(numControlLetter.getNumeral());
        lettersList.add(numControlLetter.getLetters());
    }

    /**
     * Integrate a collection of strings in a loop.
     * @return String[]
     */
    public String[] getAllLetters() {
        String[] crossLetterArr = new String[1];
        for (String[] letters : lettersList) {
            crossLetterArr = crossAssemble(crossLetterArr, letters);
        }

        return crossLetterArr;
    }

    /**
     * Cycle the characters added in the last round, and continue to add characters to the "cross combination".
     * @param strArr1 String[]
     * @param strArr2 String[]
     * @return String[]
     */
    private String[] crossAssemble(String[] strArr1, String[] strArr2) {
        String[] crossLetterArr = new String[strArr1.length * strArr2.length];
        for (int i = 0; i < strArr1.length; i++) {
            for (int j = 0; j < strArr2.length; j++) {
                crossLetterArr[i + strArr1.length * j] = jointValue(strArr1[i], strArr2[j]);
            }
        }

        return crossLetterArr;
    }


    /**
     * Concatenation string.
     * @param str1 String
     * @param str2 String
     * @return String
     */
    private String jointValue(String str1, String str2) {
        if (str1 == null || "".equals(str1)) str1 = "";
        if (str2 == null || "".equals(str2)) str2 = "";

        return str1 + str2;
    }

}
