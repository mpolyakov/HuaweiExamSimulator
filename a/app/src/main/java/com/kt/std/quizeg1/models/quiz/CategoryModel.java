package com.kt.std.quizeg1.models.quiz;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {
    String categoryID;
    String categoryName;

    public CategoryModel(String categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeString(categoryID);
        dest.writeString(categoryName);
    }

    public CategoryModel(Parcel in) {
        categoryID = in.readString();
        categoryName = in.readString();
    }

    public static Creator<CategoryModel> getCreator(){
        return CREATOR;
    }
    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel source) {
            return new CategoryModel(source);
        }

        @Override
        public CategoryModel[] newArray(int i) {
            return new CategoryModel[i];
        }
    };
}
