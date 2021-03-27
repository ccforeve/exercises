package com.examination.exercises.enums;

import lombok.Getter;

/**
 * Phone numbers Map Letters Enum
 * @Author ZhongJinChun
 * @Date 2021.3.27
 */
@Getter
public enum NumeralControlLetterEnum {

    TWO("2", "A", "B", "C"),
    THREE("3", "D", "E", "F"),
    FOUR("4", "G", "H", "I"),
    FIVE("5", "J", "K", "L"),
    SIX("6", "M", "N", "O"),
    SEVEN("7", "P", "Q", "R", "S"),
    EIGHT("8", "T", "U", "V"),
    NINE("9", "W", "X", "Y", "Z");

    private String numeral;

    private String[] letters;

    NumeralControlLetterEnum(String numeral, String... letters) {
        this.numeral = numeral;
        this.letters = letters;
    }
}
