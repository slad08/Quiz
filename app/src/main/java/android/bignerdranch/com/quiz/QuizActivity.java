package android.bignerdranch.com.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex= 0;

    private static final String KEY_INDEX = "index";
    private static final String TAG = "QuizActivity";

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_ocean,true),
            new TrueFalse(R.string.question_midnest,false),
            new TrueFalse(R.string.question_africa,false),
            new TrueFalse(R.string.question_america,true),
            new TrueFalse(R.string.question_asia,true),
    };

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }


    private void checkAnswer(boolean userPressedTrue){

        boolean answerTrue = mQuestionBank[mCurrentIndex].getTrueQuestion();
    int messageResId = 0;
        if(userPressedTrue == answerTrue){
            messageResId = R.string.correnct;
        }else {
            messageResId = R.string.incorrect;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.text_question);

//        int question  = mQuestionBank[mCurrentIndex].getQuestion();
//        mQuestionTextView.setText(question);
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.btn_true);
        mFalseButton =(Button)findViewById(R.id.btn_false);
        mNextButton = (ImageButton) findViewById(R.id.btn_next);
        mPrevButton = (ImageButton) findViewById(R.id.btn_prev);


        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                   if (mCurrentIndex!=0) {
                       mCurrentIndex = (mCurrentIndex - 1);//%mQuestionBank.length;
                   }else {
                       mCurrentIndex= mQuestionBank.length-1;
                   }
                   updateQuestion();



            }
        });
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this,
//                        R.string.correnct,
//                        Toast.LENGTH_SHORT).show();

                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Toast.makeText(QuizActivity.this,
//                        R.string.incorrect,
//                        Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;

              updateQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });

        if(savedInstanceState !=null)
        {
        mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }



}
