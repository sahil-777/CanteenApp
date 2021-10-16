package com.example.canteenapp.adapters;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canteenapp.databinding.ItemRowBinding;
import com.example.canteenapp.models.Item;

public class ItemListAdapter extends ListAdapter<Item, ItemListAdapter.ItemViewHolder> {

    ItemInterface itemInterface;
    public ItemListAdapter(ItemInterface itemInterface) {
        super(Item.itemCallback);
        this.itemInterface = itemInterface;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemRowBinding itemRowBinding = ItemRowBinding.inflate(layoutInflater, parent, false);
        itemRowBinding.setShopInterface(itemInterface);
        return new ItemViewHolder(itemRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = getItem(position);
        holder.itemRowBinding.setProduct(item);
        holder.itemRowBinding.executePendingBindings();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ItemRowBinding itemRowBinding;

        public ItemViewHolder(ItemRowBinding binding) {
            super(binding.getRoot());
            this.itemRowBinding = binding;
        }
    }

    public interface ItemInterface {
        void addItem(Item item);
        void onItemClick(Item item);
    }
}
