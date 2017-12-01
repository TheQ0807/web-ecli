package demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {

	private Map<Integer, Book> db = new HashMap<>();
	
	public BookDao() {
		db.put(1, new Book(1,"이것이 자바다","신용권", "한빛미디어",35000,true,"자바에 대한 대략적인개요"));
		db.put(2, new Book(2,"요것이 뭐다냐?","영화", "영화명대사",25000,true,"영화 명대사를 모아놓은 책입니다. '뭣이 중한데!'를 외치던 그소녀의 대사! 어디서 나왔을까요?"));
		db.put(3, new Book(3,"두리먹어야","차두리", "독일의영웅",22222,false,"차두리와 차범근의 부자의 정을느끼는 책! 차범근 그의 인생스토리가 펼쳐집니다!!!"));
		db.put(4, new Book(4,"라면의정석","양군", "우리집",3000,true, "양군의 라면 끓이기!! 라면을 맛나게 드시고 싶으세요? 그럼 저를 따라서 천천히 만들어보세요!ㅋ"));
		db.put(5, new Book(5,"진심펀치의 사용설명서","격투의달인", "맨손격투",32000,true,"배그에서의 진심펀치! 사용해보셨나요? 진신펀치의 정석! 한번 느껴보세요!"));
		db.put(6, new Book(6,"낙하산의 펼침각도의중요성","떨어지면산다", "낙하산",32500,true,"낙하산만 잘펼쳐도 10위가 올라갑니다.! 우리 모두 베그 상위권에 올라가보아요!"));
		db.put(7, new Book(7,"해안가에서 살아남기","해안가", "보트",30000,true,"해안가에서 파밍해보셨나요? 해변가 만큼 오나전개꿀인곳이 없습니다! 보트를 타고 떠나는 베그 여행~ 같이가시죠!"));
		db.put(8, new Book(8,"밀베란 어떤곳인가?","밀덕", "해드샷",20000,false,"밀배만큼 개꿀인 곳이 없습니다! 밀베에서의 등장하는 아이템 등! 여러가지를 배워봐요!"));
		db.put(9, new Book(9,"가트카는 과연 별로인가?","지신", "월샷",10000,true,"버려진 그곳 가트카! 그곳은 과연 버려진곳인가?! 가트카의 재발견! 같이가시죠!"));
		db.put(10, new Book(10,"파밍의 신","파신", "한",50000,false,"파밍해봅시다! 내리자마자 상대편의 진심펀치에 넉다운되셨나요? 이걸 읽어보세요!"));
	}
	
	public List<Book> getAllBook() {
		return new ArrayList<Book>(db.values());
	}
	
	public Book getBook(int no){
		return db.get(no);
	}
}
