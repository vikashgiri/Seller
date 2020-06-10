package gem.in.seller;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class OrderHistoryItemAdapter extends RecyclerView.Adapter<OrderHistoryItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
String statuss;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_order_history_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public OrderHistoryItemAdapter(Context context)
{
    this.context=context;
    this.statuss="kj";
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.view_details.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();

        OrderDetailFragment incidentDetailsFragment = new OrderDetailFragment ();
        ft2.add(R.id.container, incidentDetailsFragment);
        ft2.addToBackStack(null);
        ft2.commit();
    }
});

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
TextView view_details;
        public ViewHolder(View itemView) {
            super(itemView);
            view_details=(TextView)itemView.findViewById(R.id.view_details);

        }
    }
}
