package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0603h;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gf implements Creator<C0603h> {
    static void m639a(C0603h c0603h, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        Set di = c0603h.di();
        if (di.contains(Integer.valueOf(1))) {
            C0066b.m131c(parcel, 1, c0603h.getVersionCode());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0066b.m131c(parcel, 3, c0603h.dV());
        }
        if (di.contains(Integer.valueOf(4))) {
            C0066b.m121a(parcel, 4, c0603h.getValue(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0066b.m121a(parcel, 5, c0603h.getLabel(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0066b.m131c(parcel, 6, c0603h.getType());
        }
        C0066b.m112C(parcel, k);
    }

    public C0603h m640M(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0065a.m92j(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0065a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0065a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0065a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0603h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0603h[] ar(int i) {
        return new C0603h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m640M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
