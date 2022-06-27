package com.example.siriofsociety

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.siriofsociety.adapter.ArticleAdapter

class ArticleDetail(
    private val adapter: ArticleAdapter,
    private val currentArticle: ArticleModel
) : Dialog(adapter.context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.articles_details)
        setupComponents()
        setupCloseButton()
        //setupDeleteButton()
        setupLikeButton()
        setupCartButton()
    }

    private fun updateLike(button: ImageView) {
        if(currentArticle.like){
            button.setImageResource(R.drawable.ic_like)
        }else{
            button.setImageResource(R.drawable.ic_unlike)
        }
    }
    private fun setupLikeButton() {
        val unlikeButton = findViewById<ImageView>(R.id.unlike_button)
        updateLike(unlikeButton)

        unlikeButton.setOnClickListener {
            currentArticle.like = !currentArticle.like
            val repo = ArticleRepository()
            repo.updateArticle(currentArticle)
            updateLike(unlikeButton)
        }
    }

    private fun updateCart(button: ImageView) {
        if(currentArticle.cart){
            button.setImageResource(R.drawable.ic_cart)
        }else{
            button.setImageResource(R.drawable.ic_add_cart)
        }
    }
    private fun setupCartButton() {
        val cartButton = findViewById<ImageView>(R.id.add_cart_button)
        updateCart(cartButton)

        cartButton.setOnClickListener {
            currentArticle.cart = !currentArticle.cart
            val repo = ArticleRepository()
            repo.updateArticle(currentArticle)
            updateCart(cartButton)
        }
    }

    /*private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.delete_icon).setOnClickListener {
            val repo = ArticleRepository()
            repo.deleteArticle(currentArticle)
            dismiss()
        }
    }*/

    private fun setupCloseButton(){
        findViewById<ImageView>(R.id.close_button).setOnClickListener{
            dismiss()
        }
    }

    private fun setupComponents() {
        val articleImage = findViewById<ImageView>(R.id.image_article)
        Glide.with(adapter.context).load(Uri.parse(currentArticle.imageURL)).into(articleImage)

        findViewById<TextView>(R.id.details_article_name).text = currentArticle.name
        findViewById<TextView>(R.id.details_article_price).text = currentArticle.prix
        findViewById<TextView>(R.id.details_article_description_info).text = currentArticle.description
        findViewById<RatingBar>(R.id.details_article_ratingBar).numStars = currentArticle.rating

    }
}