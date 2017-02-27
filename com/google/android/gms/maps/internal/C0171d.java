package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0070b;
import com.google.android.gms.dynamic.C0070b.C0357a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.internal.C0198d;
import com.google.android.gms.maps.model.internal.C0198d.C0535a;

/* renamed from: com.google.android.gms.maps.internal.d */
public interface C0171d extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.d.a */
    public static abstract class C0502a extends Binder implements C0171d {

        /* renamed from: com.google.android.gms.maps.internal.d.a.a */
        private static class C0501a implements C0171d {
            private IBinder dG;

            C0501a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public IBinder asBinder() {
                return this.dG;
            }

            public C0070b m1552f(C0198d c0198d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0198d != null ? c0198d.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0070b z = C0357a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0070b m1553g(C0198d c0198d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(c0198d != null ? c0198d.asBinder() : null);
                    this.dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0070b z = C0357a.m1114z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0502a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static C0171d m1554L(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0171d)) ? new C0501a(iBinder) : (C0171d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0070b f;
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = m716f(C0535a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case DetectedActivity.ON_FOOT /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    f = m717g(C0535a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C0070b m716f(C0198d c0198d) throws RemoteException;

    C0070b m717g(C0198d c0198d) throws RemoteException;
}
