package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.b */
public interface C0070b extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.b.a */
    public static abstract class C0357a extends Binder implements C0070b {

        /* renamed from: com.google.android.gms.dynamic.b.a.a */
        private static class C0356a implements C0070b {
            private IBinder dG;

            C0356a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }
        }

        public C0357a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static C0070b m1114z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0070b)) ? new C0356a(iBinder) : (C0070b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
