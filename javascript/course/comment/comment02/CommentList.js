import Comment from "./Comment";

// 댓글 데이터
const comments = [
    { name: "홍길동", comment: "안녕하세요. 홍길동입니다." }, 
    { name: "신길동", comment: "안녕하세요. 매운 짬뽕입니다." },
    { name: "고길동", comment: "둘리가 싫어요." }
];

function CommentList(props) {
    return (
        <>
            {   // 화살표 함수 축약
                comments.map((cmt, index) => <Comment key={index} name={cmt.name} comment={cmt.comment} />)
            }
            {   // 화살표 함수
                comments.map((cmt, index) => {
                    return <Comment key={index} name={cmt.name} comment={cmt.comment} />;
                })
            }
            {   // 익명 함수 표현식
                comments.map(function(cmt, index) {
                    return <Comment key={index} name={cmt.name} comment={cmt.comment} />;
                })
            }
        </>
    );
}
export default CommentList;
