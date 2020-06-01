package gem.in.seller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class IncidentDetailsItemAdapter extends RecyclerView.Adapter<IncidentDetailsItemAdapter.ViewHolder>{
String text[]={"Pending \norder","Pending \nDelivery"};
String color[]={"#","#"};
Context context;
String statuss;
int id[]={R.drawable.pending_order,R.drawable.ic_pending_delivery};
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_incident_details_fragments, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public IncidentDetailsItemAdapter(Context context)
{
    this.context=context;
    this.statuss="kj";
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
