package ssjprajwol.com;

public class Word {
    private String mNepaliTranslation;
    private String mDefaultTranslation;

    public Word(String nepaliTranslation, String defaultTranslation){
        mNepaliTranslation = nepaliTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    public String getNepaliTranslation(){
        return mNepaliTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

}
