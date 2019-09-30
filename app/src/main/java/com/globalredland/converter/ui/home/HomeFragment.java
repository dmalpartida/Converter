package com.globalredland.converter.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.globalredland.converter.R;
import com.globalredland.converter.ui.converter.ConverterFragment;
import com.globalredland.converter.ui.equivalente.EquivalenteFragment;
import com.globalredland.converter.ui.intro.IntroActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Intent intent = new Intent(getContext(), IntroActivity.class);
        startActivity(intent);

        final NavigationView navigationView = getActivity().findViewById(R.id.nav_view);

        Button btnConverter = root.findViewById(R.id.button_unit_converter);
        Button btnEquivalente = root.findViewById(R.id.button_unit_equivalent);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navigationView.getMenu().getItem(1).setChecked(true);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment, new ConverterFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        btnEquivalente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navigationView.getMenu().getItem(2).setChecked(true);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.nav_host_fragment, new EquivalenteFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        homeViewModel.getText().observe(this, new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }
}