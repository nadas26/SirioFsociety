package com.example.siriofsociety.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.siriofsociety.*

class ArticleAdapter(
    val context: MainActivity,
    private val articleList: List<ArticleModel>,
    private val layoutId : Int
    ) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    //regrouper les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleImage = view.findViewById<ImageView>(R.id.image_article)
        val articleName:TextView? = view.findViewById(R.id.name_article)
        val articleDescription:TextView? = view.findViewById(R.id.description_article)
        val articlelike = view.findViewById<ImageView>(R.id.unlike_button)
        val addArticleCart = view.findViewById<ImageView>(R.id.add_cart_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les infos des articles
        val currentArticle = articleList[position]

        val repo = ArticleRepository()

        //glide pour recup l'image
        Glide.with(context).load(Uri.parse(currentArticle.imageURL)).into(holder.articleImage)

        //mettre à jour le nom et la description de la plante
        holder.articleName?.text = currentArticle.name
        holder.articleDescription?.text = currentArticle.prix

        //verification du like
        if (currentArticle.like){
            holder.articlelike.setImageResource(R.drawable.ic_like)
        }else{
            holder.articlelike.setImageResource(R.drawable.ic_unlike)
        }

        //gérer les likes
        holder.articlelike.setOnClickListener {
            currentArticle.like = !currentArticle.like
            repo.updateArticle(currentArticle)
        }

        //verification du panier
        if (currentArticle.cart){
            holder.addArticleCart.setImageResource(R.drawable.ic_cart)
        }else{
            holder.addArticleCart.setImageResource(R.drawable.ic_add_cart)
        }

        //gérer le panier
        holder.addArticleCart.setOnClickListener {
            currentArticle.cart = !currentArticle.cart
            repo.updateArticle(currentArticle)
        }

        //Affichage du popup
        holder.itemView.setOnClickListener{
            ArticleDetail(this, currentArticle).show()
        }
    }

    override fun getItemCount(): Int = articleList.size

}