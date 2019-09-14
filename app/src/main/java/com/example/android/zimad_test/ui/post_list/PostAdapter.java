package com.example.android.zimad_test.ui.post_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.zimad_test.R;
import com.example.android.zimad_test.data.entities.Model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Model> items = new ArrayList<>();
    private OnPostClickListener onClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Model currentItem = items.get(position);
        holder.number.setText(String.valueOf(position));
        holder.text.setText(String.valueOf(currentItem.getTitle()));
        Picasso.get().load(currentItem.getUrl()).error(R.drawable.ic_launcher_background).into(holder.postImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItems(final List<Model> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void setOnPostClickListener(final OnPostClickListener clickListener) {
        this.onClickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.number)
        protected TextView number;
        @BindView(R.id.text)
        protected TextView text;
        @BindView(R.id.post_image)
        protected ImageView postImage;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View view) {
            if (onClickListener != null) {
                onClickListener.onPostClicked(items.get(getAdapterPosition()));
            }
        }
    }
}
