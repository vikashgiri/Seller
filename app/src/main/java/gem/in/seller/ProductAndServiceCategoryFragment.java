package gem.in.seller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import gem.in.seller.databinding.FragmentProductAndServiceCategoryBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductAndServiceCategoryFragment extends Fragment {

    public ProductAndServiceCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentProductAndServiceCategoryBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_product_and_service_category, container, false);
  binding.itemNumber.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          switches("43304");

      }
  });

        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }
    void switches(String s)
    {
        FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putString("type",s);
        ProductAndServiceDetailsFragment productAndServiceDetailsFragment = new ProductAndServiceDetailsFragment ();
        productAndServiceDetailsFragment.setArguments(args);
        ft2.add(R.id.container, productAndServiceDetailsFragment);
        ft2.addToBackStack(null);
        ft2.commit();
    }
}
