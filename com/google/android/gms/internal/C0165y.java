package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.internal.y */
public class C0165y implements Creator<C0473x> {
    static void m700a(C0473x c0473x, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, c0473x.versionCode);
        C0066b.m121a(parcel, 2, c0473x.ew, false);
        C0066b.m131c(parcel, 3, c0473x.height);
        C0066b.m131c(parcel, 4, c0473x.heightPixels);
        C0066b.m124a(parcel, 5, c0473x.ex);
        C0066b.m131c(parcel, 6, c0473x.width);
        C0066b.m131c(parcel, 7, c0473x.widthPixels);
        C0066b.m112C(parcel, k);
    }

    public C0473x m701b(Parcel parcel) {
        int i = 0;
        int j = C0065a.m92j(parcel);
        String str = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < j) {
            int i6 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i6)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i5 = C0065a.m86f(parcel, i6);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0065a.m94l(parcel, i6);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i4 = C0065a.m86f(parcel, i6);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0065a.m86f(parcel, i6);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0065a.m83c(parcel, i6);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0065a.m86f(parcel, i6);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i = C0065a.m86f(parcel, i6);
                    break;
                default:
                    C0065a.m80b(parcel, i6);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0473x(i5, str, i4, i3, z, i2, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public C0473x[] m702c(int i) {
        return new C0473x[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m701b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m702c(x0);
    }
}
