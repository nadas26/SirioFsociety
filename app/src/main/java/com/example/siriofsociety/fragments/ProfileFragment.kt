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

import android.content.Intent
import android.widget.Button
import com.example.siriofsociety.*
import com.example.siriofsociety.adapter.ProfileAdapter

class ProfileFragment(private val context: MainActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.fragment_profile, container, false)

        // recuperer recycler view
        val settingsRecyclerView = view.findViewById<RecyclerView>(R.id.profile_recycler_list)
        settingsRecyclerView.adapter = ProfileAdapter(object : ProfileAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsProfileActivity::class.java))
                    }
                }
                if (position == 1) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsOrderActivity::class.java))
                    }
                }
                if (position == 2) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsAddressActivity::class.java))
                    }
                }
                if (position == 3) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsPaymentActivity::class.java))
                    }
                }
            }
        })
        settingsRecyclerView.layoutManager = LinearLayoutManager(context)

        val logButton = view.findViewById<Button>(R.id.Login)
        logButton.setOnClickListener {
            val intent = Intent(activity, SignInUpActivity::class.java)
            activity?.startActivity(intent);
        }

        return view


    }
}
