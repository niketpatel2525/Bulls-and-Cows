package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

public interface Invitation extends Parcelable, Freezable<Invitation>, Participatable {
    int ch();

    long getCreationTimestamp();

    Game getGame();

    String getInvitationId();

    Participant getInviter();

    int getVariant();
}
