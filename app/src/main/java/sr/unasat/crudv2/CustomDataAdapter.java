package sr.unasat.crudv2;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomDataAdapter extends ArrayAdapter<DataModel> {

    public CustomDataAdapter(@NonNull Context context, int resource, @NonNull List<DataModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Aangepaste weergave van elk item in de lijst
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView customDataTextView = view.findViewById(android.R.id.text1);
        DataModel data = getItem(position);

        if (data != null) {
            customDataTextView.setText("Custom Data: " + data.getCustomData());
        }


        return view;
    }

}
