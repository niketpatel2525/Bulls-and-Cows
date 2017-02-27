package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.fv.C0598b;
import com.google.android.gms.internal.fv.C0598b.C0596a;
import com.google.android.gms.internal.fv.C0598b.C0597b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class fy implements Creator<C0598b> {
    static void m625a(C0598b c0598b, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0598b.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0598b.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m120a(parcel, 2, c0598b.dM(), i, true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m120a(parcel, 3, c0598b.dN(), i, true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0066b.m131c(parcel, 4, c0598b.getLayout());
        }
        C0066b.m112C(parcel, k);
    }

    public C0598b m626F(Parcel parcel) {
        C0597b c0597b = null;
        int i = 0;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        C0596a c0596a = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    C0596a c0596a2 = (C0596a) C0065a.m77a(parcel, i3, C0596a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c0596a = c0596a2;
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0597b c0597b2 = (C0597b) C0065a.m77a(parcel, i3, C0597b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0597b = c0597b2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0065a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0598b(hashSet, i2, c0596a, c0597b, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0598b[] ak(int i) {
        return new C0598b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m626F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }
}
