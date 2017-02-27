package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.fv.C0599c;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gb implements Creator<C0599c> {
    static void m631a(C0599c c0599c, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0599c.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0599c.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m121a(parcel, 2, c0599c.getUrl(), true);
        }
        C0066b.m112C(parcel, k);
    }

    public C0599c m632I(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0065a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0599c(hashSet, i, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0599c[] an(int i) {
        return new C0599c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m632I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return an(x0);
    }
}
