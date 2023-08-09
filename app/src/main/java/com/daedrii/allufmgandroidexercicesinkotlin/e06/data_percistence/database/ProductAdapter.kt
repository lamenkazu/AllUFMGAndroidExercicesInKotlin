package com.daedrii.allufmgandroidexercicesinkotlin.e06.data_percistence.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.daedrii.allufmgandroidexercicesinkotlin.R
import com.google.android.material.textview.MaterialTextView

class ProductAdapter(private val context: Context): BaseAdapter() {

    private val products: MutableList<Product> = ArrayList()
    private val productDAO = ProductDAO(context)

    init{
        updateProducts(productDAO.getAll())
    }

    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(position: Int): Any {
        return this.products[position]
    }

    override fun getItemId(position: Int): Long {
        return products[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val atual = this.products[position]

        val productView = LayoutInflater.from(context).inflate(R.layout.item_product_list, parent, false)

        val txtProductId = productView.findViewById<MaterialTextView>(R.id.txt_product_id)
        val txtProductName = productView.findViewById<MaterialTextView>(R.id.txt_product_name)
        val txtProductPrice = productView.findViewById<MaterialTextView>(R.id.txt_product_price)

        txtProductId.text = atual.id.toString()
        txtProductName.text = atual.name.toString()
        txtProductPrice.text = atual.price.toString()

        return productView

    }

    fun updateProducts(newProducts: List<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }

    fun deleteProducts(){
        products.clear()
        productDAO.deleteAll()
        notifyDataSetChanged()
    }

    fun insertProduct(newProduct: Product) {
        productDAO.insert(newProduct)
        updateProducts(productDAO.getAll())
    }

    fun getProducts(): MutableList<Product> {
        return products
    }

}