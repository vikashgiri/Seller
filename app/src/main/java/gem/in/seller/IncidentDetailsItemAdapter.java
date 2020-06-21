package gem.in.seller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class IncidentDetailsItemAdapter extends RecyclerView.Adapter<IncidentDetailsItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
boolean statuss;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_incident_details_fragments, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public IncidentDetailsItemAdapter(Context context,Boolean b)
{
    this.context=context;
    this.statuss=b;
}
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
if(!statuss)
{holder.bid_id.setText("Order Id: GEM/2020/B/65228");
}
     holder.rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statuss) {

                    FragmentTransaction ft2 = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.container, new IncidentDetailsViewFragment());
                    ft2.commit();
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
RelativeLayout rel1;
TextView bid_id;
        public ViewHolder(View itemView) {
            super(itemView);
            rel1=(RelativeLayout)itemView.findViewById(R.id.rel1);
            bid_id=(TextView) itemView.findViewById(R.id.bid_id);
        }
    }
}
