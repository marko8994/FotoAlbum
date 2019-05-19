package com.rms.markomladenovic.fotoalbum;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ImageViewHolder> {
    private ArrayList names;
    private ArrayList images;

    CustomAdapter(ArrayList names, ArrayList images) {
        this.names = names;
        this.images = images;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText((CharSequence) names.get(position));
        holder.image.setImageResource((Integer) images.get(position));

        // implement setOnClickListener event on item view.
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // open another activity on item click
//                Intent intent = new Intent(context, ImageOverviewActivity.class);
//                intent.putExtra(bundle_extra_image, holder.getAdapterPosition()); // put image data in Intent
//                context.startActivity(intent); // start Intent
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return names.size();
    }
    class ImageViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        ImageViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.recyclerItemImage);
        }
    }
}
