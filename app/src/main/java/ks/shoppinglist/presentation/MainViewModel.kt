package ks.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import ks.shoppinglist.data.ShopListRepositoryImpl
import ks.shoppinglist.domain.DeleteShopItemUseCase
import ks.shoppinglist.domain.EditShopItemUseCase
import ks.shoppinglist.domain.GetShopListUseCase
import ks.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopList(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState (shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}