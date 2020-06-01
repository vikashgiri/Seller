package gem.in.seller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class OrderStatiticsDetailsFragmentItemAdapter extends RecyclerView.Adapter<OrderStatiticsDetailsFragmentItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
String status;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_order_statitics_details_fragments, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public OrderStatiticsDetailsFragmentItemAdapter(Context context)
{
    this.context=context;
    this.status=status;
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
