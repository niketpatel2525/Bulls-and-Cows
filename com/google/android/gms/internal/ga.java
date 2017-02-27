package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.fv.C0598b.C0597b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ga implements Creator<C0597b> {
    static void m629a(C0597b c0597b, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0597b.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0597b.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m131c(parcel, 2, c0597b.getHeight());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m121a(parcel, 3, c0597b.getUrl(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0066b.m131c(parcel, 4, c0597b.getWidth());
        }
        C0066b.m112C(parcel, k);
    }

    public C0597b m630H(Parcel parcel) {
        int i = 0;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C0065a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0597b(hashSet, i3, i2, str, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0597b[] am(int i) {
        return new C0597b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m630H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }
}
