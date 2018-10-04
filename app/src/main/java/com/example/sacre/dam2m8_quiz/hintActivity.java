package com.example.sacre.dam2m8_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class hintActivity extends AppCompatActivity {

    public String n;
    private ImageView nImg;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        Bundle user = this.getIntent().getExtras();
        n = user.getString("imageName");

        int resID = getResources().getIdentifier(n, "drawable", getPackageName());

        nImg = (ImageView) findViewById(R.id.imView);
        nImg.setImageResource(resID);

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(hintActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });

    }
}
