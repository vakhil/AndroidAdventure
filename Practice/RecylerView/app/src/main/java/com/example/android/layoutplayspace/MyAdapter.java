package com.example.android.layoutplayspace;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class  MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private static String TAG = "clicked";
    private List<ListItem> listItems;
    private Context context;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "OnBindViewHolder called");
        ListItem listItem = listItems.get(i);
        viewHolder.head.setText(listItem.getHead());
        viewHolder.description.setText(listItem.getDescription());

    }

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView head;
        public TextView description;
         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            head = (TextView) itemView.findViewById(R.id.textViewHead);
            description = (TextView) itemView.findViewById(R.id.textViewDesc);
        }
    }


}
