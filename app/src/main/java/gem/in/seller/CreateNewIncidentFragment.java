package gem.in.seller;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentCreateNewIncidentBinding;
import gem.in.seller.databinding.FragmentCreateNewIncidentBindingImpl;
import gem.in.seller.databinding.FragmentPaymentStatisticsListBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNewIncidentFragment extends Fragment {

    public CreateNewIncidentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCreateNewIncidentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_create_new_incident, container, false);

        binding.toolbar.title.setText(R.string.incident);
        binding.textView.setText(Html.fromHtml(
                "To choose contact from earlier version please " +
                        "<a href=\"http://www.google.com\">click here</a> "));
        binding.textView.setMovementMethod(LinkMovementMethod.getInstance());

        View view = binding.getRoot();
        return view;
    }
}
