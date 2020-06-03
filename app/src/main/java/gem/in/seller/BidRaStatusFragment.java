package gem.in.seller;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentBidRaStatusBinding;
import gem.in.seller.databinding.FragmentBidRaStatusBindingImpl;
import gem.in.seller.databinding.FragmentIncidentDetailsBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BidRaStatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BidRaStatusFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BidRaStatusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        FragmentBidRaStatusBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_bid_ra_status, container, false);

        binding.toolbar.title.setText(R.string.bid_ra_status);

        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


        BidRaStatusFragmentItemAdapter adapter = new BidRaStatusFragmentItemAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);


        return binding.getRoot();
    }
}
