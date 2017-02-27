package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.common.data.e */
public class C0056e implements Creator<C0348d> {
    static void m45a(C0348d c0348d, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m127a(parcel, 1, c0348d.aK(), false);
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0348d.getVersionCode());
        C0066b.m126a(parcel, 2, c0348d.aL(), i, false);
        C0066b.m131c(parcel, 3, c0348d.getStatusCode());
        C0066b.m117a(parcel, 4, c0348d.aM(), false);
        C0066b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m46h(x0);
    }

    public C0348d m46h(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int j = C0065a.m92j(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    strArr = C0065a.m105w(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0065a.m81b(parcel, i3, CursorWindow.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bundle = C0065a.m96n(parcel, i3);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0065a.m86f(parcel, i3);
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() != j) {
            throw new C0064a("Overread allowed size end=" + j, parcel);
        }
        C0348d c0348d = new C0348d(i2, strArr, cursorWindowArr, i, bundle);
        c0348d.aJ();
        return c0348d;
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m47s(x0);
    }

    public C0348d[] m47s(int i) {
        return new C0348d[i];
    }
}
