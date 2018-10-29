package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.mylibrary.DataNotification;
import com.example.mylibrary.R;

import java.util.List;

/**
 * Created by KIM on 10/23/2018.
 */

public class Adapter extends ArrayAdapter {
    Context context;
    int resource;
    List<DataNotification> listNotification;
    public Adapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listNotification = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder viewHolder = new viewHolder();
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_column,parent,false);
            viewHolder.time = convertView.findViewById(R.id.tv_time);
            viewHolder.content = convertView.findViewById(R.id.tv_content);
            viewHolder.title = convertView.findViewById(R.id.tv_title);
            viewHolder.type = convertView.findViewById(R.id.tv_type);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (viewHolder) convertView.getTag();
        }
        DataNotification dataNotification = listNotification.get(position);
        viewHolder.time.setText(dataNotification.getTime());
        // get length of summary of content
        int length;
                length = (dataNotification.getContent().length() >=100) ? 100: dataNotification.getContent().length();
        viewHolder.content.setText(dataNotification.getContent().substring(0,length)+"...");
        viewHolder.title.setText(dataNotification.getTitle());
        viewHolder.type.setText(dataNotification.getType());

        return convertView;
    }
    public class viewHolder{
        TextView time;
        TextView content;
        TextView title;
        TextView type;
    }
}