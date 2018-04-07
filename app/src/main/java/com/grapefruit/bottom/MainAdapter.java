package com.grapefruit.bottom;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grapefruit.bottom.databinding.ItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<MainItem> items = new ArrayList<>();

    public MainAdapter() {
        super();
        for (int i = 0; i < 100; i++) {
            items.add(new MainItem("text"));
        }
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainItem item = items.get(position);
        holder.binding.txt.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ItemBinding binding;

        public MainViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public class MainItem {

        private String text;

        public MainItem(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
