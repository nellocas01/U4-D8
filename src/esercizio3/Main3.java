package esercizio3;

public class Main3 {

	public static void main(String[] args) {
		RegistroPresenze attendanceRegister = new RegistroPresenze();

		attendanceRegister.addAttendance("Mario Rossi", 5);
		attendanceRegister.addAttendance("Giorgio Bianchi", 7);
		attendanceRegister.addAttendance("Gianni Verdi", 7);

		attendanceRegister.saveToFile("attendance.txt");

		attendanceRegister.loadFromFile("attendance.txt");

	}

}
