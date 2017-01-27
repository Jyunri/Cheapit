package br.com.cdf.cheapit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView tvUsername;

    ImageView ivAvatar;
    private RadioGroup radioGroup1;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_profile, container, false);
        if(FacebookController.LoginMethod.equals("facebook")) {
            new DownloadImage((ImageView) rootView.findViewById(R.id.ivAvatar)).execute(FacebookController.getCurrentAvatar());
            tvUsername = (TextView)rootView.findViewById(R.id.tvUsername);
            tvUsername.setText(FacebookController.getCurrentUsername());
        }



//        radioGroup1 = (RadioGroup)rootView.findViewById(R.id.radioGroup1);
//
//        // Checked change Listener for RadioGroup 1
//        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId)
//            {
//                switch (checkedId)
//                {
//                    case R.id.radioProfile:
//                        Toast.makeText(getContext(), "Cupons Ativos", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.radioMyCoupons:
//                        MyCouponsFragment myCouponsFragment = new MyCouponsFragment();
//                        android.support.v4.app.FragmentTransaction mycouponfragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                        mycouponfragmentTransaction
//                                .replace(R.id.fragment_container, myCouponsFragment)
//                                .addToBackStack(null)
//                                .commit();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });

        return rootView;
    }

}
