package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.internal.C0198d;
import com.google.android.gms.maps.model.internal.C0198d.C0535a;

/* renamed from: com.google.android.gms.maps.internal.k */
public interface C0178k extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.k.a */
    public static abstract class C0516a extends Binder implements C0178k {

        /* renamed from: com.google.android.gms.maps.internal.k.a.a */
        private static class C0515a implements C0178k {
            private IBinder dG;

            C0515a(IBinder iBinder) {
                this.dG = iBinder;
            }

            public boolean m1563a(C0198d c0198d) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    obtain.writeStrongBinder(c0198d != null ? c0198d.asBinder() : null);
                    this.dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dG;
            }
        }

        public C0516a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
        }

        public static C0178k m1564V(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0178k)) ? new C0515a(iBinder) : (C0178k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    boolean a = m720a(C0535a.af(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeInt(a ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean m720a(C0198d c0198d) throws RemoteException;
}
