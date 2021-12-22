package com.va.khabeertask.utils;

import com.va.khabeertask.data.Deductions;
import com.va.khabeertask.data.PayRoll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    public static String getAuthToken(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        return "Bearer "+ jsonObject.getString("Token");
    }
    public static PayRoll getPayRoll(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        PayRoll payRoll = new PayRoll();
        JSONObject payrollJsonObject = jsonObject.getJSONObject("Payroll");
        JSONObject employeeJsonObject = payrollJsonObject.getJSONArray("Employee").getJSONObject(0);
        payRoll.setEmployeeName(employeeJsonObject.getString("EMP_DATA_AR"));
        payRoll.setEmployeeSpecialist(employeeJsonObject.getString("JOBNAME_AR"));
        JSONArray allowencesJsonArray = payrollJsonObject.getJSONArray("Allowences");
        int allowencesLength = allowencesJsonArray.length();
        ArrayList<Deductions>deductionsList = new ArrayList<>();
        Deductions deductions;
        JSONObject allowencesJsonObject;
        for (int i=0;i<allowencesLength;i++){
            allowencesJsonObject = allowencesJsonArray.getJSONObject(i);
            deductions = new Deductions();
            deductions.setItem(allowencesJsonObject.getString("COMP_DESC_AR"));
            deductions.setValue((float) allowencesJsonObject.getDouble("SAL_VALUE"));
            deductionsList.add(deductions);
        }
        JSONObject deductionJsonObject = payrollJsonObject.getJSONArray("Deduction").getJSONObject(0);
        deductions = new Deductions();
        deductions.setItem(deductionJsonObject.getString("COMP_DESC_AR"));
        deductions.setValue((float) deductionJsonObject.getDouble("SAL_VALUE"));
        deductionsList.add(deductions);
        payRoll.setDeductions(deductionsList);
        return payRoll;
    }
}
