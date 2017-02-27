package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0601f;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gd implements Creator<C0601f> {
    static void m635a(C0601f c0601f, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0601f.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0601f.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m121a(parcel, 2, c0601f.getDepartment(), true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m121a(parcel, 3, c0601f.getDescription(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0066b.m121a(parcel, 4, c0601f.getEndDate(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0066b.m121a(parcel, 5, c0601f.getLocation(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0066b.m121a(parcel, 6, c0601f.getName(), true);
        }
        if (di.contains(Integer.valueOf(7))) {
            C0066b.m124a(parcel, 7, c0601f.isPrimary());
        }
        if (di.contains(Integer.valueOf(8))) {
            C0066b.m121a(parcel, 8, c0601f.getStartDate(), true);
        }
        if (di.contains(Integer.valueOf(9))) {
            C0066b.m121a(parcel, 9, c0601f.getTitle(), true);
        }
        if (di.contains(Integer.valueOf(10))) {
            C0066b.m131c(parcel, 10, c0601f.getType());
        }
        C0066b.m112C(parcel, k);
    }

    public C0601f m636K(Parcel parcel) {
        int i = 0;
        String str = null;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str7 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str3 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    z = C0065a.m83c(parcel, i3);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str2 = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = C0065a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    i = C0065a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0601f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0601f[] ap(int i) {
        return new C0601f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m636K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ap(x0);
    }
}
