package project.hackerton.day;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class DiaryListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Diary> data;
    private int layout;
    private LayoutInflater inflater;

    public DiaryListAdapter(Context context, int layout, ArrayList<Diary> data) {
        this.context = context;
        this.layout = layout;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Diary getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;

        if(convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }

        TextView tvDate = (TextView)convertView.findViewById(R.id.tvDate);
        TextView tvSentence = (TextView)convertView.findViewById(R.id.tvSentence);
        tvDate.setText(getItem(pos).getDate());
        tvSentence.setText(getItem(pos).getSentence());

        return convertView;
    }
}
