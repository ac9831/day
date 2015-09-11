package project.hackerton.day.mainfragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.hackerton.day.DB.TagDBManager;
import project.hackerton.day.R;
import project.hackerton.day.taglib.ITag;
import project.hackerton.day.taglib.MyTag;
import project.hackerton.day.taglib.TagGroup;


public class FiveFragment extends Fragment {
    private static final String PARAM = "param";

    private View view;
    private List<ITag> tags=new ArrayList<>();
    private TextView mText;
    private TagGroup tagGroup;

    private TagDBManager tagDBManager;

    public static FiveFragment newInstance(String param) {
        FiveFragment fragment = new FiveFragment();
        Bundle args = new Bundle();
        args.putString(PARAM,"param");
        return fragment;
    }

    public FiveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tagDBManager = new TagDBManager(getActivity().getApplicationContext());
        View view = inflater.inflate(R.layout.fragment_five, container, false);

        mText = (TextView) view.findViewById(R.id.mtext);
        EditText editText = (EditText) view.findViewById(R.id.mtext);
        editText.setBackgroundColor(Color.TRANSPARENT);
        tagGroup= (TagGroup) view.findViewById(R.id.tags);

        ArrayList<String> tagList = tagDBManager.getHowKeywordInfo();
        tags.clear();
        for(int i=0;i<tagList.size();i++){
            String tag = tagList.get(i).toString();
            tags.add(new MyTag(tag));
        }

        tagGroup.setAppendMode(false);
        tagGroup.setSelectMode(true);
        tagGroup.setTagsList(tags);
        tagGroup.setBrightColor(Color.parseColor("#71cfeb"));

        Button btnin = (Button) view.findViewById(R.id.button_input);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tagGroup.addTag(new MyTag(mText.getText().toString()));
                tagDBManager.insertHowTag(mText.getText().toString()); //디비저장
            }
        });

        Button btndel = (Button) view.findViewById(R.id.button_delete);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tagGroup.deleteTag();

            }
        });

        return view;
    }

}
