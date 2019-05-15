import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Member {
	private HashMap<String,String[]> members;
	
	public Member() {
		members = new HashMap<>();
		String testId = "test";
		String [] testPw = new String [3];
		testPw[0] = "1234";
		testPw[1] = "서울";
		testPw[2] = "010-2222-3333";
		members.put(testId, testPw);
	}
	
	public boolean isMember(String id, String pw) {
		if(members.get(id) != null) { //값이 있을
			String[] test = members.get(id);
			if(pw.equals(test[0])) {
				System.out.println("로그인 성공~!");
				return true;
			}else{
				System.out.println("pw: "+pw);
				System.out.println("test: "+test[0]);
				System.out.println("비밀번호가 틀렸습니다.");
				return false;
			}
		}else {
			System.out.println("해당하는 아이디가 없습니다.");
			return false;
		}
	}

	public boolean registMember(String id, String pw, String addr, String phone){
		String[] value = {pw, addr, phone};

		if(members.get(id) == null){
			members.put(id, value);
			for (String abc: members.get(id)) {
				System.out.println(abc);
			}
			return true;
		}else{
			JOptionPane.showMessageDialog(null,"해당하는 아이디가 있습니다.");
			return false;
		}
	}

	public void getKey(){
		Set set = members.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			String key = (String)iterator.next();

			System.out.println("hashMap Key : " + key);

		}
	}
	
}
