public class CHAN_Wk10ParticipationStudent_4212452
{
    private String firstname;
    private String lastname;
    private int studentID;
    private String major;
    
    public CHAN_Wk10ParticipationStudent_4212452(String fn, String ln, int sid, String mjr)
    {
        firstname = fn;
        lastname = ln;
        studentID = sid;
        major = mjr;
    }
   
    public void setFirstname(String fn)
    {
        firstname = fn;
    }
    
    public void setLastname(String ln)
    {
        lastname = ln;
    }
    
    public void setStudentID(int sid)
    {
        studentID = sid;
    }
    
    public void setMajor(String mjr)
    {
        major = mjr;
    }
    
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public String getLastname()
    {
        return lastname;
    }
    
    public int getStudentID()
    {
        return studentID;
    }
    
    public String getMajor()
    {
        return major;
    }
}
