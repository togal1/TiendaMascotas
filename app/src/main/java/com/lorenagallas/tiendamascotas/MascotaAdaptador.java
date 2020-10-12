package com.lorenagallas.tiendamascotas;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;


    public  MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false); //asocia layout con RecyclerView
        return new MascotaViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        if (position%2==0)
            mascotaViewHolder.imgFoto.setBackgroundColor(Color.RED);
        else
            mascotaViewHolder.imgFoto.setBackgroundColor(Color.BLUE);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvLike.setText(mascota.getLike() +"");

        mascotaViewHolder.btnLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mascota.setLike(mascota.getLike()+1);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLike;
        private ImageButton btnLink;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto  = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLike   = (TextView) itemView.findViewById(R.id.tvlikeCV);
            btnLink  = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}