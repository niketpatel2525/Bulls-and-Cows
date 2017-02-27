package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.dw.C0424a;
import com.google.android.gms.internal.dz.C0426b;
import com.google.android.gms.location.DetectedActivity;

public class dy implements Creator<C0426b> {
    static void m426a(C0426b c0426b, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, c0426b.versionCode);
        C0066b.m121a(parcel, 2, c0426b.lN, false);
        C0066b.m120a(parcel, 3, c0426b.lO, i, false);
        C0066b.m112C(parcel, k);
    }

    public C0426b[] m427D(int i) {
        return new C0426b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m428p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m427D(x0);
    }

    public C0426b m428p(Parcel parcel) {
        C0424a c0424a = null;
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
                    c0424a = (C0424a) C0065a.m77a(parcel, i2, C0424a.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0426b(i, str, c0424a);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }
}
