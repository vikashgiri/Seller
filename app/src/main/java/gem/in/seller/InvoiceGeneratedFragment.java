package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import gem.in.seller.databinding.FragmentInvoceGenerateBinding;
import gem.in.seller.databinding.FragmentProductAndServiceCatalogBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class InvoiceGeneratedFragment extends Fragment {

    public InvoiceGeneratedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInvoceGenerateBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_invoce_generate, container, false);
        binding.toolbar.title.setText(R.string.generate_invoice);
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }

}
