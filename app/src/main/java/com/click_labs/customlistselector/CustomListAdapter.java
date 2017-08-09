package com.click_labs.customlistselector;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aman Singh on 08-07-2017.
 */

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {


    private Activity activity;
    private List<String> list;
    private OnListItemSelectedListener onListItemSelectedListener;
    private Dialog dialog;

    public CustomListAdapter(List<String> list, Activity activity, OnListItemSelectedListener onListItemSelectedListener, Dialog dialog) {
        this.list = list;
        this.activity = activity;
        this.dialog = dialog;
        this.onListItemSelectedListener = onListItemSelectedListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = (LayoutInflater.from(parent.getContext())).inflate(R.layout.layout_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvItemList.setText(list.get(holder.getAdapterPosition()));

        holder.tvItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onListItemSelectedListener.onListItemSelected(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()));
                        dialog.dismiss();
                    }
                }, 200);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnListItemSelectedListener {
        void onListItemSelected(int position, String listItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemList;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItemList = itemView.findViewById(R.id.tv_list_item);
        }
    }

}
