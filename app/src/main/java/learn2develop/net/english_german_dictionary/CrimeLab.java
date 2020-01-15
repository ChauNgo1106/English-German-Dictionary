package learn2develop.net.english_german_dictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by hitabaca on 3/9/17.
 */

public class CrimeLab extends AppCompatActivity {

    private static CrimeLab sCrimeLab;
    private ArrayList<Dictionary> mDictionary;

    private final int NOUN=1;
    private final int VERB=2;
    private final int PREPOSITION=3;
    private final int CARDINAL_NUMBER=4;
    private final int ADJECTIVE=5;
    private final int ADVERB=6;

    private static int function=0;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mDictionary = new ArrayList<>();
    }
    //adding words in resource
    public void addDictionary( ) {
        mDictionary.add(new Dictionary("der Mann", "noun", "man"));
        mDictionary.add(new Dictionary("das Öl", "noun", "oil"));
        mDictionary.add(new Dictionary("die Frau", "noun", "woman"));
        mDictionary.add(new Dictionary("das Fräulein", "noun", "Miss"));
        mDictionary.add(new Dictionary("das Mädchen", "noun", "girl"));
        mDictionary.add(new Dictionary("das Kind", "noun", "child"));
        mDictionary.add(new Dictionary("das Haus", "noun", "house"));
        mDictionary.add(new Dictionary("die Schule", "noun", "school"));
        mDictionary.add(new Dictionary("die Tür", "noun", "door"));
        mDictionary.add(new Dictionary("kommen", "verb1", "to come"));
        mDictionary.add(new Dictionary("gehen", "verb1", "to go"));
        mDictionary.add(new Dictionary("sehen", "verb1", "to see"));
        mDictionary.add(new Dictionary("wollen", "verb1", "to want"));
        mDictionary.add(new Dictionary("wissen", "verb1", "to know"));
        mDictionary.add(new Dictionary("können", "verb1", "to be able"));
        mDictionary.add(new Dictionary("vor", "preposition", "before"));
        mDictionary.add(new Dictionary("nach", "preposition", "after"));
        mDictionary.add(new Dictionary("zu", "preposition", "to"));
        mDictionary.add(new Dictionary("bis", "preposition", "until"));
        mDictionary.add(new Dictionary("ohne", "preposition", "without"));
        mDictionary.add(new Dictionary("eins", "cardinal number", "one"));
        mDictionary.add(new Dictionary("zwei", "cardinal number", "two"));
        mDictionary.add(new Dictionary("drei", "cardinal number", "three"));
        mDictionary.add(new Dictionary("hoch", "adverb", "high"));
        mDictionary.add(new Dictionary("gut", "adjective/adverb", "good"));


    Collections.sort(mDictionary, new NameComparator());

    }
    public void addDictionary(Dictionary dictionary) {
        mDictionary.add(dictionary);
        Collections.sort(mDictionary, new NameComparator());

    }
    //removing word out of list
    public void removeDictionary(Dictionary dictionary) {
        mDictionary.remove(dictionary);
    }

    public ArrayList<Dictionary> getDictionary() {


        if(function==NOUN)
            return getNoun();
          else if(function==VERB)
            return getVerb();
        else if(function==PREPOSITION)
            return getPreposition();
        else if(function==CARDINAL_NUMBER)
            return getCardinalNumber();
        else if(function==ADJECTIVE)
            return getAdjective();
        else if(function==ADVERB)
            return getAdverb();
        else
            return mDictionary;
    }




    //adding nouns
    public ArrayList<Dictionary> getNoun() {
        ArrayList<Dictionary> listNoun = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("noun"))
                listNoun.add(dictionaries);
        }
        return listNoun;
    }

    //adding verb
    public ArrayList<Dictionary> getVerb() {
        ArrayList<Dictionary> listVerb = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("verb1"))
                listVerb.add(dictionaries);
        }
        return listVerb;
    }

    //adding preposition
    public ArrayList<Dictionary> getPreposition() {
        ArrayList<Dictionary> listPreposition = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("preposition"))
                listPreposition.add(dictionaries);
        }
        return listPreposition;

    }

    //adding cardinal number
    public ArrayList<Dictionary> getCardinalNumber() {
        ArrayList<Dictionary> listCardinalNumber = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("cardinal number"))
                listCardinalNumber.add(dictionaries);
        }
        return listCardinalNumber;
    }

    //adding adjective
    public ArrayList<Dictionary> getAdjective() {
       ArrayList<Dictionary> listAdjective = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("adjective"))
                listAdjective.add(dictionaries);
        }
        return listAdjective;
    }

    //adding adverb
    public ArrayList<Dictionary> getAdverb() {
        ArrayList<Dictionary> listAdverb = new ArrayList<Dictionary>();
        for (Dictionary dictionaries : mDictionary) {
            if (dictionaries.getPartOfSpeech().contains("adverb"))
                listAdverb.add(dictionaries);
        }
        return listAdverb;
    }


    public Dictionary getDictionary(String german) {
        for (Dictionary dictionary : mDictionary) {
            if (dictionary.getGermanWord().equals(german)) {
                return dictionary;
            }
        }
        return null;
    }
    public int getFunction() {
        return function;
    }

    public void setFunction(int mFunction) {
        function=mFunction;
    }
}
//creating another class for comaparing two strings.
class NameComparator implements Comparator<Dictionary>{

    public int compare(Dictionary dic1, Dictionary dic2){

        Collator german = Collator.getInstance(Locale.GERMAN); //sorting sensitivity in German language
        german.setStrength(Collator.PRIMARY);

        String dic1German =dic1.getGermanWord();
        String dic2German =dic2.getGermanWord();

        if(dic1.getPartOfSpeech().contains("noun"))

        {
            dic1German= dic1German.replaceAll(dic1German.substring(0,4),"");
            dic1German=dic1German.toLowerCase();//replacing der das dis
    }
        else
         dic1German=dic1German.toLowerCase();

        if(dic2.getPartOfSpeech().contains("noun"))

        {
          dic2German= dic2German.replaceAll(dic2German.substring(0,4),"");
            dic2German=dic2German.toLowerCase();//replacing der das dis by non-word
        }
        else
            dic2German=dic2German.toLowerCase();

        return german.compare(dic1German,dic2German);

    }
}

