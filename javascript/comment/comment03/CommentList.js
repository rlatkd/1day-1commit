import Comment from "./Comment";

// 댓글 데이터
const comments = [
    { name: "홍길동", comment: "안녕하세요. 홍길동입니다.", picture: "https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-business-men-icon-png-image_4186858.jpg" }, 
    { name: "신길동", comment: "안녕하세요. 매운 짬뽕입니다.", picture: "https://png.pngtree.com/png-clipart/20190630/original/pngtree-vector-avatar-icon-png-image_4162757.jpg" },
    { name: "고길동", comment: "둘리가 싫어요.", picture: "https://png.pngtree.com/png-clipart/20190520/original/pngtree-male-worker-icon-graphic-png-image_3668949.jpg" }
];

function CommentList(props) {
    return (
        <>
            {   // 화살표 함수 축약
                comments.map((cmt, index) => <Comment key={index} name={cmt.name} comment={cmt.comment} picture={cmt.picture} />)
            }
            {   // 화살표 함수
                comments.map((cmt, index) => {
                    return <Comment key={index} name={cmt.name} comment={cmt.comment} picture={cmt.picture} />;
                })
            }
            {   // 익명 함수 표현식
                comments.map(function(cmt, index) {
                    return <Comment key={index} name={cmt.name} comment={cmt.comment} picture={cmt.picture} />;
                })
            }
        </>
    );
}
export default CommentList;
