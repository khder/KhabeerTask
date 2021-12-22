package com.va.khabeertask.data;

import androidx.lifecycle.MutableLiveData;

import com.va.khabeertask.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayRollRepository {
    public void getPayroll(MutableLiveData<PayRoll>payRollMutableLiveData,
                           MutableLiveData<String>errorMutableLiveData) throws JSONException {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        JSONObject loginJsonObject = new JSONObject();
        loginJsonObject.put("MobileNumber","01068962997");
        loginJsonObject.put("Password","12345678");
        RequestBody body =
                RequestBody.create(MediaType.parse("application/json"), loginJsonObject.toString());
        apiInterface.login(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        callPayrollEndPoint(JsonUtils.getAuthToken(response.body().string()),payRollMutableLiveData,
                                errorMutableLiveData);
                    } catch (JSONException e) {
                        errorMutableLiveData.setValue("حدث خطأ ما");
                    } catch (IOException e) {
                        errorMutableLiveData.setValue("حدث خطأ ما");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                errorMutableLiveData.setValue("حدث خطأ ما");
            }
        });
    }

    private void callPayrollEndPoint(String token,
                                     MutableLiveData<PayRoll>payRollMutableLiveData,
                                     MutableLiveData<String>errorMutableLiveData){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        apiInterface.getPayRoll(token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        payRollMutableLiveData.setValue(JsonUtils.getPayRoll(response.body().string()));
                    } catch (JSONException e) {
                        errorMutableLiveData.setValue("حدث خطأ ما");
                    } catch (IOException e) {
                        errorMutableLiveData.setValue("حدث خطأ ما");
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                errorMutableLiveData.setValue("حدث خطأ ما");
            }
        });
    }
}
