package Fpoly.tukmph32467.duanmau.views.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import Fpoly.tukmph32467.duanmau.adapter.LoaiSachAdapter;
import Fpoly.tukmph32467.duanmau.dao.LoaiSachDao;
import Fpoly.tukmph32467.duanmau.databinding.DiaglogAddLoaisachBinding;
import Fpoly.tukmph32467.duanmau.databinding.FragmentQuanLyLoaiSachBinding;
import Fpoly.tukmph32467.duanmau.models.LoaiSachModel;

import java.util.ArrayList;

import Fpoly.tukmph32467.duanmau.adapter.LoaiSachAdapter;
import Fpoly.tukmph32467.duanmau.dao.LoaiSachDao;
import Fpoly.tukmph32467.duanmau.databinding.FragmentQuanLyLoaiSachBinding;
import Fpoly.tukmph32467.duanmau.models.LoaiSachModel;


public class QuanLyLoaiSachFragment extends Fragment {
    FragmentQuanLyLoaiSachBinding binding;
    LoaiSachDao dao;
    LoaiSachAdapter adapter;
    ArrayList<LoaiSachModel> arrayList;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuanLyLoaiSachBinding.inflate(inflater, container, false);
        dao = new LoaiSachDao(getContext());
        arrayList = dao.getListLoaiSach();
        loadDataFromSQL();

        listener();
        return binding.getRoot();
    }

    private void loadDataFromSQL(){
        arrayList = dao.getListLoaiSach();
        adapter = new LoaiSachAdapter(getContext(), arrayList, dao);
        binding.rcvLoaiSach.setAdapter(adapter);
    }

    private void listener() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
                DiaglogAddLoaisachBinding binding1 = DiaglogAddLoaisachBinding.inflate(inflater);
                View view = binding1.getRoot();
                builder.setView(view);
                Dialog dialog = builder.create();
                dialog.show();

                binding1.btnHoanTat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tenTL =  binding1.edTenTL.getText().toString().trim();
                        if (tenTL.isEmpty()) {
                            binding1.edTenTL.setError("Vui lòng nhập đữ liệu");
                            return;
                        }else {
                            LoaiSachModel objNew = new LoaiSachModel();
                            objNew.setTenTL(tenTL);
                            dao.addLoaiSach(objNew);
                            loadDataFromSQL();
                            Toast.makeText(getContext(), "Thêm mới thành công", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });



            }
        });
    }




}