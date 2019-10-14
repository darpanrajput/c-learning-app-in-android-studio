package com.darpan.learnc.Adapters;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.darpan.learnc.DescriptionActivity;
import com.darpan.learnc.R;
import com.darpan.learnc.models.firstFragmentitems;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {
    //  private Dialog mdialog;
    private Context mcontext;
    List<firstFragmentitems> mData;
    // private String check="Learn c++";

   // Boolean isdark = false;

  /*  public RecyclerViewAdapter(Context mcontext, List<firstFragmentitems> mData, Boolean isdark) {
        this.mcontext = mcontext;
        this.mData = mData;
        this.isdark = isdark;
    }
*/
    public RecyclerViewAdapter(Context mcontext, List<firstFragmentitems> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.first_fragment_layout,
                null,
                false);
        final myViewHolder vHolder = new myViewHolder(view);

        //   mdialog=new Dialog(mcontext);
        //   mdialog.setContentView(R.layout.denis_ritichie_bio);
        //  ImageView denis_image=(ImageView)mdialog.findViewById(R.id.denis_image);

        return vHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(mData.get(i).getTitle());
        myViewHolder.description.setText(mData.get(i).getDescription());
        myViewHolder.time.setText(mData.get(i).getTime());
        myViewHolder.lable.setText(mData.get(i).getLabel());
        myViewHolder.author.setText(mData.get(i).getAuthor());
        Glide.with(mcontext).load(mData.get(i).getLockImage()).into(myViewHolder.lock_image);
        Glide.with(mcontext).load(mData.get(i).getBanner()).into(myViewHolder.bannerImage);



        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mcontext, "clicked", Toast.LENGTH_SHORT).show();
                final Intent intent;
                intent = new Intent(mcontext, DescriptionActivity.class);
                intent.putExtra("title",mData.get(i).getTitle());
                mcontext.startActivity(intent);


            }
        });


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description, lable, time, author;
        ImageView lock_image,bannerImage;
        FrameLayout relativeLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            //getAdapterPosition();
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.desc);
            lable = itemView.findViewById(R.id.lable);
            time = itemView.findViewById(R.id.time);
            author = itemView.findViewById(R.id.author);
            relativeLayout = itemView.findViewById(R.id.denis_framelayout);
            lock_image=itemView.findViewById(R.id.lock);
            bannerImage=itemView.findViewById(R.id.img);


        }


    }

}
