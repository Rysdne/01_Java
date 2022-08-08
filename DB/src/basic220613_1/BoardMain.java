package basic220613_1;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {

		// BoardInter dao = new BoardDAOv1();
		BoardInter dao = new BoardDAOv2();

//		// 0. 확인
//		System.out.println(dao.exist(1));

//		// 1. 입력
//		BoardVO bv = new BoardVO(2, "2", "2", "jark", "9284");
//		dao.insert(bv);

//		// 2. 출력
//		List<BoardVO> list = dao.findAll();
//		for (BoardVO bv : list) {
//			System.out.println(bv);
//		}

		// 3. 하나 출력
		System.out.println(dao.findOne(2));

//		// 4. 업데이트
//		BoardVO bv = new BoardVO(3, "rysdne", "이 게시판은 굔욷이 지배한다", "굔욷", "3882");
//		dao.update(bv);
//		System.out.println(dao.findOne(bv.getNum()));

//		// 5. 삭제
//		dao.delete(2);
//		List<BoardVO> list = dao.findAll();
//		for (BoardVO bv : list) {
//			System.out.println(bv);
//		}

	}

}
