package com.icia.workmanager.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.icia.workmanager.MainViewModel;
import com.icia.workmanager.R;
import com.icia.workmanager.databinding.FragmentExecutorBinding;

public class ExecutorFragment extends Fragment {

    private MainViewModel viewModel;
    private FragmentExecutorBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_executor, container, false);
        binding = FragmentExecutorBinding.bind(view);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(
                requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(MainViewModel.class);

        viewModel.progressLiveData.observe(getViewLifecycleOwner(), progress -> {
            binding.progress.setProgress(progress);
        });

        binding.button.setOnClickListener(v -> viewModel.longTask());
    }
}