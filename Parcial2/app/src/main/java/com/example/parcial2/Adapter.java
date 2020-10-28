package com.example.parcial2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContexT;
    private List<Materias> mMateriasList;

    public Adapter(Context mContexT, List<Materias> mMateriasList) {
        this.mContexT = mContexT;
        this.mMateriasList = mMateriasList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContexT).inflate(R.layout.materiacard,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // Agrega código aquí
        Materias currentItem = mMateriasList.get(position);

        String materia = currentItem.getMateria();
        String dia = currentItem.getDia();
        String horario = currentItem.getHorario();

        holder.mMateria.setText(materia);
        holder.mDia.setText(dia);
        holder.mHorario.setText(horario);


    }

    @Override
    public int getItemCount() {
        // Agrega código aquí
        mMateriasList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Agrega código aquí
        public TextView mMateria;
        public TextView mHorario;
        public TextView mDia;


        public ViewHolder(@NonNull View itemView) {


            // Agrega código aquí
            super(itemView);
            mMateria = itemView.findViewById(R.id.textView_materia);
            mDia = itemView.findViewById(R.id.textView_dia);
            mHorario = itemView.findViewById(R.id.textView_horario);

        }
    }
}
