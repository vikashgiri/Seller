package gem.in.seller;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentOrderAndPaymentsBinding;
import gem.in.seller.databinding.FragmentPaymentDetailsStaticsBinding;
import gem.in.seller.databinding.FragmentPaymentStatisticsListBinding;
import gem.in.seller.databinding.ItemFragmentPaymentDetailsStatisticsBinding;

public class PaymentStatisticsDetailsFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PaymentStatisticsDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPaymentDetailsStaticsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_payment_details_statics, container, false);
        Bundle b = getArguments();
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        String  s = b.getString("type");
        binding.toolbar.title.setText(R.string.payment_statistics);

        PaymentStatisticsDetailsItemAdapter adapter = new PaymentStatisticsDetailsItemAdapter(getActivity(),s);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        if(s.equalsIgnoreCase(Keys.COMPLETED)) {
            binding.heading.setText("Payment Completed");
        }

        return binding.getRoot();
    }

}