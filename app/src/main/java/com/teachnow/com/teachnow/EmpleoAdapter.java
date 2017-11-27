package com.teachnow.com.teachnow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.teachnow.com.teachnow.dominio.Empleo;

import java.util.List;

/**
 * Created by JULIO on 26/11/2017.
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
    public View getView(int i, View pizzaView, ViewGroup viewGroup) {
        /*pizzaView = LayoutInflater.from(context).inflate(R.layout.pizza_item, viewGroup, false);

        TextView nombreTv = (TextView) pizzaView.findViewById(R.id.nombre);
        TextView precioTv = (TextView) pizzaView.findViewById(R.id.precio);
        ImageView fotoImg = (ImageView) pizzaView.findViewById(R.id.foto);

        Empleo empleo = empleoList.get(i);

        nombreTv.setText(empleo.getNombre());
        precioTv.setText(Double.toString(pizza.getPrecio()));
        fotoImg.setImageResource(pizza.getFotoId());
        pizzaView.setOnClickListener(new PizzaOnClickListener(context, pizza));*/

        return pizzaView;
    }
}

