package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0065a.C0064a;
import com.google.android.gms.common.internal.safeparcel.C0066b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0078a implements Creator<InvitationEntity> {
    static void m154a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int k = C0066b.m133k(parcel);
        C0066b.m120a(parcel, 1, invitationEntity.getGame(), i, false);
        C0066b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, invitationEntity.getVersionCode());
        C0066b.m121a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0066b.m116a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0066b.m131c(parcel, 4, invitationEntity.ch());
        C0066b.m120a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0066b.m130b(parcel, 6, invitationEntity.getParticipants(), false);
        C0066b.m131c(parcel, 7, invitationEntity.getVariant());
        C0066b.m112C(parcel, k);
    }

    public InvitationEntity[] m155S(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m156v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m155S(x0);
    }

    public InvitationEntity m156v(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int j = C0065a.m92j(parcel);
        long j2 = 0;
        ParticipantEntity participantEntity = null;
        int i2 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0065a.m90i(parcel);
            switch (C0065a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    gameEntity = (GameEntity) C0065a.m77a(parcel, i4, GameEntity.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0065a.m94l(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0065a.m87g(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0065a.m86f(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    participantEntity = (ParticipantEntity) C0065a.m77a(parcel, i4, ParticipantEntity.CREATOR);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    arrayList = C0065a.m82c(parcel, i4, ParticipantEntity.CREATOR);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i = C0065a.m86f(parcel, i4);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0065a.m86f(parcel, i4);
                    break;
                default:
                    C0065a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new InvitationEntity(i3, gameEntity, str, j2, i2, participantEntity, arrayList, i);
        }
        throw new C0064a("Overread allowed size end=" + j, parcel);
    }
}
