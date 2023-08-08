package com.daedrii.allufmgandroidexercicesinkotlin.e06.data_percistence.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ProductDAO(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    //companion object define membros estáticos da classe
    companion object{
        private const val DB_VERSION = 1
        private const val DB_NAME = "products_db"
        private const val TABLE_PRODUCTS = "products"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sqlQuerry = "CREATE TABLE $TABLE_PRODUCTS (" +
                "$KEY_ID INTEGER PRIMARY KEY, " +
                "$KEY_NAME TEXT, " +
                "$KEY_PRICE REAL" +
                ")"
        db?.execSQL(sqlQuerry)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PRODUCTS")
        onCreate(db)
    }

    fun insert(product: Product){
        val db = writableDatabase
        val values = ContentValues()

        values.put(KEY_ID, product.id)
        values.put(KEY_NAME, product.name)
        values.put(KEY_PRICE, product.price)

        db.insert(TABLE_PRODUCTS, null, values)
    }

    fun deleteAll(){
        val db = writableDatabase

        db?.execSQL("DELETE FROM $TABLE_PRODUCTS;")
    }

    fun getAll(): ArrayList<Product>{

        val db = readableDatabase
        val selectQuerry = "SELECT * FROM $TABLE_PRODUCTS"
        val productList = ArrayList<Product>()

        val cursor: Cursor? = db.rawQuery(selectQuerry, null)

        cursor?.apply {
            if(moveToFirst()){
                do{
                    val id = getInt(getColumnIndex(KEY_ID))
                    val name = getString(getColumnIndex(KEY_NAME))
                    val price = getDouble(getColumnIndex(KEY_PRICE))
                    productList.add(Product(id, name, price))

                }while(moveToNext())
            }
            close()
        }

        return productList
    }
}