package com.examination.exercises.service;


import com.examination.exercises.enums.NumeralControlLetterEnum;
import org.springframework.stereotype.Service;

/**
 * Phone numbers corresponding to the alphabet enumeration class
 * @Author ZhongJinChun
 * @Date 2021.3.27
 */
@Service
public class NumeralControlLetterService {

    /**
     * Returns the hit enumeration object
     * @param numeral String
     * @return NumeralControlLetter|null
     */
    public static NumeralControlLetterEnum getMap(String numeral) {
        for (NumeralControlLetterEnum letterEnum : NumeralControlLetterEnum.values()) {
            if (letterEnum.getNumeral().equalsIgnoreCase(numeral)) {
                return letterEnum;
            }
        }
        return null;
    }
}
