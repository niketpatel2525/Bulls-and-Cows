package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.dz.C0425a;
import com.google.android.gms.internal.dz.C0426b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class eb implements Creator<C0425a> {
    static void m432a(C0425a c0425a, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, c0425a.versionCode);
        C0066b.m121a(parcel, 2, c0425a.className, false);
        C0066b.m130b(parcel, 3, c0425a.lM, false);
        C0066b.m112C(parcel, k);
    }

    public C0425a[] m433F(int i) {
        return new C0425a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m434r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m433F(x0);
    }

    public C0425a m434r(Parcel parcel) {
        ArrayList arrayList = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    arrayList = C0065a.m82c(parcel, i2, C0426b.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0425a(i, str, arrayList);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }
}
