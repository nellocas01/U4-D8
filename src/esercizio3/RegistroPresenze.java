package esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	private List<Attendance> attendanceList;

	public RegistroPresenze() {
		attendanceList = new ArrayList<>();
	}

	public void addAttendance(String employeeName, int daysPresent) {
		Attendance attendance = new Attendance(employeeName, daysPresent);
		attendanceList.add(attendance);
	}

	public void saveToFile(String filePath) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Attendance attendance : attendanceList) {
			stringBuilder.append(attendance.getEmployeeName()).append("@").append(attendance.getDaysPresent())
					.append("#");
		}

		String data = stringBuilder.toString();

		try {
			FileUtils.writeStringToFile(new File(filePath), data, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadFromFile(String filePath) {
		attendanceList.clear();

		try {
			String data = FileUtils.readFileToString(new File(filePath), "UTF-8");
			String[] attendanceData = data.split("#");

			for (String attendance : attendanceData) {
				String[] splitData = attendance.split("@");
				String employeeName = splitData[0];
				int daysPresent = Integer.parseInt(splitData[1]);

				addAttendance(employeeName, daysPresent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printAttendance() {
		for (Attendance attendance : attendanceList) {
			System.out.println(attendance.getEmployeeName() + ": " + attendance.getDaysPresent() + " days");
		}
	}

	private static class Attendance {
		private String employeeName;
		private int daysPresent;

		public Attendance(String employeeName, int daysPresent) {
			this.employeeName = employeeName;
			this.daysPresent = daysPresent;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public int getDaysPresent() {
			return daysPresent;
		}
	}
}
