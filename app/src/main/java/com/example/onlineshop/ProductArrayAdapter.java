package com.example.onlineshop;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductArrayAdapter extends ArrayAdapter<Product> {

    private Context ctx;
    private int res;
    private List<Product> productList;

    public ProductArrayAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.res = resource;
        this.productList = objects;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if( convertView == null ){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.my_listview_listitem, parent, false);
        }

        TextView tv = convertView.findViewById(R.id.my_listview_listitem_text);
        tv.setText( productList.get(position).getName() );

        return convertView;
    }
}
