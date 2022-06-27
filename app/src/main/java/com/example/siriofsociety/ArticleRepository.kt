package com.example.siriofsociety

import com.example.siriofsociety.ArticleRepository.Singleton.articleList
import com.example.siriofsociety.ArticleRepository.Singleton.databaseRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ArticleRepository {

    object Singleton {
        // se connecter à la reference articles
        val databaseRef = FirebaseDatabase.getInstance().getReference("articles")

        //créer une liste qui va contenir les articles
        val articleList = arrayListOf<ArticleModel>()
    }

    fun updateData(callBack: () -> Unit) {
        //recup les donnees dans Fireb -> liste d'articles
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //clean pour recharger
                articleList.clear()
                //recup liste
                for (ds in snapshot.children) {
                    //objet article
                    val article = ds.getValue(ArticleModel::class.java)
                    if (article != null){
                        articleList.add(article)
                    }
                }
                callBack()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun updateArticle(article: ArticleModel) = databaseRef.child(article.id).setValue(article)
    fun deleteArticle(article: ArticleModel) = databaseRef.child(article.id).removeValue()


}