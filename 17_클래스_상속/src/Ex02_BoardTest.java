public class Ex02_BoardTest {
    public static void main(String[] args) {
        NoticeBoard nb = new NoticeBoard();
        nb.setNum(1);
        nb.setSubject("공지사항 입니다.");
        nb.setContent("공지사항의 내용 입니다.");
        nb.setWriter("관리자");
        nb.setFile("첨부파일.zip");

        QNABoard qna = new QNABoard();
        qna.setNum(2);
        qna.setSubject("질문답변 입니다.");
        qna.setContent("질문답변의 내용 입니다.");
        qna.setWriter("회원1");
        qna.setVote(123);

        FreeBoard free = new FreeBoard();
        free.setNum(3);
        free.setSubject("자유 게시판 입니다.");
        free.setContent("자유 게시판의 내용입니다.");
        free.setWriter("회원2");
        free.setScrapCount(456);

    }
}
