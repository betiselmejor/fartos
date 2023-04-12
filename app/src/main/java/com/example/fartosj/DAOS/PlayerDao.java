package com.example.fartosj.DAOS;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fartosj.entities.Player;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM Player")
    List<Player> getAlll();

    @Insert
    void insertAll(Player player);
}
