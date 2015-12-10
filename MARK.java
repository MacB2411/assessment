public class MARK
{
    
     private String fName;
     private String sName;
     private int Mark;
    
    public MARK()
    { fName = "";
      sName = "";
      Mark = 0;
    }
    
    public void readExamData(String dataItems)
    {// unpack string of row data into fields
       String[] rowItems = dataItems.split(",");

     // store each data item as instance property
     fName = rowItems[0];
     sName = rowItems[1];
     Mark = Integer.parseInt(rowItems[2]);
   

    }
    
    public String writeDetails()
    {
        // join up data into a string to output as a row
        // use "," to separate csv columns
        String examData = "";
        examData = examData.concat(fName);
        examData = examData.concat(",");
        examData = examData.concat(sName);
        examData = examData.concat(",");
        examData = examData.concat(Integer.toString(Mark));
        return examData;
    }
    
    public int getMark()
    { return Mark; 
    }
    
    public void displayDetails()
    {
        // output basic details
        System.out.print("Pupil Name is " + fName + " " + sName);
        System.out.print(",  top mark is ");
        System.out.println(Mark);
    }
    
}








