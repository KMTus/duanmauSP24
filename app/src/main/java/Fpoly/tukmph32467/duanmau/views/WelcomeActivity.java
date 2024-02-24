package Fpoly.tukmph32467.duanmau.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import Fpoly.tukmph32467.duanmau.R;
import Fpoly.tukmph32467.duanmau.databinding.ActivityWelcomeBinding;
import Fpoly.tukmph32467.duanmau.views.fragment.ManHinhChao;

public class WelcomeActivity extends AppCompatActivity {
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ManHinhChao()).commit();


    }
}