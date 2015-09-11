package project.hackerton.day;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import com.melnykov.fab.FloatingActionButton;
import java.io.Serializable;
import java.util.ArrayList;


public class DiaryListActivity extends Activity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;

    private int pos1;
    private int pos2;
    private int pos3;

    ArrayList<Diary> list = new ArrayList<Diary>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_list);

        ListView listView = (ListView) findViewById(R.id.list);
        DiaryListAdapter adapter = new DiaryListAdapter(this, R.layout.layout_diary, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DiaryListActivity.this, DiaryDetailActivity.class);
                intent.putExtra("diary", (Serializable) list.get(position));
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryListActivity.this, diaryWriteActivity.class);
                startActivity(intent);
            }
        });

    }

}
