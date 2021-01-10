package com.tasks.shoocaltask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    int times = 1;
    LinearLayout linearLayout;
    TextView textView1, textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        linearLayout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);
        textView1 = new TextView(this);

        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String gender = intent.getStringExtra("gender");
        String option1 = intent.getStringExtra("option1");
        String option2 = intent.getStringExtra("option2");
        boolean state = intent.getBooleanExtra("state", false);

        textView.setText("Name : " + name + "\n" +
                "Email : " + email + "\n" +
                "Phone : " + phone + "\n" +
                "Gender : " + gender);

        if (option1 != null || option2 != null || state) {
            otherView(option1, option2, state);
        }
    }

    @SuppressLint("SetTextI18n")
    private void otherView(String option1, String option2, boolean state) {
        CardView cardView = new CardView(this);
        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams margins = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        margins.setMargins(0, 0 , 8, 8);
        cardView.setCardElevation(10f);
        cardView.setRadius(2f);
        cardView.setLayoutParams(margins);

        for (int i = 0; i < times; i++) {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);

            textView1.setTextSize(24f);
            textView1.setText("Father's Occupation : " + option1 + "\n" + "Mother's Occupation : " + option2 + "\n" + "State : " + state);
            layout.addView(textView1);
            main.addView(layout);
        }
        cardView.addView(main);
        linearLayout.addView(cardView);
    }
}