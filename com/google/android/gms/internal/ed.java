package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

public class ed implements Creator<ec> {
    static void m435a(ec ecVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, ecVar.getVersionCode());
        C0066b.m119a(parcel, 2, ecVar.bH(), false);
        C0066b.m120a(parcel, 3, ecVar.bI(), i, false);
        C0066b.m112C(parcel, k);
    }

    public ec[] m436G(int i) {
        return new ec[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m437s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m436G(x0);
    }

    public ec m437s(Parcel parcel) {
        dz dzVar = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    parcel2 = C0065a.m108y(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    dzVar = (dz) C0065a.m77a(parcel, i2, dz.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new ec(i, parcel2, dzVar);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }
}
