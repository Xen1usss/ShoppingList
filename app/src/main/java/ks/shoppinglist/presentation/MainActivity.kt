package ks.shoppinglist.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ks.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var count = 0
    private lateinit var adapter: ShopListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        adapter = ShopListAdapter()
        setContentView(R.layout.activity_main) //
        setUpRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) //
        viewModel.shopList.observe(this) { //
            adapter.shopList = it
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setUpRecyclerView() { //
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list) //
        adapter = ShopListAdapter() //
        rvShopList.adapter = adapter //
    }


}