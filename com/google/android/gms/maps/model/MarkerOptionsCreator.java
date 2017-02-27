package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.C0048R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m739a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, markerOptions.getVersionCode());
        C0066b.m120a(parcel, 2, markerOptions.getPosition(), i, false);
        C0066b.m121a(parcel, 3, markerOptions.getTitle(), false);
        C0066b.m121a(parcel, 4, markerOptions.getSnippet(), false);
        C0066b.m118a(parcel, 5, markerOptions.cN(), false);
        C0066b.m115a(parcel, 6, markerOptions.getAnchorU());
        C0066b.m115a(parcel, 7, markerOptions.getAnchorV());
        C0066b.m124a(parcel, 8, markerOptions.isDraggable());
        C0066b.m124a(parcel, 9, markerOptions.isVisible());
        C0066b.m124a(parcel, 10, markerOptions.isFlat());
        C0066b.m115a(parcel, 11, markerOptions.getRotation());
        C0066b.m115a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0066b.m115a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0066b.m115a(parcel, 14, markerOptions.getAlpha());
        C0066b.m112C(parcel, k);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    latLng = (LatLng) C0065a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder = C0065a.m95m(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    f = C0065a.m89i(parcel, i2);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    f2 = C0065a.m89i(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    z = C0065a.m83c(parcel, i2);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z2 = C0065a.m83c(parcel, i2);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    z3 = C0065a.m83c(parcel, i2);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    f3 = C0065a.m89i(parcel, i2);
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    f4 = C0065a.m89i(parcel, i2);
                    break;
                case C0048R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    f5 = C0065a.m89i(parcel, i2);
                    break;
                case 14:
                    f6 = C0065a.m89i(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
