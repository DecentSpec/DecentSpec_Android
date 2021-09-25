package com.example.decentspec_v3.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// Room based database definition
// use private to restrict DB io to this module only
@Entity
public class SampleFile {

    public static final int STAGE_RECEIVING = 0; // starts writing file immediately
    public static final int STAGE_RECEIVED = 1;
    public static final int STAGE_TRAINING = 2;
    public static final int STAGE_TRAINED = 3;

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "file_name")
    public String fileName;

    @ColumnInfo(name = "stage")
    public int stage;

    @ColumnInfo(name = "progress")
    public int progress;

    public SampleFile(String fileName) {
        this.fileName = String.valueOf(fileName);
        this.stage = STAGE_RECEIVING;
        this.progress = 0;
    }

    @Override
    public String toString() {
        return "id: " + id + " | filename: " + fileName + " | stage: " + stage + " | progress: " + progress;
    }
}
