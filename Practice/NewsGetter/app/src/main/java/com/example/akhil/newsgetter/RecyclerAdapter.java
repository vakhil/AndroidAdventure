package com.example.akhil.newsgetter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    private ArrayList<SingleItem> mImageNames = new ArrayList<SingleItem>();
    Context context;


    public RecyclerAdapter(ArrayList<SingleItem> mImageNames, Context context) {
        this.mImageNames = mImageNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG,"OnBindViewHolder called");

       final SingleItem viewHolderItemSelected = mImageNames.get(i);
       Glide.with(context).asBitmap().load(viewHolderItemSelected.mImageHyperLink).into(viewHolder.image);
       viewHolder.imageName.setText(viewHolderItemSelected.storyTitle);


        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(viewHolderItemSelected.hyperLink);
                Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.tv_image);
            imageName = (TextView) itemView.findViewById(R.id.tv_text_view);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
        }


    }

}
