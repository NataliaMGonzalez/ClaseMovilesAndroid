package com.example.parcial2;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = Constants.TABLE_NAME_MATERIAS)
public class Materias {

    public long getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(long materia_id) {
        this.materia_id = materia_id;
    }

    @PrimaryKey(autoGenerate = true)
    private long materia_id;

    private String materia;
    private String horario;
    private String dia;

    public Materias(String materia, String horario, String dia) {
        this.materia = materia;
        this.horario = horario;
        this.dia = dia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }


}
