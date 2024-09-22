package com.example.recycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<Country> countryList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnItemClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.bind(country, listener);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;

        public CountryViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);

        }

        public void bind(final Country country, final OnItemClickListener listener) {
            itemTitle.setText(country.getName());
            itemView.setOnClickListener(v -> listener.onItemClick(country));
        }
    }
}

