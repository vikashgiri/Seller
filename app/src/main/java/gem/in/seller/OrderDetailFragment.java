package gem.in.seller;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentOrderAndPaymentsBinding;
import gem.in.seller.databinding.FragmentOrderDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderDetailFragment extends Fragment {

    public OrderDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentOrderDetailBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_order_detail, container, false);
        binding.toolbar.title.setText(R.string.order_details);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        View view = binding.getRoot();

        return  view;
    }
}
