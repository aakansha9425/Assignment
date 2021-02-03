package com.example.assignment.miskaaassignment.Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.miskaaassignment.R;
import com.example.miskaaassignment.modelClass.CountryData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountryDataAdapter extends RecyclerView.Adapter<CountryDataAdapter.MyViewHolder> {
    private ArrayList<CountryData> countryDataList = new ArrayList<>();
    private Context context;
    String lang = "";

    public CountryDataAdapter(Context context, ArrayList<CountryData> countryDataList) {
        this.countryDataList = countryDataList;
        this.context = context;

    }

    @NonNull
    @Override
    public CountryDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new CountryDataAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryDataAdapter.MyViewHolder holder, int position) {
        String lang = "";
        String border = "";
        // String imageUri = countryDataList.get(position).getFlag();
        //Picasso.get().load(imageUri).into(holder.flag);
        Glide.with(context).load(countryDataList.get(position).getFlag())
                .placeholder(R.drawable.ic_launcher_foreground).into(holder.flag);
        holder.name.setText(countryDataList.get(position).getName());
        holder.capital.setText(countryDataList.get(position).getCapital());
        holder.region.setText(countryDataList.get(position).getRegion());
        holder.sub_region.setText(countryDataList.get(position).getSubregion());
        holder.population.setText(String.valueOf(countryDataList.get(position).getPopulation()));
        for (int i = 0; i < countryDataList.get(position).getLanguages().size(); i++) {
            if (i > 0)
                lang = lang + " , ";
            lang = lang + countryDataList.get(position).getLanguages().get(i).getName();

        }
        for (int i = 0; i < countryDataList.get(position).getBorders().size(); i++) {
            if (i > 0)
                border = border + " , ";
            border = border + countryDataList.get(position).getBorders().get(i);

        }


        holder.languages.setText(lang);
        holder.borders.setText(border);


//        holder.borders.setText((CharSequence) countryDataList.get(position).getBorders());
    }

    @Override
    public int getItemCount() {
        return countryDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, capital, population, region, sub_region, borders, languages;
        private ImageView flag;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.country_name);
            capital = (TextView) itemView.findViewById(R.id.country_capital);
            population = (TextView) itemView.findViewById(R.id.country_population);
            region = (TextView) itemView.findViewById(R.id.country_region);
            sub_region = (TextView) itemView.findViewById(R.id.country_sub_region);
            borders = (TextView) itemView.findViewById(R.id.country_borders);
            languages = (TextView) itemView.findViewById(R.id.country_language);
            flag = (ImageView) itemView.findViewById(R.id.flag_icon);

        }
    }
}
