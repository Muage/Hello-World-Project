//package com.icia.livedata;
//
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//public class PostViewModel extends ViewModel {
//
//    public static MutableLiveData<List<Post>> post = new MutableLiveData<>();
//
//    public MutableLiveData<List<Post>> getPost() {
//        if(post == null) {
//            post = new MutableLiveData<>();
//        }
//        return post;
//    }
//
//    public static void setLike(int pos, int val) {
//        List<Post> p = new ArrayList<>();
//        p.addAll(post.getValue());
//        p.get(pos).setLike(p.get(pos).getLike() + (val));
//
//        post.setValue(p);
//    }
//}
