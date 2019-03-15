package com.gl.app.applicationutlity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Map;

public class ApplicationInformation {


    /**
     * This method all about to store application info
     */
    public static Map<Integer, Object> storeApplicationInformation() {
        String packageName = null;
        int versionCode = 0;
        String versionName = null;
        PackageInfo info = new PackageInfo();
        info.packageName = packageName;
        info.versionCode = versionCode;
        info.versionName = versionName;
        info.applicationInfo = new ApplicationInfo();
        info.applicationInfo.publicSourceDir = "/tmp/mock-location";

        return null;
    }
}
