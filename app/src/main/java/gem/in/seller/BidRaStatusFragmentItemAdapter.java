package gem.in.seller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class BidRaStatusFragmentItemAdapter extends RecyclerView.Adapter<BidRaStatusFragmentItemAdapter.ViewHolder>{
Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_bid_ra_status_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
public BidRaStatusFragmentItemAdapter(Context context)
{
    this.context=context;
}
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
holder.viewButton.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v) {
        FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        ft2.replace(R.id.container, new BidResultFragment());
        ft2.commit();
    }
});
            }



    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
TextView viewButton;
        public ViewHolder(View itemView) {
            super(itemView);
            viewButton=(TextView)itemView.findViewById(R.id.viewButton);
                 }
    }
}
