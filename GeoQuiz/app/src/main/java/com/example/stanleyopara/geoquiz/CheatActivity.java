package com.example.stanleyopara.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {

    private static final String CURRENT_INDEX = "current_index";
    private static final String HAS_CHEATED = "has_cheated";

    private int sCurrentIndex;

    public static String getCurrentIndexKey(){
        return CURRENT_INDEX;
    }

    public static String getHasCheatedKey(){
        return HAS_CHEATED;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        sCurrentIndex = getIntent().getIntExtra(CURRENT_INDEX,0);

        TextView textView = (TextView)findViewById(R.id.question_cheat_view);
        textView.setText(QuestionManager.getAllQuestions().get(sCurrentIndex).getId());

        Button cheatButton = (Button)findViewById(R.id.cheat_button);
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheatActivity.this, QuestionManager.getAllQuestions().get(sCurrentIndex).getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CheatActivity.this,MainActivity.class);
                intent.putExtra(HAS_CHEATED,true);
                setResult(200, intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
