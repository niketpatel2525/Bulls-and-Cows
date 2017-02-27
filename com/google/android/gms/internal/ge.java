package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.fv.C0602g;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ge implements Creator<C0602g> {
    static void m637a(C0602g c0602g, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0602g.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0602g.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0066b.m124a(parcel, 2, c0602g.isPrimary());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m121a(parcel, 3, c0602g.getValue(), true);
        }
        C0066b.m112C(parcel, k);
    }

    public C0602g m638L(Parcel parcel) {
        boolean z = false;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    z = C0065a.m83c(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0065a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0602g(hashSet, i, z, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0602g[] aq(int i) {
        return new C0602g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m638L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }
}
