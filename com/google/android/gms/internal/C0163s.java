package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.s */
public final class C0163s {
    private final Runnable el;
    private C0472v em;
    private boolean en;

    /* renamed from: com.google.android.gms.internal.s.1 */
    class C01621 implements Runnable {
        private final WeakReference<C0605r> eo;
        final /* synthetic */ C0605r ep;
        final /* synthetic */ C0163s eq;

        C01621(C0163s c0163s, C0605r c0605r) {
            this.eq = c0163s;
            this.ep = c0605r;
            this.eo = new WeakReference(this.ep);
        }

        public void run() {
            this.eq.en = false;
            C0605r c0605r = (C0605r) this.eo.get();
            if (c0605r != null) {
                c0605r.m2016b(this.eq.em);
            }
        }
    }

    public C0163s(C0605r c0605r) {
        this.en = false;
        this.el = new C01621(this, c0605r);
    }

    public void m695a(C0472v c0472v, long j) {
        if (this.en) {
            cn.m299q("An ad refresh is already scheduled.");
            return;
        }
        cn.m297o("Scheduling ad refresh " + j + " milliseconds from now.");
        this.em = c0472v;
        this.en = true;
        cm.hO.postDelayed(this.el, j);
    }

    public void cancel() {
        cm.hO.removeCallbacks(this.el);
    }

    public void m696d(C0472v c0472v) {
        m695a(c0472v, 60000);
    }
}
