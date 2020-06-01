package gem.in.seller;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gem.in.seller.databinding.FragmentMoreBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentMoreBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_more, container, false);
        binding.gemAdvantage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MoreWebviewActivity.class);
                myIntent.putExtra("url","https://gem.gov.in/page/detail/26");
                getActivity().startActivity(myIntent);            }
        });
        binding.gemExclusive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MoreWebviewActivity.class);
                myIntent.putExtra("url","https://gem.gov.in/page/detail/27");
                getActivity().startActivity(myIntent);            }
        }); binding.faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MoreWebviewActivity.class);
                myIntent.putExtra("url","https://gem.gov.in/userFaqs");
                getActivity().startActivity(myIntent);            }
        }); binding.contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MoreWebviewActivity.class);
                myIntent.putExtra("url","https://gem.gov.in/contactUs");
                getActivity().startActivity(myIntent);            }
        });
binding.rateOnSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MoreWebviewActivity.class);
                myIntent.putExtra("url","https://gem.gov.in/user_feedback");
                getActivity().startActivity(myIntent);            }
        });

        return  binding.getRoot();
        /*View view= inflater.inflate(R.layout.fragment_more, container, false);
        return  view;*/
    }
}
