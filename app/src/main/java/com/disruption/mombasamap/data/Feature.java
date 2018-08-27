package com.disruption.mombasamap.data;

/**
 * {@link Feature} is a class that represents the characteristics of the feature in question
 * namely name, address, and year of construction
 */
public class Feature {

    /*The name of the feature*/
    private String mFeatureName;


    /*Address of the current feature in Mombasa*/
    private String mFeatureAddress;

    /*Year of completion of construction*/
    private String mFeatureCompletionYear;

    /*Add a variable to reference the image resource ID for every feature*/
    private int mImageResourceId;


    /**
     * This constructor is for objects with a completion year
     *
     * @param featureName           is the name of the feature
     * @param featureAddress        is the address of the feature
     * @param featureCompletionYear is the year the feature's construction work was completed
     */
    public Feature(String featureName, String featureAddress, String featureCompletionYear, int imageResourceId) {
        mFeatureName = featureName;
        mFeatureAddress = featureAddress;
        mImageResourceId = imageResourceId;
        mFeatureCompletionYear = featureCompletionYear;
    }

    /**
     * This constructor is for objects without a completion year
     *
     * @param featureName    is the name of the feature
     * @param featureAddress is the address of the feature
     */
    public Feature(String featureName, String featureAddress, int imageResourceId) {
        mFeatureName = featureName;
        mFeatureAddress = featureAddress;
        mImageResourceId = imageResourceId;
    }

    /**
     * Generate getters for all the variables describing a {@link Feature} object
     */
    public String getFeatureName() {
        return mFeatureName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getFeatureAddress() {
        return mFeatureAddress;
    }

    public String getFeatureCompletionYear() {
        return mFeatureCompletionYear;
    }
}
