package com.example.myapplicationlll.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

class ViewModelFactory implements ViewModelProvider.Factory {
    Context context;
    public ViewModelFactory(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActivityViewModel.class)) {
            return (T) new MainActivityViewModel(context,"samir");
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
