package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.de.C0135e;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class df implements Callback {
    private static final Object kU;
    private static df kV;
    private final Context kW;
    private final HashMap<String, C0137a> kX;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.df.a */
    final class C0137a {
        private final String kY;
        private final C0136a kZ;
        private final HashSet<C0135e> la;
        private boolean lb;
        private IBinder lc;
        private ComponentName ld;
        final /* synthetic */ df le;
        private int mState;

        /* renamed from: com.google.android.gms.internal.df.a.a */
        public class C0136a implements ServiceConnection {
            final /* synthetic */ C0137a lf;

            public C0136a(C0137a c0137a) {
                this.lf = c0137a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.lf.le.kX) {
                    this.lf.lc = binder;
                    this.lf.ld = component;
                    Iterator it = this.lf.la.iterator();
                    while (it.hasNext()) {
                        ((C0135e) it.next()).onServiceConnected(component, binder);
                    }
                    this.lf.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.lf.le.kX) {
                    this.lf.lc = null;
                    this.lf.ld = component;
                    Iterator it = this.lf.la.iterator();
                    while (it.hasNext()) {
                        ((C0135e) it.next()).onServiceDisconnected(component);
                    }
                    this.lf.mState = 2;
                }
            }
        }

        public C0137a(df dfVar, String str) {
            this.le = dfVar;
            this.kY = str;
            this.kZ = new C0136a(this);
            this.la = new HashSet();
            this.mState = 0;
        }

        public void m351a(C0135e c0135e) {
            this.la.add(c0135e);
        }

        public void m352b(C0135e c0135e) {
            this.la.remove(c0135e);
        }

        public C0136a bg() {
            return this.kZ;
        }

        public String bh() {
            return this.kY;
        }

        public boolean bi() {
            return this.la.isEmpty();
        }

        public boolean m353c(C0135e c0135e) {
            return this.la.contains(c0135e);
        }

        public IBinder getBinder() {
            return this.lc;
        }

        public ComponentName getComponentName() {
            return this.ld;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.lb;
        }

        public void m354l(boolean z) {
            this.lb = z;
        }
    }

    static {
        kU = new Object();
    }

    private df(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.kX = new HashMap();
        this.kW = context.getApplicationContext();
    }

    public static df m356s(Context context) {
        synchronized (kU) {
            if (kV == null) {
                kV = new df(context.getApplicationContext());
            }
        }
        return kV;
    }

    public boolean m357a(String str, C0135e c0135e) {
        boolean isBound;
        synchronized (this.kX) {
            C0137a c0137a = (C0137a) this.kX.get(str);
            if (c0137a != null) {
                this.mHandler.removeMessages(0, c0137a);
                if (!c0137a.m353c(c0135e)) {
                    c0137a.m351a((C0135e) c0135e);
                    switch (c0137a.getState()) {
                        case DetectedActivity.ON_BICYCLE /*1*/:
                            c0135e.onServiceConnected(c0137a.getComponentName(), c0137a.getBinder());
                            break;
                        case DetectedActivity.ON_FOOT /*2*/:
                            c0137a.m354l(this.kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0137a.bg(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0137a = new C0137a(this, str);
            c0137a.m351a((C0135e) c0135e);
            c0137a.m354l(this.kW.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0137a.bg(), 129));
            this.kX.put(str, c0137a);
            isBound = c0137a.isBound();
        }
        return isBound;
    }

    public void m358b(String str, C0135e c0135e) {
        synchronized (this.kX) {
            C0137a c0137a = (C0137a) this.kX.get(str);
            if (c0137a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0137a.m353c(c0135e)) {
                c0137a.m352b(c0135e);
                if (c0137a.bi()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0137a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                C0137a c0137a = (C0137a) msg.obj;
                synchronized (this.kX) {
                    if (c0137a.bi()) {
                        this.kW.unbindService(c0137a.bg());
                        this.kX.remove(c0137a.bh());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
