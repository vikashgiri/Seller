package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import gem.in.seller.databinding.FragmentBidRaStatsBinding;
import gem.in.seller.databinding.FragmentBidRaStatusBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BidRaStatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BidRaStatsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BidRaStatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        FragmentBidRaStatsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_bid_ra_stats, container, false);
binding.toolbar.title.setText(R.string.bid_start);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });



        return binding.getRoot();
    }
}
