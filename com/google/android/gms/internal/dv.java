package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.dt.C0423a;
import com.google.android.gms.location.DetectedActivity;

public class dv implements Creator<C0423a> {
    static void m410a(C0423a c0423a, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, c0423a.versionCode);
        C0066b.m121a(parcel, 2, c0423a.lx, false);
        C0066b.m131c(parcel, 3, c0423a.ly);
        C0066b.m112C(parcel, k);
    }

    public C0423a[] m411B(int i) {
        return new C0423a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m412n(x0);
    }

    public C0423a m412n(Parcel parcel) {
        int i = 0;
        int j = C0065a.m92j(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0065a.m94l(parcel, i3);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0065a.m86f(parcel, i3);
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0423a(i2, str, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m411B(x0);
    }
}
