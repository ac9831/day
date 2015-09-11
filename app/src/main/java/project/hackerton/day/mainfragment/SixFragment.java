package project.hackerton.day.mainfragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import project.hackerton.day.DB.TagDBHelper;
import project.hackerton.day.DB.TagDBManager;
import project.hackerton.day.MainActivity;
import project.hackerton.day.R;
import project.hackerton.day.diaryListActivity;
import project.hackerton.day.diaryWriteActivity;


public class SixFragment extends Fragment {

    private static final String PARAM = "param";

    private TextView strView;

    private  TextView daysView;

    public static SixFragment newInstance(String param) {
        SixFragment fragment = new SixFragment();
        Bundle args = new Bundle();
        args.putString(PARAM,"param");
        return fragment;
    }

    public SixFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TagDBManager tagDB  = new TagDBManager(getActivity());

        View view = inflater.inflate(R.layout.fragment_six, container, false);

        diaryWriteActivity a = (diaryWriteActivity) getActivity();
        strView =  (TextView)view.findViewById(R.id.munjang);
        strView.setText(tagDB.selectMunjangT());
        daysView = (TextView)view.findViewById(R.id.days);
        daysView.setText(tagDB.selectMunjangD());

        Button btn = (Button) view.findViewById(R.id.btn_save_01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TagDBManager tagDB  = new TagDBManager(getActivity());
                tagDB.insertMainTag(daysView.getText().toString(),strView.getText().toString());
                Toast.makeText(getActivity(), "저장되었습니다.", Toast.LENGTH_LONG);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
