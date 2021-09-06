package Lab03.Person;
import java.io.File;
import javax.print.Doc;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Person {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random value = new Random();


        int admitMonth = value.nextInt(13);
        int admitDay = value.nextInt(32);
        int admitYear = value.nextInt(22);

        System.out.print("\nEnter patient's ID: ");
        int p1ID = input.nextInt();

        System.out.print("\nEnter patient first name: ");
        String p1FirstName = input.next();

        System.out.print("\nEnter patient last name: ");
        String p1LastName = input.next();

        int dobMonth = value.nextInt(13);
        int dobDay = value.nextInt(31);
        int dobYear = value.nextInt(21);

        Patient p1 = new Patient(p1FirstName, p1LastName, new Date(dobMonth, dobDay, dobYear), new Date(admitMonth, admitDay, admitYear), new Date(admitMonth, admitDay + 7, admitYear));
        System.out.print("\nEnter doctor's first name: ");
        String doc1FirstName = input.next();

        System.out.print("\nEnter doctor's last name: ");
        String doc1LastName = input.next();

        System.out.print("\nEnter doctor's specialty: ");
        String doc1Specialty = input.next();

        Doctor doc1 = new Doctor(doc1FirstName, doc1LastName, doc1Specialty);

        Bill b1 = new Bill();
        b1.setPharmCharge(value.nextInt(500));
        b1.setRoomCharge(value.nextInt(5000));
        b1.setDoctorFee(value.nextInt(5000));
        System.out.println("Patient: " + p1FirstName + p1LastName + "\t\t" + "Date of Birth: " + dobMonth + "/" + dobDay + "/" + dobYear);
        System.out.println("Attending Physician: " + doc1.getFirstName() + " " + doc1.getLastName() + ", " + doc1.getDocSpecialty());
        System.out.println("Admit Date: " + admitMonth + "/" +admitDay + "/" + admitYear);
        System.out.print("Discharge Date: " + admitMonth + "/" + (admitDay + 7) + "/" + admitYear + "\n");
        System.out.println("Pharmacy Charges: " + "$" + b1.getPharmCharge());
        System.out.println("Room Charges: \t" + "$" + b1.getRoomCharge());
        System.out.println("Doctor's Fee: \t" + "$" + b1.getDoctorFee());
        System.out.println("_________________________________________");
        System.out.println("Total Charges: \t" + "$" + (b1.getPharmCharge() + b1.getRoomCharge() + b1.getDoctorFee()));


        String tempStoreFile = p1.getFirstName() + p1.getLastName() + ".txt";
        try
        {
            FileWriter inputFile = new FileWriter(new File(tempStoreFile));
            inputFile.write(p1.toString() + "\n");
            inputFile.write("\n" + b1);
            inputFile.close();
        } catch(IOException temp)
        {
            System.out.println("Error.");
        }
    }
    String firstName, lastName;

    Person()
    {
        firstName = "N/A";
        lastName = "N/A";
    }
    Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    String getFirstName()
    {
        return firstName;
    }
    String getLastName()
    {
        return lastName;
    }
}

class Doctor extends Person {
    String docSpecialty;

    Doctor()
    {
        firstName = "N/A";
        lastName = "N/A";
        docSpecialty = "N/A";
    }
    Doctor(String firstName, String lastName, String docSpecialty)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.docSpecialty = docSpecialty;
    }
    void setDocSpecialty(String docSpecialty)
    {
        this.docSpecialty = docSpecialty;
    }
    String getDocSpecialty()
    {
        return docSpecialty;
    }
}

class Bill {
    int patientID;
    float pharmCharge, doctorFee, roomCharge, totalCharge;

    Bill()
    {
        patientID = 0;
        pharmCharge = 0;
        doctorFee = 0;
        roomCharge = 0;
        totalCharge = 0;
    }
    Bill(int patientID, float pharmCharge, float doctorFee, float roomCharge)
    {
        this.patientID = patientID;
        this.pharmCharge = pharmCharge;
        this.doctorFee = doctorFee;
        this.roomCharge = roomCharge;
    }
    void setPatientID(int patientID) { this.patientID = patientID; }
    void setPharmCharge(float pharmCharge) { this.pharmCharge = pharmCharge; }
    void setDoctorFee(float doctorFee) { this.doctorFee = doctorFee; }
    void setRoomCharge(float roomCharge) { this.roomCharge = roomCharge; }

    int getPatientID() { return patientID; }
    float getPharmCharge() { return pharmCharge; }
    float getDoctorFee()
    {
        return doctorFee;
    }
    float getRoomCharge()
    {
        return roomCharge;
    }
}

class Date {
    int day, month, year;

    Date()
    {
        day = 0;
        month = 0;
        year = 0;
    }
    Date(int month, int day, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }
     void setDate(int month, int day, int year) {
         while (month >= 1 && month <= 12)
         {
             this.month = month;
         }
         while (day >= 1 && day <= 31)
         {
             this.day = day;
         }
         this.year = year;
     }

}


class Patient extends Person {
    int patientID;
    Doctor physicianName;
    Date dateOfBirth, admitDate, dischargeDate;

    Patient(String firstName, String lastName, Date dateOfBirth, Date admitDate, Date dischargeDate)
    {

    }

    void setPatientID(int patientID) { this.patientID = patientID; }
    void setPhysicianName(Doctor physicianName) { this.physicianName = physicianName; }
    void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    void setAdmitDate(Date admitDate) { this.admitDate = admitDate; }
    void setDischargeDate(Date dischargeDate) { this.dischargeDate = dischargeDate; }

    int getPatientID() { return patientID; }
    Doctor getPhysicianName() { return physicianName; }
    Date getDateOfBirth() { return dateOfBirth; }
    Date getAdmitDate() { return admitDate; }
    Date getDischargeDate() { return dischargeDate; }
}

