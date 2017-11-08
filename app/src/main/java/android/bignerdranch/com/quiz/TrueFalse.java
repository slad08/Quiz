package android.bignerdranch.com.quiz;

/**
 * Created by Denis on 30.10.2017.
 */

public class TrueFalse {

    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean truequestion){
        mQuestion = question;
        mTrueQuestion = truequestion;
    }

    public boolean getTrueQuestion() {
        return mTrueQuestion;
    }
    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }


}
