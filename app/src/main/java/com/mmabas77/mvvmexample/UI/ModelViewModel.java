package com.mmabas77.mvvmexample.UI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mmabas77.mvvmexample.pojo.Model;
import com.mmabas77.mvvmexample.utils.RetrofitInterface;
import com.mmabas77.mvvmexample.utils.Retrofitinstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelViewModel extends ViewModel {
  public   MutableLiveData<List<Model>>listMutableLiveData = new MutableLiveData<>();

    public void getData(){
        RetrofitInterface retrofitInterface = Retrofitinstance.getData().create(RetrofitInterface.class);
        Call<List<Model>>call =retrofitInterface.getPosts();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
