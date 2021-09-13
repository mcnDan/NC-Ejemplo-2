package com.dan.nc2021;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dan.nc2021.Model.ProductoModel;
import com.dan.nc2021.ViewModel.InicioViewModel;
import com.dan.nc2021.databinding.FragmentFinalBinding;


public class Final extends Fragment {

    private FragmentFinalBinding binding;
    private InicioViewModel inicioViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFinalBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicioViewModel = new ViewModelProvider(requireActivity()).get(InicioViewModel.class);

        inicioViewModel.getProductoMLD().observe(getViewLifecycleOwner(), new Observer<ProductoModel>() {
            @Override
            public void onChanged(ProductoModel model) {
                binding.tvDescripcionFinal.setText(model.getDescripcion());
                binding.tvPrecioFinal.setText(String.valueOf(model.getPrecio()));
                binding.tvCantidadFinal.setText(String.valueOf(model.getCantidad()));
            }
        });

        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.myNavHost);
        NavController navController = navHostFragment.getNavController();


    }
}