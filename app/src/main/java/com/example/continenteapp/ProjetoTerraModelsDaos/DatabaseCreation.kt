package com.example.continenteapp.ProjetoTerraModelsDaos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DatabaseCreation(ctx: Context) : SQLiteOpenHelper(ctx,DB_NAME,null,DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE $TABLE_NAME (
                id integer primary key autoincrement,
                nome text,
                area integer
            );
            """.trimMargin();
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    companion object {
        private val DB_VERSION = 2
        private val DB_NAME = "ContinentDB"
        private val TABLE_NAME = "continente"
    }
}
