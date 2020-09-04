package ssjprajwol.com;

public class Word {
    private String mNepaliTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;



    public Word(String nepaliTranslation, String defaultTranslation){
        mNepaliTranslation = nepaliTranslation;
        mDefaultTranslation = defaultTranslation;
    }
    public Word(String nepaliTranslation, String defaultTranslation, int ImageResourceId){
        mNepaliTranslation = nepaliTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = ImageResourceId;
    }

    public String getNepaliTranslation(){
        return mNepaliTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
