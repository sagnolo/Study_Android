package com.sagnolo.activity_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean isFragmentA = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSwitch = (Button) findViewById(R.id.button1);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment_switch();
            }
        });
    }

    public void fragment_switch(){
        Fragment fr;

        if (isFragmentA) {
            fr = new fragmentA();
        } else {
            fr = new fragmentB();
        }

        isFragmentA = (isFragmentA) ? false : true ;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentAorB,fr);
        fragmentTransaction.commit();
    }
}
