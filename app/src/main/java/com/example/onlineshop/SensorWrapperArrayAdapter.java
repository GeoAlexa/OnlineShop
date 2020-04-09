package com.example.onlineshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SensorWrapperArrayAdapter  extends ArrayAdapter<SensorWrapper> {

    private Context ctx;
    private int res;
    private List<SensorWrapper> sensorList;

    public SensorWrapperArrayAdapter(@NonNull Context context, int resource, @NonNull List<SensorWrapper> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.res = resource;
        this.sensorList = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if( convertView == null ){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.sensor_wrapper_list_item, parent, false);
        }

        TextView nameTv = convertView.findViewById(R.id.sensor_wrapper_list_item_name);
        nameTv.setText( sensorList.get(position).getName() );

        TextView valueTv = (TextView)convertView.findViewById(R.id.sensor_wrapper_list_item_value);
        valueTv.setText( sensorList.get(position).getValue().toString() );

        return convertView;
    }
}
