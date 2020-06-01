package gem.in.seller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BidFragment extends Fragment
{

    public BidFragment() {
        // Required empty public constructor
    }
    //EMD & EPRG
    //Verify & ESIGN
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_bid_view, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        BidFragmentItemAdapter adapter = new BidFragmentItemAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
       /* WebView webView=(WebView)view.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://bidplus.gemorion.org/bidlists");*/
        return  view;

    }
}
