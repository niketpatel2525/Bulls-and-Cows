package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m743a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0066b.m118a(parcel, 2, tileOverlayOptions.cP(), false);
        C0066b.m124a(parcel, 3, tileOverlayOptions.isVisible());
        C0066b.m115a(parcel, 4, tileOverlayOptions.getZIndex());
        C0066b.m112C(parcel, k);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0065a.m92j(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    iBinder = C0065a.m95m(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0065a.m83c(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0065a.m89i(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new TileOverlayOptions(i, iBinder, z, f);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
