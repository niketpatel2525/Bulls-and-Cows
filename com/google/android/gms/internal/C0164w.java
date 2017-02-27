package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

/* renamed from: com.google.android.gms.internal.w */
public class C0164w implements Creator<C0472v> {
    static void m697a(C0472v c0472v, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, c0472v.versionCode);
        C0066b.m116a(parcel, 2, c0472v.es);
        C0066b.m117a(parcel, 3, c0472v.extras, false);
        C0066b.m131c(parcel, 4, c0472v.et);
        C0066b.m122a(parcel, 5, c0472v.eu, false);
        C0066b.m124a(parcel, 6, c0472v.ev);
        C0066b.m131c(parcel, 7, c0472v.tagForChildDirectedTreatment);
        C0066b.m112C(parcel, k);
    }

    public C0472v m698a(Parcel parcel) {
        List list = null;
        int i = 0;
        int j = C0065a.m92j(parcel);
        long j2 = 0;
        boolean z = false;
        int i2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0065a.m87g(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bundle = C0065a.m96n(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0065a.m106x(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    z = C0065a.m83c(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i = C0065a.m86f(parcel, i4);
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0472v(i3, j2, bundle, i2, list, z, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0472v[] m699b(int i) {
        return new C0472v[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m698a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m699b(x0);
    }
}
