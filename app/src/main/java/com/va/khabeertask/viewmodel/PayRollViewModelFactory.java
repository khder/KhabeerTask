package com.va.khabeertask.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.va.khabeertask.data.PayRollRepository;

public class PayRollViewModelFactory implements ViewModelProvider.Factory {
    private PayRollRepository payRollRepository;

    public PayRollViewModelFactory(PayRollRepository payRollRepository){
        this.payRollRepository = payRollRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PayRollViewModel.class)) {
            return (T) new PayRollViewModel(payRollRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");

    }
}
