package gem.in.seller;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentIncidentDetailsBinding;
import gem.in.seller.databinding.FragmentIncidentStatusBinding;
import gem.in.seller.databinding.FragmentPaymentDetailsStaticsBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncidentDetailsFragment extends Fragment {

    public IncidentDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentIncidentDetailsBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_incident_details, container, false);
        Bundle b = getArguments();
        String  s = b.getString("type");
        binding.toolbar.title.setText(R.string.incident);
        binding.titles.setText(""+s);

        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.toolbar.title.setText(R.string.incident);

        IncidentDetailsItemAdapter adapter = new IncidentDetailsItemAdapter(getActivity(),true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);


        return binding.getRoot();
    }
}
