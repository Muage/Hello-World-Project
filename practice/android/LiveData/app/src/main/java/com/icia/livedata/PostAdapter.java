//package com.icia.livedata;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.LifecycleOwner;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.lifecycle.ViewModelStoreOwner;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
//
//    private ArrayList<Post> post = new ArrayList<>();
//    private PostViewModel postViewModel;
//    private Context context;
//
//
//    public PostAdapter(Context context) {
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_post, parent, false);
//
//        //ViewModel 객체 생성
//        postViewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(PostViewModel.class);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        setViewModel(holder, position);
//        setPostData(holder, position);
//    }
//
//    private void setViewModel(MyViewHolder holder, int position) {
//
//        //PostViewModel에 있는 데이터가 변경이 됐음을 감지하면(setValue()를 통해 데이터의 변경이 일어남) onChanged 함수실행
//        postViewModel.getPost().observe((LifecycleOwner) context, new Observer<List<Post>>() {
//            @Override
//            public void onChanged(List<Post> p) {
//                //변경된 값으로 holder의 데이터 변경
//                holder.LikedNum.setText(String.valueOf(p.get(position).getLikeNum()));
//            }
//        });
//    }
//
//    private void setPostData(MyViewHolder holder, int position) {
//        Post post = postViewModel.getPost().getValue().get(position);
//        holder.likedNum.setText(String.valueOf(post.getLikeNum()));
//
//        setClickListenerOnHolder(holder, position);
//    }
//
//    private void setClickListenerOnHolder(MyViewHolder holder, int position) {
//        holder.img_like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!v.isActivated()) {
//                    PostViewModel.setLike(position, 1);
//                } else {
//                    PostViewModel.setLike(position, -1);
//                }
//            }
//        });
//        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //gotoDetailPostActivity
//                intent = new Intent(context, DetailPostActivity.class);
//                intent.putExtra("pos", position);
//
//                ((Activity) context).startActivity(intent);
//            }
//        });
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return post.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView likedNum;
//        Button btn_detail;
//        ImageView img_like;
//
//        MyViewHolder(View view) {
//            super(view);
//            LikedNum = (TextView) view.findViewById(R.id.likedNum);
//            btn_detail=(Button)view.findViewById(R.id.btn_detail);
//            img_like=(ImageView)view.findViewById(R.id.img_like;
//        }
//
//    }
//
//}
