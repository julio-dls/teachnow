package com.teachnow.com.teachnow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

/**
 * Created by JULIO on 01/12/2017.
 */

public class EmpleoAdapter extends BaseAdapter {

    private Context context;
    private List<Empleo> empleoList;

    private EmpleoAdapter() {
    }

    public EmpleoAdapter(Context context, List<Empleo> pizzaList) {
        this.empleoList = pizzaList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return empleoList.size();
    }

    @Override
    public Object getItem(int i) {
        return empleoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long) empleoList.get(i).getName().hashCode();
    }

    @Override
    public View getView(int i, View ofertaView, ViewGroup viewGroup) {
        ofertaView = LayoutInflater.from(context).inflate(R.layout.activity_empleo_item, viewGroup, false);

        TextView nombre = (TextView) ofertaView.findViewById(R.id.titulo);
        TextView descripcion = (TextView) ofertaView.findViewById(R.id.descripcion);
        ImageView logoImg = (ImageView) ofertaView.findViewById(R.id.imagen);

        Empleo empleo = empleoList.get(i);

        nombre.setText(empleo.getName());
        descripcion.setText(empleo.getDescription());
        logoImg.setImageResource(empleo.getPhotoId());
        return ofertaView;
    }
}

