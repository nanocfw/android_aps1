package com.example.marciano.aps1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.marciano.aps1.R;

import java.util.List;

/**
 * Created by Marciano on 16/10/2017.
 */

public class AdapterCheckListView extends ArrayAdapter<String> {

    private boolean reloading;
    private int selectedItem;

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public AdapterCheckListView(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        selectedItem = -1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.item_lista_desafio, null);
            CheckBox chkItem = (CheckBox) v.findViewById(R.id.chkItem);
            chkItem.setTag(position);
            chkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (reloading) return;
                    if (isChecked) {
                        selectedItem = (int) compoundButton.getTag();
                    } else {
                        selectedItem = -1;
                    }
                    notifyDataSetChanged();
                }
            });
        }

        CheckBox chkItem = (CheckBox) v.findViewById(R.id.chkItem);
        chkItem.setText(getItem(position));
        reloading = true;
        chkItem.setChecked(position == selectedItem);
        reloading = false;
        return v;
    }
}
