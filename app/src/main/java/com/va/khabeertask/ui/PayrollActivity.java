package com.va.khabeertask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.va.khabeertask.R;
import com.va.khabeertask.data.Deductions;
import com.va.khabeertask.data.PayRoll;
import com.va.khabeertask.data.PayRollRepository;
import com.va.khabeertask.databinding.ActivityPayrollBinding;
import com.va.khabeertask.viewmodel.PayRollViewModel;
import com.va.khabeertask.viewmodel.PayRollViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class PayrollActivity extends AppCompatActivity {
    private ActivityPayrollBinding binding;
    private PayRollViewModel payRollViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayrollBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViewModel();
        List<TitleValueColorEntity> pieChartData = new ArrayList();
        pieChartData.add(new TitleValueColorEntity("",40.8f,getResources().getColor(R.color.dark_blue)));
        pieChartData.add(new TitleValueColorEntity("",59.2f,getResources().getColor(R.color.dark_yellow)));
        binding.pieChart.setData(pieChartData);
    }
    private void initViewModel(){
        payRollViewModel =
                new ViewModelProvider(this,new PayRollViewModelFactory(new PayRollRepository()))
                .get(PayRollViewModel.class);
        payRollViewModel.payRollMutableLiveData.observe(this, this::bindData);
        payRollViewModel.errorMutableLiveData.observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        });
        payRollViewModel.getPayRoll();

    }

    private void bindData(PayRoll payRoll){

        binding.doctorName.setText(payRoll.getEmployeeName());
        binding.doctorSpecialist.setText(payRoll.getEmployeeSpecialist());

        Deductions deductions = payRoll.getDeductions().get(0);
        binding.firstItem.setText(deductions.getItem());
        binding.firstValue.setText(String.valueOf(deductions.getValue()));

        deductions = payRoll.getDeductions().get(1);
        binding.secondItem.setText(deductions.getItem());
        binding.secondValue.setText(String.valueOf(deductions.getValue()));

        deductions = payRoll.getDeductions().get(2);
        binding.thirdItem.setText(deductions.getItem());
        binding.thirdValue.setText(String.valueOf(deductions.getValue()));
        binding.deductionsValue.setText(String.valueOf(deductions.getValue()));

        binding.icArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}