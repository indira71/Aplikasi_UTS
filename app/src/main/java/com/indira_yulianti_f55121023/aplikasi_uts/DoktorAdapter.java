package com.indira_yulianti_f55121023.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DoktorAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Doktor> doktors;
    void setDoktors (ArrayList<Doktor> doktors) {
        this.doktors = doktors;
    }
    DoktorAdapter(Context context){
        this.context = context;
        doktors = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return doktors.size();
    }

    @Override
    public Object getItem(int i) {
        return doktors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_doktor, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Doktor doktor = (Doktor) getItem(i);
        viewHolder.bind(doktor);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Doktor doktor) {
            txtName.setText(doktor.getName());
            txtDescription.setText(doktor.getDescription());
            imgPhoto.setImageResource(doktor.getPhoto());
        }
    }
}
