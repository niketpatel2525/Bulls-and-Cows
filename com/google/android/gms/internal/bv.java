package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class bv implements Creator<bu> {
    static void m226a(bu buVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, buVar.versionCode);
        C0066b.m117a(parcel, 2, buVar.gA, false);
        C0066b.m120a(parcel, 3, buVar.gB, i, false);
        C0066b.m120a(parcel, 4, buVar.ed, i, false);
        C0066b.m121a(parcel, 5, buVar.adUnitId, false);
        C0066b.m120a(parcel, 6, buVar.applicationInfo, i, false);
        C0066b.m120a(parcel, 7, buVar.gC, i, false);
        C0066b.m121a(parcel, 8, buVar.gD, false);
        C0066b.m121a(parcel, 9, buVar.gE, false);
        C0066b.m121a(parcel, 10, buVar.gF, false);
        C0066b.m120a(parcel, 11, buVar.eg, i, false);
        C0066b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m227e(x0);
    }

    public bu m227e(Parcel parcel) {
        co coVar = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        PackageInfo packageInfo = null;
        ApplicationInfo applicationInfo = null;
        String str4 = null;
        C0473x c0473x = null;
        C0472v c0472v = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    bundle = C0065a.m96n(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    c0472v = (C0472v) C0065a.m77a(parcel, i2, C0472v.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    c0473x = (C0473x) C0065a.m77a(parcel, i2, C0473x.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    applicationInfo = (ApplicationInfo) C0065a.m77a(parcel, i2, ApplicationInfo.CREATOR);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    packageInfo = (PackageInfo) C0065a.m77a(parcel, i2, PackageInfo.CREATOR);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str3 = C0065a.m94l(parcel, i2);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    coVar = (co) C0065a.m77a(parcel, i2, co.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new bu(i, bundle, c0472v, c0473x, str4, applicationInfo, packageInfo, str3, str2, str, coVar);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public bu[] m228i(int i) {
        return new bu[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m228i(x0);
    }
}
