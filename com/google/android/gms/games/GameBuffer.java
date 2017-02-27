package com.google.android.gms.games;

import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.DataBuffer;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(C0348d dataHolder) {
        super(dataHolder);
    }

    public Game get(int position) {
        return new C0570b(this.jf, position);
    }
}
