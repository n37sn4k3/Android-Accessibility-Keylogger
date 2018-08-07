# Android-Accessibility-Keylogger
Android module which tracks text view changes using an accessibility service and saves the updates into a Realm database.

## Information

Open accessibility activity (prompt user to enable the service)
```java
startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
```

Process the result(s) (using Realm)
```java
// Accessibility
RealmResults<TypeViewTextChangedEventObject> typeViewTextChangedEventObjectRealmResults = null;

if (realm != null && !realm.isClosed()) {
    typeViewTextChangedEventObjectRealmResults = realm.where(TypeViewTextChangedEventObject.class).findAll();

    if (typeViewTextChangedEventObjectRealmResults.size() > 0) {
        // TODO: Process object
    }
}

// ----

RealmResults<TypeViewTextSelectionChangedEventObject> typeViewTextSelectionChangedEventObjectRealmResults = null;

if (realm != null && !realm.isClosed()) {
    typeViewTextSelectionChangedEventObjectRealmResults = realm.where(TypeViewTextSelectionChangedEventObject.class).findAll();

    if (typeViewTextSelectionChangedEventObjectRealmResults.size() > 0) {
        // TODO: Process object
    }
}
// - Accessibility
```

## Manifest requirement(s)
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <service android:name=".module.accessibility.service.AccessibilityService"
      android:label="@string/service"
      android:description="@string/additional_service"
      android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE">
      <intent-filter>
          <action android:name="android.accessibilityservice.AccessibilityService" />
      </intent-filter>
  </service>
</manifest>

## License
This project is released under the The GNU General Public License v3.0. See "LICENSE" file for further information.
