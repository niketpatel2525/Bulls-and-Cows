package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0346c;
import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.fv;
import com.google.android.gms.internal.gg;

public final class PersonBuffer extends DataBuffer<Person> {
    private final C0346c<fv> tt;

    public PersonBuffer(C0348d dataHolder) {
        super(dataHolder);
        if (dataHolder.aM() == null || !dataHolder.aM().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.tt = null;
        } else {
            this.tt = new C0346c(dataHolder, fv.CREATOR);
        }
    }

    public Person get(int position) {
        return this.tt != null ? (Person) this.tt.m1088p(position) : new gg(this.jf, position);
    }
}
