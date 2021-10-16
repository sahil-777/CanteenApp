package com.example.canteenapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.canteenapp.models.CartItem;
import com.example.canteenapp.models.Item;
import com.example.canteenapp.repositories.CartRepo;
import com.example.canteenapp.repositories.ItemRepo;

import java.util.List;

public class ItemViewModel extends ViewModel {

    ItemRepo itemRepo = new ItemRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Item> mutableItem = new MutableLiveData<>();

    public LiveData<List<Item>> getItems() {
        return itemRepo.getItems();
    }

    public void setItem(Item item) {
        mutableItem.setValue(item);
    }

    public LiveData<Item> getItem() {
        return mutableItem;
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Item item) {
        return cartRepo.addItemToCart(item);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

}
