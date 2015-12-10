import javax.swing.JOptionPane;
import java.io.*;               // for general file handling
public class TEACHER
{
    // array of MEMBER objects
    private MARK MarkList[];
    // number of members calculated after reading file
    int noOfPupil;
    // to read file from storage
    FILEREADCSV examDataFile;
    FILEWRITECSV resultFile;
    
    int topPupil;
    public TEACHER()  throws IOException
    {
        // create file handler objects
        examDataFile = new FILEREADCSV();
        resultFile = new FILEWRITECSV();
    }

    // top level algorithm
    public void processMark()  throws IOException
    {
        setUpPupilList();
        //displayPupil();
        countTOPmark();
    }

     public void setUpPupilList() throws IOException
     {
        // First user message
        System.out.println("Pupil with highest mark : List update  ");
        System.out.println("** Preparing to read data file.");
        
        // read file, fetch data as String array containing the rows
        String[] dataRows = examDataFile.readCSVtable();
        // calculate the number of member rows, skip headings
        noOfPupil = dataRows.length;

        // update user with number of rows with membership details
        System.out.println("** " + noOfPupil + " rows read.\n\n");
        // prepare array for members
        MarkList = new MARK [noOfPupil];
        // create member objects and copy data from source
        for  (int i = 0; i < noOfPupil; i++) {
            MarkList[i] = new MARK();
            // adjust to skip headings
            MarkList[i].readExamData(dataRows[i]);
        
       }
    
   }
    
     public void displayPupil() {
        System.out.println("A listing of all pupils who sat the exam\n");
         for  (int i = 0; i < noOfPupil; i++) {
            MarkList[i].displayDetails();
        }
        // 2 blank line to separate this report from others.
        System.out.print("\n\n\n");
      }

    public void countTOPmark() throws IOException
    {
         int maxMark = MarkList[0].getMark();
         int maxDataPosition = 0;
         String fileContent = "";
         // repeat for the REST of the array
        for (int i=1; i<50; i++) {

            //compare current value with best value
            if (MarkList[i].getMark() > MarkList[maxDataPosition].getMark()) 
            {
                // update the position of the best value
                maxDataPosition = i;

        
  		    } 
        }
    
        
            //display results: position and the best (max) value
          System.out.print("Position is:" + maxDataPosition + " , Value is:");
          MarkList[maxDataPosition].displayDetails();
          System.out.println();
          
        }
        
     public static void main(String[] args)  throws IOException
      {
         TEACHER myTeacher = new TEACHER();
         myTeacher.processMark();
       }
    
    
       }



   


