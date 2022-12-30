import React from "react";
import Comment from "./Comment";

const comments =  [
    {
        name: "홍길동",
        comment: "안녕하세요, 홍길동입니다."
    },
    {
        name: "심청이",
        comment: "리액트 재밌습니다."
    },
    {
        name: "강감찬",
        comment: "저도 리액트 배워보고 싶네요."
    }
]

function CommentList(props) {
    return (
        <div>
            {comments.map(comment => {
                return (
                    <Comment key={comment.name} name={comment.name} comment={comment.comment} />
                );
            })}
        </div>
    );
}

export default CommentList;