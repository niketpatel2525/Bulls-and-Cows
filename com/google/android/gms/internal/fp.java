package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

public class fp implements Creator<fn> {
    static void m615a(fn fnVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m121a(parcel, 1, fnVar.getAccountName(), false);
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, fnVar.getVersionCode());
        C0066b.m127a(parcel, 2, fnVar.cZ(), false);
        C0066b.m127a(parcel, 3, fnVar.da(), false);
        C0066b.m127a(parcel, 4, fnVar.db(), false);
        C0066b.m121a(parcel, 5, fnVar.dc(), false);
        C0066b.m121a(parcel, 6, fnVar.dd(), false);
        C0066b.m121a(parcel, 7, fnVar.de(), false);
        C0066b.m121a(parcel, 8, fnVar.df(), false);
        C0066b.m112C(parcel, k);
    }

    public fn m616A(Parcel parcel) {
        String str = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str5 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    strArr3 = C0065a.m105w(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    strArr2 = C0065a.m105w(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    strArr = C0065a.m105w(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str3 = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new fn(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public fn[] af(int i) {
        return new fn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m616A(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return af(x0);
    }
}
