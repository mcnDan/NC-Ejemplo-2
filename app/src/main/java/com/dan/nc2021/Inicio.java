package com.dan.nc2021;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dan.nc2021.Model.ProductoModel;
import com.dan.nc2021.ViewModel.InicioViewModel;
import com.dan.nc2021.databinding.FragmentInicioBinding;


public class Inicio extends Fragment {

    private FragmentInicioBinding binding;
    private InicioViewModel inicioViewModel;
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentInicioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicioViewModel = new ViewModelProvider(requireActivity()).get(InicioViewModel.class);

        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.myNavHost);
        navController = navHostFragment.getNavController();



        binding.btnPreviewInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProductoModel model = new ProductoModel();
                model.setDescripcion(binding.etDescripcionInicio.getText().toString());
                model.setPrecio(Double.parseDouble(binding.etPrecioIncio.getText().toString()));
                model.setCantidad(Integer.parseInt(binding.etCantiidadInicio.getText().toString()));

                inicioViewModel.setProductoMLD(model);

                navController.navigate(R.id.final1);


            }
        });






    }
}