package edu.multi.mvc;

public class LoginVO {
	//id, pw, age 요청파라미터 입력 저장 변수들.
	String id;
	String pw;
	int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
