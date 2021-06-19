import java.io.*;
import java.util.*;
class fsMiniProj
{
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException,NullPointerException
    {
        fsMiniProj obj = new fsMiniProj();
        int choice;
        while(true)
        {
            System.out.println("");
            System.out.println("**");
            System.out.println("1.Insert New Student record");
            System.out.println("2.View all Student records in a department");
            System.out.println("3.Search for a student record!!");
            System.out.println("4.Modify()");
            System.out.println("5.Exit");
            System.out.println("**");
            System.out.println("Please enter your choice:");
            choice = obj.scan.nextInt();
            obj.scan.nextLine();
            System.out.println("");
            switch(choice)
            {
                case 1:
                obj.pack();
                break;
                case 2:
                obj.unpack();
                break;
                case 3:
                obj.search();
                break;
                /*case 4:
                obj.modify();
                break;*/
                case 5:
                System.out.println("You chose exit!");
                System.exit(0);
                default:
                System.out.println("Invalid Option");
            }
        }
    }
 
    public void pack() throws FileNotFoundException
    {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter USN: ");
        String usn = scan.nextLine();
        System.out.print("Enter Phno: ");
        String phno = scan.nextLine();
        System.out.print("Enter Date of birth(dd/mm/yyyy): ");
        String dob = scan.nextLine();
        System.out.print("Enter year of studying: ");
        String year = scan.nextLine();
        System.out.print("Enter branch: ");
        String branch = scan.nextLine();
        String key= hashTable(branch,year);
        write(name,usn,phno,dob,key);    
    }
        
    public void unpack()throws IOException
    {
        String name = "" ,usn = "" ,phno= "" , dob=" ", s;
        System.out.println("Enter department");
        String branch = scan.nextLine();
        if(branch.equalsIgnoreCase("ise")){
        for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ise/"+i+".txt"));
                System.out.println("*Students of sem:"+i+"*");
                    while((s = br.readLine())!=null)
                    {
                        String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
                    }
                    br.close();
                
        }
       
    }
    if(branch.equalsIgnoreCase("cse")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("cse/"+i+".txt"));
        System.out.println("*Students of sem:"+i+"*");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
    if(branch.equalsIgnoreCase("tce")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("tce/"+i+".txt"));
        System.out.println("*Students of sem:"+i+"*");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
    if(branch.equalsIgnoreCase("ece")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("ece/"+i+".txt"));
        System.out.println("*Students of sem:"+i+"*");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
            usn = result[0];
            name = result[1];
            phno = result[2];
            dob=result[3];
            System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
}
      
    public void search()throws FileNotFoundException, IOException
    {

        String name = "", usn = "", phno="",dob="", r;
        System.out.print("Enter the usn of the student to search: ");
        String usn1 = scan.nextLine();
        if(usn1.contains("cs")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("cse/"+i+".txt"));
                int flag=0;
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i + ". The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: CSE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    if(flag==0)
                        {
                            System.out.println("Record NOT found in year "+ i);
                            System.out.println();
                            br.close(); 
                        }
            }
        }
        if(usn1.contains("is")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ise/"+i+".txt"));
                int flag=0;
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i + ". The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: ISE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    if(flag==0)
                        {
                            System.out.println("Record NOT found in year "+ i);
                            System.out.println();
                            br.close(); 
                        }
            }
        }
        if(usn1.contains("tc")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("tce/"+i+".txt"));
                int flag=0;
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i + ". The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: TCE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    if(flag==0)
                        {
                            System.out.println("Record NOT found in year "+ i);
                            System.out.println();
                            br.close(); 
                        }
            }
        }
        if(usn1.contains("ec")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ece/"+i+".txt"));
                int flag=0;
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i + ". The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: ECE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    if(flag==0)
                        {
                            System.out.println("Record NOT found in year "+ i);
                            System.out.println();
                            br.close(); 
                        }
            }
        }
    }

    public void modify() throws FileNotFoundException,IOException,NullPointerException


    {
        String name = "", usn = "", sem = "", branch = "", r;
        File file = new File("student.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        File temp = new File("temp.txt");
        PrintWriter pw = new PrintWriter(temp);
        System.out.println("Enter usn");
        String usn1 = scan.nextLine();
        while((r= br.readLine()) !=null)
        {
            String[] result = r.split("\\|");
            name=result[0];
            usn=result[1];
            sem= result[2];
            branch=result[3];
            if(usn.equals(usn1))
            {
                System.out.println("The details are: " + name + " " + usn + " " + sem + " " + branch);
                System.out.println("enter name, usn,sem and branch");
                String name11 = scan.nextLine();
                String usn11 = scan.nextLine();
                String sem11 = scan.nextLine();
                String branch11 = scan.nextLine();
                String b = name11+"|"+usn11+"|"+sem11+"|"+branch11+"|";
                pw.println(b);
                
            }
            else
            {
                pw.println(r);
            }
        }
        pw.flush();
        pw.close();
        br.close();
        file.delete();
        temp.renameTo(file);
        System.out.println("File Modified");
    }
   
    public void write(String name, String usn, String phno, String dob, String key) throws FileNotFoundException
    {  
            char ch1 = key.charAt(0); 
            char ch2 = key.charAt(1);   
            if(ch1=='1')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("cse/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
            else if(ch1=='2')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ise/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
            else if(ch1=='3')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("tce/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
           else
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ece/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
     }
   
    public String hashTable(String branch, String sem)
    {   
    String key2="";
    String key1="";
    String key;
    if(branch.equalsIgnoreCase("cse"))
        key1="1";
    else if(branch.equalsIgnoreCase("ise"))
        key1="2";
    else if(branch.equalsIgnoreCase("tce"))
        key1="3";
    else if(branch.equalsIgnoreCase("ece"))
        key1="4";
    if(sem.equalsIgnoreCase("1"))
        key2="1";
    else if(sem.equalsIgnoreCase("2"))
        key2="2";
    else if(sem.equalsIgnoreCase("3"))
        key2="3";
    else if(sem.equalsIgnoreCase("4"))
        key2="4";
    key=key1+key2;
    return (key);
    }
}