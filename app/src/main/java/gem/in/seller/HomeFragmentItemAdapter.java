package gem.in.seller;

import android.content.Context;
import android.content.pm.FeatureGroupInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragmentItemAdapter extends RecyclerView.Adapter<HomeFragmentItemAdapter.ViewHolder>{
String text[]={"Acceptance","Delivery","Transation \n Charges","Products \nApproval","Services \nApproval"
       ,"Incident \nResolution","Invoice"};
String color[]={"#F2C4C1","#F3BE92","#F2C4C1","#F3BE92","#F2C4C1","#F3BE92","#F2C4C1"};
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    FragmentTransaction ft2=((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("type",Keys.ACCEPTED);
                    OrderStatisticsDetailsFragment orderStatisticsDetailsFragment = new OrderStatisticsDetailsFragment ();
                    orderStatisticsDetailsFragment.setArguments(args);
                    ft2.add(R.id.container, orderStatisticsDetailsFragment);
                    ft2.addToBackStack(null);
                    ft2.commit();

                }
                if(position==1)
                {
                    FragmentTransaction ft2=((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("type","Delivery In-Progress");
                    OrderStatisticsDetailsFragment orderStatisticsDetailsFragment = new OrderStatisticsDetailsFragment ();
                    orderStatisticsDetailsFragment.setArguments(args);
                    ft2.add(R.id.container, orderStatisticsDetailsFragment);
                    ft2.addToBackStack(null);
                    ft2.commit();
                }
                if(position==5)
                {
                    FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("type","Incident Closed");
                    IncidentDetailsFragment incidentDetailsFragment = new IncidentDetailsFragment ();
                    incidentDetailsFragment.setArguments(args);
                    ft2.add(R.id.container, incidentDetailsFragment);
                    ft2.addToBackStack(null);
                    ft2.commit();
                }
                if(position==6)
                {
                    FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("type",Keys.INVOICE);
                    OrderStatisticsDetailsFragment orderStatisticsDetailsFragment = new OrderStatisticsDetailsFragment ();
                    orderStatisticsDetailsFragment.setArguments(args);
                    ft2.add(R.id.container, orderStatisticsDetailsFragment);
                    ft2.addToBackStack(null);
                    ft2.commit();
                }  if(position==3)
                {

                    FragmentTransaction ft2= ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    Bundle args = new Bundle();
                    args.putString("type","Pending Approval");
                    ProductAndServiceDetailsFragment productAndServiceDetailsFragment = new ProductAndServiceDetailsFragment ();
                    productAndServiceDetailsFragment.setArguments(args);
                    ft2.add(R.id.container, productAndServiceDetailsFragment);
                    ft2.addToBackStack(null);
                    ft2.commit();
                }
            }
        });
        if(position==0) {
            holder.title.setText(text[0]);
            holder.title.setTextColor(Color.parseColor(color[0]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                      R.drawable.pending_order));        }
        if(position==1) {
            holder.title.setText(text[1]);
            holder.title.setTextColor(Color.parseColor(color[1]));

            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.ic_pending_delivery));
        }
        if(position==2) {
            holder.title.setText(text[2]);
            holder.title.setTextColor(Color.parseColor(color[2]));

            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.transaction_charges));        }
        if(position==3) {
            holder.title.setText(text[3]);
            holder.title.setTextColor(Color.parseColor(color[3]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.products_approval));        }
        if(position==4) {
            holder.title.setText(text[4]);
            holder.title.setTextColor(Color.parseColor(color[4]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.services_approval));        }/*
 if(position==5) {
            holder.title.setText(text[5]);
            holder.title.setTextColor(Color.parseColor(color[5]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.incidents_response));        }*/
 if(position==5) {
            holder.title.setText(text[5]);
            holder.title.setTextColor(Color.parseColor(color[5]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.incidents_resolution));        }



 if(position==6) {
            holder.title.setText(text[6]);
            holder.title.setTextColor(Color.parseColor(color[6]));


            holder.image.setImageDrawable(context.getResources().getDrawable(
                    R.drawable.ic_product_service));        }


    }


    @Override
    public int getItemCount() {
        return text.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
ImageView image;
TextView title;
RelativeLayout rel1;
        public ViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            image=(ImageView) itemView.findViewById(R.id.image);
            rel1=(RelativeLayout) itemView.findViewById(R.id.rel1);
                 }
    }

}
