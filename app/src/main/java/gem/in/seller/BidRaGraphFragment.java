package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import gem.in.seller.databinding.FragmentBidRaStatusBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BidRaGraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BidRaGraphFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BidRaGraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        FragmentBidRaStatusBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_bid_ra_graph, container, false);




        return binding.getRoot();
    }
}
