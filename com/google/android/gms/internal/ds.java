package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

public class ds implements Creator<dr> {
    static void m404a(dr drVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, drVar.getVersionCode());
        C0066b.m120a(parcel, 2, drVar.bk(), i, false);
        C0066b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m405l(x0);
    }

    public dr m405l(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        int i = 0;
        dt dtVar = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    dtVar = (dt) C0065a.m77a(parcel, i2, dt.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new dr(i, dtVar);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m406z(x0);
    }

    public dr[] m406z(int i) {
        return new dr[i];
    }
}
