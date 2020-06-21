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
public OrderStatiticsDetailsFragmentItemAdapter(Context context,String status)
{
    this.context=context;
    this.status=status;
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

if(status.equalsIgnoreCase(Keys.ACCEPTED) || status.equalsIgnoreCase(Keys.INVOICE) )
{
    holder.generate_invoice.setVisibility(View.VISIBLE);
}
        if(status.equalsIgnoreCase(Keys.ACCEPTANCE) || status.equalsIgnoreCase(Keys.ORDER_PLACED))
        {
            holder.generate_invoice.setVisibility(View.VISIBLE);
            holder.generate_invoice.setText(R.string.accept);
        }
holder.generate_invoice.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();

        InvoiceGeneratedFragment invoiceGeneratedFragment = new InvoiceGeneratedFragment ();
        ft2.add(R.id.container, invoiceGeneratedFragment);
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
TextView generate_invoice;
        public ViewHolder(View itemView) {
            super(itemView);
            generate_invoice=(TextView)itemView.findViewById(R.id.generate_invoice);

        }
    }
}
