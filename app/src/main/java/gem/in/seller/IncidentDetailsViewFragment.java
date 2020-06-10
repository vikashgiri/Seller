package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import gem.in.seller.databinding.FragmentIncidentDetailsViewBinding;
import gem.in.seller.databinding.FragmentInvoiceGeneratedSecondPageBinding;
import gem.in.seller.databinding.FragmentOrderDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncidentDetailsViewFragment extends Fragment {

    public IncidentDetailsViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentIncidentDetailsViewBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_incident_details_view, container, false);
binding.toolbar.title.setText(R.string.incidet_detaiils);
        View view = binding.getRoot();

        return  view;
    }
}
