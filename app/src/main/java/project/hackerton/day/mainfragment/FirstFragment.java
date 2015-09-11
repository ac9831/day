package project.hackerton.day.mainfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.hackerton.day.R;
import project.hackerton.day.diaryWriteActivity;
import project.hackerton.day.taglib.ITag;
import project.hackerton.day.taglib.MyTag;
import project.hackerton.day.taglib.TagGroup;


public class FirstFragment extends Fragment {

    private static final String PARAM = "param";

    private View view;
    private List<ITag> tags=new ArrayList<>();
    private TextView mText;
    private TagGroup tagGroup;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;

    private int pos1;
    private int pos2;
    private int pos3;

    String getYear, getMonth, getDay;


    public static FirstFragment newInstance(String param) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(PARAM,"param");
        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Date date = new Date();
        SimpleDateFormat CurYearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat CurMonthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat CurDayFormat = new SimpleDateFormat("dd");

        String strCurYear = CurYearFormat.format(date);
        String strCurMonth = CurMonthFormat.format(date);
        String strCurDay = CurDayFormat.format(date);


        final String[] yearArray = getResources().getStringArray(R.array.yearArray);
        final String[] monthArray = getResources().getStringArray(R.array.monthArray);
        final String[] dayArray = getResources().getStringArray(R.array.dayArray);

        spinner1 = (Spinner)view.findViewById(R.id.spinner1);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, yearArray);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setVerticalScrollbarPosition(Integer.parseInt(strCurYear) - 2015);
        getYear = "2015";
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    pos1 = position;
                    getYear = (String) adapter1.getItem(position);
                query(getYear+getMonth+getDay);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2 = (Spinner)view.findViewById(R.id.spinner2);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.monthArray,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setVerticalScrollbarPosition(Integer.parseInt(strCurMonth) - 1);
        getMonth = "01";
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    pos2 = position;
                    getMonth = (String) adapter2.getItem(position);
                query(getYear+getMonth+getDay);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.dayArray,
                android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setVerticalScrollbarPosition(Integer.parseInt(strCurDay) - 1);
        getDay = "01";
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos3 = position;
                getDay = (String) adapter3.getItem(position);
                query(getYear+getMonth+getDay);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public void query(String str){
        diaryWriteActivity act = (diaryWriteActivity) getActivity();
        act.setPos(0);
        act.updateQuery(str);
    }

}
