package com.google.android.gms.internal;

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

public class bg implements Creator<bh> {
    static void m203a(bh bhVar, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, bhVar.versionCode);
        C0066b.m120a(parcel, 2, bhVar.fR, i, false);
        C0066b.m118a(parcel, 3, bhVar.m1181U(), false);
        C0066b.m118a(parcel, 4, bhVar.m1182V(), false);
        C0066b.m118a(parcel, 5, bhVar.m1183W(), false);
        C0066b.m118a(parcel, 6, bhVar.m1184X(), false);
        C0066b.m121a(parcel, 7, bhVar.fW, false);
        C0066b.m124a(parcel, 8, bhVar.fX);
        C0066b.m121a(parcel, 9, bhVar.fY, false);
        C0066b.m118a(parcel, 10, bhVar.m1185Y(), false);
        C0066b.m131c(parcel, 11, bhVar.orientation);
        C0066b.m131c(parcel, 12, bhVar.ga);
        C0066b.m121a(parcel, 13, bhVar.fz, false);
        C0066b.m120a(parcel, 14, bhVar.eg, i, false);
        C0066b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m204d(x0);
    }

    public bh m204d(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        int i = 0;
        be beVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        co coVar = null;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    beVar = (be) C0065a.m77a(parcel, i4, be.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    iBinder = C0065a.m95m(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    iBinder2 = C0065a.m95m(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder3 = C0065a.m95m(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    iBinder4 = C0065a.m95m(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str = C0065a.m94l(parcel, i4);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    z = C0065a.m83c(parcel, i4);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str2 = C0065a.m94l(parcel, i4);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    iBinder5 = C0065a.m95m(parcel, i4);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i2 = C0065a.m86f(parcel, i4);
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    i3 = C0065a.m86f(parcel, i4);
                    break;
                case C0048R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    str3 = C0065a.m94l(parcel, i4);
                    break;
                case 14:
                    coVar = (co) C0065a.m77a(parcel, i4, co.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new bh(i, beVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, coVar);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public bh[] m205h(int i) {
        return new bh[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m205h(x0);
    }
}
