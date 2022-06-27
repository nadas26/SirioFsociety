package com.example.siriofsociety.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siriofsociety.ArticleRepository.Singleton.articleList
import com.example.siriofsociety.MainActivity
import com.example.siriofsociety.PaymentActivity
import com.example.siriofsociety.R
import com.example.siriofsociety.SignInUpActivity
import com.example.siriofsociety.adapter.ArticleAdapter
import com.example.siriofsociety.adapter.ArticleItemDecoration

class CartFragment (
    private val context: MainActivity
) : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_cart, container, false)
        val cartRecyclerView = view.findViewById<RecyclerView>(R.id.cart_recycler_list)
        cartRecyclerView.adapter = ArticleAdapter(context, articleList.filter{it.cart}, R.layout.item_vertical_article)
        cartRecyclerView.layoutManager = LinearLayoutManager(context)
        cartRecyclerView.addItemDecoration(ArticleItemDecoration())

        val paymentButton = view.findViewById<Button>(R.id.checkCart)
        paymentButton.setOnClickListener {
            val intent = Intent(activity, PaymentActivity::class.java)
            activity?.startActivity(intent);
        }

        return view
    }
}
