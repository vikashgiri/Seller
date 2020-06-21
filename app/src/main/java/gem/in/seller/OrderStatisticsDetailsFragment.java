package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import gem.in.seller.databinding.FragmentOrderStaticsBinding;
import gem.in.seller.databinding.FragmentOrderStaticsDetailsBinding;
import gem.in.seller.databinding.FragmentPaymentDetailsStaticsBinding;

public class OrderStatisticsDetailsFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OrderStatisticsDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOrderStaticsDetailsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_order_statics_details, container, false);
        Bundle b = getArguments();
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        String  s = b.getString("type");
        binding.toolbar.title.setText(R.string.order_statistics);

        if(s.equalsIgnoreCase(Keys.INVOICE) )
        {
            binding.toolbar.title.setText(R.string.invoice);
        }
binding.heading.setText(""+s);
        OrderStatiticsDetailsFragmentItemAdapter adapter = new OrderStatiticsDetailsFragmentItemAdapter(getActivity(),s);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

}