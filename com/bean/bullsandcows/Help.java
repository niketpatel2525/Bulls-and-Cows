package com.bean.bullsandcows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.widget.TextView;
import com.sxnyodot.uefqvmio207964.AdListener;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.Prm;

public class Help extends Activity {
    private Prm prm;
    TextView tvhelp;

    /* renamed from: com.bean.bullsandcows.Help.1 */
    class C03401 implements AdListener {
        C03401() {
        }

        public void onSDKIntegrationError(String message) {
        }

        public void onSmartWallAdShowing() {
        }

        public void onSmartWallAdClosed() {
        }

        public void onAdError(String message) {
        }

        public void onAdCached(AdType arg0) {
        }

        public void noAdAvailableListener() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0047R.layout.help);
        if (this.prm == null) {
            this.prm = new Prm(this, null, false);
        }
        AdListener adCallbackListener = new C03401();
        this.tvhelp = (TextView) findViewById(C0047R.id.tvhelp);
        this.tvhelp.setText("Bulls And Cows  game is based on Artificial Intelligent. Here Computer Guess a  4 Digit Number where all digits are different and  player have to find it out. When player guess a number and if he get same digit position as computer generated number has then Bulls will plus 1  or if the digit is present in the number then Cows will plus 1. For an example  . Let Computer Generated Number is  4052  and player guess 4250 then Bulls will  be 2 and Cows will be 2 because  digit 4 and 5 are at correct position and 0 and 2 are present in number.Each time you have 6 moves to guess a number.");
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.Home")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
