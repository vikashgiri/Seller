package gem.in.seller;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import gem.in.seller.databinding.FragmentMoreBinding;
import gem.in.seller.databinding.FragmentOrderAndPaymentsBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderHomeFragment extends Fragment {

    public OrderHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentOrderAndPaymentsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_order_and_payments, container, false);
  binding.toolbar.title.setText(R.string.order_and_payments);
        binding.toolbar.backButton.setVisibility(View.GONE);
  binding.paymentStatics.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
          ft2.add(R.id.container, new PaymentStatisticsFragment());
          ft2.addToBackStack(null);
          ft2.commit();
      }
  });
        binding.orderStatics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();

                OrderStatisticsFragment orderStatisticsFragment = new OrderStatisticsFragment ();
                ft2.add(R.id.container, orderStatisticsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
        binding.orderHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent myIntent = new Intent(getActivity(), OrderActivity.class);
                getActivity().startActivity(myIntent);*/
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();

                OrderHistoryFragment orderStatisticsFragment = new OrderHistoryFragment();
                ft2.add(R.id.container, orderStatisticsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });  binding.invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(Keys.INVOICE);
            }
        });
        View view = binding.getRoot();

        //here data must be an instance of the class MarsDataProvider
        return view;
    }

    void switches(String s)
    {
        FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putString("type",s);
        OrderStatisticsDetailsFragment orderStatisticsDetailsFragment = new OrderStatisticsDetailsFragment ();
        orderStatisticsDetailsFragment.setArguments(args);
        ft2.add(R.id.container, orderStatisticsDetailsFragment);
        ft2.addToBackStack(null);
        ft2.commit();
    }
}
