package com.example.stanleyopara.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**Widget for right button   */
    private Button mTrueButton;

    /**Widget for left button*/
    private Button mFalseButton;

    /**Widget for next button*/
    private ImageButton mNextButton;

    /**Widget for prev button*/
    private ImageButton mPrevButton;

    //list to store questions
    private static List<TrueFalseQuestion>  questions;

    /** Variable that holds current Index in the list of questions*/
    private int sCurrentIndex = 0;

    /** Tag to track logs for this activity*/
    private static final String TAG = "MainActivity";

    /** Key variable to store currentIndex in bundle*/
    private static final String index = "currentIndex";

    private boolean hasCheated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** Inflating the Layout for this activity */
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Calling onCreate method ");

        questions = QuestionManager.getAllQuestions();

        //Button widgets inflated from layout
        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mPrevButton = (ImageButton)findViewById(R.id.prev_button);
        Button mCheatButton = (Button)findViewById(R.id.cheat_button);

        //TextView Widget that displays the question
        final TextView questionView = (TextView)findViewById(R.id.question_view);

        if(savedInstanceState != null){
            sCurrentIndex = savedInstanceState.getInt(index);
        }

        displayQuestion(questionView,sCurrentIndex);

        //**Setting a click listener on the cheat button *//*
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CheatActivity.class);
                intent.putExtra(CheatActivity.getCurrentIndexKey(),sCurrentIndex);
                startActivityForResult(intent, 0);
            }
        });

        //**Setting a click listener on the true button *//*
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasCheated){
                    displayToast(true);
                }else{

                }

            }
        });

        /**Setting a click listener on the false button */
        mFalseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!hasCheated){
                    displayToast(true);
                }else{

                }
            }
        });

        /**Setting a click listener on the next button */
        mNextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                displayQuestion(questionView, ++sCurrentIndex);
                hasCheated = false;
            }
        });

        /**Setting a click listener on the next button */
        mPrevButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                displayQuestion(questionView, (sCurrentIndex > 0) ? --sCurrentIndex: questions.size()+sCurrentIndex -1);
                hasCheated = false;
            }
        });
    }

    @Override
    public void onActivityResult(int sendCode,int receiptCode, Intent data){
        if (receiptCode == 200){
            hasCheated = data.getBooleanExtra(CheatActivity.getHasCheatedKey(),false);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        if (saveInstanceState != null) {
            Log.d(TAG,"Saving current index in InstanceState bundle");
            saveInstanceState.putInt(index, sCurrentIndex);
        }else{
            Log.e(TAG,"Null saveInstanceState object argument provided");
        }
    }

    /**
     * Method that displays an appropriate toast when a user clicks an answer
     * @param userAnswer
     */
    private void displayToast(boolean userAnswer){

        TrueFalseQuestion question = questions.get(sCurrentIndex);
        if (question != null){
            if (question.isAnswer() == userAnswer){
                Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(MainActivity.this,R.string.error_toast,Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Method to display the Question
     * @param textViewWidget
     * @param index
     */
    private void displayQuestion(TextView textViewWidget,int index){
        if (textViewWidget == null){
            //TODO: log
            return;
        }
        sCurrentIndex = index % questions.size();
        TrueFalseQuestion question = questions.get(sCurrentIndex);
        textViewWidget.setText(question.getId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Class has called onDestroy");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Class has called onStart");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Class has called onResume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"Class has called onStop");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"Class has called onPause");
    }
}
