package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.g */
public class C0218g implements Creator<MaskedWallet> {
    static void m788a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m131c(parcel, 1, maskedWallet.getVersionCode());
        C0066b.m121a(parcel, 2, maskedWallet.tH, false);
        C0066b.m121a(parcel, 3, maskedWallet.tI, false);
        C0066b.m127a(parcel, 4, maskedWallet.tN, false);
        C0066b.m121a(parcel, 5, maskedWallet.tK, false);
        C0066b.m120a(parcel, 6, maskedWallet.tL, i, false);
        C0066b.m120a(parcel, 7, maskedWallet.tM, i, false);
        C0066b.m126a(parcel, 8, maskedWallet.tZ, i, false);
        C0066b.m126a(parcel, 9, maskedWallet.ua, i, false);
        C0066b.m112C(parcel, k);
    }

    public MaskedWallet m789T(Parcel parcel) {
        OfferWalletObject[] offerWalletObjectArr = null;
        int j = C0065a.m92j(parcel);
        int i = 0;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        String[] strArr = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0065a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str3 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0065a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    strArr = C0065a.m105w(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0065a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    address2 = (Address) C0065a.m77a(parcel, i2, Address.CREATOR);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    address = (Address) C0065a.m77a(parcel, i2, Address.CREATOR);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0065a.m81b(parcel, i2, LoyaltyWalletObject.CREATOR);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C0065a.m81b(parcel, i2, OfferWalletObject.CREATOR);
                    break;
                default:
                    C0065a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MaskedWallet(i, str3, str2, strArr, str, address2, address, loyaltyWalletObjectArr, offerWalletObjectArr);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }

    public MaskedWallet[] ay(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m789T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
