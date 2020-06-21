package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import gem.in.seller.databinding.FragmentOrderStaticsBinding;
import gem.in.seller.databinding.FragmentPaymentStatisticsListBinding;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class OrderStatisticsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentOrderStaticsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_order_statics, container, false);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
         binding.accepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(Keys.ACCEPTED);
            }
        });  binding.placed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(Keys.ORDER_PLACED);
            }
        });      binding.cancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(getActivity().getResources().getString(R.string.order_cancelled));
            }
        });      binding.completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(getActivity().getResources().getString(R.string.order_completed));
            }
        });      binding.inprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(getActivity().getResources().getString(R.string.delivery_in_progress));

            }
        });      binding.rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(getActivity().getResources().getString(R.string.order_rejected_by_seller));

            }
        }); binding.paid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switches(getActivity().getResources().getString(R.string.order_paid));
            }
        });
        binding.toolbar.title.setText(R.string.order_statistics);
        View view = binding.getRoot();
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
