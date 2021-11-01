package com.example.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Fried Rice", 70, true, "https://recipesofhome.com/wp-content/uploads/2020/06/veg-fried-rice-recipe.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Schezwan Fried Rice", 80, true, "https://storage.googleapis.com/prod-media-makingchef/acae8e65-88bf-420b-8024-a5b820939b5d/4efdc5d9-ae6e-499d-b97d-6d129fdd5507.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Biryani", 100, true, "https://i1.wp.com/cookingfromheart.com/wp-content/uploads/2017/09/Veg-Biryani-in-Pressure-Cooker-6.jpg?resize=720%2C480&ssl=1" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Vadapav", 10, true, "https://i.ytimg.com/vi/BVcTuvoxpMY/maxresdefault.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Samosa", 10, true, "https://resize.indiatvnews.com/en/resize/newbucket/1200_-/2021/05/samosa-1622294808.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Thali", 100, true, "https://i.imgur.com/MXkPVx0.jpeg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Pav Bhaji", 90, true, "https://static.toiimg.com/photo/52416693.cms" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Fruit Juice", 50, true, "https://st1.thehealthsite.com/wp-content/uploads/2019/07/Fruit-juices.jpg?impolicy=Medium_Widthonly&w=710" ));
        mutableProductList.setValue(productList);
    }
}
