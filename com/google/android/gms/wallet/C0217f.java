package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.f */
public class C0217f implements Creator<LoyaltyWalletObject> {
    static void m786a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0066b.m121a(parcel, 2, loyaltyWalletObject.tU, false);
        C0066b.m121a(parcel, 3, loyaltyWalletObject.tV, false);
        C0066b.m121a(parcel, 4, loyaltyWalletObject.tW, false);
        C0066b.m121a(parcel, 5, loyaltyWalletObject.tX, false);
        C0066b.m121a(parcel, 6, loyaltyWalletObject.tY, false);
        C0066b.m112C(parcel, k);
    }

    public LoyaltyWalletObject m787S(Parcel parcel) {
        String str = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str5 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str4 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LoyaltyWalletObject(i, str5, str4, str3, str2, str);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public LoyaltyWalletObject[] ax(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m787S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
