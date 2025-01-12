package ks.shoppinglist.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ks.shoppinglist.R

class ShopItemActivity: AppCompatActivity() {

    private lateinit var viewModel: ShopItemViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_shop_item)
        /*viewModel.errorInputName.value = false
        viewModel.errorInputCount.value = false
        if (viewModel.closeDisplay == false) {
            onDestroy()
        }*/
    }

}