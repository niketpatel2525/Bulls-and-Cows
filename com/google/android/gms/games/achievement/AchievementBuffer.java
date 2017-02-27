package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.DataBuffer;

public final class AchievementBuffer extends DataBuffer<Achievement> {
    public AchievementBuffer(C0348d dataHolder) {
        super(dataHolder);
    }

    public Achievement get(int position) {
        return new C0360a(this.jf, position);
    }
}
