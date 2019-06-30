public class CHAN_Wk10Participation_4212452
{
    public static void main(String args[])
    {
        CHAN_Wk10ParticipationStudent_4212452 s1 = new CHAN_Wk10ParticipationStudent_4212452("Daniel", "Donald", 1357, "CS");
        CHAN_Wk10ParticipationStudent_4212452 s2 = new CHAN_Wk10ParticipationStudent_4212452("Freddie", "Clark", 2412, "Biology");
        CHAN_Wk10ParticipationStudent_4212452 s3 = new CHAN_Wk10ParticipationStudent_4212452("Clara", "King", 5813, "Math");
        
        System.out.println("Student1: " + s1.getFirstname() + " " + s1.getLastname() + "\n" + s1.getStudentID() + "\n" + s1.getMajor() + "\n");
        System.out.println("Student2: " + s2.getFirstname() + " " + s2.getLastname() + "\n" + s2.getStudentID() + "\n" + s2.getMajor() + "\n");
        System.out.println("Student3: " + s3.getFirstname() + " " + s3.getLastname() + "\n" + s3.getStudentID() + "\n" + s3.getMajor() + "\n");
        
        s1.setMajor("Physical Therapy");
        
        System.out.println("Major changed.\n");
        
        System.out.println("Student1: " + s1.getFirstname() + " " + s1.getLastname() + "\n" + s1.getStudentID() + "\n" + s1.getMajor() + "\n");
        System.out.println("Student2: " + s2.getFirstname() + " " + s2.getLastname() + "\n" + s2.getStudentID() + "\n" + s2.getMajor() + "\n");
        System.out.println("Student3: " + s3.getFirstname() + " " + s3.getLastname() + "\n" + s3.getStudentID() + "\n" + s3.getMajor() + "\n");

    }
}
