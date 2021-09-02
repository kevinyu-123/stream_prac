package day20;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<StuDTO> list = new ArrayList<StuDTO>();
		DBClass db = new DBClass();
		int num, age,result=0;
		String id, name;
		while (true) {
			System.out.println("1.모든데이터 보기 2.검색 3.저장  4.삭제 5.수정");
			num = scan.nextInt();
			switch (num) {
			case 1:
				list = db.getList();
				db.showStu(list);
//				for (int i = 0; i < list.size(); i++) {
//					System.out.println("id : " + list.get(i).getId());
//					System.out.println("name : " + list.get(i).getName());
//					System.out.println("age : " + list.get(i).getAge());
//					System.out.println("-------------");
//				}
				break;
			case 2:
				//검색한 데이터를 데이터베이스에서 가져오기
				System.out.println("id 입력: ");
				id = scan.next();
				list = db.search(id);
				if(list !=null) {
					db.showStu(list);
//				System.out.println("id : "+dto.getId());
//				System.out.println("name : "+dto.getName());
//				System.out.println("age : "+dto.getAge());
				}else {
					System.out.println("해당 아이디는 존재하지 않습니다.");				
				}
				break;
			case 3:
				//데이터베이스에 저장하기
				System.out.println("아이디 입력: ");
				id = scan.next();
				System.out.println("이름 입력: ");
				name = scan.next();
				System.out.println("나이 입력: ");
				age = scan.nextInt();
				
				result = db.saveData(id,name,age);
				if(result == 1) {
					System.out.println("저장 성공");
				}else {
					System.out.println("동일한 아이디가 존재");
				}
				break;
			case 4:
				break;
			case 5:
				break;

			}

		}

	}

}
