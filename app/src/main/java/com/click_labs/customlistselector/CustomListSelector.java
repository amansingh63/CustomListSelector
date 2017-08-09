package com.click_labs.customlistselector;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman Singh on 08-07-2017.
 */

public class CustomListSelector {
    private Activity activity;
    private Dialog dialog;
    private List<String> list;
    private RecyclerView rvItemList;
    private TextView tvMessage;
    private View vDivider;
    private CustomListAdapter.OnListItemSelectedListener onListItemSelectedListener;


    /**
     * Constructor to Call
     *
     * @param activity for passing activity where to show
     */

    public CustomListSelector(Activity activity, ArrayList<String> list) {
        this.activity = activity;
        this.list = list;
        dialog = new Dialog(activity, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_custom_list_selector);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
    }


    public static CustomListSelector showCustomListSelector(Activity activity, ArrayList<String> list) {
        return new CustomListSelector(activity, list);
    }

    public CustomListSelector setMessage(String title) {
        if (dialog != null) {
            tvMessage = (TextView) dialog.findViewById(R.id.tv_list_title);
            vDivider = (View) dialog.findViewById(R.id.v_divider);
            vDivider.setVisibility(View.VISIBLE);
            tvMessage.setText(title);
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setAllCaps(true);
        }
        return this;
    }


    public void show(CustomListAdapter.OnListItemSelectedListener onListItemSelectedListener) {
        if (dialog != null) {
            rvItemList = (RecyclerView) dialog.findViewById(R.id.rv_list);
            rvItemList.setAdapter(new CustomListAdapter(list, activity, onListItemSelectedListener, dialog));
            rvItemList.setLayoutManager(new LinearLayoutManager(activity));
            rvItemList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(activity).build());
            dialog.show();
        }
    }
}
