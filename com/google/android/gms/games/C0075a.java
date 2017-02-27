package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.widget.ViewDragHelper;
import com.google.android.gms.C0048R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.games.a */
public class C0075a implements Creator<GameEntity> {
    static void m146a(GameEntity gameEntity, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m121a(parcel, 1, gameEntity.getApplicationId(), false);
        C0066b.m121a(parcel, 2, gameEntity.getDisplayName(), false);
        C0066b.m121a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0066b.m121a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0066b.m121a(parcel, 5, gameEntity.getDescription(), false);
        C0066b.m121a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0066b.m120a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0066b.m120a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0066b.m120a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0066b.m124a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0066b.m124a(parcel, 11, gameEntity.isInstanceInstalled());
        C0066b.m121a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0066b.m131c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0066b.m131c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0066b.m131c(parcel, 15, gameEntity.getLeaderboardCount());
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, gameEntity.getVersionCode());
        C0066b.m112C(parcel, k);
    }

    public GameEntity[] m147K(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m148t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m147K(x0);
    }

    public GameEntity m148t(Parcel parcel) {
        int j = C0065a.m92j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i5)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str = C0065a.m94l(parcel, i5);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0065a.m94l(parcel, i5);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str3 = C0065a.m94l(parcel, i5);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0065a.m94l(parcel, i5);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str5 = C0065a.m94l(parcel, i5);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str6 = C0065a.m94l(parcel, i5);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    uri = (Uri) C0065a.m77a(parcel, i5, Uri.CREATOR);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    uri2 = (Uri) C0065a.m77a(parcel, i5, Uri.CREATOR);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    uri3 = (Uri) C0065a.m77a(parcel, i5, Uri.CREATOR);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    z = C0065a.m83c(parcel, i5);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z2 = C0065a.m83c(parcel, i5);
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    str7 = C0065a.m94l(parcel, i5);
                    break;
                case C0048R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    i2 = C0065a.m86f(parcel, i5);
                    break;
                case 14:
                    i3 = C0065a.m86f(parcel, i5);
                    break;
                case ViewDragHelper.EDGE_ALL /*15*/:
                    i4 = C0065a.m86f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0065a.m86f(parcel, i5);
                    break;
                default:
                    C0065a.m80b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }
}
