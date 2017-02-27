package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.internal.dt.C0423a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class du implements Creator<dt> {
    static void m407a(dt dtVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, dtVar.getVersionCode());
        C0066b.m130b(parcel, 2, dtVar.bm(), false);
        C0066b.m112C(parcel, k);
    }

    public dt[] m408A(int i) {
        return new dt[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m409m(x0);
    }

    public dt m409m(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    arrayList = C0065a.m82c(parcel, i2, C0423a.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new dt(i, arrayList);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m408A(x0);
    }
}
