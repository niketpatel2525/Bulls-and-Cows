package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0073e;
import com.google.android.gms.dynamic.C0073e.C0072a;
import com.google.android.gms.dynamic.C0569c;
import com.google.android.gms.internal.dk.C0422a;

public final class dn extends C0073e<dk> {
    private static final dn ll;

    static {
        ll = new dn();
    }

    private dn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m1268d(Context context, int i, int i2) throws C0072a {
        return ll.m1269e(context, i, i2);
    }

    private View m1269e(Context context, int i, int i2) throws C0072a {
        try {
            return (View) C0569c.m1772b(((dk) m145t(context)).m385a(C0569c.m1773g(context), i, i2));
        } catch (Throwable e) {
            throw new C0072a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public /* synthetic */ Object m1270d(IBinder iBinder) {
        return m1271y(iBinder);
    }

    public dk m1271y(IBinder iBinder) {
        return C0422a.m1267x(iBinder);
    }
}
