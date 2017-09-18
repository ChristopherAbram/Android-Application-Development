package fi.jamk.aad.l3334.menunotificationexcercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krzysztof on 18.09.2017.
 */

public class PhoneArrayAdapter extends ArrayAdapter {

    // application context
    private Context context;
    // phone data (names)
    private ArrayList<String> phones;

    // get application context and phones data to adapter
    public PhoneArrayAdapter(Context context, ArrayList<String> phones) {
        super(context, R.layout.row, R.id.phone_name, phones);
        this.context = context;
        this.phones = phones;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get row
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        // show phone name
        TextView textView = (TextView) rowView.findViewById(R.id.phone_name);
        textView.setText(phones.get(position));
        // show phone icon/image
        ImageView imageView = (ImageView) rowView.findViewById(R.id.phone_image);
        switch (phones.get(position)) {
            case "Android": imageView.setImageResource(R.drawable.android); break;
            case "iPhone": imageView.setImageResource(R.drawable.ios); break;
            case "WindowsMobile": imageView.setImageResource(R.drawable.windows); break;
            case "Blackberry": imageView.setImageResource(R.drawable.blackberry); break;
            case "WebOS": imageView.setImageResource(R.drawable.webos); break;
            case "Ubuntu": imageView.setImageResource(R.drawable.ubuntu); break;
        }
        // return row view
        return rowView;
    }

}
