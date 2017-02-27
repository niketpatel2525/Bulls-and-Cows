package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m740a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, polygonOptions.getVersionCode());
        C0066b.m130b(parcel, 2, polygonOptions.getPoints(), false);
        C0066b.m132c(parcel, 3, polygonOptions.cO(), false);
        C0066b.m115a(parcel, 4, polygonOptions.getStrokeWidth());
        C0066b.m131c(parcel, 5, polygonOptions.getStrokeColor());
        C0066b.m131c(parcel, 6, polygonOptions.getFillColor());
        C0066b.m115a(parcel, 7, polygonOptions.getZIndex());
        C0066b.m124a(parcel, 8, polygonOptions.isVisible());
        C0066b.m124a(parcel, 9, polygonOptions.isGeodesic());
        C0066b.m112C(parcel, k);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int j = C0065a.m92j(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0065a.m82c(parcel, i4, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0065a.m79a(parcel, i4, arrayList, getClass().getClassLoader());
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0065a.m89i(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0065a.m86f(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i = C0065a.m86f(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    f = C0065a.m89i(parcel, i4);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    z2 = C0065a.m83c(parcel, i4);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z = C0065a.m83c(parcel, i4);
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
