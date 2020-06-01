package gem.in.seller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentStatisticsDetailsItemAdapter extends RecyclerView.Adapter<PaymentStatisticsDetailsItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
String status;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_fragment_payment_details_statistics, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public PaymentStatisticsDetailsItemAdapter(Context context,String status)
{
    this.context=context;
    this.status=status;
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(status.equalsIgnoreCase(Keys.COMPLETED))
        {
            holder.bill_creation_parants.setVisibility(View.GONE);

            holder.cracDate.setText(R.string.payment_date);
            holder.cracDateValue.setText(" 20-10-2020");
            holder.cracNo.setText(R.string.mode_of_payment);
            holder.cracNoValue.setText(" Offline");

        }

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

LinearLayout bill_creation_parants;
TextView heading,cracDate,cracDateValue,cracNo,cracNoValue;
        public ViewHolder(View itemView) {
            super(itemView);
            bill_creation_parants = (LinearLayout) itemView.findViewById(R.id.bill_creation_parants);
            cracDate = (TextView) itemView.findViewById(R.id.crac_date);
            cracDateValue = (TextView) itemView.findViewById(R.id.crac_date_value);
            cracNo = (TextView) itemView.findViewById(R.id.crac_no);
            cracNoValue = (TextView) itemView.findViewById(R.id.crac_no_value);
        }
    }
}
