package learn2develop.net.english_german_dictionary;

/**
 * Created by hitabaca on 4/6/17.
 */

public class Dictionary {

    private String mGermanWord;
    private String mPartOfSpeech;
    private String mEnglishWord;



    public Dictionary(String german,String partOfSpeech, String english){
        mEnglishWord=english;
        mGermanWord=german;
        mPartOfSpeech=partOfSpeech;

    }

    public String getEnglishWord() {
        return mEnglishWord;
    }

    public String getGermanWord() {
        return mGermanWord;
    }

    public String getPartOfSpeech() {
        return mPartOfSpeech;
    }

    public void setEnglishWord(String englishWord) {
        mEnglishWord = englishWord;
    }

    public void setGermanWord(String germanWord) {
        mGermanWord = germanWord;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        mPartOfSpeech = partOfSpeech;
    }
}
