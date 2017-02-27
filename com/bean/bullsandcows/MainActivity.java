package com.bean.bullsandcows;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity implements OnClickListener {
    static int trycounter;
    int BULLS;
    int COWS;
    Button check;
    int count1;
    int count2;
    int count3;
    int count4;
    NumberPicker fbutton;
    NumberPicker fobutton;
    int imag1;
    int imag2;
    int imag3;
    int imag4;
    String res;
    TextView result;
    NumberPicker sbutton;
    NumberPicker tbutton;

    public MainActivity() {
        this.res = "";
        this.BULLS = 0;
        this.COWS = 0;
        this.imag1 = 0;
        this.imag2 = 0;
        this.imag3 = 0;
        this.imag4 = 0;
        this.count1 = 0;
        this.count2 = 0;
        this.count3 = 0;
        this.count4 = 0;
    }

    static {
        trycounter = 1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0047R.layout.activity_main);
        getIntent().removeExtra("res");
        initialize();
        computerNumber();
        setValue();
        this.check.setOnClickListener(this);
    }

    private void setValue() {
        this.fbutton.setMaxValue(9);
        this.fbutton.setMinValue(0);
        this.sbutton.setMaxValue(9);
        this.sbutton.setMinValue(0);
        this.tbutton.setMaxValue(9);
        this.tbutton.setMinValue(0);
        this.fobutton.setMaxValue(9);
        this.fobutton.setMinValue(0);
        this.fbutton.setDescendantFocusability(393216);
        this.sbutton.setDescendantFocusability(393216);
        this.tbutton.setDescendantFocusability(393216);
        this.fobutton.setDescendantFocusability(393216);
    }

    private void computerNumber() {
        Random rand = new Random();
        this.imag1 = rand.nextInt(9);
        this.imag2 = rand.nextInt(9);
        if (this.imag1 == this.imag2) {
            this.imag2 = (this.imag1 + 1) % 10;
        }
        this.imag3 = rand.nextInt(9);
        if (this.imag3 == this.imag1) {
            this.imag3 = (this.imag3 + 1) % 10;
        } else if (this.imag3 == this.imag2) {
            this.imag3 = (this.imag3 + 1) % 10;
        }
        if (this.imag3 == this.imag2) {
            this.imag3 = (this.imag3 + 1) % 10;
        } else if (this.imag3 == this.imag1) {
            this.imag3 = (this.imag3 + 1) % 10;
        }
        this.imag4 = rand.nextInt(9);
        if (this.imag4 == this.imag1) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag2) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag3) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag2) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag3) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag3) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag2) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag1) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag3) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag3) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag1) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag1) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag2) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
        if (this.imag4 == this.imag2) {
            this.imag4 = (this.imag4 + 1) % 10;
        } else if (this.imag4 == this.imag1) {
            this.imag4 = (this.imag4 + 1) % 10;
        }
    }

    private void initialize() {
        this.fbutton = (NumberPicker) findViewById(C0047R.id.fbutton);
        this.sbutton = (NumberPicker) findViewById(C0047R.id.sbutton);
        this.tbutton = (NumberPicker) findViewById(C0047R.id.tbutton);
        this.fobutton = (NumberPicker) findViewById(C0047R.id.fobutton);
        this.check = (Button) findViewById(C0047R.id.submit);
        this.result = (TextView) findViewById(C0047R.id.result);
    }

    public void onClick(View v) {
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DroidSansMono.ttf");
        switch (v.getId()) {
            case C0047R.id.submit:
                try {
                    checkfun();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            default:
        }
    }

    private void checkfun() throws ClassNotFoundException {
        if (trycounter < 6) {
            int i1 = this.fbutton.getValue();
            int i2 = this.sbutton.getValue();
            int i3 = this.tbutton.getValue();
            int i4 = this.fobutton.getValue();
            if (i1 == this.imag1) {
                this.BULLS++;
            }
            if (i2 == this.imag2) {
                this.BULLS++;
            }
            if (i3 == this.imag3) {
                this.BULLS++;
            }
            if (i4 == this.imag4) {
                this.BULLS++;
            }
            if (this.BULLS == 4) {
                trycounter = 1;
                this.COWS = 0;
                this.BULLS = 0;
                this.imag4 = 0;
                this.imag3 = 0;
                this.imag2 = 0;
                this.imag1 = 0;
                win();
            }
            if (i1 == this.imag2 || i1 == this.imag3 || i1 == this.imag4) {
                this.COWS++;
            }
            if (i2 == this.imag1 || i2 == this.imag3 || i2 == this.imag4) {
                this.COWS++;
            }
            if (i3 == this.imag1 || i3 == this.imag2 || i3 == this.imag4) {
                this.COWS++;
            }
            if (i4 == this.imag1 || i4 == this.imag2 || i4 == this.imag3) {
                this.COWS++;
            }
            setString(i1, i2, i3, i4);
            this.BULLS = 0;
            this.COWS = 0;
            trycounter++;
            return;
        }
        trycounter = 1;
        this.COWS = 0;
        this.BULLS = 0;
        loss();
    }

    private void loss() throws ClassNotFoundException {
        Intent ourIntent = new Intent(this, Class.forName("com.bean.bullsandcows.LossResult"));
        ourIntent.putExtra("res", this.imag1 + this.imag2 + this.imag3 + this.imag4);
        this.imag4 = 0;
        this.imag3 = 0;
        this.imag2 = 0;
        this.imag1 = 0;
        startActivity(ourIntent);
    }

    private void win() throws ClassNotFoundException {
        startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.WinResult")));
    }

    private void setString(int i1, int i2, int i3, int i4) {
        this.res += "    " + this.BULLS + " BULLS     " + this.COWS + " COWS " + i1 + i2 + i3 + i4 + "\n";
        this.result.setText(this.res);
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
