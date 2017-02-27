package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.fv.C0598b.C0596a;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class fz implements Creator<C0596a> {
    static void m627a(C0596a c0596a, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0596a.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0596a.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m131c(parcel, 2, c0596a.getLeftImageOffset());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m131c(parcel, 3, c0596a.getTopImageOffset());
        }
        C0066b.m112C(parcel, k);
    }

    public C0596a m628G(Parcel parcel) {
        int i = 0;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0596a(hashSet, i3, i2, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0596a[] al(int i) {
        return new C0596a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m628G(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return al(x0);
    }
}
