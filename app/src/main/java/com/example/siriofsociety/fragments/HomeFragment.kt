package com.example.siriofsociety.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.siriofsociety.ArticleModel
import com.example.siriofsociety.ArticleRepository.Singleton.articleList
import com.example.siriofsociety.MainActivity
import com.example.siriofsociety.R
import com.example.siriofsociety.adapter.ArticleAdapter
import com.example.siriofsociety.adapter.ArticleItemDecoration


class HomeFragment ( private val context: MainActivity
): Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)


        //recuperer le recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = ArticleAdapter(context, articleList, R.layout.item_horizontal_article)


        //recuperer le second recyclerview
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = ArticleAdapter(context, articleList, R.layout.item_vertical_article)
        verticalRecyclerView.addItemDecoration(ArticleItemDecoration())
        return view
    }
}