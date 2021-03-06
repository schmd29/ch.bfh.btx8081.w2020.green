package model.common;

import java.time.LocalDate;

/**
 * Class represents a Staff member
 */

public class Staff extends Person {

	private int staffId;
	private String department;
	private String certification;
	private LocalDate joinedDate;

	public Staff(String firstName, String secondName, String birthDate, String gender, Address address, String email,
			String phone) {
		super(firstName, secondName, birthDate, gender, address, email, phone);
		// TODO Auto-generated constructor stub
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public LocalDate getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDate joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Override
	public String toString() {
		return "Staff{" +
				"staffId=" + staffId +
				", department='" + department + '\'' +
				", certification='" + certification + '\'' +
				", joinedDate=" + joinedDate +
				'}';
	}
}
