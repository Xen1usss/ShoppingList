package ks.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
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

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopList(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList() // вызываем этот метод, чтобы автоматически обновить список элементов
    }

    fun changeEnableState (shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
    }

}