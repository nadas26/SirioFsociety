package com.example.siriofsociety.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siriofsociety.ArticleRepository.Singleton.articleList
import com.example.siriofsociety.MainActivity
import com.example.siriofsociety.R
import com.example.siriofsociety.adapter.ArticleAdapter
import com.example.siriofsociety.adapter.ArticleItemDecoration

class FavorisFragment (
    private val context: MainActivity
    ) : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_favoris, container, false)
        val favRecyclerView = view.findViewById<RecyclerView>(R.id.fav_recycler_list)
        favRecyclerView.adapter = ArticleAdapter(context, articleList.filter{it.like}, R.layout.item_vertical_article)
        favRecyclerView.layoutManager = LinearLayoutManager(context)
        favRecyclerView.addItemDecoration(ArticleItemDecoration())
        return view
    }
}
