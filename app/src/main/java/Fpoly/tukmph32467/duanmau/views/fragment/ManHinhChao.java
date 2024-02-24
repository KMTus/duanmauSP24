package Fpoly.tukmph32467.duanmau.views.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import Fpoly.tukmph32467.duanmau.R;
import Fpoly.tukmph32467.duanmau.databinding.FragmentManHinhChaoBinding;


public class ManHinhChao extends Fragment {
    FragmentManHinhChaoBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentManHinhChaoBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new LoginFragment()).commit();
            }
        }, 3000);

        return binding.getRoot();
    }
}