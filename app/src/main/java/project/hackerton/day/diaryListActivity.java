package project.hackerton.day;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class diaryListActivity extends Activity {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    int pos1;
    int pos2;
    int pos3;

    String getYear, getMonth, getDay;

    ArrayList<Diary> list = new ArrayList<Diary>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarylist);
    }
}
