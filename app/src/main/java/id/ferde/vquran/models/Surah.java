package id.ferde.vquran.models;

import java.util.List;

/**
 * Created by E460 on 12/13/2017.
 */

public class Surah {
    public int number;
    public String name;
    public String englishName;
    public String englishNameTranslation;
    public int numberOfAyahs;
    public String revelationType;


    public Surah(int number, String name, String englishName, String englishNameTranslation, int numberOfAyahs, String revelationType){
        this.number = number;
        this.revelationType = revelationType;
        this.name = name;
        this.englishName = englishName;
        this.englishNameTranslation = englishNameTranslation;
        this.numberOfAyahs = numberOfAyahs;
    }


}


