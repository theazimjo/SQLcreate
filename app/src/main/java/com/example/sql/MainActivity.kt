package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Sql database yaratish uchun
        val database = openOrCreateDatabase("mydb", MODE_PRIVATE, null)


//        table yaratamiz bu tekshiradi agar bo'lsa ochib beradi bo'lmasa yaratadi
        database.execSQL("create table if not exists people (name texts,age integer) ")
//        ma'lumot kiritamiz bu ma'lumotni kirgazadi va qayta qayta run qilinganda u ko'payib bora veradi
        database.execSQL("insert into people(name,age) values('Ali',30)")

    }
}