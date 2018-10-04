package com.example.sacre.dam2m8_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private Button TrueButton,FalseButton,prevButton,nextButton,hintButton;
    private TextView pregunt_view;
    private pregunta[] ListPreguntas = new pregunta[]{
            new pregunta(R.string.pregunta1, true, "hint1"),
            new pregunta(R.string.pregunta2, false, "hint2"),
            new pregunta(R.string.pregunta3, true, "hint3"),
    };

    private int indexPregunta = 0;

    public void updateQuestion(){
        int pregunta = ListPreguntas[indexPregunta].getPreguntaId();
        pregunt_view.setText(pregunta);
    }
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = ListPreguntas[indexPregunta].isRespPregunta();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) { messageResId = R.string.correct_toast; }
        else { messageResId = R.string.fail_toast; }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT) .show();
    }
    public void test(View view){
        Intent intent =new Intent(this, pregunta.class);
        TextView editext =(TextView) findViewById(R.id.pregunta);
        String message= editext.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pregunt_view = (TextView) findViewById(R.id.pregunta);
        updateQuestion();
        TrueButton = (Button) findViewById(R.id.bt_true);
        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }

        });
        FalseButton = (Button) findViewById(R.id.bt_false);
        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }

        });
        nextButton = (Button) findViewById(R.id.bt_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexPregunta<2) {
                    indexPregunta++;
                }
                updateQuestion();
            }

        });
        prevButton = (Button) findViewById(R.id.bt_prev);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(indexPregunta>0) {
                    indexPregunta--;
                }
                updateQuestion();
            }

        });
        hintButton = (Button) findViewById(R.id.btHint);
        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hintActivity = new Intent(MainActivity.this, hintActivity.class);
                String imageName = ListPreguntas[indexPregunta].getResName();
                hintActivity.putExtra("imageName", imageName);
                startActivity(hintActivity);
            }
        });
    }
}
