package gem.in.seller;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentIncidentStatusBinding;
import gem.in.seller.databinding.FragmentPaymentStatisticsListBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncidentStatusFragment extends Fragment {

    public IncidentStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentIncidentStatusBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_incident_status, container, false);
        binding.toolbar.title.setText(R.string.incident);
        binding.toolbar.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type","Incident Closed");

                IncidentDetailsFragment incidentDetailsFragment = new IncidentDetailsFragment ();
                incidentDetailsFragment.setArguments(args);

                ft2.add(R.id.container, incidentDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });    binding.esclate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type","Incident Escalated");

                IncidentDetailsFragment incidentDetailsFragment = new IncidentDetailsFragment ();
                incidentDetailsFragment.setArguments(args);

                ft2.add(R.id.container, incidentDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });    binding.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type","Incident Open");

                IncidentDetailsFragment incidentDetailsFragment = new IncidentDetailsFragment ();
                incidentDetailsFragment.setArguments(args);

                ft2.add(R.id.container, incidentDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();

                CreateNewIncidentFragment incidentDetailsFragment = new CreateNewIncidentFragment ();
                ft2.replace(R.id.container, incidentDetailsFragment);
                ft2.commit();
            }
        });
        View view = binding.getRoot();
        return view;    }
}
