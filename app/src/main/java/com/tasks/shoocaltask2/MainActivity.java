package com.tasks.shoocaltask2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout parentLayout, layout;
    EditText nameEt, emailEt, phoneEt, optional1, optional2;
    Spinner spinner;
    CheckBox checkBox;
    Button add, remove, save;
    int count = 0;
    int times = 1;
    ArrayList<Integer> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLayout = findViewById(R.id.linearLayout);
        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        phoneEt = findViewById(R.id.phoneEt);
        spinner = findViewById(R.id.spinner);
        add = findViewById(R.id.addBtn);
        remove = findViewById(R.id.removeBtn);
        save = findViewById(R.id.saveBtn);

        optional1 = new EditText(this);
        optional2 = new EditText(this);
        checkBox = new CheckBox(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(v -> {
            count++;
            LinearLayout main = new LinearLayout(this);
            main.setOrientation(LinearLayout.VERTICAL);
            main.setId(count);
            CardView cardView = new CardView(this);
            LinearLayout.LayoutParams margins = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            margins.setMargins(0, 8, 0, 8);
            cardView.setRadius(2f);
            cardView.setElevation(10f);
            cardView.setLayoutParams(margins);
            arrayList = new ArrayList<>();

            for (int i = 0; i < times; i++) {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.VERTICAL);

                optional1 = new EditText(this);
                optional2 = new EditText(this);
                checkBox = new CheckBox(this);
                optional1.setInputType(InputType.TYPE_CLASS_TEXT);
                optional2.setInputType(InputType.TYPE_CLASS_TEXT);
                optional1.setHint("Father's Occupation (Optional)");
                optional2.setHint("Mother's Occupation (Optional)");
                checkBox.setText(R.string.agree);

                optional1.setId(count);
                optional2.setId(count);
                checkBox.setId(count);

                layout.addView(optional1);
                layout.addView(optional2);
                layout.addView(checkBox);
                main.addView(layout);
            }
            arrayList.add(count);
            cardView.addView(main);
            parentLayout.addView(cardView);
        });

        remove.setOnClickListener(v -> {
            if (count > 0) {
                final LinearLayout linearLayout = (LinearLayout) parentLayout.findViewById(count);
                linearLayout.removeAllViews();
                parentLayout.removeView(linearLayout);
                count--;
            }
        });

        save.setOnClickListener(v -> {
            String name = nameEt.getText().toString();
            String email = emailEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String gender = (String) spinner.getSelectedItem();
            String option1 = optional1.getText().toString();
            String option2 = optional2.getText().toString();
            Boolean state = checkBox.isChecked();

            Intent intent = new Intent(this, Second.class);

            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("gender", gender);

            if (option1.length() != 0 || option2.length() != 0) {
                intent.putExtra("option1", option1);
                intent.putExtra("option2", option2);
                intent.putExtra("state", state);
            }

            startActivity(intent);
        });
    }
}