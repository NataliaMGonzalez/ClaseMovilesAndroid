package com.example.parcial2;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MateriasDao {

    @Query("SELECT * FROM Materias")
    List<Materias> getMaterias();

    @Insert
    long insertMateria(Materias materia);

    @Query("DELETE FROM " + Constants.TABLE_NAME_MATERIAS)
    void delete();

}