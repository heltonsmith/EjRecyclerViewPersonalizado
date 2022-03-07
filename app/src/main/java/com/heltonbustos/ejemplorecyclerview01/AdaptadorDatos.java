package com.heltonbustos.ejemplorecyclerview01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDatos extends RecyclerView.Adapter<AdaptadorDatos.ViewHolderDator> {

    ArrayList<Personaje> listDatos;
    Context context;

    public AdaptadorDatos(ArrayList<Personaje> listDatos, Context context) {
        this.listDatos = listDatos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDator onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler, null, false);
        return new ViewHolderDator(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDator holder, int position) {
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition));
        holder.texto.setText(listDatos.get(position).getTexto());
        holder.des.setText(listDatos.get(position).getDes());
        holder.imagen.setImageResource(listDatos.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDator extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView texto;
        TextView des;

        public ViewHolderDator(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.myImagen);
            texto = itemView.findViewById(R.id.myDato);
            des = itemView.findViewById(R.id.myDes);
        }
    }


}
