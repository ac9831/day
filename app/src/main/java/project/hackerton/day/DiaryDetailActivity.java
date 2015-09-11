package project.hackerton.day;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DiaryDetailActivity extends Activity {

    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_detail);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);

        Intent intent = getIntent();
        Diary diary = (Diary)intent.getSerializableExtra("diary");

        tv1.setText(diary.getDate());
        tv2.setText(diary.getSentence());

    }



}
