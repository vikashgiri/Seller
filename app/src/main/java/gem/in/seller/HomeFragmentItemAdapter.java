package gem.in.seller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragmentItemAdapter extends RecyclerView.Adapter<HomeFragmentItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_home_fragment_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public HomeFragmentItemAdapter(Context context)
{
    this.context=context;
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position==1) {
            holder.title.setText(text[1]);
            holder.title.setTextColor(Color.parseColor("#F3BE92"));

            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.ic_pending_delivery));
        }
        else {
            holder.title.setText(text[0]);
            holder.title.setTextColor(Color.parseColor("#F2C4C1"));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.pending_order));        }


    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
ImageView image;
TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            image=(ImageView) itemView.findViewById(R.id.image);
                 }
    }
}
