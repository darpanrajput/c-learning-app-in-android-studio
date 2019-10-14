package com.darpan.learnc.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.darpan.learnc.DescriptionActivity;
import com.darpan.learnc.DownloadActivity;
import com.darpan.learnc.R;
import com.darpan.learnc.models.firstFragmentitems;

import java.util.List;

public class netsedRvAdapter extends RecyclerView.Adapter<netsedRvAdapter.myViewHolder> {
    private Context context;
    private List<firstFragmentitems> nestedList;
    Dialog mdiaglog;
   private int index;

    public netsedRvAdapter(Context context, List<firstFragmentitems> nestedList,int index) {
        this.context = context;
        this.nestedList = nestedList;
        this.index=index;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.second_fragment_layout,viewGroup,false);
        mdiaglog = new Dialog(context);
        mdiaglog.setContentView(R.layout.dialog_box_layout);
        mdiaglog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(nestedList.get(i).getTitle());
        myViewHolder.description.setText(nestedList.get(i).getDescription());
        myViewHolder.author.setText(nestedList.get(i).getAuthor());
        myViewHolder.image.setImageResource(nestedList.get(i).getBanner());
        myViewHolder.lockImage.setImageResource(nestedList.get(i).getLockImage());



        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mdiaglog.show();
                return false;
            }
        });

        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==0)
                {
                  /*  Toast.makeText(context, "Please buy the content", Toast.LENGTH_SHORT).show();*/
                    new AlertDialog.Builder(context)
                            .setTitle("Download permission")
                            .setMessage("To View the content you have to Buy it ")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                   Intent intent=new Intent(context, DownloadActivity.class);
                                   intent.putExtra("index",myViewHolder.getAdapterPosition());
                                   context.startActivity(intent);
                                    Log.i("position:",
                                            Integer.toString(myViewHolder.getAdapterPosition()));
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else {
                    Toast.makeText(context, "click the items", Toast.LENGTH_SHORT).show();
                    final Intent intent;
                    intent = new Intent(context, DescriptionActivity.class);
                    intent.putExtra("title",nestedList.get(i).getTitle());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nestedList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView description,author;
        ImageView image,lockImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.desc);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.img);
            lockImage=itemView.findViewById(R.id.lock);
        }
    }

}
