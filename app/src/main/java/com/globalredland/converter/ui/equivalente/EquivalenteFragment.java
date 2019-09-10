package com.globalredland.converter.ui.equivalente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.globalredland.converter.R;

public class EquivalenteFragment extends Fragment {

    private EquivalenteViewModel equivalenteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        equivalenteViewModel =
                ViewModelProviders.of(this).get(EquivalenteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_equivalente, container, false);

        return root;
    }
}
