package ssjprajwol.com;

public class Word {
    private String mNepaliTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;



    public Word(String nepaliTranslation, String defaultTranslation, int AudioResourceId){
        mNepaliTranslation = nepaliTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = AudioResourceId;
    }
    public Word(String nepaliTranslation, String defaultTranslation, int ImageResourceId, int AudioResourceId){
        mNepaliTranslation = nepaliTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = ImageResourceId;
        mAudioResourceId = AudioResourceId;
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
    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
