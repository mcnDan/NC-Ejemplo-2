package com.dan.nc2021.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dan.nc2021.Model.ProductoModel;

public class InicioViewModel extends ViewModel {

    private MutableLiveData<ProductoModel> productoMLD = new MutableLiveData<>();

    public LiveData<ProductoModel> getProductoMLD(){
        return productoMLD;
    }

    public void setProductoMLD(ProductoModel model){
        productoMLD.setValue(model);
    }

}
