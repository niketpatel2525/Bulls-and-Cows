package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.e */
public class C0216e implements Creator<LineItem> {
    static void m784a(LineItem lineItem, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, lineItem.getVersionCode());
        C0066b.m121a(parcel, 2, lineItem.description, false);
        C0066b.m121a(parcel, 3, lineItem.tQ, false);
        C0066b.m121a(parcel, 4, lineItem.tR, false);
        C0066b.m121a(parcel, 5, lineItem.tD, false);
        C0066b.m131c(parcel, 6, lineItem.tS);
        C0066b.m121a(parcel, 7, lineItem.tE, false);
        C0066b.m112C(parcel, k);
    }

    public LineItem m785R(Parcel parcel) {
        int i = 0;
        String str = null;
        int j = C0065a.m92j(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0065a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str5 = C0065a.m94l(parcel, i3);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str4 = C0065a.m94l(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0065a.m94l(parcel, i3);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0065a.m94l(parcel, i3);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i = C0065a.m86f(parcel, i3);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str = C0065a.m94l(parcel, i3);
                    break;
                default:
                    C0065a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public LineItem[] aw(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m785R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
