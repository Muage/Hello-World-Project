//package com.icia.livedata;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class PostFragment extends Fragment {
//
//    //데이터를 받아올 Lists
//    private ArrayList<Post> posts;
//    private RecyclerView listView;
//
//    private PostAdapter postAdapter;
//    private PostViewModel postViewModel;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        //fragment_post 내에 정의 된 listView_p의 recyclerView를 불러옵니다.
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_post, container, false);
//        listView = root.findViewById(R.id.listview);
//
//        setListView(listView);
//        return root;
//    }
//
//
//    public void setListView(RecyclerView listView) {
//
//        //서버에서 데이터 받아오기
//        service.getPost().enqueue(new Callback<PostResponse>() {
//            @Override
//            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
//                if (response.isSuccessful()) {
//                    PostResponse p = response.body();
//
//                    //ViewModel 객체 생성
//                    postViewModel = new ViewModelProvider(requireActivity()).get(PostViewModel.class);
//
//                    //post 데이터 및 like 데이터 받아오기
//                    posts = p.getPostData();
//
//                    //ViewModel의 데이터 setting
//                    postViewModel.getPost().setValue(posts);
//                    setPostAdapter(listView);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PostResponse> call, Throwable t) {
//                //에러 처리
//            }
//        });
//
//    }
//
//
//    private void setPostAdapter(RecyclerView listView) {
//        //listView adapter 적용
//        postAdapter = new ListPostAdapter(getActivity(), post);
//        listView.setAdapter(postAdapter);
//
//        LinearLayoutManager pLayoutManager = new LinearLayoutManager(getActivity());
//        pLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        listView.setLayoutManager(pLayoutManager);
//        listView.setItemAnimator(new DefaultItemAnimator());
//    }
//
//}