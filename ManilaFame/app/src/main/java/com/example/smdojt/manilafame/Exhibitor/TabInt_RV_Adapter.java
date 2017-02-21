package com.example.smdojt.manilafame.Exhibitor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smdojt.manilafame.R;
import com.example.smdojt.manilafame.sample1;

import java.util.List;

/**
 * Created by smdojt on 2/21/2017.
 */

public class TabInt_RV_Adapter extends RecyclerView.Adapter<TabInt_RV_Adapter.ItemViewHolder> {

    public static class ItemViewHolder extends RecyclerView.ViewHolder
    {
        static CardView cv;
        TextView itemName;
        TextView itemCathegory;
        ImageView itemPhoto;

        public ItemViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemCathegory = (TextView) itemView.findViewById(R.id.item_cathegory);
            itemPhoto = (ImageView) itemView.findViewById(R.id.item_photo);
        }
    }
    List<Exhibitors_Int> items;
    Context context;
    TabInt_RV_Adapter(List<Exhibitors_Int> items, Context context)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_exhibitor_tabint_item, viewGroup, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, final int i) {
        itemViewHolder.cv.setOnClickListener(null);
        itemViewHolder.itemName.setText(items.get(i).name);
        itemViewHolder.itemCathegory.setText(items.get(i).cathegory);
        itemViewHolder.itemPhoto.setImageResource(items.get(i).photoId);

        ItemViewHolder.cv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (i == 0)
                {
                    //Toast.makeText(context, "Index position is 0", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (context, sample1.class);
                    context.startActivity(intent);

//                    Using this code specifically for activity will make backstack automatically generated:
//                    meaning, the cardviews w/ recyclerviewer in the tab before will remain intack.
                }
                else if  (i == 1)
                {
                    Toast.makeText(context, "Index position is 1", Toast.LENGTH_SHORT).show();
                    //AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    //GalleryFragment gf = new GalleryFragment();
                    //activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, gf).addToBackStack(null).commit();

//                    Using this code specifically for fragment will make backstack ignored:
//                    meaning, all the cardviews in the list before will disappeare ** Known Bug 2-16-17
                }

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }


}
