package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateClient;
import com.google.android.gms.appstate.OnSignOutCompleteListener;
import com.google.android.gms.appstate.OnStateDeletedListener;
import com.google.android.gms.appstate.OnStateListLoadedListener;
import com.google.android.gms.appstate.OnStateLoadedListener;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.data.C0348d;
import com.google.android.gms.internal.cy.C0414a;
import com.google.android.gms.internal.de.C0134b;
import com.google.android.gms.internal.de.C0415c;
import com.google.android.gms.internal.de.C0582d;

public final class cw extends de<cy> {
    private final String it;

    /* renamed from: com.google.android.gms.internal.cw.b */
    final class C0409b extends C0134b<OnStateDeletedListener> {
        final /* synthetic */ cw iB;
        private final int iC;
        private final int iD;

        public C0409b(cw cwVar, OnStateDeletedListener onStateDeletedListener, int i, int i2) {
            this.iB = cwVar;
            super(cwVar, onStateDeletedListener);
            this.iC = i;
            this.iD = i2;
        }

        public void m1211a(OnStateDeletedListener onStateDeletedListener) {
            onStateDeletedListener.onStateDeleted(this.iC, this.iD);
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.h */
    final class C0410h extends C0134b<OnSignOutCompleteListener> {
        final /* synthetic */ cw iB;

        public C0410h(cw cwVar, OnSignOutCompleteListener onSignOutCompleteListener) {
            this.iB = cwVar;
            super(cwVar, onSignOutCompleteListener);
        }

        public void m1213a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.d */
    final class C0580d extends C0415c<OnStateListLoadedListener> {
        final /* synthetic */ cw iB;

        public C0580d(cw cwVar, OnStateListLoadedListener onStateListLoadedListener, C0348d c0348d) {
            this.iB = cwVar;
            super(cwVar, onStateListLoadedListener, c0348d);
        }

        public void m1813a(OnStateListLoadedListener onStateListLoadedListener, C0348d c0348d) {
            onStateListLoadedListener.onStateListLoaded(c0348d.getStatusCode(), new AppStateBuffer(c0348d));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.f */
    final class C0581f extends C0415c<OnStateLoadedListener> {
        final /* synthetic */ cw iB;
        private final int iD;

        public C0581f(cw cwVar, OnStateLoadedListener onStateLoadedListener, int i, C0348d c0348d) {
            this.iB = cwVar;
            super(cwVar, onStateLoadedListener, c0348d);
            this.iD = i;
        }

        public void m1815a(OnStateLoadedListener onStateLoadedListener, C0348d c0348d) {
            byte[] bArr = null;
            AppStateBuffer appStateBuffer = new AppStateBuffer(c0348d);
            try {
                String conflictVersion;
                byte[] localData;
                if (appStateBuffer.getCount() > 0) {
                    AppState appState = appStateBuffer.get(0);
                    conflictVersion = appState.getConflictVersion();
                    localData = appState.getLocalData();
                    bArr = appState.getConflictData();
                } else {
                    localData = null;
                    conflictVersion = null;
                }
                appStateBuffer.close();
                int statusCode = c0348d.getStatusCode();
                if (statusCode == AppStateClient.STATUS_WRITE_OUT_OF_DATE_VERSION) {
                    onStateLoadedListener.onStateConflict(this.iD, conflictVersion, localData, bArr);
                } else {
                    onStateLoadedListener.onStateLoaded(statusCode, this.iD, localData);
                }
            } catch (Throwable th) {
                appStateBuffer.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.a */
    final class C0619a extends cv {
        private final OnStateDeletedListener iA;
        final /* synthetic */ cw iB;

        public C0619a(cw cwVar, OnStateDeletedListener onStateDeletedListener) {
            this.iB = cwVar;
            this.iA = (OnStateDeletedListener) dm.m388a((Object) onStateDeletedListener, (Object) "Listener must not be null");
        }

        public void onStateDeleted(int statusCode, int stateKey) {
            this.iB.m1243a(new C0409b(this.iB, this.iA, statusCode, stateKey));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.c */
    final class C0620c extends cv {
        final /* synthetic */ cw iB;
        private final OnStateListLoadedListener iE;

        public C0620c(cw cwVar, OnStateListLoadedListener onStateListLoadedListener) {
            this.iB = cwVar;
            this.iE = (OnStateListLoadedListener) dm.m388a((Object) onStateListLoadedListener, (Object) "Listener must not be null");
        }

        public void m2086a(C0348d c0348d) {
            this.iB.m1243a(new C0580d(this.iB, this.iE, c0348d));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.e */
    final class C0621e extends cv {
        final /* synthetic */ cw iB;
        private final OnStateLoadedListener iF;

        public C0621e(cw cwVar, OnStateLoadedListener onStateLoadedListener) {
            this.iB = cwVar;
            this.iF = (OnStateLoadedListener) dm.m388a((Object) onStateLoadedListener, (Object) "Listener must not be null");
        }

        public void m2087a(int i, C0348d c0348d) {
            this.iB.m1243a(new C0581f(this.iB, this.iF, i, c0348d));
        }
    }

    /* renamed from: com.google.android.gms.internal.cw.g */
    final class C0622g extends cv {
        final /* synthetic */ cw iB;
        private final OnSignOutCompleteListener iG;

        public C0622g(cw cwVar, OnSignOutCompleteListener onSignOutCompleteListener) {
            this.iB = cwVar;
            this.iG = (OnSignOutCompleteListener) dm.m388a((Object) onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            this.iB.m1243a(new C0410h(this.iB, this.iG));
        }
    }

    public cw(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.it = (String) dm.m392e(str);
    }

    public void m1817a(OnStateLoadedListener onStateLoadedListener, int i, byte[] bArr) {
        if (onStateLoadedListener == null) {
            cx cxVar = null;
        } else {
            Object c0621e = new C0621e(this, onStateLoadedListener);
        }
        try {
            ((cy) bd()).m331a(cxVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m1818a(dj djVar, C0582d c0582d) throws RemoteException {
        djVar.m373a(c0582d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.it, aY());
    }

    protected void m1819a(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        dm.m389a(z, String.format("AppStateClient requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String ag() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void deleteState(OnStateDeletedListener listener, int stateKey) {
        try {
            ((cy) bd()).m333b(new C0619a(this, listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public int getMaxNumKeys() {
        try {
            return ((cy) bd()).getMaxNumKeys();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int getMaxStateSize() {
        try {
            return ((cy) bd()).getMaxStateSize();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public void listStates(OnStateListLoadedListener listener) {
        try {
            ((cy) bd()).m328a(new C0620c(this, listener));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void loadState(OnStateLoadedListener listener, int stateKey) {
        try {
            ((cy) bd()).m329a(new C0621e(this, listener), stateKey);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected /* synthetic */ IInterface m1820p(IBinder iBinder) {
        return m1821r(iBinder);
    }

    protected cy m1821r(IBinder iBinder) {
        return C0414a.m1226t(iBinder);
    }

    public void resolveState(OnStateLoadedListener listener, int stateKey, String resolvedVersion, byte[] resolvedData) {
        try {
            ((cy) bd()).m330a(new C0621e(this, listener), stateKey, resolvedVersion, resolvedData);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void signOut(OnSignOutCompleteListener listener) {
        if (listener == null) {
            cx cxVar = null;
        } else {
            Object c0622g = new C0622g(this, listener);
        }
        try {
            ((cy) bd()).m332b(cxVar);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }
}
