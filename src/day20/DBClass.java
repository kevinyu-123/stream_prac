package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBClass {
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	private String id = "hyeonjoon";
	private String pwd = "tntor123";

	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<StuDTO> search(String id) {
		String sql = "SELECT * FROM newst WHERE id = '"+id+"'";
		ArrayList<StuDTO> list = new ArrayList<StuDTO>();
		StuDTO dto = null;
		try {
			// db 연결
			Connection con = DriverManager.getConnection(url,this.id,pwd);
			System.out.println("데이터베이스와 연결이 잘 되었습니다.");
			//쿼리문 전송 객체 생성
			PreparedStatement pr = con.prepareStatement(sql);
			// 전송 객체 실행 및 결과 값 저장
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				dto = new StuDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<StuDTO> getList() {
		ArrayList<StuDTO> list = new ArrayList<StuDTO>();
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			System.out.println("데이터베이스와 연결이  되었습니다.");

			// 명령어를 수행할 수 있는 객체를 생성
			String sql = "select * from newst";
			PreparedStatement ps = con.prepareStatement(sql);

			// 명령어를 수행할 수있는 객체를 이용하여 명령어 수행과 동시에 결과를 rs객체에 저장.
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StuDTO dto = new StuDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void showStu(ArrayList<StuDTO> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println("id : " + list.get(i).getId());
			System.out.println("name : " + list.get(i).getName());
			System.out.println("age : " + list.get(i).getAge());
			System.out.println("-------------");
		}
	}
	
	public int saveData(String id2,String name,int age) {
		int result = 0;
		//String sql = "INSERT INTO newst VALUES('"+id2+"','"+name+"','"+age+"')";
		String sql = "INSERT INTO newst VALUES(?,?,?)";
		
		try {
			//db와 연결
			Connection con = DriverManager.getConnection(url, id, pwd);

			PreparedStatement ps = con.prepareStatement(sql);
			//물음표 자리 채우기
			ps.setString(1, id2);
			ps.setString(2,name);
			ps.setInt(3, age);
			
			//select 쿼리문을 전송할때 사용 = executeQuery();
			//ResultSet rs = ps.executeQuery();
			
			//select를 제외한 쿼리문은 executeUpdate()사용, return 값을 돌려줌.
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
