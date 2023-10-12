package com.example.sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Sql database yaratish uchun
        val database = openOrCreateDatabase("mydb", MODE_PRIVATE, null)


//        table yaratamiz bu tekshiradi agar bo'lsa ochib beradi bo'lmasa yaratadi
//        database.execSQL("create table if not exists people (name texts,age integer) ")
//        ma'lumot kiritamiz bu ma'lumotni kirgazadi va qayta qayta run qilinganda u ko'payib bora veradi
//        database.execSQL("insert into people(name,age) values('Ali',30)")

//        ma'lumotni update qilish pastdagi kodlarni yozib sinagandan so'ng
        database.execSQL("update people set age = 40 where name = 'Ali'")


//        cursor orqali tanlab olamiz
        val cursor = database.rawQuery("select * from people", null)
//        birinchi qatorga olib borish
        cursor.moveToFirst()
//        name va age ning indexsini topib beradi
        val nameIndex = cursor.getColumnIndex("name")
        val ageIndex = cursor.getColumnIndex("age")
        do {
//            name va age ni olib olamiz
            val name = cursor.getString(nameIndex)
            val age = cursor.getInt(ageIndex)
//            logd ga chaqiramiz
            Log.d("TAG", "name : $name , age : $age ")
//            keyingi qatorga surulguncha ishlasin
        } while (cursor.moveToNext())

//        bazani bekitamiz
        cursor.close()
        database.close()
    }
}