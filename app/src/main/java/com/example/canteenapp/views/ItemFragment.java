package com.example.canteenapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.canteenapp.R;
import com.example.canteenapp.adapters.ItemListAdapter;
import com.example.canteenapp.databinding.FragmentItemBinding;
import com.example.canteenapp.models.Item;
import com.example.canteenapp.viewmodels.ItemViewModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ItemFragment extends Fragment implements ItemListAdapter.ItemInterface {

    private static final String TAG = "ItemFragment";
    FragmentItemBinding fragmentItemBinding;
    private ItemListAdapter itemListAdapter;
    private ItemViewModel itemViewModel;
    private NavController navController;

    public ItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentItemBinding = FragmentItemBinding.inflate(inflater, container, false);
        return fragmentItemBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemListAdapter = new ItemListAdapter(this);
        fragmentItemBinding.itemRecyclerView.setAdapter(itemListAdapter);
        fragmentItemBinding.itemRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentItemBinding.itemRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        itemViewModel.getItems().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                itemListAdapter.submitList(items);
            }
        });

        navController = Navigation.findNavController(view);

    }

    @Override
    public void addItem(Item item) {
        boolean isAdded = itemViewModel.addItemToCart(item);
        if (isAdded) {
            Snackbar.make(requireView(), item.getName() + " added to cart.", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_itemFragment_to_cartFragment);
                        }
                    })
                    .show();
        } else {
            Snackbar.make(requireView(), "Already have the max quantity in cart.", Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemClick(Item item) {
        itemViewModel.setItem(item);
        navController.navigate(R.id.action_itemFragment_to_itemDetailFragment);
    }
}