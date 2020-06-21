package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import gem.in.seller.databinding.FragmentIncidentDetailsBinding;
import gem.in.seller.databinding.FragmentProductAndServiceDetailsBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductAndServiceDetailsFragment extends Fragment {

    public ProductAndServiceDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentProductAndServiceDetailsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product_and_service_details, container, false);

        binding.toolbar.title.setText(R.string.catalogue_nmanagement);

        Bundle b = getArguments();

        String  s = b.getString("type");
        binding.heading.setText(""+s);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });



        ProductAndServiceDetailsItemAdapter adapter = new ProductAndServiceDetailsItemAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

}
