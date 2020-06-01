package gem.in.seller;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gem.in.seller.databinding.FragmentOrderAndPaymentsBinding;
import gem.in.seller.databinding.FragmentPaymentStatisticsListBinding;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class PaymentStatisticsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPaymentStatisticsListBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_payment_statistics_list, container, false);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        binding.complited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type",Keys.COMPLETED);
                PaymentStatisticsDetailsFragment paymentStatisticsDetailsFragment = new PaymentStatisticsDetailsFragment ();
                paymentStatisticsDetailsFragment.setArguments(args);
                ft2.add(R.id.container, paymentStatisticsDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        }); binding.pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type",Keys.PENDING);
                PaymentStatisticsDetailsFragment paymentStatisticsDetailsFragment = new PaymentStatisticsDetailsFragment ();
                paymentStatisticsDetailsFragment.setArguments(args);
                ft2.add(R.id.container, paymentStatisticsDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
        binding.toolbar.title.setText(R.string.payment_statistics);
        View view = binding.getRoot();
        return view;
    }



}
