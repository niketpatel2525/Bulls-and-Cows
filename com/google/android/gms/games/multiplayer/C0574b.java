package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0054b;
import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.games.C0570b;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.dm;
import com.sxnyodot.uefqvmio207964.C0303k;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.b */
public final class C0574b extends C0054b implements Invitation {
    private final ArrayList<Participant> nQ;
    private final Game nS;
    private final C0575d nT;

    C0574b(C0348d c0348d, int i, int i2) {
        super(c0348d, i);
        this.nS = new C0570b(c0348d, i);
        this.nQ = new ArrayList(i2);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i3 = 0; i3 < i2; i3++) {
            C0575d c0575d = new C0575d(this.jf, this.ji + i3);
            if (c0575d.getParticipantId().equals(string)) {
                obj = c0575d;
            }
            this.nQ.add(c0575d);
        }
        this.nT = (C0575d) dm.m388a(obj, (Object) "Must have a valid inviter!");
    }

    public int ch() {
        return getInteger(C0303k.MEDIA_FILE_TYPE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m2073a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public Game getGame() {
        return this.nS;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public Participant getInviter() {
        return this.nT;
    }

    public ArrayList<Participant> getParticipants() {
        return this.nQ;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m2072a(this);
    }

    public String toString() {
        return InvitationEntity.m2074b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
