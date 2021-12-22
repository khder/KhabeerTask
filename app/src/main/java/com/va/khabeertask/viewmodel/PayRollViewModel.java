package com.va.khabeertask.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.va.khabeertask.data.PayRoll;
import com.va.khabeertask.data.PayRollRepository;

import org.json.JSONException;

public class PayRollViewModel extends ViewModel {
    private final PayRollRepository payRollRepository;
    public MutableLiveData<PayRoll>payRollMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String>errorMutableLiveData = new MutableLiveData<>();
    public PayRollViewModel(PayRollRepository payRollRepository){
        this.payRollRepository = payRollRepository;
    }

    public void getPayRoll(){
        try {
            payRollRepository.getPayroll(payRollMutableLiveData,errorMutableLiveData);
        } catch (JSONException e) {
            errorMutableLiveData.setValue("حدث خطأ ما");
        }
    }

}
