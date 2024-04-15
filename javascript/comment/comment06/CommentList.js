import Comment from "./Comment";

// 댓글 데이터
const comments = [
    { name: "홍길동", comment: "안녕하세요. 홍길동입니다." }, 
    { name: "신길동", comment: "안녕하세요. 매운 짬뽕입니다." },
    { name: "고길동", comment: "둘리가 싫어요." }
];

// 사용자 정보
const users = [
    { name: "홍길동", regno: "701010-1457934", picture: "https://png.pngtree.com/png-clipart/20190705/original/pngtree-vector-business-men-icon-png-image_4186858.jpg" }, 
    { name: "신길동", regno: "201010-3457934", picture: "https://png.pngtree.com/png-clipart/20190630/original/pngtree-vector-avatar-icon-png-image_4162757.jpg" },
    { name: "고길동", regno: "211010-4157934", picture: "https://png.pngtree.com/png-clipart/20190520/original/pngtree-male-worker-icon-graphic-png-image_3668949.jpg" }
];

// 사용자의 이름을 입력받아서 남, 여를 구분해서 반환하는 함수
const getUserGender = (name) => {
    const user = users.filter(u => u.name === name);
    return [1, 3].includes(Number(user[0].regno[7])) ? "남" : "여";
};
console.log(getUserGender("홍길동"));
console.log(getUserGender("고길동"));

// 댓글 데이터에 사용자 이미지를 추가하고, 이름을 재설정 
const commentsAndUsers = 
    comments.map(c => ({ 
        ...c, 
        picture: users.filter(u => u.name === c.name)[0].picture,
        name: `${c.name} (${getUserGender(c.name)})`
    }));

function CommentList(props) {
    return (
        <>
            <h1>모두 출력</h1>
            {   
                commentsAndUsers.map((cmt, index) => <Comment key={index} name={cmt.name} comment={cmt.comment} picture={cmt.picture} />)
            }
            
            <h1>홍길동만 출력</h1>
            {   
                commentsAndUsers
                .map((cmt, index) => {
                    return cmt.name === "홍길동" && <Comment key={index} name={cmt.name} comment={cmt.comment} picture={cmt.picture} />
                })
            }
        </>
    );
}
export default CommentList;
