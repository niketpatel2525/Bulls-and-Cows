package com.bean.bullsandcows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.widget.TextView;

public class About extends Activity {
    TextView tvabout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0047R.layout.aboutus);
        this.tvabout = (TextView) findViewById(C0047R.id.tvabout);
        this.tvabout.setText("My name is Niket Patel. I am a student in L.D. College of Engineering. This is my first Android Game App. I hope you like it.");
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
